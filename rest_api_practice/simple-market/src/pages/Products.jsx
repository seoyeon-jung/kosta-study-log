import React from "react";
import ProductList from "../components/product/ProductList";
import { Button } from "@material-tailwind/react";
import { useNavigate } from "react-router-dom";

const Products = () => {
  const navigate = useNavigate();

  return (
    <div className="flex flex-col items-center justify-center min-h-screen p-4">
      <h1 className="text-2xl font-bold mb-6">상품 리스트</h1>
      <Button
        className="lg:hidden mb-4 bg-cyan-100 hover:bg-cyan-200"
        onClick={() => navigate("/products/add")}
      >
        상품 추가
      </Button>
      <ProductList />
    </div>
  );
};

export default Products;
