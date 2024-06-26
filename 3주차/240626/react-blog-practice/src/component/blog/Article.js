import React from "react";

function Article({ title, date, imgUrl, content }) {
  return (
    <article>
      <h2> {title} </h2>
      <p> {date} </p>
      <img src={imgUrl} alt="img" />
      <p> {content} </p>
    </article>
  );
}

export default Article;
