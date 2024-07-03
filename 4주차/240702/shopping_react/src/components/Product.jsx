import React, { useEffect, useState } from "react";
import axios from "axios";
import ProdInput from "./product/ProdInput";
import ProdBox from "./product/ProdBox";

const Product = () => {
  const [products, setProducts] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(false);

  // const getProducts = () => {
  //   axios
  //     .get("http://localhost:8080/products")
  //     .then((res) => {
  //       return res.data;
  //     })
  //     .then((data) => setProducts(data))
  //     .catch((err) => console.error(err));
  // };

  const getProducts = async () => {
    try {
      const res = await axios.get("http://localhost:8080/products");
      setLoading(false);
      const data = res.data;
      setProducts(data);
    } catch (err) {
      console.error(err);
      setError(true);
    }
  };

  useEffect(() => {
    getProducts();
  }, []);

  if (error) {
    return <div>에러 발생</div>;
  }

  if (loading) {
    return <div>loading...</div>;
  }

  return (
    <main>
      <div style={{ display: "flex", flexWrap: "wrap" }}>
        {products.map((prod) => {
          return (
            <ProdBox
              key={prod.id}
              prod={prod}
              setProducts={setProducts}
              products={products}
            />
          );
        })}
      </div>

      <ProdInput setProducts={setProducts} products={products} />
    </main>
  );
};

export default Product;
