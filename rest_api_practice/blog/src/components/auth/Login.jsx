import { useNavigate } from "react-router-dom";
import { useAuth } from "../../hooks/useAuth";
import google from "../../assets/google.png";

const {
  Paper,
  Box,
  Typography,
  Divider,
  TextField,
  Button,
} = require("@mui/material");
const { useForm } = require("react-hook-form");

const Login = () => {
  const {
    register,
    handleSubmit,
    formState: { errors },
    setError,
    //clearErrors,
  } = useForm();
  const navigate = useNavigate();
  const { login } = useAuth();

  const onSubmit = (data) => {
    try {
      login(
        data,
        () => navigate("/"),
        () => alert("로그인 실패")
      );
    } catch (error) {
      setError("email", { type: "manual", message: "아이디를 확인해주세요" });
      setError("password", {
        type: "manual",
        message: "비밀번호를 확인해주세요",
      });
    }
  };

  const handleGoogleLogin = () => {
    // 구글 로그인 버튼 클릭 시 이동하는 경로 지정
    const params = new URLSearchParams({
      scope: "email profile",
      response_type: "code",
      redirect_uri: "http://localhost:3000/oauth/google",
      client_id:
        "690190545613-ad3vmju6rrpvcuu17dd929ck4ednkfcr.apps.googleusercontent.com",
    });
    const GOOGLE_URL = `https://accounts.google.com/o/oauth2/v2/auth?${params.toString()}`;

    // 지정한 경로로 이동
    window.location.href = GOOGLE_URL;
  };

  return (
    <Paper variant="outlined" sx={{ marginTop: "30px" }}>
      <Box
        component="form"
        noValidate
        sx={{ p: 5 }}
        onSubmit={handleSubmit(onSubmit)}
      >
        <Typography component="h1" variant="h6" gutterBottom>
          로그인
        </Typography>
        <Divider sx={{ my: 2 }} />
        <TextField
          label="Email address"
          id="email"
          name="email"
          placeholder="your email address"
          variant="standard"
          fullWidth
          margin="normal"
          type="email"
          focused
          color="main"
          autoComplete="email"
          {...register("email", { required: "이메일은 필수 입력값입니다." })}
          error={errors.email ? true : false}
          helperText={errors.email && errors.email.message}
        />
        <TextField
          label="Password"
          id="password"
          name="password"
          placeholder="your password"
          variant="standard"
          fullWidth
          margin="normal"
          type="password"
          focused
          color="main"
          autoComplete="password"
          sx={{ mb: 3 }}
          {...register("password", {
            required: "비밀번호를 입력해주세요",
            pattern: {
              value: /^(?=.*[a-zA-Z0-9]).{6,20}$/,
              message:
                "비밀번호는 문자와 숫자를 포함해 최소 6자 이상 20자 이내로 작성해주세요.",
            },
          })}
          error={errors.password ? true : false}
          helperText={errors.password && errors.password.message}
        />
        <Button type="submit" variant="contained" color="main" fullWidth>
          로그인
        </Button>
        <Button fullWidth onClick={() => handleGoogleLogin()}>
          <img src={google} alt="google-login" height="45" />
        </Button>
      </Box>
    </Paper>
  );
};

export default Login;
