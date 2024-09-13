import React from "react";
import { ListItem } from "@material-tailwind/react";
import { useNavigate } from "react-router-dom";

const ProductItem = ({ product }) => {
  const navigate = useNavigate();

  const handleClick = () => {
    navigate(`/products/${product.id}`);
  };

  return (
    <ListItem
      onClick={handleClick}
      className="flex justify-between items-center p-2 rounded-lg shadow-sm hover:bg-cyan-100 transition-colors duration-200
        bg-cyan-50 dark:bg-dark-paper dark:text-dark-text
        hover:dark:bg-dark-background"
    >
      <div className="font-semibold text-gray-800 dark:text-gray-200">
        {product.name}
      </div>
      <div className="text-gray-600 dark:text-gray-400">{product.price}원</div>
    </ListItem>
  );
};

export default ProductItem;
