import { Typography } from "@material-tailwind/react";
import React from "react";

const Footer = ({ isDarkMode }) => {
  return (
    <footer
      className={`flex w-full flex-row flex-wrap items-center justify-center gap-y-6 gap-x-12 border-t py-6 text-center ${
        isDarkMode
          ? "bg-dark-paper border-dark-background text-dark-text"
          : "bg-cyan-100 border-blue-gray-50 text-gray-500"
      }`}
    >
      <Typography className="font-normal">
        &copy; 2024 seoyeon simple-market-project
      </Typography>
    </footer>
  );
};

export default Footer;
