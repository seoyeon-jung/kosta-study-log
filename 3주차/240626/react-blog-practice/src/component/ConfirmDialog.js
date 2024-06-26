import React from "react";

function Button(props) {
  return <button className={`bg-${props.color}`}>{props.children}</button>;
}

function ConfirmDialog(props) {
  return (
    <div>
      <p>내용을 확인하셨다면 버튼을 클릭하세요.</p>
      <Button color="green">확인 버튼</Button>
    </div>
  );
}

export default ConfirmDialog;
