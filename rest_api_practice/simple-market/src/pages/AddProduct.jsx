import React from "react";
import ProductForm from "../components/product/ProductForm";

const AddProduct = () => {
  return (
    <div className="flex items-center justify-center min-h-screen bg-gray-50 dark:bg-gray-900">
      <div className="p-6 bg-white rounded shadow-lg w-full max-w-md dark:bg-gray-800 dark:border dark:border-gray-700">
        <h1 className="text-2xl font-semibold mb-4 text-center text-gray-900 dark:text-gray-100">
          상품 추가
        </h1>
        <ProductForm />
      </div>
    </div>
  );
};

export default AddProduct;
