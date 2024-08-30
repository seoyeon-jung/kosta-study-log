import "./App.css";
import Header from "./components/layouts/Header";
import styled from "styled-components";
import { Routes, Route } from "react-router-dom";
import Products from "./components/products/Products";

function App() {
  return (
    <div className="App">
      <Header />
      <Title>쇼핑몰</Title>
      <Routes>
        <Route path="/" element={<h1>메인화면</h1>}></Route>
        <Route path="/about" element={<h1>정보</h1>}></Route>
        <Route path="/service" element={<h1>서비스</h1>}></Route>
        <Route path="/product" element={<Products />}></Route>
      </Routes>
    </div>
  );
}

const Title = styled.div`
  font-size: 1.5rem;
  color: #024d4d;
  margin-top: 20px;
`;

export default App;
