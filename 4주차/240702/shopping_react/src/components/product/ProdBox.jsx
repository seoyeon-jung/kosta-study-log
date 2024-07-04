import axios from "axios";
import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import styled from "styled-components";

// products, setProducts
const ProdBox = ({ prod, dispatch }) => {
  const [isUpdateMode, setIsUpdateMode] = useState(false);
  const navigate = useNavigate();

  // update 진행
  // 1. 입력한 상품명과 가격 받아오기
  const [product, setProduct] = useState({
    name: prod.name,
    price: prod.price,
    description: prod.description,
  });

  const handleUpdateMode = (id) => {
    setIsUpdateMode(true);
  };

  const handleUpdate = async () => {
    try {
      // 2. 서버에 update 요청
      // put : 전체에 대한 변경
      // patch : 일부에 대한 변경
      const editProduct = { ...product, id: prod.id };
      await axios.put(`http://localhost:8080/products/${prod.id}`, product);
      // const updateProducts = products.map((p) =>
      //   p.id === prod.id ? editProduct : p
      // );
      //setProducts(updateProducts);
      dispatch({ type: "EDIT_PRODUCT", payload: editProduct });

      //getProducts();

      // 3. 정상적으로 update 되었다는 mode false로 변경
      setIsUpdateMode(false);
    } catch (error) {
      console.error(error);
    }
  };

  const handleChange = (e) => {
    setProduct((prevState) => ({
      ...prevState,
      [e.target.name]: e.target.value,
    }));
  };

  const handleDelete = async () => {
    try {
      await axios.delete(`http://localhost:8080/products/${prod.id}`);
      //getProducts();

      // const newProducts = products.filter((p) => {
      //   return p.id !== prod.id;
      // });
      //setProducts(newProducts);

      dispatch({ type: "DELETE_PRODUCT", payload: prod.id });
    } catch (err) {
      console.error(err);
    }
  };

  const priceNumber = parseInt(product.price);

  return (
    <Wrapper key={prod.name}>
      <Container>
        {isUpdateMode ? (
          <EditWrapper>
            <Input
              type="text"
              name="name"
              onChange={handleChange}
              value={product.name}
            />
            <Input
              type="number"
              name="price"
              min="0"
              step="1000"
              onChange={handleChange}
              value={product.price}
            />
            <Textarea
              type="text"
              name="description"
              onChange={handleChange}
              value={product.description}
            />
            <Button onClick={handleUpdate}>완료</Button>
          </EditWrapper>
        ) : (
          <>
            <Name onClick={() => navigate(`/product/${prod.id}`)}>
              {prod.name}
            </Name>
            <Price>{priceNumber.toLocaleString()}원</Price>
            <Button primary onClick={handleUpdateMode}>
              수정
            </Button>
            <Button danger onClick={handleDelete}>
              삭제
            </Button>
          </>
        )}
      </Container>
    </Wrapper>
  );
};

const Wrapper = styled.div`
  text-align: center;
  display: flex;
  flex-direction: column;
  width: 30%;
  padding: 10px;
  align-items: center;
`;

const Container = styled.div`
  width: 100%;
  background-color: #ddd;
  border-radius: 10px;
  padding: 5px;
`;

const EditWrapper = styled.div`
  display: flex;
  flex-direction: column;
  text-align: center;
  align-items: center;
`;

const Button = styled.button`
  background-color: ${(props) =>
    props.primary ? "#bf4f74" : props.danger ? "#ff3131" : "#868686"};
  font-size: 1em;
  color: #fff;
  font-weight: semi-bold;
  padding: 0.25em 1em;
  //border: 2px solid #bf4f74;
  border: none;
  border-radius: 10px;
  margin: 10px;
  cursor: pointer;

  &:hover {
    opacity: 70%;
  }
`;

const Input = styled.input`
  width: 90%;
  height: 30px;
  margin-bottom: 20px;
  border-radius: 5px;
  border: 1px solid black;
`;

const Textarea = styled.textarea`
  width: 90%;
  height: 80px;
  margin-bottom: 20px;
  border-radius: 5px;
  border: 1px solid black;
`;

const Name = styled.div`
  font-size: 20px;
  cursor: pointer;

  &:hover {
    text-decoration: underline;
    opacity: 70%;
  }
`;

const Price = styled.div`
  font-size: 15px;
`;

export default ProdBox;
