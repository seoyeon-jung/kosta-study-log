import "./App.css";

function App() {
  const name = "리액트";
  const url = "https://naver.com";
  let num = 20;

  const style = { color: "red", backgroundColor: "lightgray" };

  return (
    <div>
      {/* 중괄호를 이용해 변수 삽입 가능 */}
      <h1>{name} 시작</h1>
      <a href={url}>네이버</a>

      <br />

      {/* 단일 태그도 태그를 닫아야 한다 */}
      <input type="text" value={name} />
      <br />
      <input type="password" />

      {/* class, for => className, htmlFor */}
      <div className="title">제목</div>
      <label htmlFor="user_id">아이디</label>
      <input type="text" id="user_id" />

      {/** style */}
      <div style={{ color: "red", backgroundColor: "lightgray" }}>
        안녕하세요
      </div>
      <div style={style}>hello</div>

      <div>
        {num > 10 ? (
          <h1>num은 10보다 크다</h1>
        ) : (
          <h1>num은 10보다 같거나 작다</h1>
        )}
      </div>
    </div>
  );
}

export default App;
