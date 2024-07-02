import "./App.css";
import { Article, Header, Introduce, Nav } from "./components";

function App() {
  return (
    <>
      {/* header */}
      <Header />
      {/* nav */}
      <Nav />
      {/* article */}
      <Article text="환영합니다" />
      <Article text="만나서 반갑습니다" />
      {/* props: 부모 컴포넌트가 자식 컴포넌트에게 전달하는 값  */}
      <Introduce name="유재석" gender="남자" />
      <Introduce name="김종국" gender="남자" />
      <Introduce name="송지효" gender="여자" />
      <Introduce name="지석진" gender="남자" />
      {/* <Introduce /> default props */}
    </>
  );
}

export default App;
