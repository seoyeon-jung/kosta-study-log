import React, { useState } from "react";

const Container = () => {
  // 하위 컴포넌트의 데이터를 관리, 관련된 핸들러 정의
  // 하위 컴포넌트로 필요한 속성 전달

  const style = {
    wrapper: {
      padding: 15,
      display: "flex",
      flexDirection: "column",
    },
  };

  const menus = [
    { mno: 1, name: "상품1", prcie: 3000 },
    { mno: 2, name: "상품2", prcie: 5000 },
    { mno: 3, name: "상품3", prcie: 4000 },
    { mno: 4, name: "상품4", prcie: 2000 },
    { mno: 5, name: "상품5", prcie: 1000 },
  ];

  const [selectedMenu, setSelectedMenu] = useState();

  return (
    <div>
      <div>List</div>
    </div>
  );
};

export default Container;
