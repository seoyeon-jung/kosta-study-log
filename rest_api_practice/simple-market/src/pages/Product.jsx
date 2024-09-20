import React from "react";
import ProductDetail from "../components/product/ProductDetail";
import { Button } from "@material-tailwind/react";
import { useNavigate } from "react-router-dom";

const Product = () => {
  const navigate = useNavigate();

  return (
    <div className="flex flex-col items-center justify-center min-h-screen p-4">
      <ProductDetail />
      {/* 뒤로가기 버튼 추가 */}
      <div className="flex justify-center mt-4 mb-4">
        <Button
          className="bg-cyan-300 text-white hover:bg-cyan-500 dark:bg-gray-300 dark:hover:bg-gray-500 dark:text-black"
          onClick={() => navigate(-1)} // 이전 페이지로 돌아가기
        >
          이전으로 돌아가기
        </Button>
      </div>
    </div>
  );
};

export default Product;
