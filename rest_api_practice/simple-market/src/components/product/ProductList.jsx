import React, { useEffect, useReducer } from "react";
import { productAPI } from "../../api/services/product";
import ProductItem from "./ProductItem";
import { Card, List } from "@material-tailwind/react";

const reducer = (state, action) => {
  switch (action.type) {
    case "GET_SUCCESS":
      return { ...state, products: action.payload, loading: false };
    case "GET_FAIL":
      return { ...state, error: action.payload, loading: false };
    default:
      return state;
  }
};

const ProductList = () => {
  const [state, dispatch] = useReducer(reducer, {
    products: [],
    loading: true,
    error: null,
  });

  const { products, loading, error } = state;

  const getAllProducts = async () => {
    try {
      const response = await productAPI.getAllProducts();
      dispatch({ type: "GET_SUCCESS", payload: response.data });
    } catch (error) {
      dispatch({ type: "GET_FAIL", payload: error });
      console.error("[상품 전체 조회 에러] ", error);
    }
  };

  useEffect(() => {
    getAllProducts();
  }, []);

  if (loading)
    return (
      <div className="text-center text-yellow-500 dark:text-white-400">
        loading...
      </div>
    );
  if (error)
    return (
      <div className="text-center text-red-500 dark:text-red-400">
        Error: {error.message}
      </div>
    );

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
