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
import Home from "./pages/Home";
import AccessControl from "./components/common/AccessControl";
import { oauthAPI } from "./api/services/oauth";
import { useEffect } from "react";

function App() {
  const auth = useProvideAuth();

  return (
    <LonginContext.Provider value={auth}>
      <Layout>
        <Routes>
          <Route path="/" element={<Home />} />

          <Route
            path="/favorite"
            element={
              <AccessControl roleList={["ROLE_USER", "ROLE_ADMIN"]}>
                <Favorite />
              </AccessControl>
            }
          />
          <Route
            path="/favorite/write"
            element={
              <AccessControl roleList={["ROLE_ADMIN"]}>
                <FavoriteForm />
              </AccessControl>
            }
          />
          <Route
            path="/favorite/modify/:id"
            element={
              <AccessControl roleList={["ROLE_ADMIN"]}>
                <FavoriteForm />
              </AccessControl>
            }
          />

          <Route
            path="/post"
            element={
              <AccessControl roleList={["ROLE_USER", "ROLE_ADMIN", "none"]}>
                <Post />
              </AccessControl>
            }
          />

          <Route
            path="/post/write"
            element={
              <AccessControl roleList={["ROLE_USER", "ROLE_ADMIN"]}>
                <PostForm />
              </AccessControl>
            }
          />
          <Route
            path="/post/modify/:postId"
            element={
              <AccessControl roleList={["ROLE_USER", "ROLE_ADMIN"]}>
                <PostForm />
              </AccessControl>
            }
          />
          <Route
            path="/post/:postId"
            element={
              <AccessControl roleList={["ROLE_USER", "ROLE_ADMIN", "none"]}>
                <PostDetail />
              </AccessControl>
            }
          />

          <Route
            path="/signup"
            element={
              <AccessControl roleList={["none"]}>
                <SignUp />
              </AccessControl>
            }
          />
          <Route
            path="/login"
            element={
              <AccessControl roleList={["none"]}>
                <Login />
              </AccessControl>
            }
          />

          <Route
            path="/user"
            element={
              <AccessControl roleList={["ROLE_ADMIN"]}>
                <User />
              </AccessControl>
            }
          />
          <Route
            path="/search"
            element={
              <AccessControl roleList={["ROLE_USER", "ROLE_ADMIN", "none"]}>
                <Post />
              </AccessControl>
            }
          />
          <Route
            path="/error"
            element={
              <AccessControl roleList={["ROLE_USER", "ROLE_ADMIN", "none"]}>
                <Error />
              </AccessControl>
            }
          />

          <Route path="/oauth/google" element={<GoogleLogin />} />

          <Route
            path="*"
            element={
              <AccessControl roleList={["ROLE_USER", "ROLE_ADMIN", "none"]}>
                <NotFound />
              </AccessControl>
            }
          />
        </Routes>
      </Layout>
    </LonginContext.Provider>
  );
}

const GoogleLogin = () => {
  const code = new URLSearchParams(window.location.search).get("code");
  console.log(code);

  const login = async () => {
    try {
      const response = await oauthAPI.googleLogin(code);
      if (response.status !== 200) {
        throw new Error("로그인 실패");
      }
    } catch (error) {
      console.log(error);
    }
  };

  useEffect(() => {
    login();
  }, [code]);

  return <div>로그인 처리 중...</div>;
};

export default App;
