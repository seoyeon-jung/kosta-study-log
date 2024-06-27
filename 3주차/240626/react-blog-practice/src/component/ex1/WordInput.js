import React, { useState } from "react";

const WordInput = ({ addWord }) => {
  const [text, setText] = useState("");

  const clickAdd = () => {
    addWord();
    setText("");
  };

  return (
    <div>
      <input value={text} onChange={(e) => setText(e.target.value)} />
      <button onClick={clickAdd}>단어 추가</button>
    </div>
  );
};

export default WordInput;
