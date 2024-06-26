import React, { useState } from "react";
import Toolbar from "./Toolbar";

// isLogin  Toolbar => 로그인 상태 전달,  로그인 핸들러, 로그아웃 핸들러

function MainPage(props) {
  // 변경값 : 로그인 여부
  const [isLogin, setIsLogin] = useState(false);

  const onClickLogin = () => {
    setIsLogin(true);
  };
  const onClickLogout = () => {
    setIsLogin(false);
  };

  return (
    <>
      <Toolbar
        isLogin={isLogin}
        onClickLoginHandle={onClickLogin}
        onClickLogoutHandle={onClickLogout}
      ></Toolbar>
      안녕하세요. 메인페이지 입니다.
    </>
  );
}

export default MainPage;
