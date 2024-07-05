import { Button, InputBase, TextField } from "@mui/material";
import React from "react";
import useInput from "../../hooks/useInput";
import axios from "axios";

const PostWrite = ({ dispatch }) => {
  const { form, handleChange } = useInput({ content: "" });

  //   const handleAddPost = async () => {
  //     let formData = {
  //       userId: "1",
  //       like: 0,
  //       img: [],
  //       ...form,
  //     };

  //     try {
  //       const res = await axios.get(
  //         `${process.env.REACT_APP_SERVER_ADDR}/users?id=${formData.userId}`
  //       );
  //       if (res.status === 200 && res.data.length === 1) {
  //         formData.userId = res.data[0].id;
  //         console.log(formData.userId);
  //       } else {
  //         throw Error("알 수 없는 에러");
  //       }

  //       const res2 = await axios.post(
  //         `${process.env.REACT_APP_SERVER_ADDR}/posts`,
  //         formData
  //       );
  //       if (res2.status === 201) {
  //         //console.log(res.data);
  //         dispatch({ type: "ADD_POST", payload: res2.data });
  //       }
  //     } catch (error) {
  //       console.error(error);
  //     }
  //   };

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
      <Button
        variant="outlined"
        //onClick={handleAddPost}
      >
        글쓰기
      </Button>
    </form>
  );
};

export default PostWrite;
