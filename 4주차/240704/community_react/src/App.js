import "./App.css";
import Layout from "./components/Layouts/Layout";
import { Navigate, Outlet, Route, Routes } from "react-router-dom";
import Home from "./components/pages/Home";
import Login from "./components/pages/Login";
import SignUp from "./components/pages/SignUp";
import NotFound from "./components/pages/NotFound";
import TimeLine from "./components/pages/TimeLine";
import Search from "./components/pages/Search";
import Profile from "./components/pages/Profile";
import MyProfile from "./components/pages/MyProfile";

/*
pages
[누구나]
- 홈 (/)
- 타임라인 (/post) [게시글 리스트]
- 검색 (/search) [게시글 검색]
- 프로필 (/profile/:id) [특정 사람의 프로필]
- NOT FOUND (/*)
[회원만]
- 마이 프로필 (/profile) [내 프로필]
[게스트만]
- 로그인 (/login)
- 회원가입 (/singup)
*/

function App() {
  return (
    <Layout>
      <Routes>
        {/* 누구나 접근 가능 */}
        <Route path="/" element={<Home />} />
        <Route path="/post" element={<TimeLine />} />
        <Route path="/search" element={<Search />} />

        {/* 게스트만 접근 가능 */}
        <Route element={<GuestRoute />}>
          <Route path="/login" element={<Login />} />
          <Route path="/signup" element={<SignUp />} />
        </Route>

        {/* 로그인한 회원만 접근 가능 */}
        <Route element={<UserRouter />}>
          <Route path="/profile" element={<MyProfile />} />
        </Route>

        <Route path="/profile/:id" element={<Profile />} />

        <Route path="*" element={<NotFound />} />
      </Routes>
    </Layout>
  );
}

const GuestRoute = () => {
  const loginUser = localStorage.getItem("loginUser");
  const isLogin = !!loginUser;
  return isLogin ? <Navigate to="/info" /> : <Outlet />;
};

const UserRouter = () => {
  const loginUser = localStorage.getItem("loginUser");
  //const isLogin = loginUser ? true : false;
  const isLogin = !!loginUser;

  return isLogin ? <Outlet /> : <Navigate to="/login" />;
};

export default App;

/* 라우팅: 주소에 다라 다른 화면을 보여주는 것 (react-router-dom 사용)
    BrowserRouter로 전체를 감싼다.
    Routes 안에 Route로 경로와 컴포넌트 요소를 알려준다.
    a 태그를 통해서 페이지를 이동하면, 아예 페이지를 새롭게 불러온다 -> 상태 초기화
    상태를 유지하면서 이동하기 위해서는 Link 컴포넌트로 주소를 바꿔야 한다. */
