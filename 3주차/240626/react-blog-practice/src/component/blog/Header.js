import React from "react";

function Header({ header }) {
  // 블로그 이름, 설명, 객체로 받는다 {title: '', description: ''}

  return (
    <header>
      <h1 className="title">{header.title}</h1>
      <p>{header.description}</p>
    </header>
  );
}

export default Header;
