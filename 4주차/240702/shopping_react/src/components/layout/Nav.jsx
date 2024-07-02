import React from "react";
import "./Layout.css";

const Nav = () => {
  const menuArr = [
    { link: "/#", name: "HOME" },
    { link: "/#", name: "ABOUT" },
    { link: "/#", name: "SERVICE" },
    { link: "/#", name: "PRODUCT" },
  ];
  return (
    <nav>
      {menuArr.map((menu) => {
        return (
          <li key={menu.name}>
            <a href={menu.link}>{menu.name}</a>
          </li>
        );
      })}
    </nav>
  );
};

export default Nav;
