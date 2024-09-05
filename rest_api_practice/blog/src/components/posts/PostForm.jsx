import { Button, Grid2, TextField } from "@mui/material";
import React, { useEffect } from "react";
import { useForm } from "react-hook-form";
import { useNavigate, useParams } from "react-router-dom";
import { postAPI } from "../../api/services/post";

const PostForm = () => {
  const navigate = useNavigate();

  const {
    register,
    handleSubmit,
    formState: { errors },
    setValue, // data 세팅
  } = useForm();

  const { postId } = useParams(); // postId가 존재하면 수정, 아니면 작성화면

  const getPost = async () => {
    try {
      const res = await postAPI.getPost(postId);
      const data = res.data;
      setValue("title", data.title);
      setValue("content", data.content);
    } catch (error) {
      console.error(error);
      navigate("/error", { state: error });
    }
  };

  useEffect(() => {
    // postId가 존재하면 게시물 정보 가져오기
    if (postId) {
      getPost();
    }
  });

  const onSubmit = async (data) => {
    data.authorId = 1; // 로그인 기능 추가 전까지 임의로 지정

    // data.image는 fileList로 data에 저장된다. >> 필요한 부분은 image[0]
    data.image = data.image[0];

    const formData = new FormData();
    Object.keys(data).forEach((key) => {
      formData.append(key, data[key]);
    });

    try {
      // postId가 존재하면 수정
      if (postId) {
        // 서버에 수정 요청 보내기
        formData.append("id", postId);
        await postAPI.modifyPost(formData);

        // 기존 게시물 디테일 페이지로 이동
        navigate(`/post/${postId}`);
      } else {
        // 서버에 등록 요청 보내기
        await postAPI.writePost(formData);

        // 게시물 리스트 페이지로 이동
        navigate("/post");
      }
    } catch (error) {
      console.error(error);
      // 비정상이면 error page로 이동
      navigate("/error", { state: error });
    }
  };

  return (
    <>
      {/* hanndleSubmit 함수는 onSubmit 동작 전에 입력값에 대한 유효값 검증(validation)한다. */}
      <form onSubmit={handleSubmit(onSubmit)}>
        <Grid2
          container
          direction={"column"}
          spacing={3}
          sx={{ width: { xs: "300px", sm: "800px" }, marginTop: "40px" }}
        >
          {/* ...register("이름") -> 값이 전달된다 */}
          {/* 필수값, 유효성 검증 등을 추가할 수 있다. */}

          {/* 제목 : 필수, 50자 이내 */}
          <div>
            <TextField
              label={postId ? "" : "제목"}
              placeholder="제목을 입력해주세요"
              variant="outlined"
              error={errors.title && true}
              helperText={
                errors.title &&
                "제목은 필수값이며, 50자 이내로 작성해야 합니다."
              }
              {...register("title", { required: true, maxLength: 50 })}
              fullWidth
            />
          </div>

          {/* 내용 : 필수 */}
          <div>
            <TextField
              id="outlined-multiline-static"
              label={postId ? "" : "내용"}
              placeholder="내용을 입력해주세요"
              multiline
              rows={8}
              error={errors.content && true}
              helperText={errors.content && "내용은 필수값입니다."}
              {...register("content", { required: true })}
              fullWidth
            />
          </div>

          {/* 이미지 : 필수 아님 */}
          <div>
            <TextField
              type="file"
              {...register("image")}
              fullWidth
              // image만 등록될 수 있도록 막아둠(백엔드에서 한번 더 체크 필요)
              slotProps={{ htmlInput: { accept: "image/*" } }}
            />
          </div>

          {/* 비밀번호 : 필수, 영어+숫자 8자리 이상 20자리 이하 */}
          <div>
            <TextField
              label={postId ? "" : "비밀번호"}
              placeholder="비밀번호를 입력해주세요 (영어+숫자 8~20자리)"
              type="password"
              error={errors.password && true}
              helperText={
                errors.password &&
                "비밀번호는 필수값이며, 영어+숫자로 8~20자리로 작성해야 합니다."
              }
              {...register("password", {
                required: true,
                pattern: /^(?=.*[a-zA-Z])(?=.*\d)[a-zA-Z\d]{8,20}$/,
              })}
              fullWidth
            />
          </div>

          <Button fullWidth type="submit" variant="contained" color="main">
            {postId ? "수정" : "작성"}
          </Button>
        </Grid2>
      </form>
    </>
  );
};

export default PostForm;
