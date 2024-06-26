import React from "react";

const style = {
  wrap: {
    margin: 8,
    padding: 8,
    display: "flex",
    flexDirection: "row",
    border: "1px solid gray",
  },
  image: {
    width: 50,
    height: 50,
    borderRadius: 25,
  },
  contentContainer: {
    marginLeft: 10,
    display: "flex",
    flexDirection: "column",
    justifyContent: "center",
  },
  commentText: {
    color: "black",
    fontSize: 12,
    marginBottom: 10,
  },
  dateText: {
    color: "gray",
    fontSize: 10,
  },
};

function Comment2(props) {
  return (
    <div style={style.wrap}>
      {/* 회원 정보 */}
      <div>
        <img
          src={props.user.imgUrl}
          alt={props.user.userName}
          style={style.image}
        />
        <div
          style={{
            color: "blue",
            fontSize: 10,
            fontWeight: "bold",
          }}
        >
          {" "}
          {props.user.userName}{" "}
        </div>
      </div>
      <div style={style.contentContainer}>
        {/* reply Content */}
        <div style={style.commentText}> {props.content} </div>
        {/* reply replydate */}
        <div style={style.dateText}> {props.replydate} </div>
      </div>
    </div>
  );
}

export default Comment2;
