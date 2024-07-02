import { useState } from "react";
import "./App.css";
import Music from "./components/Music";
//import Login from "./components/Login";

function App() {
  const [musicList, setMusicList] = useState([
    {
      id: new Date().getTime(),
      title: "Love wins all",
      like: 0,
      boom: true,
    },
  ]);

  const [music, setMusic] = useState("");

  const addMusic = () => {
    music &&
      setMusicList([
        ...musicList,
        {
          id: new Date().getTime(),
          title: music,
          like: 0,
          boom: true,
        },
      ]);
  };

  return (
    <div className="App">
      {/* <Login /> */}
      <div>
        <h1>플레이리스트</h1>
      </div>
      <div className="music-box">
        <div>
          <label htmlFor="title_input"></label>
          <input
            id="title_input"
            type="text"
            placeholder="음악 제목을 입력하세요"
            value={music}
            onChange={(e) => setMusic(e.target.value)}
          />
          <button onClick={addMusic}>추가</button>
        </div>

        {musicList.map((music, idx) => {
          return (
            <Music
              key={music.id}
              music={music}
              idx={idx}
              musicList={musicList}
              setMusicList={setMusicList}
            />
          );
        })}
      </div>
    </div>
  );
}

export default App;
