import React from "react";
import ProductDetail from "../components/product/ProductDetail";

const Product = () => {
  return (
    <div className="flex flex-col items-center justify-center min-h-screen p-4">
      <h1 className="text-2xl font-bold mb-6">상품 상세보기</h1>
      <ProductDetail />
    </div>
  );
};

export default Product;
