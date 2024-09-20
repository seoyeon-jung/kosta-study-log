import { Button, Card, Input, Typography } from "@material-tailwind/react";
import React from "react";
import { useForm } from "react-hook-form";
import { useNavigate } from "react-router-dom";
import { productAPI } from "../../api/services/product";

const ProductForm = () => {
  const navigate = useNavigate();
  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm();

  const onSubmit = async (data) => {
    try {
      await productAPI.addProduct(data);
      navigate("/products");
    } catch (error) {
      console.error("[상품 등록 에러] ", error);
    }
  };

  return (
    <Card
      color="transparent"
      shadow={false}
      className="mt-4 bg-white dark:bg-gray-800"
    >
      <form
        className="mt-8 mb-2 w-80 max-w-screen-lg sm:w-96"
        onSubmit={handleSubmit(onSubmit)}
      >
        <div className="mb-6 flex flex-col gap-4">
          <div className="flex flex-col gap-1">
            <Typography
              variant="h6"
              color="blue-gray"
              className="font-medium text-gray-800 dark:text-gray-200"
            >
              상품명
            </Typography>
            <Input
              size="lg"
              placeholder="(예) 아메리카노"
              className="p-3 border border-gray-300 rounded-md dark:border-gray-600 focus:border-cyan-500 focus:ring-1 focus:ring-cyan-500 transition-all dark:bg-gray-700 dark:focus:border-cyan-400 dark:focus:ring-cyan-400"
              {...register("name", { required: "상품명을 입력해주세요" })}
              error={!!errors.name}
            />
            {errors.name && (
              <Typography
                variant="small"
                className="mt-1 text-red-600 dark:text-red-400"
              >
                {errors.name.message}
              </Typography>
            )}
          </div>

          <div className="flex flex-col gap-1">
            <Typography
              variant="h6"
              color="blue-gray"
              className="font-medium text-gray-800 dark:text-gray-200"
            >
              가격
            </Typography>
            <Input
              type="number"
              size="lg"
              placeholder="(예) 4000"
              className="p-3 border border-gray-300 rounded-md dark:border-gray-600 focus:border-cyan-500 focus:ring-1 focus:ring-cyan-500 transition-all dark:bg-gray-700 dark:focus:border-cyan-400 dark:focus:ring-cyan-400"
              {...register("price", { required: "가격을 입력해주세요" })}
              error={!!errors.price}
            />
            {errors.price && (
              <Typography
                variant="small"
                className="mt-1 text-red-600 dark:text-red-400"
              >
                {errors.price.message}
              </Typography>
            )}
          </div>
        </div>
        <Button
          type="submit"
          className="mt-6 bg-cyan-600 text-white hover:bg-cyan-400 focus:outline-none focus:ring-2 focus:ring-cyan-300 rounded-md dark:bg-gray-500 dark:hover:bg-gray-400 dark:focus:ring-gray-400"
          fullWidth
        >
          상품 추가
        </Button>
      </form>
    </Card>
  );
};

export default ProductForm;
