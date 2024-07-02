import React from "react";
import Button from "./Button";

const Introduce = (props) => {
  return (
    <div>
      <h2>안녕하세요</h2>
      <Button size="small" color="red" event={() => alert("클릭")}>
        클릭
      </Button>
      <Button size="medium" color="orange">
        누르세요
      </Button>
      <Button size="large" color="yellow">
        click
      </Button>
      <p>내 친구 이름은 {props.name}입니다.</p>
      <p>내 친구의 성별은 {props.gender}입니다.</p>
    </div>
  );
};

Introduce.defaultProps = {
  name: "sy",
  gender: "여자",
};

export default Introduce;
