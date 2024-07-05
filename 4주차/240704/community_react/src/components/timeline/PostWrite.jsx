import { Button, InputBase, TextField } from "@mui/material";
import React from "react";
import useInput from "../../hooks/useInput";
import { userApi } from "../../api/services/users";
import { postApi } from "../../api/services/posts";

const PostWrite = ({ dispatch }) => {
  const { form, handleChange, handleReset } = useInput({ content: "" });

  const handleAddPost = async () => {
    let formData = {
      userId: "1",
      like: 0,
      img: [],
      ...form,
    };

    try {
      //   const res = await axios.get(
      //     `${process.env.REACT_APP_SERVER_ADDR}/users?id=${formData.userId}`
      //   );
      const res1 = await userApi.getUser(formData.userId);
      if (res1.status === 200 && res1.data) {
        formData.user = res1.data;
      } else {
        throw new Error("알 수 없는 에러");
      }

      //   const res2 = await axios.post(
      //     `${process.env.REACT_APP_SERVER_ADDR}/posts`,
      //     formData
      //   );
      const res2 = await postApi.postPosts(formData);
      if (res2.status === 201) {
        //console.log(res2.data);
        dispatch({ type: "ADD_POST", payload: res2.data });
      }
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <form>
      <TextField
        fullWidth
        id="content"
        name="content"
        value={form.content}
        onChange={handleChange}
      />
      <InputBase type="file" accept="image/*" />
      <Button variant="outlined" onClick={handleAddPost}>
        글쓰기
      </Button>
    </form>
  );
};

export default PostWrite;
