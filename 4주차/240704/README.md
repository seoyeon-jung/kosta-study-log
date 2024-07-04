# 리액트 community 프로젝트
### [community_react 바로가기](./community_react/README.md)
- `custom hook` 실습 : `useInput` 생성해서 재활용 가능한 컴포넌트 만들기
- `useNavigate()` : Link의 역할을 하는 `useNavigate()` 사용해서 페이지 이동 구현
- 로그인한 유저만 들어갈 수 있도록 조건 생성
  ```javascript
  // main.jsx
  // Route로 접근 제한하는 route를 묶어준 다음에 함수 생성

  ...

   {/* 로그인한 회원만 접근 가능 */}
    <Route element={<UserRouter />}>
        <Route path="/logout" element={<h2>logout</h2>} />
        <Route path="/info" element={<h2>info page</h2>} />
    </Route>

    ...

    const UserRouter = () => {
        const loginUser = localStorage.getItem("loginUser");
        const isLogin = !!loginUser;

        return isLogin ? <Outlet /> : <Navigate to="/login" />;
    };
  ```
- 회원가입 : 유효성 검사 추가