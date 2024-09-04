import {
  Avatar,
  IconButton,
  Link,
  ListItem,
  ListItemAvatar,
  ListItemText,
} from "@mui/material";
import React from "react";
import DeleteIcon from "@mui/icons-material/Delete";
import ModeEditIcon from "@mui/icons-material/ModeEdit";
import Swal from "sweetalert2";
import { favoriteAPI } from "../../api/services/favorite";
import { useNavigate } from "react-router-dom";

const FavoriteCard = ({ favorite, onDelete }) => {
  const id = favorite.id;
  const navigate = useNavigate();

  // 북마크 삭제
  const handleDelete = async () => {
    try {
      const result = await Swal.fire({
        title: "삭제 확인",
        text: "이 북마크를 정말 삭제하시겠습니까?",
        icon: "warning",
        showCancelButton: true,
        confirmButtonColor: "#3085d6",
        cancelButtonColor: "#d33",
        confirmButtonText: "삭제",
        cancelButtonText: "취소",
      });

      if (result.isConfirmed) {
        await favoriteAPI.deleteFavorite(id);

        // 삭제 후 성공 메세지
        Swal.fire("삭제 완료", "북마크가 삭제되었습니다", "success");

        if (onDelete) {
          onDelete(id);
        }
      }
    } catch (error) {
      console.error(error);
      Swal.fire("오류 발생", "북마크 삭제 중 오류가 발생했습니다.", "error");
    }
  };

  return (
    <ListItem>
      <ListItemAvatar>
        <Avatar
          sx={{
            width: 56,
            height: 56,
            display: "flex",
            justifyContent: "center",
            alignItems: "center",
            overflow: "hidden",
            marginRight: "20px",
          }}
        >
          <Link href={favorite.url} target="_blank">
            <img
              src={`${process.env.REACT_APP_SERVER}/img/${favorite.imageFile.saved}`}
              alt="게시글 이미지"
              style={{
                width: "100%",
                height: "100%",
                objectFit: "cover",
              }}
            />
          </Link>
        </Avatar>
      </ListItemAvatar>
      <ListItemText>
        <Link
          href={favorite.url}
          underline="hover"
          target="_blank"
          sx={{ color: "#000000" }}
        >
          {favorite.title}
        </Link>
      </ListItemText>
      <IconButton onClick={() => navigate(`/favorite/modify/${favorite.id}`)}>
        <ModeEditIcon />
      </IconButton>
      <IconButton edge="end" onClick={handleDelete}>
        <DeleteIcon />
      </IconButton>
    </ListItem>
  );
};

export default FavoriteCard;
