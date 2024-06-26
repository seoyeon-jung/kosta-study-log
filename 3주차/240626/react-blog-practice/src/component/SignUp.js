import React, { useState } from "react";

function SIgnUp(props) {
  const [userName, setUserName] = useState("");
  const [gender, setGender] = useState("M");

  return (
    <form
      onSubmit={(event) => {
        event.preventDefault();
        alert(`이름 : ${userName}, 성별 : ${gender}`);
      }}
    >
      <label>이름</label>
      <input
        type="text"
        value={userName}
        onChange={(event) => {
          setUserName(event.target.value);
        }}
      />
      <br />
      <label>성별</label>
      <select
        value={gender}
        onChange={(event) => {
          setGender(event.target.value);
        }}
      >
        <option value="M">남성</option>
        <option value="F">여성</option>
      </select>
      <br />
      <button type="submit">제출</button>
    </form>
  );
}

export default SIgnUp;
