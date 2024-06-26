import React, { useState } from "react";

function NameForm(props) {
  const [value, setValue] = useState("");

  const handleChange = (event) => {
    setValue(event.target.value);
    console.log(event.target.value);
  };
  const handleSubmit = (event) => {
    event.preventDefault();
    alert("입력한 이름 : " + value);
  };

  return (
    <form onSubmit={handleSubmit}>
      <label>이름</label>
      <input type="text" value={value} onChange={handleChange} />
      <button type="submit">제출</button>
    </form>
  );
}

export default NameForm;
