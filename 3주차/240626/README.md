## 목차

1. [state와 생명주기](#state와-생명주기)
2. [hook](#hook)
3. [custom hook 예제 - useCounter()](#custom-hook-예제---usecounter)

<br/>
<br/>
<br/>

# state와 생명주기

### state

- 리액트에서의 state는 리액트 컴포넌트의 상태를 의미 (리액트 컴포넌트의 데이터 )
- 리액트 컴포넌트의 변경 가능한 데이터를 state라고 한다.
- state는 사전에 미리 정해진 것이 아니라 리액트 컴포넌트를 개발하는 각 개발자가 직접 정의해서 사용
  - state를 정의할 때 중요한 점은 꼭 렌더링이나 데이터 흐름에 사용되는 값만 state에 포함시켜야 한다
  - state가 변경될 경우 컴포넌트가 재렌더링되기 때문에 렌더링과 데이터 흐름에 관련 없는 값을 포함하면 컴포넌트가 다시 렌더링되어 성능을 저하 시킬 수 있다.

### 리액트 컴포넌트의 생명주기

#### 컴포넌트가 생성되는 시점

- Mounting
- 이때 컴포넌트의 `constructor`(생성자)가 실행, 컴포넌트의 state를 정의, `componentDidMount()` 호출

#### 컴포넌트 렌더링

- Updating 
- `componentDidUpdate()` 함수가 호출
- 컴포넌트의 props가 변경
- setState () 함수 호출에 의해 state가 변경
- forceUpdate()라는 강제 업데이트 함수 호출로 인해 컴포넌트가 다시 렌더링

#### 언마운트

- 상위 컴포넌트에서 현재 컴포넌트를 더 이상 화면에 표시하지 않게 될 때 언마운트
- 언마운트 직전에 `componentWillUnmount()` 호출

<br/>
<br/>
<br/>

# hook

- 함수 컴포넌트는 클래스 컴포넌트와는 다르게 코드도 굉장히 간결하고, 별도로 state를 정의해서 사용하거나 - 컴포넌트의 생명주기에 맞춰 어떤 코드가 실행되도록 할 수 없었다.
- 함수형 컴포넌트에 이런 기능을 지원하기 위해서 나온 것이 바로 훅
- 훅을 사용하면 함수 컴포넌트도 클래스 컴포넌트의 기능을 모두 동일하게 구현할 수 있다.

### useState()

- state를 사용하기 위한 훅
- 함수 컴포넌트에서는 기본적으로 state를 제공하지 않기 때문에 state 사용하려면 `useState()` 사용

<br/>

```javascript
import React, { useState } from "react";

function Counter(props) {
  const [count, setCount] = useState(0);
  return (
    <div>
      <p>총 {count}번 클릭했습니다. </p>
      <button onClick={() => setCount(count + 1)}>Click</button>
    </div>
  );
}
```

### useEffect()

- 사이드 이펙트side effect를 수행하기 위한 훅
- 리액트에서의 사이드 이펙트는 그냥 효과 혹은 영향을 뜻하는 이펙트의 의미
  - 예를 들면 서버에서 데이터를 받아오거나 수동으로 DOM을 변경하는 등의 작업을 의미
  - 이런 작업을 이펙트라고 부르는 이유는 이 작업들이 다른 컴포넌트에 영향을 미칠 수 있고, 렌더링 중에는 작업이 완료될 수 없기 때문에 사이드 이펙트라 칭함.
  - 렌더링이 끝난 이후에 실행되어야 하는 작업들이다.
- useEffect()는 리액트의 함수 컴포넌트 생명주기 안에서 사이드 이펙트를 실행할 수 있도록 해주는 훅
  - useEffect()는 클래스 컴포넌트에서 제공하는 생명주기 함수인 `componentDidMount()`, `componentDidUpdate()` 그리고 `componentWillUnmount()`와 동일한 기능을 하나로 통합해서 제공
  - 그래서 useEffect() 훅만으로 위의 생명주기 함수와 동일한 기능을 수행할 수 있다.

<br/>

```javascript
useEffect(() => {

// 컴퍼넌트가 마운트 된 후
// 의존성 배열에 있는 변수들 중 하나라도 값이 변경되었을 때 실행
// 의존성 배열에 빈 배열([])을 넣으면 마운트와 언마운트시에 단 한 번씩만 실행됨
// 의존성 배열 생략 시 컴포넌트 업데이트 시마다 실행됨

}, [의존성 변수1, 의존성 변수2, ...]);
```

### useMemo()

- Memoized value를 리턴하는 훅
- 파라미터로 Memoized value 를 생성하는 create 함수와 의존성 배열을 받는다.
- 의존성 배열에 들어있는 변수가 변했을 경우에만 새로 create 함수를 호출하여 결과값을 반환하며, 그렇지 않은 경우에는 기
  존 함수의 결과값을 그대로 반환.
- useMemo() 훅을 사용하면 컴포넌트가 다시 렌더링될 때마다 연산량이 높은 작업을 반복하는 것을 피할 수 있다.
- 빠른 렌더링 속도 가능
- useMemo ()로 전달된 함수는 렌더링이 일어나는 동안 실행된다

#### 메모이제이션(Memoization)

- 최적화를 위해서 사용하는 개념
- 비용이 높은(연산량이 많이 드는) 함수의 호출 결과를 저장해 두었다가, 같은 입력 값으로 함수를 호출하면 새로 함수를 호출하
  지 않고 이전에 저장해놨던 호출 결과를 바로 반환하는 것
- 이렇게 하면 결과적으로 함수 호출 결과를 받기까지 걸리는 시간도 짧아질뿐더러 불필요한 중복 연산도 하지 않기 때문에 컴퓨터의 자원(CPU, Memory 등)을 적게 쓰게 된다.
- Memoized value : 메모이제이션이 된 결과 값

<br/>

```javascript
const memoizedValue = useMemo(
    () => {
        // 연산량이 높은 작업을 수행하여 결과를 반환
        return computeExpensiveValue(의존성 변수1, 의존성 변수);
    },
    [의존성 변수 1, 의존성 변수2]
);
```

### useCallback()

- `useMemo()` 훅과 유사한 역할을 함.
- 차이점은 값이 아닌 함수를 반환한다는 것
- 함수와 의존성 배열을 파라미터로 받고, useCallback() 훅에서는 파라미터로 받는 함수를 콜백callback이라 함.
- 의존성 배열에 있는 변수 중 하나라도 변경되면 Memoized (메모이제이션이 된) 콜백 함수를 반환합니다.

### useRef()

- 레퍼런스Reference를 사용하기 위한 훅
- 리액트에서 레퍼런스란 특정 컴포넌트에 접근할 수 있는 객체를 의미.
- useRef () 혹은 바로 레퍼런스 객체ref object를 반환
- 레퍼런스 객체에는 .current라는 속성이 있는데 이것은 현재 레퍼런스(참조)하고 있는 엘리먼트를 가리킨다.

<br/>

```javascript
// 버튼 클릭 시 input에 focus를 하도록 하는 예제
import React, { useState, useEffect, useRef } from "react";

function TextInputWithFocusButton(prps) {
  const inputElem = useRef("null");
  const onButtonClick = () => {
    // current`는 마운트된 input element 를 가리킴
    inputElem.current.focus();
    inputElem.current.value = "new Text";
  };

  return (
    <>
      <input ref={inputElem} type="text" />
      <button onClick={onButtonClick}>Focus the input</button>
    </>
  );
}

export default TextInputWithFocusButton;
```

## 훅의 규칙

1. 최상위 레벨에서만 호출해야 한다
2. 리액트 함수 컴포넌트에서믄 호춣해야 한다

<br/>
<br/>
<br/>

# custom hook 예제 - useCounter()

```javascript
// useCounter.jsx
// count라는 state 생성, count의 증/감소 처리하는 함수

import React, { useState } from "react";

function useCounter(initialValue) {
  const [count, setCount] = useState(initialValue);
  const increaseCount = () => setCount((count) => count + 1);
  const decreaseCount = () => setCount((count) => Math.max(count - 1, 0));

  return [count, increaseCount, decreaseCount];
}

export default useCounter;
```

```javascript
// useCounter 사용한 Accommodate.jsx
import React, { useState, useEffect } from "react";
import useCounter from "./useCounter";

const MAX_CAPACITY = 10;

function Accommodate(props) {
  const [isFull, setIsFull] = useState(false);
  const [count, increaseCount, decreaseCount] = useCounter(0);

  useEffect(() => {
    console.log("======================");
    console.log("useEffect() is called.", `isFull: ${isFull}`);
  });

  useEffect(() => {
    setIsFull(count >= MAX_CAPACITY);
    console.log(`Current count value: ${count}`);
  }, [count]);

  return (
    <div style={{ padding: 16 }}>
      <p>{`총 ${count}명 입장했습니다.`}</p>
      <button onClick={increaseCount} disabled={isFull}>
        {" "}
        입장{" "}
      </button>
      <button onClick={decreaseCount}>퇴장</button>
      {isFull && <p style={{ color: "red" }}>정원이 가득찼습니다.</p>}
    </div>
  );
}

export default Accommodate;
```
