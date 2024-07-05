import React from "react";
import { Link } from "react-router-dom";
import styled from "@emotion/styled";
import { TiSocialInstagramCircular } from "react-icons/ti";

const Header = () => {
  const loginUser = localStorage.getItem("loginUser");

  return (
    <StyledHeader>
      <Link to="/">
        <TiSocialInstagramCircular />
      </Link>
      <nav>
        <Link to="/">HOME</Link>
        {/* 로그인 후에는 로그아웃으로 변경 */}
        {loginUser ? (
          <>
            <Link to="/info">{loginUser}</Link>
            <Link to="/logout">LOGOUT</Link>
          </>
        ) : (
          <>
            <Link to="/login">LOGIN</Link>
            <Link to="/signup">SIGN UP</Link>
          </>
        )}
      </nav>
    </StyledHeader>
  );
};

const StyledHeader = styled.header`
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0.5rem 1rem;
  background-color: #9ce3ff;
  color: #fff;

  & > a {
    color: #fff;
    text-decoration: none;
    font-size: 2.5rem;
  }

  nav {
    display: flex;
    a {
      text-decoration: none;
      color: #fff;
      margin: 0 1rem;
      &:hover {
        text-decoration: underline;
      }
    }
  }
`;

export default Header;
