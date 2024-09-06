import { Box, Button, Grid2, TextField } from "@mui/material";
import React, { useEffect } from "react";
import { useForm } from "react-hook-form";
import { useNavigate, useParams } from "react-router-dom";
import { favoriteAPI } from "../../api/services/favorite";

const FavoriteForm = () => {
  const {
    register,
    handleSubmit,
    formState: { errors },
    setValue, // data 세팅
  } = useForm();
  const { id } = useParams(); // id가 존재하면 수정, 아니면 등록
  const navigate = useNavigate();

  const getFav = async () => {
    try {
      const res = await favoriteAPI.getFavorite(id);
      const data = res.data;
      setValue("title", data.title);
      setValue("url", data.url);
    } catch (error) {
      console.error(error);
      navigate("/error", { state: error.message });
    }
  };

  useEffect(() => {
    if (id) {
      getFav();
    }
  });

  const onSubmit = async (data) => {
    data.image = data.image[0];

    const formData = new FormData();
    Object.keys(data).forEach((key) => {
      formData.append(key, data[key]);
    });

    try {
      if (id) {
        // 수정
        formData.append("id", id);
        await favoriteAPI.modifyFavorite(formData);

        navigate("/favorite");
      } else {
        // 등록
        await favoriteAPI.writeFavorite(formData);
        navigate("/favorite");
      }
    } catch (error) {
      console.error(error);
      navigate("/error", { state: error.message });
    }
  };

  return (
    <>
      <form onSubmit={handleSubmit(onSubmit)}>
        <Grid2
          container
          direction={"column"}
          spacing={3}
          sx={{ width: { xs: "300px", sm: "800px" }, marginTop: "40px" }}
        >
          <div>
            <TextField
              label={id ? "" : "제목"}
              placeholder="북마크 제목을 입력해주세요"
              variant="outlined"
              error={errors.title && true}
              helperText={
                errors.title &&
                "제목은 필수값이며, 20자 이내로 작성해야 합니다."
              }
              {...register("title", { required: true, maxLength: 20 })}
              fullWidth
            />
          </div>

          <div>
            <TextField
              label={id ? "" : "URL"}
              placeholder="북마크할 링크를 입력해주세요."
              variant="outlined"
              error={errors.url && true}
              {...register("url", {
                required: "URL은 필수입니다.",
                pattern: {
                  value:
                    /^(https?:\/\/)?([a-zA-Z0-9\-\.]+)\.([a-zA-Z]{2,})(\/[a-zA-Z0-9#]+\/?)*$/,
                  message: "유효한 URL을 입력해주세요.",
                },
              })}
              helperText={errors.url && errors.url.message}
              fullWidth
            />
          </div>

          <div>
            <TextField
              type="file"
              {...register("image")}
              fullWidth
              error={errors.image && true}
              helperText={errors.image && "이미지는 필수입니다."}
              slotProps={{ htmlInput: { accept: "image/*" } }}
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
                {id ? "수정" : "작성"}
              </Button>
            </Box>
            <Box sx={{ flex: 1 }}>
              <Button
                type="button"
                variant="outlined"
                fullWidth
                color="main"
                onClick={() => navigate("/favorite")}
              >
                취소
              </Button>
            </Box>
          </Box>
        </Grid2>
      </form>
    </>
  );
};

export default FavoriteForm;
