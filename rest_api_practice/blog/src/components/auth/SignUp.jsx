import { Box, Button, Grid2, TextField, Typography } from "@mui/material";
import React, { useState } from "react";
import { useForm } from "react-hook-form";
import { useNavigate } from "react-router-dom";
import { userAPI } from "../../api/services/user";
import Swal from "sweetalert2";

const SignUp = () => {
  const navigate = useNavigate();
  const {
    register,
    handleSubmit,
    setValue,
    getValues,
    formState: { errors },
  } = useForm();
  const [isEmailUnique, setIsEmailUnique] = useState(null);

  const checkDuplicate = async () => {
    try {
      const email = getValues("email");
      const res = await userAPI.emailCheck(email);
      if (res.data === true) {
        Swal.fire("이미 존재하는 이메일입니다!");
        setIsEmailUnique(false);
      } else {
        Swal.fire("해당 이메일을 사용할 수 있습니다.");
        setIsEmailUnique(true);
      }
    } catch (error) {
      console.error(error);
      navigate("/error", { state: error.message });
    }
  };

  const onSubmit = async (data) => {
    if (isEmailUnique === null) {
      Swal.fire("이메일 중복 체크를 먼저 해주세요.");
      return;
    }
    if (isEmailUnique === false) {
      Swal.fire("중복된 이메일입니다. 다른 이메일을 사용해주세요.");
      return;
    }

    try {
      await userAPI.addUser(data);
      Swal.fire("회원가입이 완료되었습니다!");
      navigate("/post");
    } catch (error) {
      console.error(error);
      navigate("/error", { state: error.message });
    }
  };

  return (
    <Box
      sx={{
        marginTop: 8,
        display: "flex",
        flexDirection: "column",
        alignItems: "center",
      }}
    >
      <Typography component="h1" variant="h5">
        회원 가입
      </Typography>

      <form onSubmit={handleSubmit(onSubmit)}>
        <Grid2
          container
          direction={"column"}
          spacing={3}
          sx={{ width: { xs: "300px", sm: "800px" }, marginTop: "40px" }}
        >
          <div>
            <TextField
              name="name"
              fullWidth
              id="name"
              label="이름"
              autoFocus
              error={errors.name && true}
              helperText={
                errors.name &&
                "이름은 필수값이며, 10글자 이내로 작성해야 합니다."
              }
              {...register("name", { required: true, maxLength: 10 })}
            />
          </div>

          <div>
            <TextField
              id="email"
              label="이메일"
              placeholder="example@example.com"
              name="email"
              error={errors.email && true}
              helperText={
                errors.email &&
                "이메일은 필수값이며 example@example.com 형태로 작성해야 합니다"
              }
              {...register("email", {
                required: true,
                pattern: "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}$",
              })}
              onChange={(e) => setValue("email", e.target.value)}
            />
            <Button
              onClick={checkDuplicate}
              type="button"
              variant="outlined"
              color="main"
            >
              중복 체크
            </Button>
          </div>

          <div>
            <TextField
              fullWidth
              name="password"
              label="비밀번호"
              type="password"
              id="passsword"
              placeholder="비밀번호를 입력해주세요 (영어+숫자 8~20자리)"
              error={errors.password && true}
              helperText={
                errors.password &&
                "비밀번호는 필수값이며, 영어+숫자로 8~20자리로 작성해야 합니다."
              }
              {...register("password", {
                required: true,
                pattern: /^(?=.*[a-zA-Z])(?=.*\d)[a-zA-Z\d]{8,20}$/,
              })}
            />
          </div>

          <Box
            sx={{
              display: "flex",
              gap: 2,
              marginTop: 2,
              flexDirection: { xs: "column", sm: "row" },
            }}
          >
            <Box sx={{ flex: 1 }}>
              <Button type="submit" variant="contained" fullWidth color="main">
                회원 가입하기
              </Button>
            </Box>
            <Box sx={{ flex: 1 }}>
              <Button
                type="button"
                variant="outlined"
                fullWidth
                color="main"
                onClick={() => navigate("/")}
              >
                취소
              </Button>
            </Box>
          </Box>
        </Grid2>
      </form>
    </Box>
  );
};

export default SignUp;
