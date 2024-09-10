import { useTheme } from "@emotion/react";
import {
  Avatar,
  Button,
  Card,
  CardActions,
  CardContent,
  CardHeader,
  CardMedia,
  Typography,
} from "@mui/material";
import DeleteIcon from "@mui/icons-material/Delete";
import ModeEditIcon from "@mui/icons-material/ModeEdit";
import React, { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import Swal from "sweetalert2";
import { postAPI } from "../../api/services/post";
import { useAuth } from "../../hooks/useAuth";

const PostDetail = () => {
  const navigate = useNavigate();
  const [post, setPost] = useState([]);
  const theme = useTheme();
  // id값 가져오기 (url 참고 > /post/id)
  const { postId } = useParams();

  const { userInfo } = useAuth();

  useEffect(() => {
    // 요청 보내기
    const getPost = async () => {
      try {
        const res = await postAPI.getPost(postId);
        const data = res.data;
        setPost(data);
      } catch (error) {
        console.error(error);
        navigate("/error", { state: error.message });
      }
    };

    getPost();
  }, [postId, navigate]);

  // delete
  const handleDelete = async () => {
    const result = await Swal.fire({
      title: "삭제하시겠습니까?",
      text: "삭제하기 위해서는 비밀번호가 필요합니다",
      input: "password",
      inputPlaceholder: "비밀번호를 입력해주세요",
      inputAttributes: {
        maxlength: "10",
        autocapitalize: "off",
        autocorrect: "off",
      },
      showCancelButton: true,
      showCloseButton: true,
    });

    const password = result.value;
    if (password) {
      const authorId = 1; // 로그인 기능 전가지 임시 작성

      // data를 axios를 통해 전달해서 비밀번호가 맞는지 확인 후 맞으면 삭제
      try {
        await postAPI.deletePost(post.id, password, authorId);
        Swal.fire({
          title: "게시물 삭제 완료",
          text: `${post.id}번 게시물이 삭제되었습니다.`,
          icon: "success",
        });
        navigate("/post");
      } catch (error) {
        console.error(error);
        navigate("/error", { state: error.message });
      }
    }
  };

  // 가져온 정보를 화면에 뿌리기
  return (
    <>
      {post && (
        <Card sx={{ width: { xs: "300px", sm: "800px" }, marginTop: "35px" }}>
          <CardHeader
            avatar={
              <Avatar sx={{ bgcolor: theme.palette.main.main }}>
                {post.id}
              </Avatar>
            }
            title={post.title}
            subheader={post.createdAt}
          />
          {post.image && post.image.saved ? (
            <CardMedia
              component="img"
              //height="194"
              image={`${process.env.REACT_APP_SERVER}/img/${post.image.saved}`}
              alt="게시글 이미지"
            />
          ) : null}
          <CardContent>
            <Typography variant="body2" sx={{ color: "text.secondary" }}>
              {post.content}
            </Typography>
          </CardContent>
          {userInfo && (
            <CardActions>
              <Button
                variant="contained"
                color="sub"
                startIcon={<ModeEditIcon />}
                onClick={() => navigate(`/post/modify/${post.id}`)}
              >
                수정
              </Button>
              <Button
                variant="contained"
                color="bg1"
                startIcon={<DeleteIcon />}
                onClick={handleDelete}
              >
                삭제
              </Button>
            </CardActions>
          )}
        </Card>
      )}
    </>
  );
};

export default PostDetail;
