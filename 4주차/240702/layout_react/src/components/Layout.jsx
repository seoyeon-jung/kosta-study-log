import React from "react";
import "./Layout.css";

const Layout = ({ children }) => {
  return (
    <>
      <header>
        <div id="logo">
          <a href="/">로고</a>
        </div>
        <nav id="nav">
          {/* <li>
            <a href="/#">menu1</a>
          </li>
          <li>
            <a href="/#">menu2</a>
          </li>
          <li>
            <a href="/#">menu3</a>
          </li>
          <li>
            <a href="/#">menu4</a>
          </li> */}
          <div>
            <a href="/#">menu1</a>
          </div>
          <div>
            <a href="/#">menu2</a>
          </div>
          <div>
            <a href="/#">menu3</a>
          </div>
          <div>
            <a href="/#">menu4</a>
          </div>
        </nav>
      </header>

      <main>{children}</main>

      <footer>연락처 정보</footer>
    </>
  );
};

export default Layout;
