import React, { useEffect, useState } from "react";
import {
  Typography,
  IconButton,
  Input,
  Button,
} from "@material-tailwind/react";
import { Bars3Icon, XMarkIcon } from "@heroicons/react/24/outline";
import { useNavigate } from "react-router-dom";
//import { useDarkMode } from "../../hooks/useDarkMode";
import { useCookies } from "react-cookie";
import { jwtDecode } from "jwt-decode";
import { removeCookie } from "../../utils/cookieUtil";

const Header = () => {
  const navigate = useNavigate();
  // 로그인 상태와 역할을 상태로 관리
  const [openNav, setOpenNav] = useState(false);
  const [cookies] = useCookies(["accessToken"]);
  const [role, setRole] = useState();

  const handleLogout = () => {
    removeCookie("accessToken", { path: "/" });
    navigate("/");
  };

  useEffect(() => {
    if (cookies.accessToken && typeof cookies.accessToken === "string") {
      try {
        const decodedToken = jwtDecode(cookies.accessToken);
        const role = decodedToken.role;
        setRole(role);
      } catch (error) {
        console.error("Error decoding token", error);
        setRole(null);
      }
    } else {
      setRole(null);
    }
  }, [cookies.accessToken]);

  // dark mode
  // const { isDarkMode, toggleDarkMode } = useDarkMode();

  // 메뉴 항목 상태 관리
  const menuItems = () => {
    if (!cookies.accessToken) {
      return (
        <ul className="my-2 flex flex-col gap-2 lg:mb-0 lg:mt-0 lg:flex-row lg:items-center lg:gap-6">
          <Typography
            as="li"
            variant="small"
            color="blue-gray"
            className="p-1 font-medium"
          >
            <Button
              variant="text"
              onClick={() => navigate("/signin")}
              className="hover:text-blue-400"
            >
              회원가입
            </Button>
          </Typography>
        </ul>
      );
    }
    if (role === "ROLE_ADMIN") {
      return (
        <ul className="my-2 flex flex-col gap-2 lg:mb-0 lg:mt-0 lg:flex-row lg:items-center lg:gap-6">
          <Typography
            as="li"
            variant="small"
            color="blue-gray"
            className="p-1 font-medium"
          >
            <Button
              variant="text"
              onClick={() => navigate("/products/add")}
              className="hover:text-blue-400"
            >
              상품 추가
            </Button>
          </Typography>
          <Typography
            as="li"
            variant="small"
            color="blue-gray"
            className="p-1 font-medium"
          >
            <Button
              onClick={handleLogout}
              className="flex items-center hover:text-blue-500 transition-colors"
            >
              로그아웃
            </Button>
          </Typography>
          <li className="p-1 font-medium">
            <Input
              type="search"
              placeholder="Search..."
              className="w-full max-w-xs"
            />
          </li>
        </ul>
      );
    }
    if (role === "ROLE_USER") {
      return (
        <ul className="my-2 flex flex-col gap-2 lg:mb-0 lg:mt-0 lg:flex-row lg:items-center lg:gap-6">
          <Typography
            as="li"
            variant="small"
            color="blue-gray"
            className="p-1 font-medium"
          >
            <Button
              onClick={handleLogout}
              className="flex items-center hover:text-blue-500 transition-colors"
            >
              로그아웃
            </Button>
          </Typography>
          <li className="p-1 font-medium">
            <Input
              type="search"
              placeholder="Search..."
              className="w-full max-w-xs"
            />
          </li>
        </ul>
      );
    }
    return null;
  };

  return (
    <header className="mx-auto w-full px-6 py-3 bg-cyan-100">
      <div className="flex items-center justify-between text-blue-gray-900">
        <Typography
          as="a"
          href={cookies.accessToken ? "/products" : "/"}
          variant="h4"
          className="mr-4 cursor-pointer py-1.5"
        >
          Simple Market
        </Typography>
        <div className="hidden lg:block">{menuItems()}</div>
        <IconButton
          variant="text"
          className="ml-auto h-6 w-6 text-inherit hover:bg-transparent focus:bg-transparent active:bg-transparent lg:hidden"
          ripple={false}
          onClick={() => setOpenNav(!openNav)}
        >
          {openNav ? (
            <XMarkIcon className="h-6 w-6" strokeWidth={2} />
          ) : (
            <Bars3Icon className="h-6 w-6" strokeWidth={2} />
          )}
        </IconButton>

        {/* Dark mode toggle button */}
        {/* <IconButton
          variant="text"
          className="ml-4 h-6 w-6 text-inherit hover:bg-transparent focus:bg-transparent active:bg-transparent"
          ripple={false}
          onClick={toggleDarkMode}
        >
          {isDarkMode ? (
            <span className="material-icons">dark</span> // Example icon for light mode
          ) : (
            <span className="material-icons">light</span> // Example icon for dark mode
          )}
        </IconButton> */}
      </div>

      {openNav && <div className="lg:hidden">{menuItems()}</div>}
    </header>
  );
};

export default Header;
