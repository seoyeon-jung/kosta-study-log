import React, { useEffect, useState } from "react";
import axios from "axios";

const Product = () => {
  const [products, setProducts] = useState([]);

  const getProducts = () => {
    axios
      .get("http://localhost:8080/products")
      .then((res) => {
        return res.data;
      })
      .then((data) => setProducts(data));
  };

  useEffect(() => {
    getProducts();
  }, []);

  return (
    <main>
      <div style={{ display: "flex", flexWrap: "wrap" }}>
        {products.map((prod) => {
          return (
            <div
              key={prod.name}
              style={{
                textAlign: "left",
                display: "flex",
                flexDirection: "column",
                width: "30%",
                padding: "10px",
              }}
            >
              <div
                style={{
                  width: "100%",
                  height: "100px",
                  backgroundColor: "lightgray",
                }}
              >
                <div>{prod.name}</div>
                <div>{prod.price}</div>
              </div>
            </div>
          );
        })}
      </div>
    </main>
  );
};

export default Product;
