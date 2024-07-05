import api from "../api";

export const userApi = {
  getUser: (userId) => api.get("/users", userId),
};
