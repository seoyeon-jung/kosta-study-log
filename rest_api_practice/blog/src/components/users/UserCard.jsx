import {
  Box,
  Button,
  Dialog,
  DialogActions,
  DialogContent,
  DialogTitle,
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

  const [isModalOpen, setIsModalOpen] = useState(false);
  const [newName, setNewName] = useState(user.name); // 초기값 : user의 name
  const [password, setPassword] = useState("");

  // open modal
  const handleModalOpen = () => {
    setIsModalOpen(true);
  };

  const handleModalClose = () => {
    setIsModalOpen(false);
    setNewName(user.name);
    setPassword("");
  };

  // 회원 이름 수정
  const handleNameChange = async () => {
    if (newName.trim() === "" || newName === user.name) {
      Swal.fire("유효한 이름을 입력해주세요!");
      return;
    }

    if (password.trim() === "") {
      Swal.fire("비밀번호를 입력해주세요!");
      return;
    }

    try {
      await userAPI.modifyUser({
        email: user.email,
        name: newName,
        password,
      });
      Swal.fire("이름이 수정되었습니다!");
      handleModalClose();
      // 새로고침
      window.location.reload();
    } catch (error) {
      console.error(error);
      Swal.fire("이름 수정 과정에서 문제가 발생했습니다.");
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
    <>
      <TableRow>
        <TableCell align="center">{user.id}</TableCell>
        <TableCell align="center">{user.name}</TableCell>
        <TableCell align="center">{user.email}</TableCell>
        <TableCell align="center">
          <IconButton sx={{ marginLeft: "10px" }} onClick={handleModalOpen}>
            <ModeEditIcon />
          </IconButton>
          <IconButton onClick={handleDelete}>
            <DeleteIcon />
          </IconButton>
        </TableCell>
      </TableRow>

      <Dialog open={isModalOpen} onClose={handleModalClose}>
        <DialogTitle>회원 이름 수정</DialogTitle>
        <DialogContent>
          <Box>
            <TextField
              label="새 이름"
              value={newName}
              onChange={(e) => setNewName(e.target.value)}
              fullWidth
              margin="normal"
            />
            <TextField
              type="password"
              label="비밀번호"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              fullWidth
              margin="normal"
            />
          </Box>
        </DialogContent>
        <DialogActions>
          <>
            <Button onClick={handleNameChange} variant="contained" color="main">
              수정
            </Button>
            <Button onClick={handleModalClose} color="secondary">
              취소
            </Button>
          </>
        </DialogActions>
      </Dialog>
    </>
  );
};

export default UserCard;
