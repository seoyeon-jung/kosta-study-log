import React from "react";
import { Card, Input, Button, Typography } from "@material-tailwind/react";

const LoginForm = () => {
  return (
    <Card color="transparent" shadow={false} className="mt-4">
      <form className="mt-8 mb-2 w-80 max-w-screen-lg sm:w-96">
        <div className="mb-1 flex flex-col gap-6">
          <Typography variant="h6" color="blue-gray" className="-mb-3">
            Email
          </Typography>
          <Input
            size="lg"
            placeholder="example@mail.com"
            className="!border-gray-200 p-2 focus:!border-t-gray-900 placeholder:text-sm placeholder:p-2"
            labelProps={{
              className: "before:content-none after:content-none",
            }}
          />
          <Typography variant="h6" color="blue-gray" className="-mb-3">
            Password
          </Typography>
          <Input
            type="password"
            size="lg"
            placeholder="********"
            className=" !border-gray-200 p-2 focus:!border-t-gray-900 placeholder:text-sm placeholder:p-2"
            labelProps={{
              className: "before:content-none after:content-none",
            }}
          />
        </div>
        <Button
          className="mt-6 bg-cyan-600 text-white hover:bg-cyan-400"
          fullWidth
        >
          로그인
        </Button>
      </form>
    </Card>
  );
};

export default LoginForm;
