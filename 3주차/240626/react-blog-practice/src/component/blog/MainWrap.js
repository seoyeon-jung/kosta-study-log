import React from "react";
import Article from "./Article";
import Aside from "./Aside";

function MainWrap({ posts, recentPosts }) {
  // let posts = [
  //     {title: 'aaa', date: '2024.06.10', imgUrl: 'mini.jpg', content: '안녕하세요11'},
  //     {title: 'bbb', date: '2024.06.20', imgUrl: 'mini.jpg', content: '안녕하세요12'},
  //     {title: 'ccc', date: '2024.06.26', imgUrl: 'mini.jpg', content: '안녕하세요13'}
  // ]

  // let recentPosts = [
  //     {name: '111', linkUrl: '#'},
  //     {name: '222', linkUrl: '#'},
  //     {name: '333', linkUrl: '#'},
  //     {name: '222', linkUrl: '#'},
  //     {name: '333', linkUrl: '#'},
  //     {name: '222', linkUrl: '#'},
  //     {name: '333', linkUrl: '#'}
  // ]

  return (
    <div id="wrap">
      <section>
        {posts.map((post, index) => {
          return (
            <Article
              key={index}
              title={post.title}
              date={post.date}
              imgUrl={post.imgUrl}
              content={post.content}
            ></Article>
          );
        })}
      </section>
      <Aside recentPosts={recentPosts}></Aside>
    </div>
  );
}

export default MainWrap;
