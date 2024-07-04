import axios from "axios";
import React, { useState } from "react";
import styled from "styled-components";

//{products, setProducts}
const ProdInput = ({ dispatch }) => {
  // usestate가 너무 많으면 비효율적이다
  //     const [name, setName] = useState("");
  //   const [price, setPrice] = useState(0);

  const [newProduct, setNewProduct] = useState({
    name: "",
    price: 0,
    description: "",
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
      //setProducts([...products, newProd]);
      dispatch({ type: "ADD_PRODUCT", payload: newProd });
    } catch (err) {
      console.error(err);
    }
  };

  return (
    <Wrapper>
      <Input
        type="text"
        name="name"
        value={newProduct.name}
        onChange={handleChange}
        placeholder="물건을 입력해주세요"
      />
      <Input
        type="number"
        name="price"
        min="0"
        step="1000"
        value={newProduct.price}
        onChange={handleChange}
      />
      <Textarea
        type="text"
        name="description"
        value={newProduct.description}
        onChange={handleChange}
        placeholder="제품 설명을 입력해주세요"
      />
      <Button onClick={handleAddProd}>추가</Button>
    </Wrapper>
  );
};

const Wrapper = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  margin-bottom: 30px;
`;

const Input = styled.input`
  width: 100%;
  height: 30px;
  margin-bottom: 20px;
  border-radius: 5px;
  border: 1px solid black;

  &::placeholder {
    font-size: 12px;
    padding: 3px;
  }
`;

const Textarea = styled.textarea`
  width: 100%;
  height: 80px;
  margin-bottom: 20px;
  border-radius: 5px;
  border: 1px solid black;

  &::placeholder {
    font-size: 12px;
    padding: 3px;
  }
`;

const Button = styled.button`
  width: 100%;
  padding: 10px;
  background-color: #000;
  border: none;
  color: white;
  border-radius: 10px;
  cursor: pointer;

  &:hover {
    opacity: 70%;
  }
`;

export default ProdInput;
