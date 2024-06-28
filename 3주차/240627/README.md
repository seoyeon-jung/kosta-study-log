## 목차

- [mini CRUD 구현](../240626/react-blog-practice/README.md)
  - 제품 추가
  - 제품 삭제
  - 제품 리스트 출력
- [mini-blog 프로젝트](./mini-blog/README.md)

<hr/>

1. [이벤트 처리](#이벤트)
2. [조건부 렌더링](#조건부-렌더링)
3. [리스트와 키](#리스트와-키)
4. [Form](#form)

<br/>
<br/>
<br/>

# 이벤트

## 이벤트처리하기

- 이벤트의 이름인 onclick이 onClick으로 카멜 표기법이 적용
- DOM에서는 이벤트를 처리할 함수를 문자열로 전달하지만 리액트에서는 함수 그대로 전달
- 먼저 handleClick() 함수의 정의 부분은 일반적인 함수를 정의하는 것과 동일하게 괄호와 중괄호를 사용해서 클
  래스의 함수로 정의하고 함수를 constructor()에서 bind()를 이용하여 this.handleClick에 대입해 준다.
- 자바스크립트에서는 기본적으로 클래스 함수들이 바운드되지 않기 때문에 JSX에서 this 의 의미에 대해 유의해
  야 한다.

<br/>

```javascript
function Toggle(props) {
  const [isToggleOn, setIsToggleOn] = useState(true);
  // 방법1. 함수안에 함수로 정의
  function handleClick1() {
    setIsToggleOn((isToggleOn) => !isToggleOn);
  }
  // 방법1. 함수안에 함수로 정의
  const handleClick2 = () => {
    setIsToggleOn((isToggleOn) => !isToggleOn);
  };
  return (
    <button onClick={handleClick1}>
      {this.state.isToggleOn ? "켜짐" : "꺼짐"}
    </button>
  );
}
```

## Arguments(매개변수) 전달하기

```javascript
function Mybutton(props) {
  const handleDelete = (id, event) => {
    console.log(id, event.target);
  };
  return <button onClick={(event) => handleDelete(1, event)}>삭제하기</button>;
}
```

<br/>
<br/>
<br/>

# 조건부 렌더링

- 어떠한 조건에 다라서 렌더링이 달라지는 것
- 엘리먼트 변수 : 렌더링해야 될 컴포넌트를 변수처럼 다루어야 할 때 사용할 수 있는 방법
- 인라인 조건
  - 코드를 별도로 분리된 곳에 작성하지 않고 해당 코드가 필요한 곳 안에 조건문을 코드 안에 넣어 처리
  - 인라인 if-else : 삼항연산자를 사용해서 처리
- 컴포넌트 렌더링 막기 : `null`을 리턴

<br/>

```javascript
// toolbar.jsx

const styles = {
  wrapper: {
    padding: 16,
    display: "flex",
    flexDirection: "row",
    borderBottom: "1px solid grey",
  },
  greeting: {
    marginRight: 8,
  },
};

function Toolbar(props) {
  const { isLoggedIn, onClickLogin, onClickLogout } = props;

  return (
    <div style={styles.wrapper}>
      {isLoggedIn && <span style={styles.greeting}>환영합니다!</span>}
      {isLoggedIn ? (
        <button onClick={onClickLogout}>로그아웃</button>
      ) : (
        <button onClick={onClickLogin}>로그인</button>
      )}
    </div>
  );
}
export default Toolbar;
```

<br/>
<br/>
<br/>

# 리스트와 키

- 리스트를 위해 사용하는 자료구조가 배열
- key: 컴퓨터 프로그래밍에서의 키는 각 객체나 아이템을 구분할 수 있는 고유한 값을 의미
- 리액트에서는 배열과 키를 사용하여 반복되는 다수의 엘리먼트를 쉽게 렌더링할 수 있다.
- 여러 갱의 컴포넌트 렌더링 : 자바스크립트 `map()` 함수를 이용하여 처리
- 리액트에서의 키는 리스트에서 아이템을 구분하기 위한 고유한 문자열
  - 키는 리스트에서 어떤 아이템이 변경, 추가 또는 제거되었는지 구분하기 위해 사용
  - 리액트에서의 키의 값은 같은 리스트에 있는 엘리먼트 사이에서만 고유한 값이면 된다
- 키값의 생성 방법
  - 중복되지 않는 숫자
  - 값으로 인덱스index를 사용하는 방법 ( 아이템들의 고유한 id값이 없을 때 사용 )
  - 아이템들의 고유한 id

<br/>

```javascript
// playerlist.jsx (example)

import React from "react";
const players = [
  { id: 1, name: "손흥민" },
  { id: 2, name: "이강인" },
  { id: 3, name: "황희찬" },
  { id: 4, name: "김민재" },
];

function PlayerList(props) {
  return (
    <ul>
      {players.map((player, index) => {
        return <li key={player.id}>{player.name}</li>;
      })}
    </ul>
  );
}
export default PlayerList;
```

<br/>
<br/>
<br/>

# Form

### 제어 컴포넌트

- 사용자가 입력한 값에 접근하고 제어할 수 있도록 해주는 컴포넌트
- 리액트의 통제를 받는 컴포넌트
- 제어 컴포넌트는 그 값이 리액트의 통제를 받는 입력 폼 엘리먼트
- 모든 데이터를 state에서 관리
- state의 값을 변경할 때에는 무조건 setState () 함수를 사용
- 함수 컴포넌트에서는
- useState( ) 훅을 사용하여 state를 관리
- textarea, select, form 등

<br/>

```javascript
// 회원가입 form

function SignUp(props) {
  const [name, setName] = useState("");
  const [gender, setGender] = useState("남자");

  const handleChangeName = (event) => {
    setName(event.target.value);
  };

  const handleChangeGender = (event) => {
    setGender(event.target.value);
  };

  const handleSubmit = (event) => {
    alert(`이름: ${name}, 성별: ${gender}`);
    event.preventDefault();
  };

  return (
    <form onSubmit={handleSubmit}>
      <label>
        이름:
        <input type="text" value={name} onChange={handleChangeName} />
      </label>
      <br />
      <label>
        성별:
        <select value={gender} onChange={handleChangeGender}>
          <option value="남자">남자</option>
          <option value="여자">여자</option>
        </select>
      </label>
      <button type="submit">제출</button>
    </form>
  );
}

export default SignUp;
```
