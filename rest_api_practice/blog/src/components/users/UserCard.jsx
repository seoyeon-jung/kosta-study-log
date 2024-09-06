import {
  Box,
  Button,
  IconButton,
  TableCell,
  TableRow,
  TextField,
} from "@mui/material";
import React, { useState } from "react";
import DeleteIcon from "@mui/icons-material/Delete";
import ModeEditIcon from "@mui/icons-material/ModeEdit";
import Swal from "sweetalert2";
import { useNavigate } from "react-router-dom";
import { userAPI } from "../../api/services/user";

const UserCard = ({ user }) => {
  const navigate = useNavigate();

  const [isEditing, setIsEditing] = useState(false);
  const [newName, setNewName] = useState(user.name); // 초기값 : user의 name

  // toggle 버튼 (클릭 시 name 대신 input창이 뜨도록)
  const handleToggle = () => {
    setIsEditing(!isEditing);
  };

  // 회원 이름 수정
  const handleNameChange = async () => {
    const result = await Swal.fire({
      title: "이름을 수정하시겠습니까?",
      text: "수정하기 위해서는 비밀번호가 필요합니다",
      input: "password",
      inputPlaceholder: "비밀번호를 입력해주세요",
      inputAttributes: {
        maxlength: "10",
        autocapitalize: "off",
        autocorrect: "off",
      },
      showCancelButton: true,
      showCloseButton: true,
    });

    const password = result.value;

    if (newName.trim() !== "" && newName !== user.name) {
      try {
        await userAPI.modifyUser({
          email: user.email,
          name: newName,
          password,
        });
        Swal.fire("이름이 수정되었습니다!");
        setIsEditing(false);
        // 새로 고침
        window.location.reload();
      } catch (error) {
        console.error(error);
        Swal.fire("이름 수정 과정에서 문제가 발생했습니다.");
      }
    } else {
      Swal.fire("유효한 이름을 입력해주세요!");
    }
  };

  // 회원 삭제
  const handleDelete = async () => {
    const result = await Swal.fire({
      title: "삭제하시겠습니까?",
      text: "삭제하기 위해서는 비밀번호가 필요합니다",
      input: "password",
      inputPlaceholder: "비밀번호를 입력해주세요",
      inputAttributes: {
        maxlength: "10",
        autocapitalize: "off",
        autocorrect: "off",
      },
      showCancelButton: true,
      showCloseButton: true,
    });

    const password = result.value;

    if (password) {
      try {
        await userAPI.deleteUser(user.email, password);
        Swal.fire("삭제되었습니다!");
        // 새로 고침
        window.location.reload();
      } catch (error) {
        console.error(error);
        navigate("/error", { state: error.message });
      }
    } else {
      Swal.fire("비밀번호를 입력해주세요!");
    }
  };

  return (
    <TableRow>
      <TableCell align="center">{user.id}</TableCell>
      <TableCell align="center">
        {isEditing ? (
          <Box sx={{ display: "flex", alignItems: "center" }}>
            <TextField
              value={newName}
              onChange={(e) => setNewName(e.target.value)}
              size="small"
              sx={{ width: "100px", marginRight: "8px" }}
            />
            <Button variant="contained" color="main" onClick={handleNameChange}>
              수정
            </Button>
          </Box>
        ) : (
          user.name
        )}
      </TableCell>
      <TableCell align="center">{user.email}</TableCell>
      <TableCell align="center">
        <IconButton sx={{ marginLeft: "10px" }} onClick={handleToggle}>
          <ModeEditIcon />
        </IconButton>
        <IconButton onClick={handleDelete}>
          <DeleteIcon />
        </IconButton>
      </TableCell>
    </TableRow>
  );
};

export default UserCard;
