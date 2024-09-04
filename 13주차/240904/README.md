## 목차
- [글 수정하기 \[백엔드\]](#글-수정하기-백엔드)
  - [controller 수정](#controller-수정)
  - [ServiceImpl 수정](#serviceimpl-수정)
- [`.env` 파일 추가 \[프론트\]](#env-파일-추가-프론트)
- [api 관련 따로 폴더 생성 \[프론트\]](#api-관련-따로-폴더-생성-프론트)
  - [api 파일 생성](#api-파일-생성)
  - [service 폴더 안에 `post`, `favorite` 파일 생성](#service-폴더-안에-post-favorite-파일-생성)

<br/>
<br/>
<br/>
<br/>

# 글 수정하기 [백엔드]
## controller 수정
```java
	@PatchMapping("")
	public ResponseEntity<PostResponse> modifyPost(PostRequest post,
			@RequestParam(name = "image", required = false) MultipartFile file) {
		PostResponse updatedPost = postService.updatePost(post, file);
		return ResponseEntity.ok(updatedPost);
	}
```
## ServiceImpl 수정
```java
	// 이미지 저장 메소드 (중복되므로 메소드 생성)
	private ImageFile saveImage(MultipartFile file) {
		if (file != null) {
			// 이미지 파일 가져오기
			ImageFile imageFile = fileUtils.fileUpload(file);

			if (imageFile != null) {
				// DB에 저장
				ImageFile savedImageFile = imageFileRepoistory.save(imageFile);
				return savedImageFile;
			}
		}
		return null;
	}

    
    // 글 작성
    @Override
	public PostResponse insertPost(PostRequest postDTO, MultipartFile file) {

		ImageFile savedImage = saveImage(file);
		if (savedImage != null) {
			// postDTO (postRequest)에 이미지 파일 추가
			postDTO.setImageFile(savedImage);
		}

		// post table에 저장
		User user = userRepository.findById(postDTO.getAuthorId())
				.orElseThrow(() -> new IllegalArgumentException("해당 유저를 찾을 수 없음"));
		Post post = postDTO.toEntity(user);
		Post savedPost = postRepository.save(post);

		// response에 image 추가
		PostResponse result = PostResponse.toDTO(savedPost);
		return result;
	}

    // 글 수정
    @Override
	public PostResponse updatePost(PostRequest postDTO, MultipartFile file) {

		User user = userRepository.findById(postDTO.getAuthorId())
				.orElseThrow(() -> new IllegalArgumentException("해당 유저를 찾을 수 없음"));
		Post post = postRepository.findById(postDTO.getId())
				.orElseThrow(() -> new IllegalArgumentException("해당 게시물을 찾을 수 없음"));

		if (!post.getAuthor().getId().equals(user.getId())) {
			throw new IllegalArgumentException("본인이 작성한 글만 수정할 수 있음");
		}

		if (!post.getPassword().equals(postDTO.getPassword())) {
			throw new IllegalArgumentException("비밀번호가 일치하지 않음");
		}

		// 이미지 있는 경우 확인
		ImageFile savedImage = saveImage(file);
		if (savedImage != null) {
			// postDTO (postRequest)에 이미지 파일 추가
			post.setImage(savedImage);
		}

		if (postDTO.getTitle() != null) {
			post.setTitle(postDTO.getTitle());
		}
		if (postDTO.getContent() != null) {
			post.setContent(postDTO.getContent());
		}
		post.setUpdatedAt(LocalDateTime.now());

		Post updatedPost = postRepository.save(post);
		PostResponse result = PostResponse.toDTO(updatedPost);

		return result;
	}
```

<br/>
<br/>
<br/>
<br/>

# `.env` 파일 추가 [프론트]
```javascript
REACT_APP_REST_SERVER=http://localhost:8080/api
REACT_APP_SERVER=http://localhost:8080
```
```javascript
  useEffect(() => {
    // 요청 보내기
    const getPost = async () => {
      try {
        const res = await axios.get(
          `${process.env.REACT_APP_REST_SERVER}/post/${postId}`
        );
        const data = res.data;
        setPost(data);
      } catch (error) {
        navigate("/error");
      }
    };

    getPost();
  }, [postId, navigate]);
```
- server 주소 바뀌면 쉽게 `.env` 파일에서 주소를 수정하면 된다.
  
<br/>
<br/>
<br/>
<br/>

# api 관련 따로 폴더 생성 [프론트]
## api 파일 생성
```javascript
import axios from "axios";

const api = axios.create({
  baseURL: `${process.env.REACT_APP_REST_SERVER}`,
});

api.interceptors.request.use(
  (config) => {
    return config;
  },
  (err) => {
    return Promise.reject(err);
  }
);

// 응답할 때 사용하는 interceptor
// response에 따라서 분기가 가능하다
api.interceptors.response.use(
  (res) => {
    // response가 있는 경우 response의 data 반환
    return res;
  },
  (err) => {
    // error 처리
    return Promise.reject(err);
    // 만약에 권한이 없다는 에러가 나오면 토큰 재발급 해주도록 할 것이다.
  }
);

export default api;
```
- `axios`로 백엔드 서버와 연동하기 위해 baseURL을 설정했다.
- 추후 수정할 경우 이 파일만 수정하면 된다.
## service 폴더 안에 `post`, `favorite` 파일 생성
```javascript
import api from "../api";

export const postAPI = {
  getPostList: () => api.get("/post"),
  getPost: (id) => api.get(`/post/${id}`),
  writePost: (formData) =>
    api.post("/post", formData, {
      headers: { "Content-Type": "mulipart/form-data" },
    }),
  modifyPost: (formData) =>
    api.patch("/post", formData, {
      headers: { "Content-Type": "mulipart/form-data" },
    }),
  deletePost: (id, password, authorId) =>
    api.delete(`/post/${id}`, { data: { password, authorId } }),
};
```
```javascript
import api from "../api";

export const FavoriteAPI = {
  getFavoriteList: () => api.get("/favorite"),
  writeFavorite: (formData) =>
    api.Favorite("/favorite", formData, {
      headers: { "Content-Type": "mulipart/form-data" },
    }),
  modifyFavorite: (formData) =>
    api.patch("/favorite", formData, {
      headers: { "Content-Type": "mulipart/form-data" },
    }),
  deleteFavorite: (id) => api.delete(`/favorite/${id}`),
};

```