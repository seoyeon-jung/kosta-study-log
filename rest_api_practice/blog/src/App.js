import { Route, Routes } from "react-router-dom";
import Layout from "./components/layouts/Layout";
import Post from "./components/posts/Post";
import PostForm from "./components/posts/PostForm";
import PostDetail from "./components/posts/PostDetail";
import Favorite from "./components/favorite/Favorite";
import FavoriteForm from "./components/favorite/FavoriteForm";
import Error from "./components/errorPage/Error";
import NotFound from "./components/errorPage/NotFound";
import SignUp from "./components/auth/SignUp";
import User from "./components/users/User";
import { LonginContext } from "./contexts/LoginContext";
import useProvideAuth from "./hooks/useProvideAuth";
import Login from "./components/auth/Login";

function App() {
  const auth = useProvideAuth();

  return (
    <LonginContext.Provider value={auth}>
      <Layout>
        <Routes>
          <Route path="/" element={<h1>HOME</h1>} />

          <Route path="/favorite" element={<Favorite />} />
          <Route path="/favorite/write" element={<FavoriteForm />} />
          <Route path="/favorite/modify/:id" element={<FavoriteForm />} />

          <Route path="/post" element={<Post />} />
          <Route path="/post/write" element={<PostForm />} />
          <Route path="/post/modify/:postId" element={<PostForm />} />
          <Route path="/post/:postId" element={<PostDetail />} />

          <Route path="/signup" element={<SignUp />} />
          <Route path="/login" element={<Login />} />
          <Route path="/user" element={<User />} />

          <Route path="/search" element={<Post />} />
          <Route path="/error" element={<Error />} />
          <Route path="*" element={<NotFound />} />
        </Routes>
      </Layout>
    </LonginContext.Provider>
  );
}

export default App;
