import React, { useEffect, useState } from "react";
import {
  Card,
  CardHeader,
  CardBody,
  CardFooter,
  Typography,
  Button,
  Input,
} from "@material-tailwind/react";
import { productAPI } from "../../services/product";
import { useNavigate, useParams } from "react-router-dom";
import { MdDelete, MdEdit } from "react-icons/md";
import Swal from "sweetalert2";

const ProductDetail = () => {
  const [product, setProduct] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const { id } = useParams();
  const navigate = useNavigate();

  const [isEditing, setIsEditing] = useState(false);
  const [name, setName] = useState("");
  const [price, setPrice] = useState("");

  useEffect(() => {
    const getProduct = async () => {
      try {
        const response = await productAPI.getProduct(id);
        setProduct(response.data);
        setName(response.data.name);
        setPrice(response.data.price);
      } catch (error) {
        console.error("[상품 조회 에러] ", error);
        setError("상품 조회 실패");
      } finally {
        setLoading(false);
      }
    };
    getProduct();
  }, [id]);

  if (loading) {
    return <div className="text-center">Loading...</div>;
  }

  if (error) {
    return <div className="text-center text-red-500">{error}</div>;
  }

  if (!product) {
    return <div className="text-center">No product data found.</div>;
  }

  const handleDelete = async () => {
    try {
      const result = await Swal.fire({
        title: "정말 삭제하시겠습니까?",
        text: "한번 삭제를 하면 되돌릴 수 없습니다.",
        icon: "warning",
        showCancelButton: true,
        confirmButtonColor: "#3085d6",
        confirmButtonText: "삭제",
        cancelButtonText: "취소",
      });

      if (result.isConfirmed) {
        await productAPI.deleteProduct(id);
        Swal.fire(
          `${product.name} 삭제`,
          "상품이 성공적으로 삭제되었습니다",
          "success"
        );
        navigate("/products");
      }
    } catch (error) {
      console.error("[상품 삭제 에러] ", error);
      Swal.fire("삭제 실패", "상품 삭제 중 오류가 발생했습니다.", "error");
    }
  };

  const handleUpdate = async () => {
    try {
      await productAPI.updateProduct({ id, name, price });
      setProduct({ ...product, name, price });
      setIsEditing(false);
      Swal.fire(
        "수정 완료",
        "상품 정보가 성공적으로 수정되었습니다",
        "success"
      );
    } catch (error) {
      console.error("[상품 수정 에러] ", error);
      Swal.fire("수정 실패", "상품 수정 중 오류가 발생했습니다.", "error");
    }
  };

  return (
    <Card className="w-80 mx-auto mb-6 border">
      <CardHeader shadow={false} floated={false} className="h-56">
        <img
          src="https://indiaeducationdiary.in/wp-content/uploads/2021/02/SD-default-image.png"
          alt="기본 이미지"
          className="h-full w-full object-cover"
        />
      </CardHeader>
      <CardBody>
        <div className="mb-2 flex items-center justify-between">
          {isEditing ? (
            <div className="flex flex-col gap-2">
              <Input
                type="text"
                value={name}
                onChange={(e) => setName(e.target.value)}
                className="p-3 border border-gray-300 rounded-md focus:border-cyan-500 focus:ring-1 focus:ring-cyan-500 transition-all"
                placeholder="상품 이름"
              />
              <Input
                type="number"
                value={price}
                onChange={(e) => setPrice(e.target.value)}
                className="p-3 border border-gray-300 rounded-md focus:border-cyan-500 focus:ring-1 focus:ring-cyan-500 transition-all"
                placeholder="상품 가격"
              />
            </div>
          ) : (
            <>
              <Typography color="blue-gray" className="font-medium">
                {product.name}
              </Typography>
              <Typography color="blue-gray" className="font-medium">
                {product.price}원
              </Typography>
            </>
          )}
        </div>
        <Typography
          variant="small"
          color="gray"
          className="font-normal opacity-75"
        >
          "상품 설명이 들어갈 자리입니다."
        </Typography>
      </CardBody>
      <CardFooter className="pt-0 flex gap-2">
        {isEditing ? (
          <>
            <Button
              className="flex items-center justify-center p-2 bg-cyan-300 text-white hover:bg-cyan-600"
              aria-label="Update"
              onClick={handleUpdate}
            >
              수정하기
            </Button>
            <Button
              className="flex items-center justify-center p-2 bg-gray-300 text-white hover:bg-gray-600"
              aria-label="Cancel"
              onClick={() => setIsEditing(false)}
            >
              취소
            </Button>
          </>
        ) : (
          <>
            <Button
              className="flex items-center justify-center p-2 rounded-full text-white focus:outline-none"
              aria-label="Edit"
              onClick={() => setIsEditing(true)}
            >
              <MdEdit className="text-xl text-black hover:text-gray-400" />
            </Button>
            <Button
              className="flex items-center justify-center p-2 rounded-full text-white focus:outline-none "
              aria-label="Delete"
              onClick={handleDelete}
            >
              <MdDelete className="text-xl text-black hover:text-gray-400" />
            </Button>
          </>
        )}
      </CardFooter>
    </Card>
  );
};

export default ProductDetail;
