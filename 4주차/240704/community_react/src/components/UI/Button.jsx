import styled, { css } from "styled-components";
import { darken } from "polished";

const Button = styled.button`
  ${(props) => css`
    padding: 5px 10px;
    cursor: pointer;
    border: none;
    border-radius: 10px;
    margin: 0.2rem 0.5rem;
    background-color: ${props.color};
    color: #fff;
    font-weight: bold;
    box-shadow: 0 0 5px rgba(0, 0, 0, 0.3);
    transition: background-color 0.3s ease-in;
    &:hover {
      background-color: ${darken(0.5, props.color)};
    }
    &:actie {
      transform: translate(1.5px);
    }
  `}
`;

export default Button;
