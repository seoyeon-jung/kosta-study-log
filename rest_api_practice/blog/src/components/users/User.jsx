import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { userAPI } from "../../api/services/user";
import UserCard from "./UserCard";
import {
  Table,
  TableBody,
  TableCell,
  TableHead,
  TableRow,
} from "@mui/material";

const User = () => {
  const [userList, setUserList] = useState([]);
  const navigate = useNavigate();

  const getUserList = async () => {
    try {
      const res = await userAPI.getUserList();
      const data = res.data;
      setUserList(data);
    } catch (error) {
      console.error(error);
      navigate("/error", { state: error.message });
    }
  };

  useEffect(() => {
    getUserList();
  }, []);

  return (
    <>
      <h1>회원 관리</h1>
      <Table>
        <TableHead>
          <TableRow>
            <TableCell align="center">번호</TableCell>
            <TableCell align="center">이름</TableCell>
            <TableCell align="center">이메일</TableCell>
            <TableCell align="center"></TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {userList.map((user) => {
            return <UserCard key={user.id} user={user} />;
          })}
        </TableBody>
      </Table>
    </>
  );
};

export default User;
