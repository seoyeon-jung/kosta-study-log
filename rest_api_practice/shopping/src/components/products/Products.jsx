import React, { useState } from "react";
import ProductBox from "./ProductBox";
import axios from "axios";

const Products = () => {
  const [productList, setProductList] = useState([]);
  const [newProduct, setNewProduct] = useState({
    name: "",
    description: "",
    price: "",
  });

  const getProducts = async () => {
    const res = await axios.get("http://localhost:8080/product");
    const data = res.data;
    setProductList(data);
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
      setProductList([...productList, data]);
      setNewProduct({
        name: "",
        description: "",
        price: "",
      });
    } catch (err) {
      console.error(err);
    }
  };

  // product를 제외시키는 동작
  const exceptProduct = (id) => {
    setProductList(productList.filter((p) => p.id !== id));
  };

  // product 수정 이후 update
  const modifyProduct = (editedProduct) => {
    setProductList(
      productList.map((p) => (p.id === editedProduct.id ? editedProduct : p))
    );
  };

  return (
    <main>
      상품 목록
      <button onClick={getProducts}>가져오기</button>
      <div style={{ display: "flex", flexWrap: "wrap" }}>
        {productList.map((product) => (
          <ProductBox
            key={product.id}
            product={product}
            getProducts={getProducts}
            modifyProduct={modifyProduct}
          />
        ))}
      </div>
      <div>
        <input
          name="name"
          value={newProduct.name}
          onChange={handleChange}
          exceptProduc={exceptProduct}
        />
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
