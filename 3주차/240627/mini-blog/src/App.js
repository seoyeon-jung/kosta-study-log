import "./App.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import BlogMain from "./components/page/BlogMain";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route index element={<BlogMain />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
