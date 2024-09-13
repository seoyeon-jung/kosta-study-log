import { Route, Routes } from "react-router-dom";
import Layout from "./components/layouts/Layout";
import {
  AddProduct,
  Login,
  NotFound,
  Product,
  Products,
  SignIn,
} from "./pages";
import {
  AdminRoute,
  GuestRoute,
  LoginUserRoute,
} from "./shared/ProtectedRoutes";

function App() {
  return (
    <Layout>
      <Routes>
        <Route path="/" element={<GuestRoute component={Login} />} />
        <Route path="/signin" element={<GuestRoute component={SignIn} />} />
        <Route
          path="/products"
          element={<LoginUserRoute component={Products} />}
        />
        <Route
          path="/products/:id"
          element={<LoginUserRoute component={Product} />}
        />
        <Route
          path="/products/add"
          element={<AdminRoute component={AddProduct} />}
        />

        <Route path="*" element={<NotFound />} />
      </Routes>
    </Layout>
  );
}

export default App;
