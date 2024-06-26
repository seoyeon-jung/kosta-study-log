import React from "react";

function Aside({ recentPosts }) {
  // 최근 글의 제목 링크
  // [{name: '', linkUrl: ''}, {name: '', linkUrl: ''}, {name: '', linkUrl: ''}, ....]

  return (
    <aside>
      <h4>카테고리</h4>
      <ul>
        {recentPosts.map((item, index) => {
          return (
            <li key={index}>
              <a href={item.linkUrl}>{item.name}</a>
            </li>
          );
        })}
      </ul>
    </aside>
  );
}

export default Aside;
