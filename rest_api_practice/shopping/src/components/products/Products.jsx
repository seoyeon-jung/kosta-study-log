import React, { useEffect, useReducer, useState } from "react";
import ProductBox from "./ProductBox";
import axios from "axios";

// reducer
const productReducer = (state, action) => {
  switch (action.type) {
    case "SET_PRODUCT":
      return action.payload;
    case "ADD_PRODUCT":
      return [...state, action.payload];
    case "EDIT_PRODUCT":
      return state.map((p) =>
        p.id === action.payload.id ? action.payload : p
      );
    case "DELETE_PRODUCT":
      return state.filter((p) => p.id !== action.payload.id);
    default:
      return;
  }
};

const Products = () => {
  const [productList, dispatch] = useReducer(productReducer, []);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(false);

  //const [productList, setProductList] = useState([]);
  const [newProduct, setNewProduct] = useState({
    name: "",
    description: "",
    price: "",
  });

  const getProducts = async () => {
    try {
      const res = await axios.get("http://localhost:8080/product");
      const data = res.data;
      // setProductList(data);
      dispatch({ type: "SET_PRODUCT", payload: data });
      setLoading(false);
    } catch (err) {
      console.error(err);
      setError(true);
    }
  };

  const handleChange = (e) => {
    setNewProduct((prevState) => ({
      ...prevState,
      [e.target.name]: e.target.value,
    }));
  };

  const handleAddProduct = async () => {
    try {
      const res = await axios.post("http://localhost:8080/product", newProduct);
      const data = res.data;
      //setProductList([...productList, data]);
      dispatch({ type: "ADD_PRODUCT", payload: data });
      setNewProduct({
        name: "",
        description: "",
        price: "",
      });
    } catch (err) {
      console.error(err);
    }
  };

  useEffect(() => {
    getProducts();
  }, []);

  if (error) {
    return <main>error!</main>;
  }

  if (loading) {
    return <main>loading...</main>;
  }

  return (
    <main>
      상품 목록
      <div style={{ display: "flex", flexWrap: "wrap" }}>
        {productList.map((product) => (
          <ProductBox
            key={product.id}
            product={product}
            getProducts={getProducts}
            dispatch={dispatch}
          />
        ))}
      </div>
      <div>
        <input name="name" value={newProduct.name} onChange={handleChange} />
        <input
          name="description"
          value={newProduct.description}
          onChange={handleChange}
        />
        <input
          name="price"
          type="number"
          value={newProduct.price}
          onChange={handleChange}
        />
        <button onClick={handleAddProduct}>등록</button>
      </div>
    </main>
  );
};

export default Products;
