import { Typography } from "@mui/material";
import React, { useEffect, useReducer } from "react";
import PostList from "../timeline/PostList";
import { postReducer } from "../../hooks/reducer";
import PostWrite from "../timeline/PostWrite";
import { postApi } from "../../api/services/posts";
import { userApi } from "../../api/services/users";

const TimeLine = () => {
  const [posts, dispatch] = useReducer(postReducer, []);

  const getPosts = async () => {
    try {
      //const res = await axios.get(`${process.env.REACT_APP_SERVER_ADDR}/posts`);
      const res = await postApi.getPosts();
      //console.log(res.data);
      const posts = res.data;
      const postList = [];

      // post 하나씩 userid 가져오기
      for (let post of posts) {
        //console.log(post.userId);
        // const response = await axios.get(
        //   `${process.env.REACT_APP_SERVER_ADDR}/users/${post.userId}`
        // );
        const res2 = await userApi.getUser(post.userId);
        post.user = res2.data;
        postList.push(post);
        //console.log(postList);
      }

      if (res.status === 200) {
        dispatch({ type: "SET_POSTS", payload: postList });
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
