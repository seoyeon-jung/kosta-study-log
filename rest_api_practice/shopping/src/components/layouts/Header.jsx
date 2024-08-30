import React from "react";
import "./Header.css";
import Navigation from "./Navigation";

const Header = () => {
  return (
    <>
      <header>
        <a href="/">메인 로고</a>
        <Navigation />
      </header>
    </>
  );
};

export default Header;
