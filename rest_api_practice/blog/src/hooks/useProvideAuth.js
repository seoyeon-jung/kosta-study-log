import { useState } from "react";
import { userAPI } from "../api/services/user";
import { jwtDecode } from "jwt-decode";
import { getCookie, removeCookie, setCookie } from "../utils/cookieUtil";

const useProvideAuth = () => {
  const [userInfo, setuserInfo] = useState(null);

  const refreshUserinfo = () => {
    const token = getCookie("accessToken");
    if (token) {
      const jwtPayload = jwtDecode(token);
      setuserInfo({
        id: jwtPayload.id,
        email: jwtPayload.sub,
        role: jwtPayload.role,
      });
    }
  };

  const login = async (data, successCallBack = null) => {
    try {
      const res = await userAPI.login(data);

      if (res.status === 200) {
        const token = res.data.accessToken;
        //localStorage.setItem("token", token); // localstorage에 token 저장

        setCookie("accessToken", token, { path: "/" });

        refreshUserinfo(token);
        if (successCallBack) successCallBack();
      }
    } catch (error) {
      console.error(error);
    }
  };

  const logout = (callBack = null) => {
    //localStorage.removeItem("token"); // token값 삭제
    removeCookie("accessToken");
    setuserInfo({});
    if (callBack) callBack();
  };

  const tokenCheck = () => {
    //const token = localStorage.getItem("token");
    const token = getCookie("accessToken");
    if (token) {
      const jwtPayload = jwtDecode(token);
      return jwtPayload.role;
    } else {
      return false;
    }
  };

  return { userInfo, refreshUserinfo, login, logout, tokenCheck };
};

export default useProvideAuth;
