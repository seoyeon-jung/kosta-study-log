import React from "react";
import LoginForm from "../components/login/LoginForm";

const Login = () => {
  return (
    <div className="flex items-center justify-center min-h-screen bg-gray-100 dark:bg-gray-900">
      <div className="p-6 bg-white rounded shadow-lg w-full max-w-md dark:bg-gray-800 dark:text-gray-200">
        <h1 className="text-2xl font-semibold mb-4 text-gray-800 dark:text-gray-100">
          로그인
        </h1>
        <LoginForm />
      </div>
    </div>
  );
};

export default Login;
