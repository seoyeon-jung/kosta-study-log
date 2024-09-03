import { Route, Routes } from "react-router-dom";
import Layout from "./components/layouts/Layout";
import Post from "./components/posts/Post";
import PostForm from "./components/posts/PostForm";
import PostDetail from "./components/posts/PostDetail";

function App() {
  return (
    <Layout>
      <Routes>
        <Route path="/" element={<h1>HOME</h1>} />
        <Route path="/post" element={<Post />} />
        <Route path="/post/write" element={<PostForm />} />
        <Route path="/post/modify/:postId" element={<PostForm />} />
        <Route path="/post/:postId" element={<PostDetail />} />
        <Route path="/search" element={<h1>SEARCH</h1>} />
        <Route path="/error" element={<h1>ERROR</h1>} />
        <Route path="*" element={<h1>NOT FOUND</h1>} />
      </Routes>
    </Layout>
  );
}

export default App;
