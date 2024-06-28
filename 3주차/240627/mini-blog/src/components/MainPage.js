import React from "react";
import styled from "styled-components";

const Wrapper = styled.div`
  padding: 5px;
  background-color: gray;
  display: flex;
  flex-direction: row;
  align-items: flex-start;
`;

const Title = styled.h1`
  font-size: 150%;
  color: white;
  text-align: center;
`;

const Button = styled.button`
  color: ${(props) => (props.dark ? "white" : "black")};
  background-color: ${(props) => (props.dark ? "black" : "white")};
  border: 3px solid #000000;
  margin: 10px;
  padding: 5px;
`;

const RoundedButton = styled(Button)`
  border-radius: 10px;
`;

const Block = styled.div`
  padding: ${(props) => props.padding};
  border: 1px solid black;
  border-radius: 1rm;
  background-color: ${(props) => props.bColor};
  color: white;
  font-size: 2rm;
  font-weight: bold;
  text-align: center;
`;

function MainPage(props) {
  return (
    <>
      <Wrapper>
        <Title>mini blog</Title>
        <Button dark>버튼</Button>
        <RoundedButton dark>라운드버튼</RoundedButton>

        <Block padding="30px" bColor="pink">
          안녕하세요
        </Block>
      </Wrapper>
    </>
  );
}

export default MainPage;
