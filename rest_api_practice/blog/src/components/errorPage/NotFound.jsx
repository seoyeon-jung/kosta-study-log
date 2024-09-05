import { Button, Container, Typography } from "@mui/material";
import React from "react";
import { useNavigate } from "react-router-dom";

const NotFound = () => {
  const navigate = useNavigate();

  return (
    <Container
      sx={{
        display: "flex",
        flexDirection: "column",
        alignItems: "center",
        justifyContent: "center",
        height: "100vh",
        textAlign: "center",
        padding: 3,
      }}
    >
      <Typography variant="h1" component="h1" color="#000" gutterBottom>
        404
      </Typography>
      <Typography variant="h5" component="h2" gutterBottom>
        페이지를 찾을 수 없습니다
      </Typography>
      <Typography variant="body1">
        요청하신 페이지가 존재하지 않거나 삭제되었을 수 있습니다.
      </Typography>
      <Button variant="contained" color="danger" onClick={() => navigate("/")}>
        홈으로 돌아가기
      </Button>
    </Container>
  );
};

export default NotFound;
