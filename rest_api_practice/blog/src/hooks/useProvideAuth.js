import { useState } from "react";
import { userAPI } from "../api/services/user";
import { jwtDecode } from "jwt-decode";

const useProvideAuth = () => {
  const [userInfo, setuserInfo] = useState(null);

  const login = async (data, successCallBack = null) => {
    try {
      const res = await userAPI.login(data);

      if (res.status === 200) {
        const token = res.data.accessToken;
        localStorage.setItem("token", token); // localstorage에 token 저장
        const jwtPayload = jwtDecode(token);
        setuserInfo({
          id: jwtPayload.id,
          email: jwtPayload.sub,
          role: jwtPayload.role,
        });
        if (successCallBack) successCallBack();
      }
    } catch (error) {
      console.error(error);
    }
  };

  const logout = (callBack = null) => {
    localStorage.removeItem("token"); // token값 삭제
    setuserInfo(null);
    if (callBack) callBack();
  };

  const tokenCheck = () => {
    const token = localStorage.getItem("token");
    if (token !== null) {
      const jwtPayload = jwtDecode(token);
      if (jwtPayload.exp > Date.now() / 1000) {
        return true;
      }
    }
    return false;
  };

  return { userInfo, login, logout, tokenCheck };
};

export default useProvideAuth;
