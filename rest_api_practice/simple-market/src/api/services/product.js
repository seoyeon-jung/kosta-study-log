import api from "../api";

export const productAPI = {
  getAllProducts: () => api.get("/product/productlist"),
  getProduct: (id) => api.get(`/product/${id}`, { params: { id } }),
  addProduct: (data) => api.post("/product/add", data),
  updateProduct: (data) => api.patch("/product/update", data),
  deleteProduct: (id) => api.delete("/product/delete", { params: { id } }),
};
