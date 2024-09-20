import React, { useState } from "react";
import { Card, Input, Button, Typography } from "@material-tailwind/react";
import { useForm } from "react-hook-form";
import { useNavigate } from "react-router-dom";
import { userAPI } from "../../api/services/user";

const JoinForm = () => {
  const {
    register,
    handleSubmit,
    getValues,
    setError,
    formState: { errors },
  } = useForm();
  const navigate = useNavigate();

  const [nameAvailable, setNameAvailable] = useState(null);
  const [emailAvailable, setEmailAvailable] = useState(null);

  const onSubmit = async (data) => {
    if (nameAvailable === false) {
      setError("name", {
        type: "manual",
        message: "닉네임이 이미 사용 중입니다.",
      });
      return;
    }

    if (emailAvailable === false) {
      setError("email", {
        type: "manual",
        message: "이메일이 이미 사용 중입니다.",
      });
      return;
    }

    try {
      await userAPI.join(data);
      navigate("/");
    } catch (error) {
      console.error("회원가입 실패 => ", error);
    }
  };

  const checkNameDuplicate = async (name) => {
    if (!name) {
      setNameAvailable(null); // 비어있을 때는 상태를 초기화
      return;
    }

    try {
      const response = await userAPI.nameCheck(name);
      setNameAvailable(response.data.available);
    } catch (error) {
      console.error("닉네임 중복 체크 실패 => ", error);
      setNameAvailable(false);
    }
  };

  const checkEmailDuplicate = async (email) => {
    if (!email) {
      setEmailAvailable(null); // 비어있을 때는 상태를 초기화
      return;
    }

    try {
      const response = await userAPI.emailCheck(email);
      setEmailAvailable(response.data.available);
    } catch (error) {
      console.error("이메일 중복 체크 실패 => ", error);
      setEmailAvailable(false);
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
            <Typography
              variant="h6"
              color="blue-gray"
              className="font-medium dark:text-white"
            >
              닉네임
            </Typography>
            <div className="flex items-center">
              <Input
                size="lg"
                placeholder="name"
                className="p-3 border border-gray-300 rounded-md focus:border-cyan-500 focus:ring-1 focus:ring-cyan-500 transition-all dark:text-white"
                {...register("name", {
                  required: "닉네임을 10자 이내로 입력해주세요",
                  maxLength: 10,
                  onBlur: (e) => checkNameDuplicate(e.target.value),
                })}
                error={!!errors.name}
              />
              <Button
                type="button"
                onClick={() => checkNameDuplicate(getValues("name"))}
                className="ml-2 bg-cyan-200 text-white text-sm py-1 px-3 hover:bg-cyan-400 dark:bg-gray-200 dark:hover:bg-gray-400 dark:text-black whitespace-nowrap"
              >
                중복 확인
              </Button>
            </div>
            {errors.name && (
              <Typography variant="small" className="mt-1 text-red-600">
                {errors.name.message}
              </Typography>
            )}
            {nameAvailable === true && (
              <Typography variant="small" className="mt-1 text-green-600">
                사용 가능한 닉네임입니다.
              </Typography>
            )}
            {nameAvailable === false && (
              <Typography variant="small" className="mt-1 text-red-600">
                닉네임이 이미 사용 중입니다.
              </Typography>
            )}
          </div>

          <div className="flex flex-col gap-1">
            <Typography
              variant="h6"
              color="blue-gray"
              className="font-medium dark:text-white"
            >
              이메일
            </Typography>
            <div className="flex items-center">
              <Input
                size="lg"
                placeholder="example@mail.com"
                className="p-3 border border-gray-300 rounded-md focus:border-cyan-500 focus:ring-1 focus:ring-cyan-500 transition-all dark:text-white"
                {...register("email", {
                  required: "이메일을 example@example.com 형태로 입력해주세요",
                  pattern: {
                    value: /[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$/,
                    message: "올바른 이메일 형식이 아닙니다.",
                  },
                  onBlur: (e) => checkEmailDuplicate(e.target.value),
                })}
              />
              <Button
                type="button"
                onClick={() => checkEmailDuplicate(getValues("email"))}
                className="ml-2 bg-cyan-200 text-white text-sm py-1 px-3 hover:bg-cyan-400 dark:bg-gray-200 dark:hover:bg-gray-400 dark:text-black whitespace-nowrap"
              >
                중복 확인
              </Button>
            </div>
            {errors.email && (
              <Typography variant="small" className="mt-1 text-red-600">
                {errors.email.message}
              </Typography>
            )}
            {emailAvailable === true && (
              <Typography variant="small" className="mt-1 text-green-600">
                사용 가능한 이메일입니다.
              </Typography>
            )}
            {emailAvailable === false && (
              <Typography variant="small" className="mt-1 text-red-600">
                이메일이 이미 사용 중입니다.
              </Typography>
            )}
          </div>

          <div className="flex flex-col gap-1">
            <Typography
              variant="h6"
              color="blue-gray"
              className="font-medium dark:text-white"
            >
              비밀번호
            </Typography>
            <Input
              type="password"
              size="lg"
              placeholder="********"
              className="p-3 border border-gray-300 rounded-md focus:border-cyan-500 focus:ring-1 focus:ring-cyan-500 transition-all dark:text-white"
              {...register("password", {
                required: "비밀번호는 영어+숫자로 8~20자리 작성해야 합니다.",
                pattern: {
                  value: /^(?=.*[a-zA-Z])(?=.*\d)[a-zA-Z\d]{8,20}$/,
                  message: "비밀번호는 영어+숫자로 8~20자리여야 합니다.",
                },
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
