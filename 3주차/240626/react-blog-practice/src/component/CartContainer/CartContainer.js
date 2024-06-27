import React, { useState } from "react";
import ProductList from "./ProductList";
import CartList from "./CartList";

function CartContainer(props) {
  const styles = {
    wrapper: {
      padding: 15,
      display: "flex",
      flexDirection: "row",
      jstifyContent: "space-around",
    },
  };

  const products = [
    { mno: 1, name: "커피", price: 3000 },
    { mno: 2, name: "Tea", price: 4000 },
    { mno: 3, name: "음료", price: 5000 },
    { mno: 4, name: "디저트", price: 6000 },
    { mno: 5, name: "굿즈", price: 7000 },
  ];

  const [cart, setCart] = useState([]);

  const selectedMenu = (mno) => {
    const menu = products.find((p) => p.mno === mno);
    setCart([...cart, menu]);
  };

  const deleteMenu = (mno) => {
    //const newCart = cart.filter(menu => menu.mno !== mno)
    const newCart = cart.filter((item, index) => mno !== index);
    setCart([...newCart]);
  };

  return (
    <div style={styles.wrapper}>
      <ProductList
        productList={products}
        selectedMenu={selectedMenu}
      ></ProductList>
      <CartList cart={cart} deleteMenu={deleteMenu}></CartList>
    </div>
  );
}

export default CartContainer;
