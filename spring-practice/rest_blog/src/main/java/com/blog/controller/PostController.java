package com.blog.controller;

import java.util.ArrayList;
import java.util.List;

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

import com.blog.domain.ErrorResponse;
import com.blog.domain.PostRequest;
import com.blog.domain.PostResponse;
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

	// 추가
	// {"title" : "제목 수정", "content" : "내용", "password": "1234", "authorId": 1 }
	@PostMapping("")
	public ResponseEntity<PostResponse> writePost(@RequestBody PostRequest post) {
		PostResponse savedPost = postService.insertPost(post);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedPost);
	}

	// 수정
	// {"id": 1, "title" : "제목 수정", "content" : "내용", "password": "1234",
	// "authorId": 1 }
	@PatchMapping("")
	public ResponseEntity<PostResponse> modifyPost(@RequestBody PostRequest post) {
		PostResponse updatedPost = postService.updatePost(post);
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

	// 예외 처리
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorResponse> handlePostException(RuntimeException e, HttpServletRequest req) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(ErrorResponse.builder().statusCode(HttpStatus.BAD_REQUEST.value()).message("게시물 관련 에러 발생")
						.url(req.getRequestURI()).details(e.getMessage()).build());
	}
}
