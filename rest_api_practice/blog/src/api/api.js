import axios from "axios";

const api = axios.create({
  baseURL: `${process.env.REACT_APP_REST_SERVER}`,
});

api.interceptors.request.use(
  (config) => {
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
  (err) => {
    // error 처리
    return Promise.reject(err);
    // 만약에 권한이 없다는 에러가 나오면 토큰 재발급 해주도록 할 것이다.
  }
);

export default api;
