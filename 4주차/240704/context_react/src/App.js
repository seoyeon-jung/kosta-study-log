import "./App.css";
//import GrandFather from "./components/GrandFather";
import { SamsungContext } from "./contexts/SamsungContext";
import { MyColorContext } from "./contexts/MyColorContext";
import { useState } from "react";
import ReducerPractice from "./components/ReducerPractice";
// import ColorBox from "./components/ColorBox";
// import Color from "./components/Color";
//import StatePractice from "./components/StatePractice";

function App() {
  const [myColor, setMyColor] = useState("red");

  return (
    <MyColorContext.Provider value={{ myColor, setMyColor }}>
      <SamsungContext.Provider value={"삼성주식"}>
        <div className="App">
          {/* <GrandFather /> */}
          {/* <ColorBox />
          <div
            style={{
              fontSize: "18px",
              fontWeight: "bold",
              color: myColor,
            }}
          >
            {myColor}
          </div>
          <Color /> */}
          {/* <StatePractice /> */}
          <ReducerPractice />
        </div>
      </SamsungContext.Provider>
    </MyColorContext.Provider>
  );
}

export default App;
