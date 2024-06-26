import React from "react";

function Nav({ nav }) {
  // 메뉴 데이터 : 배열 [{name: '', linkUrl : ''}, {}, .....]

  return (
    <nav>
      <ul>
        {nav.map((menu, index) => {
          return (
            <li key={index}>
              <a href={menu.linkUrl}>{menu.name}</a>
            </li>
          );
        })}
      </ul>
    </nav>
  );
}

export default Nav;
