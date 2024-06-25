import React from "react";
import Comment2 from "./Comment2";

let comments = [
  {
    cno: 1,
    user: {
      imgUrl:
        "https://encrypted-tbn1.gstatic.com/licensed-image?q=tbn:ANd9GcRpSo5X-9GknhLwsqbgdtHhueRB_ZitJC-6IPBvZ7KWWxgFHCl9oke9ouGB8DzTUth-fvavDDA1pSJBlc4",
      userName: "손흥민",
    },
    content: "1등이다!!!!!!!",
    replydate: "2024.06.20",
  },
  {
    cno: 2,
    user: {
      imgUrl:
        "https://encrypted-tbn1.gstatic.com/licensed-image?q=tbn:ANd9GcRpSo5X-9GknhLwsqbgdtHhueRB_ZitJC-6IPBvZ7KWWxgFHCl9oke9ouGB8DzTUth-fvavDDA1pSJBlc4",
      userName: "이강인",
    },
    content: "반갑습니다.",
    replydate: "2024.06.22",
  },
  {
    cno: 3,
    user: {
      imgUrl:
        "https://encrypted-tbn1.gstatic.com/licensed-image?q=tbn:ANd9GcRpSo5X-9GknhLwsqbgdtHhueRB_ZitJC-6IPBvZ7KWWxgFHCl9oke9ouGB8DzTUth-fvavDDA1pSJBlc4",
      userName: "김민재",
    },
    content: "강인아~ 놀러와~~",
    replydate: "2024.06.25",
  },
];

function CommentList() {
  return (
    <div>
      {comments.map((comment) => {
        return (
          <Comment2
            key={comment.cno}
            user={comment.user}
            content={comment.content}
            replydate={comment.replydate}
          ></Comment2>
        );
      })}
    </div>
  );
}

export default CommentList;
