import React, { useState } from "react";

const Counter = () => {
  const [number, setNumber] = useState(0);
  // const stateArr = useState();
  // stateArr[0] => 상태값
  // stateARr[1] => 상태 변경 함수

  return (
    <h1>
      {number}
      <button onClick={() => setNumber(number + 1)}>클릭</button>
    </h1>
  );
};

export default Counter;
