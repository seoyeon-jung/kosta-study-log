import { Divider, Grid2 } from "@mui/material";
import axios from "axios";
import React, { useEffect, useState } from "react";
import PostCard from "./PostCard";

const Post = () => {
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
      {/* 글쓰기 양식 */}
      <Divider />
      {/* 전체 리스트 */}
      <Grid2 container spacing={4}>
        {postList.map((post) => (
          <PostCard post={post} key={post.id} />
        ))}
      </Grid2>
    </>
  );
};

export default Post;
