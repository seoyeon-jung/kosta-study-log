import React, { useEffect } from "react";
import { BrowserRouter } from "react-router-dom";
import Header from "./Header";
import Footer from "./Footer";
import { useDarkMode } from "../../hooks/useDarkMode";

const Layout = ({ children }) => {
  const { isDarkMode, toggleDarkMode } = useDarkMode();

  useEffect(() => {
    document.documentElement.classList.toggle("dark", isDarkMode);
  }, [isDarkMode]);

  return (
    <BrowserRouter>
      <Header toggleDarkMode={toggleDarkMode} isDarkMode={isDarkMode} />
      <main>{children}</main>
      <Footer isDarkMode={isDarkMode} />
    </BrowserRouter>
  );
};

export default Layout;
