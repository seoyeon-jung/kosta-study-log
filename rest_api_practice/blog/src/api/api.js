import axios from "axios";

const api = axios.create({
  baseURL: `${process.env.REACT_APP_REST_SERVER}`,
  withCredentials: true, // http only (cookie  속성)
});

api.interceptors.request.use(
  (config) => {
    const token = localStorage.getItem("token");
    if (token) {
      config.headers.Authorization = `Bearer ${token}`;
    } else {
      delete config.headers.Authorization;
    }
    return config;
  },
  (err) => {
    return Promise.reject(err);
  }
);

// 응답할 때 사용하는 interceptor
// response에 따라서 분기가 가능하다
api.interceptors.response.use(
  (res) => {
    // response가 있는 경우 response의 data 반환
    return res;
  },
  async (err) => {
    const originReq = err.config;
    if (err.response.status === 403 && !originReq._retry) {
      originReq._retry = true; // 플래그 설정

      // 만약에 권한이 없다는 에러가 나오면 토큰 재발급 해주도록 할 것이다.
      try {
        // token 재발급
        const response = await refreshTokenHandler();

        // 정상 재발급 시
        if (response.status === 200) {
          // token 값 로컬 스토리지에 저장
          localStorage.setItem("token", response.data.accessToken);
          // header에 새로운 token 추가하기
          originReq.headers.Authorization = `Bearer ${response.data.accessToken}`;

          // 실패했던 요청 다시 보내기
          return api.request(originReq);
        }
      } catch (error) {
        console.err("토큰 재발급 실패");
        // error 처리
        return Promise.reject(err);
      }
    }
    return Promise.reject(err);
  }
);

const refreshTokenHandler = async () => {
  try {
    const response = await api.post("/auth/refresh-token");
    return response;
  } catch (error) {
    throw Error;
  }
};

export default api;
