module.exports = {
  content: ["./src/**/*.{js,jsx,ts,tsx}"],
  theme: {
    extend: {
      colors: {
        cyan: {
          50: "#e0f7fa",
          100: "#b2ebf2",
          200: "#80deea",
          300: "#4dd0e1",
          400: "#26c6da",
          500: "#00bcd4",
          600: "#00acc1",
          700: "#0097a7",
          800: "#00838f",
          900: "#006064",
        },
        dark: {
          background: "#121212",
          paper: "#1e1e1e",
          text: "#ffffff",
        },
        light: {
          background: "#ffffff",
          paper: "#f5f5f5",
          text: "#000000",
        },
      },
    },
  },
  darkMode: "class",
  plugins: [],
};
