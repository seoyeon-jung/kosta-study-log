// 요청보내는 함수 만들기

import api from "../api";

export const postApi = {
  getPosts: () => api.get("/posts"),
  postPosts: (post) => api.post("/posts", post),
};
