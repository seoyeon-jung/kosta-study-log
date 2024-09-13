import React from "react";
import { Typography, Button } from "@material-tailwind/react";
import { useNavigate } from "react-router-dom";

const NotFound = () => {
  const navigate = useNavigate();

  return (
    <div className="flex items-center justify-center min-h-screen bg-gray-100 p-4">
      <div className="text-center">
        <Typography
          variant="h1"
          color="blue-gray"
          className="text-6xl font-bold mb-4"
        >
          404
        </Typography>
        <Typography variant="h6" color="blue-gray" className="mb-4">
          페이지를 찾을 수 없습니다.
        </Typography>
        <Button
          onClick={() => navigate("/")}
          className="bg-cyan-500 text-white hover:bg-cyan-600"
        >
          홈으로 돌아가기
        </Button>
      </div>
    </div>
  );
};

export default NotFound;
