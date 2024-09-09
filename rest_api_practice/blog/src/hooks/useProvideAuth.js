import { useState } from "react";
import { userAPI } from "../api/services/user";
import { jwtDecode } from "jwt-decode";

const useProvideAuth = () => {
  const [accessToken, setAccessToken] = useState(localStorage.getItem("token"));

  const login = async (data, successCallBack, failCallBack) => {
    try {
      const res = await userAPI.login(data);

      if (res.status === 200) {
        const token = res.data.accessToken;
        localStorage.setItem("token", token); // localstorage에 token 저장
        setAccessToken(token);
        successCallBack();
      }
    } catch (error) {
      console.error(error);
      failCallBack();
    }
  };

  const logout = (callBack) => {
    localStorage.removeItem("token"); // token값 삭제
    setAccessToken(null);
    callBack();
  };

  const tokenCheck = () => {
    if (accessToken !== null && accessToken === localStorage.getItem("token")) {
      const jwtPayload = jwtDecode(accessToken);
      if (jwtPayload.exp > Date.now() / 1000) {
        return true;
      }
    }
    return false;
  };

  return { accessToken, login, logout, tokenCheck };
};

export default useProvideAuth;
