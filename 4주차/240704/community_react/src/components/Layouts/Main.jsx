import React from "react";
import { Navigate, Outlet, Route, Routes } from "react-router-dom";
import styled from "styled-components";
import Home from "../pages/Home";
import Login from "../pages/Login";
import NotFound from "../pages/NotFound";
import SignUp from "../pages/SignUp";

const Main = () => {
  return (
    <StyledMain>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route element={<GuestRoute />}>
          <Route path="/login" element={<Login />} />
          <Route path="/signup" element={<SignUp />} />
        </Route>

        {/* 로그인한 회원만 접근 가능 */}
        <Route element={<UserRouter />}>
          <Route path="/logout" element={<h2>logout</h2>} />
          <Route path="/info" element={<h2>info page</h2>} />
        </Route>

        <Route path="*" element={<NotFound />} />
      </Routes>
    </StyledMain>
  );
};

const GuestRoute = () => {
  const loginUser = localStorage.getItem("loginUser");
  const isLogin = !!loginUser;
  return isLogin ? <Navigate to="/info" /> : <Outlet />;
};

const UserRouter = () => {
  const loginUser = localStorage.getItem("loginUser");
  //const isLogin = loginUser ? true : false;
  const isLogin = !!loginUser;

  return isLogin ? <Outlet /> : <Navigate to="/login" />;
};

const StyledMain = styled.main`
  width: 70vw;
  margin: 0 auto;
`;

export default Main;
