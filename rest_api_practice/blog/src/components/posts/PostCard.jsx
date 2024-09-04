import React from "react";
import Card from "@mui/material/Card";
import CardHeader from "@mui/material/CardHeader";
import Avatar from "@mui/material/Avatar";
import { useNavigate } from "react-router-dom";
import { useTheme } from "@emotion/react";
import SimCardDownloadIcon from "@mui/icons-material/SimCardDownload";
import { IconButton } from "@mui/material";
import axios from "axios";

const PostCard = ({ post }) => {
  const navigate = useNavigate();
  const theme = useTheme();

  const handleDownload = async () => {
    try {
      await axios.get(
        `${process.env.REACT_APP_REST_SERVER}/post/download/${post.image.id}`
      );
    } catch (error) {
      console.error(error);
    }
    // e.stopPropagation();
    // window.location.href = `${process.env.REACT_APP_REST_SERVER}/post/download/${post.image.id}`;
  };

  return (
    <Card
      sx={{ width: { xs: "300px", sm: "800px" }, cursor: "pointer" }}
      onClick={() => navigate(`/post/${post.id}`)}
    >
      <CardHeader
        avatar={
          <Avatar sx={{ bgcolor: theme.palette.main.main }}>{post.id}</Avatar>
        }
        title={post.title}
        subheader={post.createdAt}
        action={
          post.image && (
            <IconButton>
              <SimCardDownloadIcon onClick={handleDownload} />
            </IconButton>
          )
        }
      />
    </Card>
  );
};

export default PostCard;
