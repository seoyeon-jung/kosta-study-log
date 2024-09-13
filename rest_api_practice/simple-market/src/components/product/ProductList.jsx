import React, { useEffect, useState } from "react";
import { productAPI } from "../../services/product";
import ProductItem from "./ProductItem";
import { Card, List } from "@material-tailwind/react";

const ProductList = () => {
  const [products, setProducts] = useState([]);

  const getAllProducts = async () => {
    try {
      const response = await productAPI.getAllProducts();
      setProducts(response.data);
    } catch (error) {
      console.error("[상품 전체 조회 에러] ", error);
    }
  };

  useEffect(() => {
    getAllProducts();
  }, [products]);

  return (
    <Card className="w-full max-w-md mx-auto my-4 p-4 shadow-lg">
      <List className="space-y-2">
        {products.map((product, idx) => (
          <ProductItem key={idx} product={product} />
        ))}
      </List>
    </Card>
  );
};

export default ProductList;
