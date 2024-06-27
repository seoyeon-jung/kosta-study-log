import React from "react";

function ProductList({ productList, selectedMenu }) {
  return (
    <div style={{ border: "3px solid #333333", padding: 10, width: 200 }}>
      <ul>
        {productList.map((product) => {
          return (
            <li key={product.mno} onClick={() => selectedMenu(product.mno)}>
              {" "}
              {product.name}{" "}
            </li>
          );
        })}
      </ul>
    </div>
  );
}

export default ProductList;
