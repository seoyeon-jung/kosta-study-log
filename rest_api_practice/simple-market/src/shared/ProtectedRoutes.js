import { jwtDecode } from "jwt-decode";
import { useCookies } from "react-cookie";
import { Navigate } from "react-router-dom";

export const AdminRoute = ({ component: Component }) => {
  const [cookies] = useCookies(["accessToken"]);
  const token = cookies.accessToken;

  if (!token) {
    return <Navigate to="/" />;
  }

  try {
    const decodedToken = jwtDecode(token);
    if (
      decodedToken.exp * 1000 < Date.now() ||
      decodedToken.role !== "ROLE_ADMIN"
    ) {
      return <Navigate to="/" />;
    }
  } catch (error) {
    console.error("Token decoding error", error);
    return <Navigate to="/" />;
  }

  return <Component />;
};

export const LoginUserRoute = ({ component: Component }) => {
  const [cookies] = useCookies(["accessToken"]);
  const token = cookies.accessToken;

  if (!token) {
    return <Navigate to="/" />;
  }

  try {
    const decodedToken = jwtDecode(token);
    if (decodedToken.exp * 1000 < Date.now()) {
      return <Navigate to="/" />;
    }
  } catch (error) {
    console.error("Token decoding error", error);
    return <Navigate to="/" />;
  }

  return <Component />;
};

export const GuestRoute = ({ component: Component }) => {
  const [cookies] = useCookies(["accessToken"]);
  const token = cookies.accessToken;

  if (token) {
    try {
      const decodedToken = jwtDecode(token);
      if (decodedToken.exp * 1000 >= Date.now()) {
        return <Navigate to="/products" />;
      }
    } catch (error) {
      console.error("Token decoding error", error);
    }
  }

  return <Component />;
};
