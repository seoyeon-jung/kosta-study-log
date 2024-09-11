import React from "react";
import { useAuth } from "../hooks/useAuth";

const Home = () => {
  const { userInfo } = useAuth();

  return (
    <>
      <h1>HOME</h1>
      <div>
        {userInfo && userInfo.email ? (
          <>{userInfo.email}님 안녕하세요</>
        ) : (
          <>로그인을 해야 글쓰기를 할 수 있습니다</>
        )}
      </div>
    </>
  );
};

export default Home;
