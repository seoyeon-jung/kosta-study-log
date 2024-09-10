import { Button, Divider, Grid2, Pagination } from "@mui/material";
import React, { useEffect, useState } from "react";
import PostCard from "./PostCard";
import { useLocation, useNavigate } from "react-router-dom";
import { postAPI } from "../../api/services/post";
import usePagination from "../../hooks/usePagination";
import { useAuth } from "../../hooks/useAuth";

const Post = () => {
  const { state } = useLocation(); // 검색 state 가져오기
  const navigate = useNavigate();
  const { userInfo } = useAuth();

  // 1. state 생성
  const [postList, setPostList] = useState([]);

  // 10개씩 pagination
  const itemsPerpage = 10;
  const { currentPage, currentItems, totalPages, paginate } = usePagination(
    postList,
    itemsPerpage
  );

  // 2. axios 사용해서 setting
  const getPostLists = async () => {
    if (state) {
      setPostList(state);
    } else {
      try {
        const res = await postAPI.getPostList();
        //console.log(res.data);
        setPostList(res.data);
      } catch (err) {
        console.error(err);
      }
    }
  };

  // 3. useEffect에 함수 적용
  useEffect(() => {
    getPostLists();
  }, [state]);

  return (
    <>
      <h1>POST LIST</h1>
      {/* 글쓰기 버튼 */}
      {userInfo && (
        <>
          <Button
            variant="contained"
            color="main"
            onClick={() => navigate("/post/write")}
          >
            글쓰기
          </Button>

          <Divider />
        </>
      )}

      {/* 전체 리스트 */}
      <Grid2 container spacing={4} direction={"column"}>
        {currentItems.map((post) => (
          <PostCard post={post} key={post.id} />
        ))}
      </Grid2>

      <Divider />

      {/* pagination */}
      <div
        style={{
          display: "flex",
          justifyContent: "center",
          alignItems: "center",
          marginTop: "1rem",
        }}
      >
        <Pagination
          count={totalPages}
          page={currentPage}
          onChange={(event, page) => paginate(page)}
          color="secondary"
          variant="outlined"
          sx={{ marginBottom: "15px" }}
        />
      </div>
    </>
  );
};

export default Post;
