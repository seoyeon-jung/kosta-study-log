import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { userAPI } from "../../api/services/user";
import UserCard from "./UserCard";
import {
  Pagination,
  Table,
  TableBody,
  TableCell,
  TableHead,
  TableRow,
} from "@mui/material";
import usePagination from "../../hooks/usePagination";

const User = () => {
  const [userList, setUserList] = useState([]);
  const navigate = useNavigate();

  // 5개씩 pagination
  const itemsPerpage = 5;
  const { currentPage, currentItems, totalPages, paginate } = usePagination(
    userList,
    itemsPerpage
  );

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
            <TableCell align="center">회원 관리</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {currentItems.map((user) => {
            return <UserCard key={user.id} user={user} />;
          })}
        </TableBody>
      </Table>

      {/* pagination */}
      <div
        style={{
          display: "flex",
          justifyContent: "center",
          alignItems: "center",
          marginTop: "1rem",
        }}
      >
        <Pagination
          count={totalPages}
          page={currentPage}
          onChange={(event, page) => paginate(page)}
          color="secondary"
          variant="outlined"
          sx={{ marginBottom: "15px" }}
        />
      </div>
    </>
  );
};

export default User;
