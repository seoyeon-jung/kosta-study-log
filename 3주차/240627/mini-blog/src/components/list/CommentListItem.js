import React from "react";
import styled from "styled-components";

const Wrapper = styled.div`
  width: 90%;
  padding: 8px 16px;
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  border: 10px solid gray;
  border-radius: 8px;
  cursor: pointer;
  background: white;
  :hover {
    background: lightgray;
  }
`;

const TtleText = styled.p`
  font-size: 16px;
  white-space: pre-wrap;
`;

function CommentListItem({ comment }) {
  return (
    <Wrapper>
      <TtleText>{comment.content}</TtleText>
    </Wrapper>
  );
}

export default CommentListItem;
