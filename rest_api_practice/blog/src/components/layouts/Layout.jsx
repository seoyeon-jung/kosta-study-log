import React, { useEffect } from "react";
import { BrowserRouter } from "react-router-dom";
import Header from "./Header";
import Main from "./Main";
import { useAuth } from "../../hooks/useAuth";

const Layout = ({ children }) => {
  const { userInfo, refreshUserinfo } = useAuth();

  useEffect(() => {
    refreshUserinfo();
  }, []);

  return (
    <BrowserRouter>
      <Header />
      <Main>{children}</Main>
    </BrowserRouter>
  );
};

export default Layout;
