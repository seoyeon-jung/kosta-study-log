import React from "react";

const Music = ({ music, idx, musicList, setMusicList }) => {
  const { title, like, boom } = music;

  const addLike = () => {
    // musicList 복사
    const copy = [...musicList];
    // 복사한 것 중에 같은 값 찾아서 증가
    copy[idx].like++;
    // 복사한 걸로 setMusicList
    setMusicList(copy);
  };

  const setBoom = () => {
    const copy = [...musicList];
    copy[idx].boom = !musicList[idx].boom;
    setMusicList(copy);
  };

  const editMusic = () => {
    const newTitle = prompt("변경할 제목을 입력하세요");
    const copy = [...musicList];
    copy[idx].title = newTitle;
    setMusicList(copy);
  };

  const deleteMusic = () => {
    const newMusicList = musicList.filter((music, index) => {
      return index !== idx;
    });
    setMusicList(newMusicList);
  };

  return (
    <div>
      <h2>{title}</h2>
      <div>
        <span style={{ cursor: "pointer" }} onClick={() => addLike(idx)}>
          👍
        </span>
        <span>좋아요: {like}</span>
      </div>
      <span style={{ cursor: "pointer" }} onClick={() => setBoom(idx)}>
        {boom ? "😁" : "🤢"}
      </span>
      <button onClick={() => editMusic(idx)}>수정</button>
      <button onClick={() => deleteMusic(idx)}>삭제</button>
    </div>
  );
};

export default Music;
