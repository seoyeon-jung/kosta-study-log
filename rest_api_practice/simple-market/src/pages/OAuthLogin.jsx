import React, { useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { oauthAPI } from "../api/services/oauth";
import { setCookie } from "../utils/cookieUtil";

const OAuthLogin = () => {
  const { provider } = useParams();
  const code = new URLSearchParams(window.location.search).get("code");
  const navigate = useNavigate();

  const oAuthAPI = {
    kakao: (code) => oauthAPI.kakaoLogin(code),
    google: (code) => oauthAPI.googleLogin(code),
  };

  useEffect(() => {
    const login = async () => {
      try {
        const response = await oAuthAPI[provider](code);
        if (response.status !== 200) {
          throw new Error("로그인 실패");
        } else {
          setCookie("accessToken", response.data.accessToken, { path: "/" });
          navigate("/products");
        }
      } catch (error) {
        console.error(error);
      }
    };

    if (code) {
      login();
    }
  }, [code]);

  return (
    <div className="flex items-center justify-center h-screen bg-gray-100 dark:bg-gray-800">
      <div className="flex flex-col items-center">
        <div className="loader mb-4">
          <svg
            className="animate-spin h-10 w-10 text-cyan-600"
            xmlns="http://www.w3.org/2000/svg"
            fill="none"
            viewBox="0 0 24 24"
          >
            <circle
              className="opacity-25"
              cx="12"
              cy="12"
              r="10"
              stroke="currentColor"
              strokeWidth="4"
            />
            <path
              className="opacity-75"
              fill="currentColor"
              d="M4 12a8 8 0 118 8v-4a4 4 0 10-4-4H4z"
            />
          </svg>
        </div>
        <p className="text-lg text-gray-700 dark:text-gray-300">
          로그인 중입니다. 잠시만 기다려 주세요...
        </p>
      </div>
    </div>
  );
};

export default OAuthLogin;
