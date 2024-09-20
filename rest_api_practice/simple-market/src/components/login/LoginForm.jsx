import React from "react";
import { Card, Input, Button, Typography } from "@material-tailwind/react";
import { useForm } from "react-hook-form";
import { userAPI } from "../../api/services/user";
import { useNavigate } from "react-router-dom";
import { useCookies } from "react-cookie";
import SocialLogin from "./SocialLogin";

const LoginForm = () => {
  const {
    register,
    handleSubmit,
    formState: { errors },
    setError,
  } = useForm();
  const [, setCookie] = useCookies(["accessToken"]);
  const navigate = useNavigate();

  const onSubmit = async (data) => {
    try {
      const response = await userAPI.login(data);
      setCookie("accessToken", response.data.accessToken, { path: "/" });
      navigate("/products");
    } catch (error) {
      if (error.status === 401) {
        setError("email", {
          type: "manual",
          message: "아이디를 다시 입력해주세요.",
        });
        setError("password", {
          type: "manual",
          message: "비밀번호를 다시 입력해주세요.",
        });
      }
    }
  };

  return (
    <Card
      color="transparent"
      shadow={false}
      className="mt-4 mb-4 bg-white dark:bg-gray-800 w-full max-w-sm mx-auto"
    >
      <form className="mt-8 mb-2 w-full" onSubmit={handleSubmit(onSubmit)}>
        <div className="mb-6 flex flex-col gap-4">
          <div className="flex flex-col gap-1">
            <Typography
              variant="h6"
              color="blue-gray"
              className="font-medium text-gray-800 dark:text-gray-200"
            >
              이메일
            </Typography>
            <Input
              size="lg"
              placeholder="example@email.com"
              className="p-3 border border-gray-300 rounded-md dark:border-gray-600 focus:border-cyan-500 focus:ring-1 focus:ring-cyan-500 transition-all bg-white dark:bg-gray-900 text-gray-800 dark:text-gray-200"
              {...register("email", { required: "이메일을 입력해주세요" })}
              error={!!errors.email}
            />
            {errors.email && (
              <Typography
                variant="small"
                className="mt-1 text-red-600 dark:text-red-400"
              >
                {errors.email.message}
              </Typography>
            )}
          </div>

          <div className="flex flex-col gap-1">
            <Typography
              variant="h6"
              color="blue-gray"
              className="font-medium text-gray-800 dark:text-gray-200"
            >
              비밀번호
            </Typography>
            <Input
              type="password"
              size="lg"
              placeholder="********"
              className="p-3 border border-gray-300 rounded-md dark:border-gray-600 focus:border-cyan-500 focus:ring-1 focus:ring-cyan-500 transition-all bg-white dark:bg-gray-900 text-gray-800 dark:text-gray-200"
              {...register("password", { required: "비밀번호를 입력해주세요" })}
              error={!!errors.password}
            />
            {errors.password && (
              <Typography
                variant="small"
                className="mt-1 text-red-600 dark:text-red-400"
              >
                {errors.password.message}
              </Typography>
            )}
          </div>
        </div>
        <Button
          type="submit"
          className="mt-3 bg-cyan-600 text-white hover:bg-cyan-400 focus:outline-none focus:ring-2 focus:ring-cyan-300 rounded-md dark:bg-gray-500 dark:hover:bg-gray-400"
          fullWidth
        >
          로그인
        </Button>
      </form>

      <div className="my-4 border-t border-gray-300 dark:border-gray-600"></div>

      {/* social login */}
      <div className="mb-4">
        <SocialLogin />
      </div>

      <div className="my-4 border-t border-gray-300 dark:border-gray-600"></div>

      <div className="mt-6 flex items-center gap-1 justify-center">
        <Typography
          variant="small"
          className="font-medium text-gray-500 dark:text-gray-400"
        >
          만약 아이디가 없다면?
        </Typography>
        <Button
          type="button"
          className="text-sm bg-transparent border-b-1 border-cyan-600 text-cyan-600 hover:underline hover:bg-transparent hover:text-cyan-200 focus:outline-none focus:ring-0 dark:border-cyan-400 dark:text-gray-400 dark:hover:text-gray-300"
          onClick={() => navigate("/signin")}
        >
          회원가입
        </Button>
      </div>
    </Card>
  );
};

export default LoginForm;
