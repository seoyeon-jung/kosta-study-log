import React from "react";
import styled from "styled-components";
import useInput from "../../hooks/useInput";

const Login = () => {
  const { form, handleChange } = useInput({
    email: "",
    password: "",
  });
  const { email, password } = form;

  const handleLogin = () => {};

  return (
    <>
      <h1>로그인 화면</h1>
      <StyledLoginBox>
        <div className="input-group">
          <input
            type="email"
            name="email"
            value={email}
            onChange={handleChange}
          />
          <input
            type="password"
            name="password"
            value={password}
            onChange={handleChange}
          />
        </div>
        <button onClick={handleLogin}>로그인</button>
      </StyledLoginBox>
    </>
  );
};

const StyledLoginBox = styled.div`
  display: flex;
  .input-group {
    display: flex;
    flex-direction: column;
  }
`;

export default Login;
