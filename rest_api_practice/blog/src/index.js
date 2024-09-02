import React from "react";
import ReactDOM from "react-dom/client";
import App from "./App";
import { createTheme, CssBaseline, ThemeProvider } from "@mui/material";

const root = ReactDOM.createRoot(document.getElementById("root"));

let theme = createTheme({});
theme = createTheme(theme, {
  palette: {
    main: theme.palette.augmentColor({ color: { main: "#AAABD3" } }),
    font: theme.palette.augmentColor({ color: { main: "#353866" } }),
    sub: theme.palette.augmentColor({ color: { main: "#77AAAD" } }),
    bg1: theme.palette.augmentColor({ color: { main: "#CBA6C3" } }),
    bg2: theme.palette.augmentColor({ color: { main: "#F8FAFF" } }),
  },
});

root.render(
  // <React.StrictMode>
  <ThemeProvider theme={theme}>
    <CssBaseline />
    <App />
  </ThemeProvider>
  // </React.StrictMode>
);
