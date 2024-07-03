import React, { useEffect, useState } from "react";

const EffectInfo = () => {
  //   const [number1, setNumber1] = useState(0);

  //   const updateState = () => {
  //     setNumber1(number1 + 1);
  //   };

  //   const [number2, setNumber2] = useState(0);

  //   const updateState2 = () => {
  //     setNumber2(number2 + 1);
  //   };

  // 렌더링 될 때 실행
  //console.log("1. 렌더링~");

  // 컴포넌트 사라질 때
  useEffect(() => {
    console.log("1. 렌더링~");

    return () => console.log("2. 컴포넌트 사망~");
  }, []);

  // 컴포넌트가 처음 나타날 때 한 번만 실행
  //   useEffect(() => {
  //     console.log("2. 최초 렌더링");
  //   }, []);

  // 컴포넌트가 업데이트될 때
  //   useEffect(() => {
  //     console.log("숫자 1이 바뀌었습니다!");
  //   }, [number1]);

  const [email, setEmail] = useState("");
  const [name, setName] = useState("");
  const handleEmail = (e) => setEmail(e.target.value);
  const handleName = (e) => setName(e.target.valuee);

  //   useEffect(() => {
  //     console.log("최초의 컴포넌트가 나타났거나, 이메일이 변경되었다");
  //   }, [email]);

  //   useEffect(() => {
  //     console.log("최초의 컴포넌트가 나타났거나, 이름이 변경되었다");
  //   }, [name]);

  // state가 여러 개 인 경우
  //   useEffect(() => {
  //     console.log("이메일 또는 이름이 변경되었다");
  //   }, [email, name]);

  return (
    <>
      {/* <button onClick={updateState}>{number1}</button>
      <button onClick={updateState2}>{number2}</button> */}
      <div>
        <label>이메일</label>
        <input type="text" value={email} onChange={handleEmail} />
        <label>이름</label>
        <input type="text" value={name} onChange={handleName} />
      </div>
      <div>
        <p>{`이메일 : ${email} / 이름 : ${name}`}</p>
      </div>
      <h1>useEffect 사용</h1>
      <p>
        use로 시작하면 99.9% hook이다. <br />
        useEffefct(콜백함수, [외존성배열]) <br />
        의존성 배열 : 의존하는 값이 들어있는 배열
        <br />
        <br />
        컴포넌트는 생명주기(life cycle)가 있다. <br />
        1. 컴포넌트 처음 나타날 때 (mount) <br />
        2. 컴포넌트 업데이트 전/후 (update) <br />
        3. 컴포넌트 사라질 때 (unmount) <br />
        <br />
        useEffect를 사용하는 경우 <br />
        1. 어려운 연산을 하는 경우 <br />
        2. 서버 API를 호출할 때 <br />
        3. 타이머 <br />
        4. local storage 사용 <br />
        5. 외부 라이브러리 사용 <br />
        <br />
      </p>
    </>
  );
};

export default EffectInfo;
