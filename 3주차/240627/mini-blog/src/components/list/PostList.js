import React from "react";
import styled from "styled-components";
import PostListItem from "./PostListItem";

const Wrapper = styled.div`
  margin-top: 10px;
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  justify-content: center;

  & > * {
    :not(:lastchild) {
      margin-bottom: 16px;
    }
  }
`;

function PostList({ posts, onClickItem }) {
  return (
    <Wrapper>
      {posts.map((post, index) => {
        return (
          <PostListItem
            key={index}
            post={post}
            onClick={() => onClickItem(post)}
          />
        );
      })}
    </Wrapper>
  );
}

export default PostList;
