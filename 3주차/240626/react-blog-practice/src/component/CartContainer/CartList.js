import React from "react";

function CartList({ cart, deleteMenu }) {
  return (
    <div style={{ border: "3px solid #333", padding: 10, width: 200 }}>
      <div>
        합계 :{" "}
        {cart.reduce((accumulator, currentValue) => {
          return accumulator + currentValue.price;
        }, 0)}
      </div>
      <h4
        style={{
          backgroundColor: "black",
          color: "yellow",
          textAlign: "center",
        }}
      >
        주문상품
      </h4>
      <ul>
        {cart.map((menu, index) => {
          return (
            <li key={index}>
              {menu.name} {menu.price}
              <button
                style={{ fontSize: 12, marginLeft: 5 }}
                onClick={() => deleteMenu(index)}
              >
                삭제
              </button>
            </li>
          );
        })}
      </ul>
    </div>
  );
}

export default CartList;
