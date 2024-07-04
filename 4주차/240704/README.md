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

<br/>
<br/>
<br/>

# 리액트 context 프로젝트
### [context_react 바로가기](./context_react/README.md)
- props drilling 실습 
  - grandfather -> father -> me -> son -> grandchild
  - props를 가지려면 너무 많이 올라가고, 내려와야 한다    
  - 이를 방지하기 위한 게 `context`   
- `useContext` 사용해서 color selector 만들기
- state 실습
  - 더하기/빼기/나누기/곱하기 실습
- reducer 실습
## useReducer
- useState보다 더 다양한 컴포넌트 상태 관리가 가능한 훅
```javascript
const [state, dispatch] = useReducer(reducer, initialValue);
```
### 첫번째 매개변수: reducer
   - 함수
   - reducer(state, action)
       - state: 상태값
       - action: 특정 타입에 따라 변화하도록 하는 조건
### 두번째 매개변수: initial value
   - initial value : 초기값
   - dispatch: aciton 객체를 파라미터로 받아, reducer 함수를 호출하는 함수
   - dispatch(action객체)