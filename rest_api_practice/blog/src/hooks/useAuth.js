import { useContext } from "react";
import { LonginContext } from "../contexts/LoginContext";

// login 인증을 사용하는 custom hook
export const useAuth = () => {
  return useContext(LonginContext);
};
