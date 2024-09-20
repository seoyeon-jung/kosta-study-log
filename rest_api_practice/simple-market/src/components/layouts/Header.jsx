import React, { useEffect, useState } from "react";
import {
  Typography,
  IconButton,
  Input,
  Button,
} from "@material-tailwind/react";
import {
  Bars3Icon,
  XMarkIcon,
  MoonIcon,
  SunIcon,
} from "@heroicons/react/24/outline";
import { useNavigate } from "react-router-dom";
import { useCookies } from "react-cookie";
import { jwtDecode } from "jwt-decode";
import { removeCookie } from "../../utils/cookieUtil";

const Header = ({ toggleDarkMode, isDarkMode }) => {
  const navigate = useNavigate();
  const [openNav, setOpenNav] = useState(false);
  const [cookies] = useCookies(["accessToken"]);
  const [role, setRole] = useState();

  const handleLogout = () => {
    removeCookie("accessToken", { path: "/" });
    setOpenNav(false);
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
              className="hover:text-cyan-400 dark:text-white dark:hover:text-gray-300"
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
              className="hover:text-cyan-400 dark:text-white dark:hover:text-gray-300"
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
              className="text-sm bg-cyan-50 text-cyan-900 flex items-center hover:bg-cyan-500 hover:text-cyan-50 transition-colors dark:bg-gray-500 dark:hover:bg-gray-400 dark:text-dark-text"
            >
              로그아웃
            </Button>
          </Typography>
          <li className="p-1 font-medium">
            <Input
              type="search"
              placeholder="검색어를 입력하세요"
              className="p-3 border border-gray-300 rounded-md focus:border-cyan-500 focus:ring-1 focus:ring-cyan-500 transition-all"
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
              className="bg-cyan-50 text-cyan-900 flex items-center hover:bg-cyan-500 hover:text-cyan-50 transition-colors dark:bg-gray-500 dark:hover:bg-gray-400 dark:text-dark-text"
            >
              로그아웃
            </Button>
          </Typography>
          <li className="p-1 font-medium">
            <Input
              type="search"
              placeholder="Search..."
              className="p-3 border border-gray-300 rounded-md focus:border-cyan-500 focus:ring-1 focus:ring-cyan-500 transition-all"
            />
          </li>
        </ul>
      );
    }
    return null;
  };

  return (
    <header
      className={`mx-auto w-full px-6 py-3 ${
        isDarkMode
          ? "bg-dark-paper border-dark-background text-dark-text"
          : "bg-cyan-100 text-cyan-900"
      }`}
    >
      <div className="flex items-center justify-between dark:text-white">
        <Typography
          as="a"
          href={cookies.accessToken ? "/products" : "/"}
          variant="h4"
          className="mr-4 cursor-pointer py-1.5"
        >
          Simple Market
        </Typography>
        <div className="hidden lg:block">{menuItems()}</div>
        <div className="flex items-center space-x-4">
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
          <IconButton
            variant="text"
            className="h-6 w-6 text-inherit hover:bg-transparent focus:bg-transparent active:bg-transparent"
            ripple={false}
            onClick={toggleDarkMode}
          >
            {isDarkMode ? (
              <MoonIcon className="h-6 w-6 text-white" />
            ) : (
              <SunIcon className="h-6 w-6 text-yellow-500" />
            )}
          </IconButton>
        </div>
      </div>

      {openNav && <div className="lg:hidden">{menuItems()}</div>}
    </header>
  );
};

export default Header;
