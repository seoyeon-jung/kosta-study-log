import "./App.css";
import Product from "./components/Product";
import Header from "./components/layout/Header";
import { Routes, Route, BrowserRouter } from "react-router-dom";
import ProdDetail from "./components/product/ProdDetail";
import styled from "styled-components";

function App() {
  return (
    <BrowserRouter>
      <Header />
      <Routes>
        <Route path="/" element={<Title>홈</Title>} />
        <Route path="/about" element={<Title>정보</Title>} />
        <Route path="/service" element={<Title>서비스</Title>} />
        <Route path="/product" element={<Product />} />
        <Route path="/product/:id" element={<ProdDetail />} />
      </Routes>
    </BrowserRouter>
  );
}

const Title = styled.h1`
  font-size: 1.5em;
  text-align: center;
  color: #bf4f74;
`;

export default App;
