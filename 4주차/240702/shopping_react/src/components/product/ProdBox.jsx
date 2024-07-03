import axios from "axios";
import React, { useState } from "react";

const ProdBox = ({ prod, products, setProducts }) => {
  const [isUpdateMode, setIsUpdateMode] = useState(false);

  // update 진행
  // 1. 입력한 상품명과 가격 받아오기
  const [product, setProduct] = useState({
    name: prod.name,
    price: prod.price,
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
      const updateProducts = products.map((p) =>
        p.id === prod.id ? editProduct : p
      );
      setProducts(updateProducts);

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

      const newProducts = products.filter((p) => {
        return p.id !== prod.id;
      });

      setProducts(newProducts);
    } catch (err) {
      console.error(err);
    }
  };

  return (
    <div
      key={prod.name}
      style={{
        textAlign: "center",
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
        {isUpdateMode ? (
          <>
            <div>
              <input
                type="text"
                name="name"
                onChange={handleChange}
                value={product.name}
              />
            </div>
            <div>
              <input
                type="number"
                name="price"
                min="0"
                step="1000"
                onChange={handleChange}
                value={product.price}
              />
            </div>
            <button onClick={handleUpdate}>완료</button>
          </>
        ) : (
          <>
            <div>{prod.name}</div>
            <div>{prod.price}</div>
            <button onClick={handleUpdateMode}>수정</button>
            <button onClick={handleDelete}>삭제</button>
          </>
        )}
      </div>
    </div>
  );
};

export default ProdBox;
