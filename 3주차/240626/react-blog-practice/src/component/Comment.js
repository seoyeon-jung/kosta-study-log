import React from "react";

function UserImg(props) {
  return (
    <img
      className="userImg"
      src={props.user.imgUrl}
      alt={props.user.userName}
    />
  );
}

function UserInfo(props) {
  return (
    <div className="userInfo">
      <UserImg user={props.user} />
      <div className="userInfoName">{props.user.userName}</div>
    </div>
  );
}

function Comment(props) {
  return (
    <div className="comment">
      <UserInfo user={props.user} />
      {/* 댓글 */}
      <div className="comment"> {props.content} </div>
      {/* 작성 시간 */}
      <div className="replydate"> {props.replydate} </div>
    </div>
  );
}

export default Comment;
