import React, { useState } from "react";
import WordInput from "./WordInput";
import WordList from "./WordList";

const WordContainer = () => {
  // 단어들을 가지는 배열을 관리
  const [words, setWords] = useState(["aaa", "bbb", "ccc"]);

  const addWord = (word) => {
    setWords([...words, word]);
  };

  const removeWord = (word) => {
    // 새로운 배열 생성
    const filterdWords = words.filter((w) => w !== word);
    setWords([...filterdWords]);
  };

  return (
    <div>
      <WordInput addWord={addWord} />
      <WordList words={words} removeWord={removeWord} />
    </div>
  );
};

export default WordContainer;
