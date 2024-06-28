import React from "react";
import CommentListItem from "./CommentListItem";
import styled from "styled-components";

const Wrapper = styled.div`
    display: flex;
    flex-direction: column;
    align-items: flex-start;
    justify-content: center;
    margin- bottom: 10px;

    & > * {
        :not(:last-child) {
            margin-bottom: 16px;
        }
    }
`;

// CommentListItem 반복 출력
// 댓글 배열 : comments
function CommentList({ comments }) {
  return (
    <Wrapper>
      {comments.map((comment, index) => {
        return <CommentListItem key={index} comment={comment} />;
      })}
    </Wrapper>
  );
}

export default CommentList;
