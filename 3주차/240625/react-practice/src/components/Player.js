import React from "react";

function Player(props) {
  return (
    <div>
      <div>축구선수 정보 출력</div>
      <ul>
        <li>선수 이름 : {props.playerName}</li>
        <li>선수 번호 : {props.playerNumber}</li>
      </ul>
    </div>
  );
}

export default Player;
