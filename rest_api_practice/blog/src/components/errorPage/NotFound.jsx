import { Box, Button, Typography } from "@mui/material";
import { useNavigate } from "react-router-dom";

const NotFound = () => {
  const navigate = useNavigate();

  return (
    <Box sx={{ marginTop: "30px" }}>
      <Typography variant="h1" component="h1" gutterBottom>
        404
      </Typography>
      <Typography variant="h5" component="h2" gutterBottom>
        Page Not Found
      </Typography>
      <Typography variant="body1">해당 경로로 접근할 수 없습니다.</Typography>
      <Box mt={2}>
        <Button variant="contained" color="main" onClick={() => navigate("/")}>
          다시 돌아가기
        </Button>
      </Box>
    </Box>
  );
};

export default NotFound;
