import React from "react";
import styled from "styled-components";

const StyledButton = styled.button`
  padding: 8px 16px;
  font-size: 16px;
  border-width: 1px;
  border-radius: 8px;
  cursor: pointer;
`;

// 버튼 이름, 이벤트 핸들러
function Button({ title, onClick }) {
  return <StyledButton onClick={onClick}>{title || "버튼"}</StyledButton>;
}

export default Button;
