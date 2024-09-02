import React from "react";
import Card from "@mui/material/Card";
import CardHeader from "@mui/material/CardHeader";
import CardMedia from "@mui/material/CardMedia";
import CardContent from "@mui/material/CardContent";
import Avatar from "@mui/material/Avatar";
import Typography from "@mui/material/Typography";

const PostCard = ({ post }) => {
  return (
    <Card sx={{ maxWidth: 345 }}>
      <CardHeader
        avatar={<Avatar>{post.id}</Avatar>}
        title={post.title}
        subheader={post.createdAt}
      />
      <CardMedia component="img" height="194" image="" alt="게시글 이미지" />
      <CardContent>
        <Typography variant="body2" sx={{ color: "text.secondary" }}>
          {post.content}
        </Typography>
      </CardContent>
    </Card>
  );
};

export default PostCard;
