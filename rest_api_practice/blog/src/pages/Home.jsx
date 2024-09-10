import React from "react";
import { useAuth } from "../hooks/useAuth";

const Home = () => {
  const { userInfo } = useAuth();

  return (
    <>
      <h1>HOME</h1>
      <div>{userInfo && userInfo.email}님 안녕하세요!</div>
    </>
  );
};

export default Home;
