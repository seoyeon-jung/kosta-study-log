import React, { useState } from "react";

// 방문객수 text, 조식여부 checkbox, 요청사항 textarea
function Reservation(props) {
  const [guestOfNum, setGuestOfNum] = useState(1);
  const [haveBreakfast, setHaveBreakfast] = useState(false);
  const [msg, setMsg] = useState("요청사항을 입력하세요!");

  const handleSubmit = (event) => {
    event.preventDefault();
    alert(`방문객 수 : ${guestOfNum}명 \n 
조식 여부 : ${haveBreakfast} \n 
요청사항 :\n ${msg}`);
  };

  return (
    <form onSubmit={handleSubmit}>
      <label>방문객 수</label>
      <input
        type="text"
        value={guestOfNum}
        onChange={(event) => {
          setGuestOfNum(event.target.value);
        }}
      />
      <br />
      <label>조식 여부</label>
      <input
        type="checkbox"
        checked={haveBreakfast}
        onChange={(event) => {
          setHaveBreakfast(event.target.checked);
        }}
      />
      <br />
      <label>요청사항</label>
      <br />
      <textarea
        value={msg}
        onChange={(event) => {
          setMsg(event.target.value);
        }}
      ></textarea>
      <br />
      <button type="submit">제출</button>
    </form>
  );
}

export default Reservation;
