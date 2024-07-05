import { Button, List, ListItem, ListItemText, Stack } from "@mui/material";
import React from "react";
import { useNavigate } from "react-router-dom";
import { Carousel } from "react-responsive-carousel";
import "react-responsive-carousel/lib/styles/carousel.min.css";

const PostList = ({ posts }) => {
  const navigate = useNavigate();

  const goToProfile = (userId) => {
    navigate(`/profile/${userId}`);
  };

  return (
    <>
      <List sx={{ minWidth: "300px" }}>
        {posts.map((p) => (
          <ListItem
            key={p.id}
            divider
            alignItems="flex-start"
            sx={{ flexDirection: "column" }}
          >
            <ListItemText>
              <Button
                size="small"
                variant="outlined"
                onClick={() => goToProfile(p.userId)}
              >
                {p.user.nickname}
              </Button>
            </ListItemText>
            <Carousel
              showArrows
              centerMode
              infiniteLoop
              dynamicHeight
              showThumbs={false}
              width={"50%"}
            >
              {p.img &&
                p.img.map((img, idx) => (
                  <Stack key={idx}>
                    <img src={`${process.env.REACT_APP_SERVER_ADDR}${img}`} />
                  </Stack>
                ))}
            </Carousel>
            {/* <img src={`${process.env.REACT_APP_SERVER_ADDR}${p.img}`} /> */}
            <ListItemText>
              <span>{p.content}</span>
            </ListItemText>
          </ListItem>
        ))}
      </List>
    </>
  );
};

export default PostList;
