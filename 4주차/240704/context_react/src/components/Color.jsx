import React, { useContext } from "react";
import { MyColorContext } from "../contexts/MyColorContext";

const Color = () => {
  const { myColor } = useContext(MyColorContext);

  // 가로 120px, 세로 120px인 박스를 만들기
  return (
    <div
      style={{
        width: "120px",
        height: "120px",
        backgroundColor: myColor,
        margin: "0 auto",
        marginTop: "10px",
      }}
    ></div>
  );
};

export default Color;
