import React from "react";

function UserGreeting(props) {
  return <h1>회원님. 다시 방문해주셔서 감사합니다.</h1>;
}

function GuestGreeting(props) {
  return (
    <h1>안녕하세요! 회원 가입을 하시면 더 좋은 서비스를 받을 수 있습니다.</h1>
  );
}

function Greeting(props) {
  const isLogin = props.isLogin;

  // if(isLogin) {
  //     return <UserGreeting/>
  // } else {
  //     return <GuestGreeting/>
  // }

  return <>{isLogin ? <UserGreeting /> : <GuestGreeting />}</>;
}

export default Greeting;
