import React, { useEffect, useState } from "react";
import ProductList from "../components/product/ProductList";
import { Button } from "@material-tailwind/react";
import { useNavigate } from "react-router-dom";
import { useCookies } from "react-cookie";
import { jwtDecode } from "jwt-decode";

const Products = () => {
  const navigate = useNavigate();
  const [role, setRole] = useState(null);
  const [loading, setLoading] = useState(false);
  const [cookies] = useCookies(["accessToken"]);

  useEffect(() => {
    const fetchRole = () => {
      const token = cookies.accessToken;

      if (token) {
        try {
          const decodedToken = jwtDecode(token);
          setRole(decodedToken.role);
        } catch (error) {
          console.error("[token error] ", error);
        }
      }
      setLoading(false);
    };

    fetchRole();
  }, [cookies.accessToken]);

  if (loading) {
    return <div className="text-center">Loading...</div>;
  }

  return (
    <div className="flex flex-col items-center justify-center min-h-screen p-4">
      <h1 className="text-2xl font-bold mb-6">상품 리스트</h1>
      {role === "ROLE_ADMIN" && (
        <Button
          className="lg:hidden mb-4 bg-cyan-100 hover:bg-cyan-200 dark:bg-gray-200 dark:text-black dark:hover:bg-gray-400"
          onClick={() => navigate("/products/add")}
        >
          상품 추가
        </Button>
      )}
      <ProductList />
    </div>
  );
};

export default Products;
