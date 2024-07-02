import React, { useState } from "react";

const Login = () => {
  // 단축기: usf
  const [userId, setUserId] = useState("");
  const [password, setPassword] = useState("");

  const handleLogin = () => {
    alert(`로그인 시도: ${userId} / ${password}`);
    setUserId("");
    setPassword("");
    // 비동기 통신 ajax (id, pw)
  };

  return (
    <>
      <div>
        <label htmlFor="userId">아이디</label>
        <input
          type="text"
          id="userId"
          value={userId}
          onChange={(e) => setUserId(e.target.value)}
        />
      </div>
      <div>
        <label htmlFor="password">비밀번호</label>
        <input
          type="password"
          id="password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />
      </div>
      <button onClick={handleLogin}>로그인</button>
    </>
  );
};

export default Login;
