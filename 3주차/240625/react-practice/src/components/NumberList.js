import React from "react";

function NumberList(props) {
  const numbers = [11, 42, 78, 32, 90];

  const listItem = numbers.map((num, index) => <li key={index}>{num}</li>);

  return <ul>{listItem}</ul>;
}

export default NumberList;
