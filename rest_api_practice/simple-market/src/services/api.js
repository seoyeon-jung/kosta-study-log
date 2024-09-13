import axios from "axios";
import { getCookie, removeCookie, setCookie } from "../utils/cookieUtil";

const api = axios.create({
  baseURL: `${process.env.REACT_APP_REST_SERVER}`,
  withCredentials: true, // httponly 쿠키 속성으로 저장된 refreshToken 전송
});

api.interceptors.request.use(
  (config) => {
    const token = getCookie("accessToken");

    if (token) {
      config.headers.Authorization = `Bearer ${token}`;
    } else {
      delete config.headers.Authorization;
    }
    return config;
  },
  (error) => {
    return Promise.reject(error);
  }
);

api.interceptors.response.use(
  (res) => {
    return res;
  },
  async (err) => {
    // 403으로 실패한 요청
    const originReq = err.config;

    // 만약 권한이 없다는 에러가 나오고 무한 루프에 빠지는 경우
    if (err.response.status === 403 && !originReq._retry) {
      originReq._retry = true; // 플래그 설정

      try {
        // 토큰 재발급 요청
        const response = await refreshTokenhandler();

        // 재발급 성공
        if (response.status === 200) {
          // token 값을 쿠키에 저장
          setCookie("accessToken", response.data.accessToken);
          // header에 새로운 token 추가
          originReq.headers.Authorization = `Bearer ${response.data.accessToken}`;

          // 실패했던 요청 다시 보내기
          return api.request(originReq);
        }
      } catch (error) {}
    }

    removeCookie("accessToken");
    return Promise.reject(err);
  }
);

const refreshTokenhandler = async () => {
  try {
    if (getCookie("accessToken")) {
      const response = await api.post("/auth/refresh-token");
      return response;
    }
  } catch (error) {
    throw error;
  }
};

export default api;
