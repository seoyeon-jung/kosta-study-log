import { Route, Routes } from "react-router-dom";
import Layout from "./components/layouts/Layout";
import Post from "./components/posts/Post";

function App() {
  return (
    <Layout>
      <Routes>
        <Route path="/" element={<h1>HOME</h1>} />
        <Route path="/post" element={<Post />} />
        <Route path="/post/:id" element={<h1>POSt DETAIL</h1>} />
        <Route path="/search" element={<h1>SEARCH</h1>} />
        <Route path="/error" element={<h1>ERROR</h1>} />
        <Route path="*" element={<h1>NOT FOUND</h1>} />
      </Routes>
    </Layout>
  );
}

export default App;
