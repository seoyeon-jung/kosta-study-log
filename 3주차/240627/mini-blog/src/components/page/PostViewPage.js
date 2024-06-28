import React, { useState } from "react";
import styled from "styled-components";
import PageLayout from "./PageLayout";
import Button from "../ui/Button";
import TextInput from "../ui/TextInput";

const PostContainer = styled.div`
  margin-top: 10px;
  padding: 8px 16px;
  border: 1px solid #aaa;
  border-radius: 8px;
`;

const TitleText = styled.p`
  font-size: 28px;
  font-weight: 500;
`;

const ContentText = styled.p`
  font-size: 20px;
  line-height: 32px;
`;

const Label = styled.p`
  font-size: 16px;
`;

function PostViewPage() {
  const [comment, setComment] = useState("");

  return (
    <PageLayout>
      <Button
        title="뒤로가기"
        onClick={() => alert("이전 페이지로 이동합니다.")}
      ></Button>

      <PostContainer>
        <TitleText>제목글입니다.</TitleText>
        <ContentText>
          안녕하세요. \n리액트에서 리스트를 렌더링하는 방법이 무엇인지
          알아봅시다.
        </ContentText>
      </PostContainer>

      <Label>댓글 목록</Label>

      <Label>댓글 작성</Label>
      <TextInput
        height={40}
        value={comment}
        onChange={(event) => setComment(event.target.value)}
      />
      <Button title="댓글 작성" onClick={() => alert("댓글을 등록합니다.")} />
    </PageLayout>
  );
}

export default PostViewPage;
