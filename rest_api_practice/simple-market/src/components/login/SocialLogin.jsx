import { Button } from "@material-tailwind/react";
import React from "react";
import google from "../../assets/google.png";
import kakao from "../../assets/kakao.png";
import github from "../../assets/github.png";

const SocialLogin = () => {
  const handleGoogleLogin = () => {
    const params = new URLSearchParams({
      scope: "email profile",
      response_type: "code",
      redirect_uri: process.env.REACT_APP_GOOGLE_REDIRECT_URI,
      client_id: process.env.REACT_APP_GOOGLE_ID,
    });

    const GOOGLE_URL = `https://accounts.google.com/o/oauth2/v2/auth?${params.toString()}`;

    window.location.href = GOOGLE_URL;
  };

  const handleKakaoLogin = () => {
    const params = new URLSearchParams({
      response_type: "code",
      redirect_uri: process.env.REACT_APP_KAKAO_REDIRECT_URI,
      client_id: process.env.REACT_APP_KAKAO_ID,
    });

    const KAKAO_URL = `https://kauth.kakao.com/oauth/authorize?${params.toString()}`;

    window.location.href = KAKAO_URL;
  };

  const handleGithubLogin = () => {
    const params = new URLSearchParams({
      client_id: process.env.REACT_APP_GITHUB_ID,
      redirect_uri: process.env.REACT_APP_GITHUB_REDIRECT_URI,
      scope: "read:user user:email",
      response_type: "code",
    });

    const GITHUB_URL = `https://github.com/login/oauth/authorize?${params.toString()}`;
    window.location.href = GITHUB_URL;
  };

  return (
    <div className="mt-4 flex flex-col gap-2">
      <Button
        type="button"
        className="flex items-center justify-center bg-white border border-gray-300 rounded-md  hover:bg-gray-100"
        onClick={handleGoogleLogin}
        fullWidth
      >
        <div className="flex items-center">
          <img src={google} alt="Google Logo" className="h-5 mr-2" />
          <span className="text-gray-800">구글로 로그인</span>
        </div>
      </Button>
      <Button
        type="button"
        className="flex items-center justify-center bg-yellow-400 text-white rounded-md shadow hover:bg-yellow-500"
        onClick={handleKakaoLogin}
        fullWidth
      >
        <div className="flex items-center">
          <img src={kakao} alt="Kakao Logo" className="h-5 mr-2" />
          <span>카카오로 로그인</span>
        </div>
      </Button>
      <Button
        type="button"
        className="flex items-center justify-center bg-gray-400 text-white rounded-md shadow hover:bg-gray-500"
        onClick={handleGithubLogin}
        fullWidth
      >
        <div className="flex items-center">
          <img src={github} alt="Github Logo" className="h-5 mr-2" />
          <span>깃허브로 로그인</span>
        </div>
      </Button>
    </div>
  );
};

export default SocialLogin;
