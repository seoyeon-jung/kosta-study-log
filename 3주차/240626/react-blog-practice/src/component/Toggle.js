import React, { useState } from "react";

function Toggle(props) {
  const [isToggle, setIsToggle] = useState(true);

  const handleClick = () => {
    setIsToggle((isToggle) => !isToggle);
  };

  return <button onClick={handleClick}>{isToggle ? "끄기" : "켜기"}</button>;
}

export default Toggle;
