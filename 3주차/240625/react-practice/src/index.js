import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import App from "./App";
// import Player from "./components/Player";
// import Team from "./components/Team";
// import ConfirmDialog from "./components/ConfirmDialog";
// import Clock from "./components/Clock";
// import Comment from "./components/Comment";
// import Comment2 from "./components/Comment2";
// import CommentList from "./components/CommentList";
// import NumberList from "./components/NumberList";
// import WelcomeDialog from "./components/WelcomeDialog.";
// import ProfileCard from "./components/ProfileCard";

const root = ReactDOM.createRoot(document.getElementById("root"));

// const user = {
//   imgUrl:
//     "https://encrypted-tbn1.gstatic.com/licensed-image?q=tbn:ANd9GcRpSo5X-9GknhLwsqbgdtHhueRB_ZitJC-6IPBvZ7KWWxgFHCl9oke9ouGB8DzTUth-fvavDDA1pSJBlc4",
//   userName: "손흥민",
// };

root.render(
  <React.StrictMode>
    <App />
    {/* <Player playerName='이강인' playerNumber='20' /> */}
    {/* <Team/> */}
    {/* <ConfirmDialog /> */}
    {/* <Clock></Clock> */}
    {/* <Comment user={user} content="안녕하세요. 1등!!!" replydate="2024.06.25"></Comment> */}
    {/* <Comment2 user={user} content="안녕하세요. 1등!!!" replydate="2024.06.25" ></Comment2> */}
    {/* <Team></Team> */}
    {/* <CommentList></CommentList> */}
    {/* <NumberList></NumberList> */}
    {/* <WelcomeDialog  ></WelcomeDialog> */}
    {/* <ProfileCard></ProfileCard> */}
  </React.StrictMode>
);
