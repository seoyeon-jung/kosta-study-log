import "./App.css";
import Header from "./components/Layouts/Header";
import Main from "./components/Layouts/Main";

function App() {
  return (
    <>
      {/* 라우팅: 주소에 다라 다른 화면을 보여주는 것 (react-router-dom 사용)
          BrowserRouter로 전체를 감싼다.
          Routes 안에 Route로 경로와 컴포넌트 요소를 알려준다.
          a 태그를 통해서 페이지를 이동하면, 아예 페이지를 새롭게 불러온다 -> 상태 초기화
          상태를 유지하면서 이동하기 위해서는 Link 컴포넌트로 주소를 바꿔야 한다. */}
      <Header />
      <Main />
    </>
  );
}

export default App;
