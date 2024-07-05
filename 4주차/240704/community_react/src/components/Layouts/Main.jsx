import React from "react";
import { Grid } from "@mui/material";

const Main = ({ children }) => {
  return (
    <Grid
      container
      my={3}
      spacing={1}
      direction={"column"}
      alignItems={"center"}
    >
      {children}
    </Grid>
  );
};

export default Main;
