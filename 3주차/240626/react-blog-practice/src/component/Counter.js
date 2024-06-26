import React from "react";
import { useState } from "react";

//let count = 0

// const countHandle = () => {
//     //count++
//     setCount(count+1)
//     console.log(count)
// }

function Counter(props) {
  // const [변수명, set함수명] = useState()
  const [count, setCount] = useState(0);
  // count = 0
  // setCount() => state 값을 변경해주는 함수, 실행 => 재 렌더링

  return (
    <div>
      <p>총 {count}번 클릭!</p>
      <button onClick={() => setCount(count + 1)}>Click</button>
    </div>
  );
}

export default Counter;
