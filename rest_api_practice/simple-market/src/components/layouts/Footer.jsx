import { Typography } from "@material-tailwind/react";
import React from "react";

const Footer = () => {
  return (
    <footer className="flex w-full bg-cyan-100 flex-row flex-wrap items-center justify-center gap-y-6 gap-x-12 border-t border-blue-gray-50 py-6 text-center">
      <Typography className="font-normal text-gray-500">
        &copy; 2024 seoyeon simple-market-project
      </Typography>
    </footer>
  );
};

export default Footer;
