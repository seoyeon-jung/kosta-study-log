import React from "react";

const Article = (props) => {
  const text = props.text;

  const style = {
    textAlign: "center",
    backgroundColor: "#aaa",
    height: "20vh",
    margin: "10px 50px",
  };

  return (
    <article style={style}>
      <h2>{text}</h2>
    </article>
  );
};

export default Article;
