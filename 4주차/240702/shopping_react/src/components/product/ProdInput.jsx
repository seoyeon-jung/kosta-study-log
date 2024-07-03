import axios from "axios";
import React, { useState } from "react";

const ProdInput = ({ setProducts, products }) => {
  // usestate가 너무 많으면 비효율적이다
  //     const [name, setName] = useState("");
  //   const [price, setPrice] = useState(0);

  const [newProduct, setNewProduct] = useState({
    name: "",
    price: 0,
  });

  const handleChange = (e) => {
    // const name = e.target.name;
    // const value = e.target.value;
    // setNewProduct({ ...newProduct, [name]: value });
    // 객체 안에서 key를 []로 감싸면 그 안에 넣은 레퍼런스가 가리키는 실제 값이 key 값으로 사용

    // const {name, value} = e.target;
    // setNewProduct({...newProduct, [name]: value})

    //setNewProduct({ ...newProduct, [e.target.name]: e.target.value });
    setNewProduct((prevState) => ({
      ...prevState,
      [e.target.name]: e.target.value,
    }));
  };

  const handleAddProd = async () => {
    try {
      const res = await axios.post(
        "http://localhost:8080/products",
        newProduct
      );
      const newProd = res.data;
      setProducts([...products, newProd]);
    } catch (err) {
      console.error(err);
    }
  };

  return (
    <div>
      <input
        type="text"
        name="name"
        value={newProduct.name}
        onChange={handleChange}
      />
      <input
        type="number"
        name="price"
        min="0"
        step="1000"
        value={newProduct.price}
        onChange={handleChange}
      />
      <button onClick={handleAddProd}>추가</button>
    </div>
  );
};

export default ProdInput;
