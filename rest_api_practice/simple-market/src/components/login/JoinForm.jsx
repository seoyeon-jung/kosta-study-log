import React from "react";
import { Card, Input, Button, Typography } from "@material-tailwind/react";
import { useForm } from "react-hook-form";
import { useNavigate } from "react-router-dom";
import { userAPI } from "../../services/user";

const JoinForm = () => {
  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm();
  const navigate = useNavigate();

  const onSubmit = async (data) => {
    try {
      await userAPI.join(data);
      navigate("/");
    } catch (error) {
      console.error("로그인 실패 => ", error);
    }
  };

  return (
    <Card color="transparent" shadow={false} className="mt-4">
      <form
        className="mt-8 mb-2 w-80 max-w-screen-lg sm:w-96"
        onSubmit={handleSubmit(onSubmit)}
      >
        <div className="mb-6 flex flex-col gap-4">
          <div className="flex flex-col gap-1">
            <Typography variant="h6" color="blue-gray" className="font-medium">
              닉네임
            </Typography>
            <Input
              size="lg"
              placeholder="name"
              className="p-3 border border-gray-300 rounded-md focus:border-cyan-500 focus:ring-1 focus:ring-cyan-500 transition-all"
              {...register("name", {
                required: "닉네임을 10자 이내로 입력해주세요",
                maxLength: 10,
              })}
              error={!!errors.name}
            />
            {errors.name && (
              <Typography variant="small" className="mt-1 text-red-600">
                {errors.name.message}
              </Typography>
            )}
          </div>

          <div className="flex flex-col gap-1">
            <Typography variant="h6" color="blue-gray" className="font-medium">
              이메일
            </Typography>
            <Input
              size="lg"
              placeholder="example@mail.com"
              className="p-3 border border-gray-300 rounded-md focus:border-cyan-500 focus:ring-1 focus:ring-cyan-500 transition-all"
              {...register("email", {
                required: "이메일을 example@example.com 형태로 입력해주세요",
                pattern: "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}$",
              })}
            />
            {errors.email && (
              <Typography variant="small" className="mt-1 text-red-600">
                {errors.email.message}
              </Typography>
            )}
          </div>

          <div className="flex flex-col gap-1">
            <Typography variant="h6" color="blue-gray" className="font-medium">
              비밀번호
            </Typography>
            <Input
              type="password"
              size="lg"
              placeholder="********"
              className="p-3 border border-gray-300 rounded-md focus:border-cyan-500 focus:ring-1 focus:ring-cyan-500 transition-all"
              {...register("password", {
                required: "비밀번호는 영어+숫자로 8~20자리 작성해야 합니다.",
                pattern: /^(?=.*[a-zA-Z])(?=.*\d)[a-zA-Z\d]{8,20}$/,
              })}
            />
            {errors.password && (
              <Typography variant="small" className="mt-1 text-red-600">
                {errors.password.message}
              </Typography>
            )}
          </div>
        </div>
        <Button
          type="submit"
          className="mt-6 bg-cyan-600 text-white hover:bg-cyan-400 focus:outline-none focus:ring-2 focus:ring-cyan-300 rounded-md dark:bg-gray-500 dark:hover:bg-gray-400"
          fullWidth
        >
          회원가입
        </Button>
      </form>
    </Card>
  );
};

export default JoinForm;
