import axios from "axios";
import React, { useCallback, useEffect, useState } from "react";
import { useParams } from "react-router-dom";

const ProdDetail = () => {
  // id값을 받아오기 위함
  let { id } = useParams();
  const [prodDetail, setProdDetail] = useState();
  const [isloading, setIsloading] = useState(true);

  const getProdDetail = useCallback(async () => {
    try {
      const res = await axios.get(`http://localhost:8080/products/${id}`);
      setProdDetail(res.data);
      setIsloading(false);
    } catch (error) {
      console.error(error);
    }
  }, [id]);

  useEffect(() => {
    getProdDetail();
  }, [getProdDetail]);

  if (isloading) {
    return <div>loading...</div>;
  }

  return (
    <div
      style={{ display: "flex", flexDirection: "column", alignItems: "center" }}
    >
      <h1 style={{ margin: "10px" }}>{prodDetail.name}</h1>
      <div style={{ margin: "10px" }}>{prodDetail.description}</div>
      <div style={{ margin: "10px" }}>{prodDetail.price}원</div>
    </div>
  );
};

export default ProdDetail;
