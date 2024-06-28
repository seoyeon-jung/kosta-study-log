import React, { useState } from "react";
import PageLayout from "./PageLayout";
import TextInput from "../ui/TextInput";
import Button from "../ui/Button";

function PostWrite() {
  const [title, setTitle] = useState("");
  const [content, setContent] = useState("");

  return (
    <PageLayout>
      <TextInput
        height={20}
        value={title}
        onChange={(event) => setTitle(event.target.value)}
      />
      <TextInput
        height={300}
        value={content}
        onChange={(event) => setContent(event.target.value)}
      />
      <Button title="글작성" onClick={() => alert("글이 작성되었습니다.")} />
    </PageLayout>
  );
}

export default PostWrite;
