import React, { useState } from "react";

const StatePractice = () => {
  //   const [값, 값변경] = useState(0);

  //   const handlePlus = () => {
  //     값변경(값 + 1);
  //   };

  const [result, setResult] = useState(0);
  const [x, setX] = useState(0);

  return (
    <>
      {/* <h1>{값}</h1>
      <button onClick={() => 값변경(값 + 1)}>plus 1</button>
      <button onClick={handlePlus}>1씩 더하기</button> */}

      <div>
        <h1>{result}</h1>
        <input
          type="number"
          name="x"
          value={x}
          onChange={(e) => setX(e.target.value)}
        />
        <div style={{ width: "50%", display: "flex", margin: "0 auto" }}>
          <button onClick={() => setResult(result + parseInt(x))}>
            더하기
          </button>
          <button onClick={() => setResult(result - parseInt(x))}>빼기</button>
          <button onClick={() => setResult(result * parseInt(x))}>
            곱하기
          </button>
          <button onClick={() => setResult(result / parseInt(x))}>
            나누기
          </button>
        </div>
      </div>
    </>
  );
};

export default StatePractice;
