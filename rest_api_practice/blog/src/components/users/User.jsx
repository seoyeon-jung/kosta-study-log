import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { userAPI } from "../../api/services/user";

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
      navigate("/error", { state: error });
    }
  };

  useEffect(() => {
    getUserList();
  }, []);

  return (
    <>
      user list
      {userList.map((user) => {
        return <div>{user.name}</div>;
      })}
    </>
  );
};

export default User;
