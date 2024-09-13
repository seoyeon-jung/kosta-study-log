import { useEffect } from "react";
import { useDarkMode } from "./hooks/useDarkMode";
import { Route, Routes } from "react-router-dom";
import Layout from "./components/layouts/Layout";
import { AddProduct, Login, Product, Products, SignIn } from "./pages";

function App() {
  const { isDarkMode } = useDarkMode();

  useEffect(() => {
    document.documentElement.classList.toggle("dark", isDarkMode);
  }, [isDarkMode]);

  return (
    <>
      <Layout>
        <Routes>
          <Route path="/" element={<Login />} />
          <Route path="/signin" element={<SignIn />} />
          <Route path="/products" element={<Products />} />
          <Route path="/products/add" element={<AddProduct />} />
          <Route path="/products/:id" element={<Product />} />
          <Route path="/admin" element={<h1>ADMIN PAGE</h1>} />
        </Routes>
      </Layout>
    </>
  );
}

export default App;
