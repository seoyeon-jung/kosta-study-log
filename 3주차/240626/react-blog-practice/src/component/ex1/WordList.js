import React from "react";

const WordList = ({ words, removeWord }) => {
  return (
    <ul>
      {words.map((word, index) => {
        return (
          <li key={index}>
            {word}
            <button onClick={removeWord}>삭제</button>
          </li>
        );
      })}
    </ul>
  );
};

export default WordList;
