import React from "react";
import styled from "styled-components";
import useInput from "../../hooks/useInput";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import Button from "../UI/Button";

const Login = () => {
  const { form, handleChange } = useInput({
    email: "",
    password: "",
  });
  const { email, password } = form;

  const navigate = useNavigate();

  const handleLogin = async () => {
    // 가짜 데이터이기 대문에 get 방식으로 로그인 진행
    // 실제로는 post 방식 사용

    const url = `${process.env.REACT_APP_SERVER_ADDR}/users?email=${email}&password=${password}`;

    try {
      const res = await axios.get(url);
      if (res.status === 200 && res.data.length === 1) {
        // 로그인 성공
        localStorage.setItem("loginUser", res.data[0].nickname);
        navigate("/");
      } else {
        alert("로그인 실패");
      }
    } catch (error) {
      console.error(error);
    }
  };

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
        <Button color="#4557f5" onClick={handleLogin}>
          로그인
        </Button>
      </StyledLoginBox>
    </>
  );
};

const StyledLoginBox = styled.div`
  display: flex;
  .input-group {
    display: flex;
    flex-direction: column;

    input {
      border: none;
      border-radius: 6px;
      background-color: #cff4f8;
      padding: 0.8rem;
      margin: 5px;
    }
  }
`;

export default Login;
