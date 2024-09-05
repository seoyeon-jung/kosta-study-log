import {
  AppBar,
  Box,
  Button,
  IconButton,
  List,
  ListItem,
  ListItemButton,
  ListItemText,
  Toolbar,
} from "@mui/material";
import MenuIcon from "@mui/icons-material/Menu";
import { FaBlogger } from "react-icons/fa6";
import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import Drawer from "./Drawer";

const Header = () => {
  const navigate = useNavigate();

  const [menu, setMenu] = useState([
    { path: "/user", name: "회원 관리" },
    { path: "/post", name: "게시물" },
    { path: "/search", name: "검색" },
    { path: "/favorite", name: "북마크" },
    { path: "signup", name: "회원가입" },
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

export default Header;
