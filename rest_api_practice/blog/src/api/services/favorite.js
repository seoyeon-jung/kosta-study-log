import api from "../api";

export const favoriteAPI = {
  getFavoriteList: () => api.get("/favorite"),
  getFavorite: (id) => api.get(`/favorite/${id}`),
  writeFavorite: (formData) =>
    api.post("/favorite", formData, {
      headers: { "Content-Type": "multipart/form-data" },
    }),
  modifyFavorite: (formData) =>
    api.patch("/favorite", formData, {
      headers: { "Content-Type": "multipart/form-data" },
    }),
  deleteFavorite: (id) => api.delete(`/favorite/${id}`),
};
