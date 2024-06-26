import React from "react";
import Player from "./Player";

let team = [
  { name: "손흥민", no: "7" },
  { name: "이강인", no: "17" },
  { name: "김민재", no: "27" },
];

function Team(props) {
  return (
    <div>
      {team.map((player) => {
        return (
          <Player playerName={player.name} playerNumber={player.no}></Player>
        );
      })}
    </div>
  );
}

export default Team;
