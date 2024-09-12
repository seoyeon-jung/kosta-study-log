import { useEffect } from "react";
import { useDarkMode } from "./hooks/useDarkMode";
import { Route, Routes } from "react-router-dom";
import Layout from "./components/layouts/Layout";
import Login from "./pages/Login";
import SignIn from "./pages/SignIn";

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
          <Route path="/products" element={<h1>PRODUCT LIST</h1>} />
          <Route path="/products/add" element={<h1>ADD PRODUCT</h1>} />
          <Route path="/products/:id" element={<h1>PRODUCT</h1>} />
          <Route path="/admin" element={<h1>ADMIN PAGE</h1>} />
        </Routes>
      </Layout>
    </>
  );
}

export default App;
