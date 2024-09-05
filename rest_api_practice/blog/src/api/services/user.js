import api from "../api";

export const userAPI = {
  getUserList: () => api.get("/auth/userlist"),
  addUser: (data) => api.post("/auth/signup", data),
  emailCheck: (email) => api.get("/auth/duplicate", { data: { email } }),
  modifyUser: (data) => api.patch("/auth/update", data),
  deletUuser: (id) => api.delete(`/auth/delete/${id}`),
};
