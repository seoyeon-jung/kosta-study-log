import axios from "axios";
import React, { useState } from "react";
import styled from "styled-components";

const ProductBox = ({ product, getProducts, exceptProduct, modifyProduct }) => {
  const [updateState, setUpdateState] = useState(false);
  const [productInfo, setProductInfo] = useState({
    name: product.name,
    price: product.price,
  });

  const handleDelete = async () => {
    try {
      console.log(product.id + "를 삭제한다.");
      const res = await axios.delete(
        `http://localhost:8080/product/${product.id}`
      );
      console.log(res);
      exceptProduct(product.id);
    } catch {
      console.error("이미 삭제된 상품입니다.");
      getProducts();
    }
  };

  const toggleUpdate = () => {
    if (updateState === false) {
      setProductInfo({
        name: product.name,
        price: product.price,
      });
    }
    setUpdateState(!updateState);
  };

  const handleProductionInfo = (e) => {
    // 변경될 때마다
    setProductInfo((prevState) => ({
      ...prevState,
      [e.target.name]: e.target.value,
    }));
  };

  const handleUpdate = async () => {
    const editedProduct = { ...productInfo, id: product.id };
    const res = await axios.patch(
      "http://localhost:8080/product",
      editedProduct
    );
    const data = res.data;
    modifyProduct(data); // 수정 후에 data 넣어주기
    setUpdateState(false);
  };

  return (
    <StyledProductBox>
      {updateState ? (
        <div>
          <input
            name="name"
            value={productInfo.name}
            onChange={handleProductionInfo}
          />
          <input
            name="price"
            type="number"
            value={productInfo.price}
            onChange={handleProductionInfo}
          />
          <button onClick={handleUpdate}>수정</button>
          <button onClick={toggleUpdate}>취소</button>
        </div>
      ) : (
        <div>
          <p>{product.name}</p>
          <p>{product.price}</p>
          <button onClick={toggleUpdate}>수정</button>
          <button onClick={handleDelete}>삭제</button>
        </div>
      )}
    </StyledProductBox>
  );
};

const StyledProductBox = styled.div`
  display: flex;
  flex-direction: column;
  width: 30%;
  padding: 10px;
`;

export default ProductBox;
