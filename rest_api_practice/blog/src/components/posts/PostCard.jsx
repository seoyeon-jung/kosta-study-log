import React from "react";
import Card from "@mui/material/Card";
import CardHeader from "@mui/material/CardHeader";
import Avatar from "@mui/material/Avatar";
import { useNavigate } from "react-router-dom";
import { useTheme } from "@emotion/react";

const PostCard = ({ post }) => {
  const navigate = useNavigate();
  const theme = useTheme();

  return (
    <Card
      sx={{ maxWidth: 345, cursor: "pointer" }}
      onClick={() => navigate(`/post/${post.id}`)}
    >
      <CardHeader
        avatar={
          <Avatar sx={{ bgcolor: theme.palette.main.main }}>{post.id}</Avatar>
        }
        title={post.title}
        subheader={post.createdAt}
      />
    </Card>
  );
};

export default PostCard;
