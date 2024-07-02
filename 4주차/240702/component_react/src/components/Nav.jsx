import React from "react";

const Nav = () => {
  const menu = [
    { name: "홈", link: "/" },
    { name: "추천", link: "/recommend" },
    { name: "뷰티", link: "/beauty" },
  ];

  return (
    <nav>
      {menu.map((item) => {
        return (
          <div>
            <a href={item.link}>{item.name}</a>
          </div>
        );
      })}
    </nav>
  );
};

export default Nav;
