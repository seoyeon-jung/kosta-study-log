import {
  alpha,
  AppBar,
  Box,
  Button,
  IconButton,
  InputBase,
  List,
  ListItem,
  ListItemButton,
  ListItemText,
  styled,
  Toolbar,
} from "@mui/material";
import MenuIcon from "@mui/icons-material/Menu";
import { FaBlogger } from "react-icons/fa6";
import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import Drawer from "./Drawer";
import SearchIcon from "@mui/icons-material/Search";
import { postAPI } from "../../api/services/post";

const Header = () => {
  const navigate = useNavigate();

  const [menu, setMenu] = useState([
    { path: "/user", name: "회원 관리" },
    { path: "/post", name: "게시물" },
    { path: "/favorite", name: "북마크" },
    { path: "signup", name: "회원가입" },
    { path: "/search", name: "검색" },
  ]);
  const [menuOpen, setMenuOpen] = useState(false); // menu open 여부

  const toggleDrawer = () => {
    setMenuOpen((prev) => !prev);
  };

  return (
    <>
      <AppBar position="static" color="main">
        <Toolbar sx={{ justifyContent: "space-between" }}>
          <IconButton
            color="font"
            sx={{ display: { sm: "none" } }}
            onClick={toggleDrawer}
          >
            <MenuIcon />
          </IconButton>

          <Box
            color="font"
            sx={{ display: { xs: "none", sm: "block" }, cursor: "pointer" }}
          >
            <FaBlogger onClick={() => navigate("/")} />
          </Box>

          <Box sx={{ display: { xs: "none", sm: "block" }, cursor: "pointer" }}>
            {menu.map((m, idx) => {
              if (m.path === "/search") {
                return <MySearch />;
              }
              return (
                <Button key={idx} color="bg2" onClick={() => navigate(m.path)}>
                  {m.name}
                </Button>
              );
            })}
          </Box>
        </Toolbar>
      </AppBar>

      {/* Drawer 추가 */}
      <Drawer menuOpen={menuOpen} toggleDrawer={toggleDrawer}>
        <List>
          {menu.map((m, idx) => (
            <ListItem key={idx}>
              <ListItemButton
                onClick={() => {
                  navigate(m.path);
                  toggleDrawer();
                }}
              >
                <ListItemText primary={m.name} />
              </ListItemButton>
            </ListItem>
          ))}
        </List>
      </Drawer>
    </>
  );
};

const MySearch = () => {
  const navigate = useNavigate();
  const [keyword, setKeyword] = useState("");

  const handleSearch = (e) => {
    if (e.key === "Enter") {
      // http://localhost:8080/api/post/search?keyword="" 를 통해 검색
      // > 검색 결과로 이동시켜준다.
      postSearch(keyword);
    }
  };

  const postSearch = async (keyword) => {
    try {
      const res = await postAPI.searchPost(keyword);
      navigate("/search", { state: res.data });
    } catch (error) {
      console.error(error);
      navigate("/error", { state: error.message });
    }
  };

  return (
    <Search>
      <SearchIconWrapper>
        <SearchIcon />
      </SearchIconWrapper>
      <StyledInputBase
        placeholder="검색어 입력"
        inputProps={{ "aria-label": "search" }}
        onKeyDown={(e) => handleSearch(e)}
        value={keyword}
        onChange={(e) => setKeyword(e.target.value)}
      />
    </Search>
  );
};

const Search = styled("div")(({ theme }) => ({
  display: "inline-block",
  position: "relative",
  borderRadius: theme.shape.borderRadius,
  backgroundColor: alpha(theme.palette.common.white, 0.15),
  "&:hover": {
    backgroundColor: alpha(theme.palette.common.white, 0.25),
  },
  marginLeft: 0,
  width: "100%",
  [theme.breakpoints.up("sm")]: {
    marginLeft: theme.spacing(1),
    width: "auto",
  },
}));

const SearchIconWrapper = styled("div")(({ theme }) => ({
  padding: theme.spacing(0, 2),
  height: "100%",
  position: "absolute",
  pointerEvents: "none",
  display: "flex",
  alignItems: "center",
  justifyContent: "center",
}));

const StyledInputBase = styled(InputBase)(({ theme }) => ({
  color: "inherit",
  width: "100%",
  "& .MuiInputBase-input": {
    padding: theme.spacing(1, 1, 1, 0),
    // vertical padding + font size from searchIcon
    paddingLeft: `calc(1em + ${theme.spacing(4)})`,
    transition: theme.transitions.create("width"),
    [theme.breakpoints.up("sm")]: {
      width: "12ch",
      "&:focus": {
        width: "20ch",
      },
    },
  },
}));

export default Header;
