import React, { useContext } from "react";
import { SamsungContext } from "../contexts/SamsungContext";

const GrandChild = () => {
  const samsung = useContext(SamsungContext);
  return (
    <div>
      <h5>grandchild - {samsung}</h5>
    </div>
  );
};

export default GrandChild;
