import axios from "axios";
import { useState } from "react";
import {
  Box,
  Button,
  FormGroup,
  IconButton,
  InputAdornment,
  InputLabel,
  TextField,
  Typography,
} from "@mui/material";
import { styled } from "@mui/system";
import { FormControl, OutlinedInput } from "@mui/material";
import useInput from "../../hooks/useInput";
import { FaEye, FaEyeSlash } from "react-icons/fa";
import { userApi } from "../../api/services/users";

const SignUp = () => {
  const { form, handleChange, handleReset } = useInput({
    email: "",
    nickname: "",
    password: "",
    password_chk: "",
  });
  const { email, nickname, password, password_chk } = form;

  const [isDuplicate, setIsDuplicate] = useState(false);
  const [errors, setErrors] = useState({});
  const [showPassword, setShowPassword] = useState(false);

  const handleTogglePassword = () => {
    setShowPassword(!showPassword);
  };

  const handleMouseDownPassword = (e) => {
    e.preventDefault();
  };

  // 이메일 중복체크
  const handleDuplicate = async () => {
    if (email.trim()) {
      //const url = `${process.env.REACT_APP_SERVER_ADDR}/users?email=${email}`;
      try {
        //const res = await axios.get(url);
        const res = await userApi.getUserByEmail(email);
        if (!res.data.length) {
          setErrors({});
          setIsDuplicate(true);
          alert("사용가능한 이메일입니다");
        } else {
          setErrors({ email: "이미 존재하는 이메일입니다." });
          setIsDuplicate(false);
        }
      } catch (error) {
        console.error(error);
      }
    }
  };

  const resetDuplicate = (e) => {
    setIsDuplicate(false);
    handleChange(e);
  };

  const validate = () => {
    let isValid = true;
    const newErrors = {};

    if (!isDuplicate) {
      newErrors.email = "중복 체크 해주세요";
    }

    for (const [key, value] of Object.entries(form)) {
      // 빈값 여부 체크
      if (!value.trim()) {
        isValid = false;
        newErrors[key] = `${key}를 입력해주세요`;
      }
    }
    // password_chk 일치 여부 체크
    if (form.password !== form.password_chk) {
      isValid = false;
      newErrors.password_chk = `비밀번호 불일치입니다`;
    }
    console.log(newErrors);
    setErrors(newErrors);
    return isValid;
  };

  const handleSignUp = async (e) => {
    e.preventDefault();
    if (isDuplicate && validate()) {
      //const url = `${process.env.REACT_APP_SERVER_ADDR}/users`;
      const user = { email, nickname, password };
      try {
        //const res = await axios.post(url, user);
        const res = await userApi.postUser(user);
        if (res.status === 201) {
          alert("회원가입 완료");
        } else {
          throw new Error("회원가입 실패");
        }
      } catch (error) {
        console.error(error);
      } finally {
        handleReset();
      }
    }
  };
  return (
    // 회원가입할 때, { email, nickname, password, password_chk}
    <>
      <Typography variant="h4">회원가입</Typography>
      <Box
        component={"form"}
        my={4}
        p={2}
        borderRadius={4}
        boxShadow={"0 0 4px gray"}
        sx={{ "& > :not(style)": { m: 1, width: "100%" } }}
        noValidate
        autoComplete="off"
      >
        <FormGroup
          sx={{ flexDirection: "row", justifyContent: "space-between" }}
        >
          <TextField
            label="이메일"
            variant="outlined"
            autoFocus
            required
            type="email"
            id="email"
            name="email"
            value={email}
            onChange={resetDuplicate}
            error={errors.email ? true : false}
            helperText={errors.email}
          />
          <Button
            onClick={handleDuplicate}
            variant="contained"
            style={{ marginLeft: "5px" }}
          >
            중복 확인
          </Button>
        </FormGroup>

        <TextField
          label="닉네임"
          variant="outlined"
          sx={{ width: "100%", marginBottom: "15px", display: "block" }}
          required
          id="nickname"
          name="nickname"
          value={nickname}
          onChange={handleChange}
          error={errors.nickname ? true : false}
          helperText={errors.nickname}
        />
        <FormControl
          sx={{ m: 1, width: "100%", display: "block" }}
          variant="outlined"
        >
          <InputLabel
            sx={errors.password && { color: "#d32f2f" }}
            htmlFor="password"
          >
            비밀번호 *
          </InputLabel>
          <OutlinedInput
            type={showPassword ? "text" : "password"}
            id="password"
            name="password"
            value={password}
            onChange={handleChange}
            required
            autoComplete="new-password"
            label="비밀번호"
            endAdornment={
              <InputAdornment position="end">
                <IconButton
                  aria-label="toggle password visibility"
                  onClick={handleTogglePassword}
                  onMouseDown={handleMouseDownPassword}
                  edge="end"
                >
                  {showPassword ? (
                    <FaEye style={{ width: "15px", height: "15px" }} />
                  ) : (
                    <FaEyeSlash style={{ width: "15px", height: "15px" }} />
                  )}
                </IconButton>
              </InputAdornment>
            }
            error={errors.password ? true : false}
          />
        </FormControl>
        <FormControl
          sx={{ m: 1, width: "100%", display: "block" }}
          variant="outlined"
        >
          <InputLabel
            sx={errors.password && { color: "#d32f2f" }}
            htmlFor="password_chk"
          >
            비밀번호 확인 *
          </InputLabel>
          <OutlinedInput
            type={showPassword ? "text" : "password"}
            id="password_chk"
            name="password_chk"
            value={password_chk}
            onChange={handleChange}
            required
            autoComplete="new-password-chk"
            label="비밀번호 확인"
            endAdornment={
              <InputAdornment position="end">
                <IconButton
                  aria-label="toggle password visibility"
                  onClick={handleTogglePassword}
                  onMouseDown={handleMouseDownPassword}
                  edge="end"
                >
                  {showPassword ? (
                    <FaEye style={{ width: "15px", height: "15px" }} />
                  ) : (
                    <FaEyeSlash style={{ width: "15px", height: "15px" }} />
                  )}
                </IconButton>
              </InputAdornment>
            }
            error={errors.password_chk ? true : false}
          />
          <ErrorMsg>{errors.password || errors.password_chk}</ErrorMsg>
        </FormControl>
        <Button
          variant="contained"
          type="button"
          sx={{ marginTop: "10px" }}
          onClick={handleSignUp}
        >
          회원 가입
        </Button>
      </Box>
    </>
  );
};

const ErrorMsg = styled("p")({
  color: "#d32f2f",
  fontFamily: '"Roboto", "Helvetica", "Arial", sans-serif',
  fontWeight: 400,
  fontSize: "0.75rem",
  lineHeight: 1.66,
  letterSpacing: "0.03333em",
  textAlign: "left",
  margin: "3px 41px 0 14px",
});

export default SignUp;
