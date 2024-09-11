import { Box, Button, Divider, List, Typography } from "@mui/material";
import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { favoriteAPI } from "../../api/services/favorite";
import FavoriteCard from "./FavoriteCard";
import NotificationsIcon from "@mui/icons-material/Notifications";

const Favorite = () => {
  const navigate = useNavigate();
  const [favList, setFavList] = useState([]);

  const getFavList = async () => {
    try {
      const res = await favoriteAPI.getFavoriteList();
      setFavList(res.data);
    } catch (error) {
      console.log(error);
      // navigate("/error", { state: error });
    }
  };

  // 삭제된 북마크를 상태에서 제거
  const handleDelete = (id) => {
    setFavList((prev) => prev.filter((fav) => fav.id !== id));
  };

  useEffect(() => {
    getFavList();
  });

  return (
    <>
      <h1>북마크 LIST</h1>
      <Box
        sx={{
          display: "flex",
          alignItems: "center",
          gap: 1,
          marginBottom: "10px",
        }}
      >
        <NotificationsIcon />
        <Typography variant="body1">
          제목을 클릭하거나, 이미지를 클릭하면 해당 링크로 이동합니다.
        </Typography>
      </Box>

      {/* 북마크 추가 버튼 */}
      <Button
        variant="contained"
        color="main"
        onClick={() => navigate("/favorite/write")}
      >
        북마크 추가하기
      </Button>

      <Divider />

      {/* 북마크 리스트 */}
      <List>
        {favList.map((favorite, idx) => (
          <FavoriteCard
            key={idx}
            favorite={favorite}
            id={favorite.id}
            onDelete={handleDelete}
          />
        ))}
      </List>
    </>
  );
};

export default Favorite;
