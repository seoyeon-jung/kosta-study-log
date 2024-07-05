import React from "react";
import Header from "./Header";
import Main from "./Main";
import { BrowserRouter } from "react-router-dom";

const Layout = ({ children }) => {
  return (
    <BrowserRouter>
      <Header />
      <Main>{children}</Main>
    </BrowserRouter>
  );
};

export default Layout;
