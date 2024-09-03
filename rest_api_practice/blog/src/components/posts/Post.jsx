import { Button, Divider, Grid2 } from "@mui/material";
import axios from "axios";
import React, { useEffect, useState } from "react";
import PostCard from "./PostCard";
import { useNavigate } from "react-router-dom";

const Post = () => {
  const navigate = useNavigate();
  // 1. state 생성
  const [postList, setPostList] = useState([]);

  // 2. axios 사용해서 setting
  const getPostLists = async () => {
    try {
      const res = await axios.get("http://localhost:8080/api/post");
      //console.log(res.data);
      setPostList(res.data);
    } catch (err) {
      console.error(err);
    }
  };

  // 3. useEffect에 함수 적용
  useEffect(() => {
    getPostLists();
  }, []);

  return (
    <>
      <h1>POST LIST</h1>
      {/* 글쓰기 버튼 */}
      <Button
        variant="contained"
        color="main"
        onClick={() => navigate("/post/write")}
      >
        글쓰기
      </Button>
      <Divider />
      {/* 전체 리스트 */}
      <Grid2 container spacing={4} direction={"column"}>
        {postList.map((post) => (
          <PostCard post={post} key={post.id} />
        ))}
      </Grid2>
    </>
  );
};

export default Post;
