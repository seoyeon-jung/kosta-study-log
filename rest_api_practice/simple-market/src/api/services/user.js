import api from "../api";

export const userAPI = {
  login: (data) => api.post("/auth/login", data),
  join: (data) => api.post("/auth/singin", data),
  emailCheck: (email) => api.get("/auth/email-check", { params: { email } }),
  nameCheck: (name) => api.get("/auth/name-check", { params: { name } }),
};
