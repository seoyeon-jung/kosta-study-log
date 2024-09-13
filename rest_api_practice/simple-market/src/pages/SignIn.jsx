import React from "react";
import JoinForm from "../components/login/JoinForm";

const SignIn = () => {
  return (
    <div className="flex items-center justify-center min-h-screen bg-gray-100 dark:bg-gray-900">
      <div className="p-6 bg-white rounded shadow-lg w-full max-w-md dark:bg-gray-800 dark:text-gray-200">
        <h1 className="text-2xl font-semibold mb-4 text-gray-800 dark:text-gray-100">
          회원가입
        </h1>
        <JoinForm />
      </div>
    </div>
  );
};

export default SignIn;
