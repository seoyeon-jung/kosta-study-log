import { Grid2 } from "@mui/material";
import React from "react";

const Main = ({ children }) => {
  return (
    <Grid2
      container
      mx={3}
      spacing={1}
      direction={"column"}
      alignItems={"center"}
    >
      {children}
    </Grid2>
  );
};

export default Main;
