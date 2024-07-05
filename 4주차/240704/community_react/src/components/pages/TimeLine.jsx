import { Typography } from "@mui/material";
import React, { useEffect, useReducer } from "react";
import PostList from "../timeline/PostList";
import { postReducer } from "../../hooks/reducer";
import axios from "axios";
import PostWrite from "../timeline/PostWrite";

const TimeLine = () => {
  const [posts, dispatch] = useReducer(postReducer, []);

  const getPosts = async () => {
    try {
      const res = await axios.get(`${process.env.REACT_APP_SERVER_ADDR}/posts`);
      //console.log(res.data);
      let posts = res.data;

      // post 하나씩 userid 가져오기
      for (const post of posts) {
        //console.log(post.userId);
        const response = await axios.get(
          `${process.env.REACT_APP_SERVER_ADDR}/users/${post.userId}`
        );
        post.user = response.data;
        const postList = [];
        postList.push(post);
        //console.log(postList);
      }

      if (res.status === 200) {
        dispatch({ type: "SET_POSTS", payload: posts });
      }
    } catch (error) {
      console.error(error);
    }
  };

  useEffect(() => {
    getPosts();
  }, []);

  return (
    <>
      <Typography variant="h4">Timeline</Typography>
      <PostWrite dispatch={dispatch} />
      <PostList posts={posts} />
    </>
  );
};

export default TimeLine;
