import { Button, Divider, List } from "@mui/material";
import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { favoriteAPI } from "../../api/services/favorite";
import FavoriteCard from "./FavoriteCard";

const Favorite = () => {
  const navigate = useNavigate();
  const [favList, setFavList] = useState([]);

  const getFavList = async () => {
    try {
      const res = await favoriteAPI.getFavoriteList();
      setFavList(res.data);
    } catch (error) {
      console.error(error);
    }
  };

  // 삭제된 북마크를 상태에서 제거
  const handleDelete = (id) => {
    setFavList((prev) => prev.filter((fav) => fav.id !== id));
  };

  useEffect(() => {
    getFavList();
  }, []);

  return (
    <>
      <h1>북마크 LIST</h1>
      <p>제목을 클릭하거나, 이미지를 클릭하면 링크로 이동합니다.</p>

      {/* 북마크 추가 버튼 */}
      <Button
        variant="contained"
        color="main"
        onClick={() => navigate("/favorite/write")}
      >
        북마크 추가하기
      </Button>

      <Divider />

      <List>
        {favList.map((favorite) => (
          <FavoriteCard
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
