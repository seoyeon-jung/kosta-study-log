import React, { useEffect, useReducer, useState } from "react";
import axios from "axios";
import ProdInput from "./product/ProdInput";
import ProdBox from "./product/ProdBox";

const productReducer = (state, action) => {
  switch (action.type) {
    case "SET_PRODUCTS":
      return action.payload;
    case "ADD_PRODUCT":
      return [...state, action.payload];
    case "EDIT_PRODUCT":
      return state.map((p) =>
        p.id === action.payload.id ? action.paylload : p
      );
    case "DELETE_PRODUCT":
      return state.filter((p) => p.id !== action.payload);
    default:
      return state;
  }
};

const Product = () => {
  //const [products, setProducts] = useState([]);
  const [products, dispatch] = useReducer(productReducer, []);
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
      //setProducts(data);
      dispatch({ type: "SET_PRODUCTS", payload: data });
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
      <ProdInput
        //setProducts={setProducts}
        //products={products}
        dispatch={dispatch}
      />

      <div style={{ display: "flex", flexWrap: "wrap" }}>
        {products.map((prod) => {
          return (
            <ProdBox
              key={prod.id}
              prod={prod}
              //setProducts={setProducts}
              products={products}
              dispatch={dispatch}
            />
          );
        })}
      </div>
    </main>
  );
};

export default Product;
