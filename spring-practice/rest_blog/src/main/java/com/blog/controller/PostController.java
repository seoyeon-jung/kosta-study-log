package com.blog.controller;

import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriUtils;

import com.blog.domain.FileDTO;
import com.blog.domain.request.PostRequest;
import com.blog.domain.response.ErrorResponse;
import com.blog.domain.response.PostResponse;
import com.blog.service.ImageFileService;
import com.blog.service.PostService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

// @ReuqestBody : 비동기 통신에서 쓰이는 Body 안의 데이터(JSON객체)를 자바 객체(VO)로 변환해주는 어노테이션
// @RequestBody를 매번 써넣지 않고 @RestController 임을 명시하면 된다
// @RestController : 반환하려는 주류는 JSON 형태의 객체 데이터
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post")
public class PostController {
	private final PostService postService;
	private final ImageFileService imageFileService;

	// application.yml 파일의 location 정보 가져오기
	@Value("${spring.upload.location}")
	private String uploadPath;

	// 추가
	// image file이 추가되므로 formData 형태로 보내줘야 한다.
	// {"title" : "제목 수정", "content" : "내용", "password": "1234", "authorId": 1 }
	@PostMapping("")
	public ResponseEntity<PostResponse> writePost(PostRequest post,
			@RequestParam(name = "image", required = false) MultipartFile file) {
		PostResponse savedPost = postService.insertPost(post, file);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedPost);
	}

	// 수정
	// {"id": 1, "title" : "제목 수정", "content" : "내용", "password": "1234",
	// "authorId": 1 }
	@PatchMapping("")
	public ResponseEntity<PostResponse> modifyPost(PostRequest post,
			@RequestParam(name = "image", required = false) MultipartFile file) {
		PostResponse updatedPost = postService.updatePost(post, file);
		return ResponseEntity.ok(updatedPost);
	}

	// 전체 게시물 조회 (localhost:8080/api/post)
	@GetMapping("")
	public ResponseEntity<List<PostResponse>> getAllPost(@RequestParam(name = "id", required = false) Long id) {
		List<PostResponse> result = new ArrayList<>();
		if (id == null) {
			result = postService.getAllPost();
		} else {
			PostResponse postResponse = postService.getPostById(id);
			result.add(postResponse);
		}
		// return ResponseEntity.status(HttpStatus.OK).body(result);
		return ResponseEntity.ok(result);
	}

	// 하나 게시물 조회
	// localhost:8080/api/post?id=1 또는 localhost:8080/api/post/1
	@GetMapping("/{id}")
	public ResponseEntity<PostResponse> getPost(@PathVariable("id") Long id) {
		PostResponse postResponse = postService.getPostById(id);
		return ResponseEntity.ok(postResponse);
	}

	// 삭제
	// { "id": 1, "password": "1234" }
	@DeleteMapping("/{id}")
	public ResponseEntity<PostResponse> removePost(@PathVariable("id") Long id, @RequestBody PostRequest post) {
		PostResponse postResponse = postService.deletePost(id, post);
		return ResponseEntity.ok(postResponse);
	}

	// image id값을 가져와서 파일 다운로드
	@GetMapping("/download/{imageId}")
	public ResponseEntity<Resource> downloadImage(@PathVariable("imageId") Long id) throws MalformedURLException {
		FileDTO fileDTO = imageFileService.getImageById(id); // 실제로 데이터를 가져오는 곳은 ImageFileRepository

		UrlResource resource = new UrlResource("file:" + uploadPath + "\\" + fileDTO.getSaved());
		String fileName = UriUtils.encode(fileDTO.getOrigin(), StandardCharsets.UTF_8);
		String contentDisposition = "attachment; filename=\"" + fileName + "\"";

		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition).body(resource);
	}

	// 검색
	@GetMapping("/search")
	public ResponseEntity<List<PostResponse>> search(@RequestParam("keyword") String keyword) {
		List<PostResponse> result = postService.search(keyword);
		return ResponseEntity.ok(result);
	}

	// 예외 처리
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorResponse> handlePostException(RuntimeException e, HttpServletRequest req) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(ErrorResponse.builder().statusCode(HttpStatus.BAD_REQUEST.value()).message("게시물 관련 에러 발생")
						.url(req.getRequestURI()).details(e.getMessage()).build());
	}
}
