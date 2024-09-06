import React from "react";
import { Typography, Button, Container } from "@mui/material";
import { useLocation, useNavigate } from "react-router-dom";

const Error = () => {
  const navigate = useNavigate();
  const { state } = useLocation();

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
        {state} 발생
      </Typography>
      <Button variant="contained" color="sub" onClick={() => navigate("/")}>
        홈으로 돌아가기
      </Button>
    </Container>
  );
};

export default Error;
