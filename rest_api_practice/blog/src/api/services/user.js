import api from "../api";

export const userAPI = {
  login: (data) => api.post("/auth/login", data),
  getUserList: () => api.get("/auth/userlist"),
  addUser: (data) => api.post("/auth/signup", data),
  emailCheck: (email) => api.get("/auth/duplicate", { params: { email } }),
  modifyUser: (data) => api.patch("/auth/update", data),
  deleteUser: (email, password) =>
    api.delete("/auth/delete", { data: { email, password } }),
};
