import React, { useState } from "react";
import Dialog from "./Dialog";

let room = [];

function SignUpDialog(props) {
  const [userName, setUserName] = useState("");

  const handleClick = (event) => {
    // 배열에 추가
    room.push(userName);
    setUserName("");
    alert(`환영합니다!! ${userName}님 `);
  };

  return (
    <Dialog title="스터디 팀 참여" message="이름을 입력하세요">
      <input
        type="text"
        value={userName}
        onChange={(event) => {
          setUserName(event.target.value);
        }}
      />
      <button onClick={handleClick}>참여하기</button>
      <div>
        {room.map((name, index) => {
          return <p key={index}>{name}</p>;
        })}
      </div>
    </Dialog>
  );
}

export default SignUpDialog;
