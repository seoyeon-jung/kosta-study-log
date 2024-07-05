import axios from "axios";

const api = axios.create({
  baseURL: `${process.env.REACT_APP_SERVER_ADDR}`,
});

// interceptors : 중간에 가로채기
// 거의 건드릴 일이 없음
api.interceptors.request.use(
  (config) => {
    return config;
  },
  (err) => {
    return Promise.reject(err);
  }
);

// 응답 가로채기 (추후에 실습할 예정)
/* 
ex) 
로그인 후 일정 시간 뒤에 로그인이 풀리는 경우
지속적으로 연장시켜주기 위해 두개 토큰 사용하고 하나의 토큰을 새로 받아오도록 한다.
로그인 토큰 만료 후 새로운 토큰을 받아와서 새로 로그인을 연장시킨다.
토큰 만료 후 자연스럽게 응답을 중간에 가로채서 처리
*/
api.interceptors.response.use(
  (response) => {
    // status, data 등등 존재
    // 조건에 따라 긴 로직이 들어갈 수도 있다.

    return response;

    // return response.data => data만 받아오려면 아예 이런식으로 지정할 수도 있음
  },
  (err) => {
    // 특정 에러인 경우에는 '이렇게 대처해라'라는 것을 작성

    // 지금은 똑같이 작성
    return Promise.reject(err);
  }
);

export default api;
