import React from "react";
import data from "../data.json";
import PostList from "../list/PostList";
import PageLayout from "./PageLayout";
import Button from "../ui/Button";

function BlogMain() {
  return (
    <PageLayout>
      <Button
        title="글 작성"
        onClick={() => alert("글쓰기 페이지로 이동합니다.")}
      ></Button>

      <PostList
        posts={data}
        onClickItem={(item) => alert(item.content)}
      ></PostList>
    </PageLayout>
  );
}

export default BlogMain;
