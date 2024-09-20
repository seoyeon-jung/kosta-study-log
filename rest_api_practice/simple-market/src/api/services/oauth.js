import api from "../api";

export const oauthAPI = {
  googleLogin: (code) => api.get(`/oauth/google?code=${code}`),
  kakaoLogin: (code) => api.get(`/oauth/kakao?code=${code}`),
  githubLogin: (code) => api.get(`/oauth/github?code=${code}`),
};
