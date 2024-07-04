import React from "react";
import { Route, Routes } from "react-router-dom";
import styled from "styled-components";
import Home from "../pages/Home";
import Login from "../pages/Login";

const Main = () => {
  return (
    <StyledMain>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/login" element={<Login />} />
      </Routes>
    </StyledMain>
  );
};

const StyledMain = styled.main`
  width: 70vw;
  margin: 0 auto;
`;

export default Main;
