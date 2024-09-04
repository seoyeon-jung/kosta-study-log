## 목차
- [글 수정하기 \[백엔드\]](#글-수정하기-백엔드)
  - [controller 수정](#controller-수정)
  - [ServiceImpl 수정](#serviceimpl-수정)
- [`.env` 파일 추가 \[프론트\]](#env-파일-추가-프론트)

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