package com.blog.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.blog.domain.request.PostRequest;
import com.blog.domain.response.PostResponse;
import com.blog.entity.ImageFile;
import com.blog.entity.Post;
import com.blog.entity.User;
import com.blog.repository.PostRepository;
import com.blog.repository.UserRepository;
import com.blog.service.ImageFileService;
import com.blog.service.PostService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
	private final PostRepository postRepository;
	private final UserRepository userRepository;
	private final ImageFileService imageFileService;

	@Override
	public PostResponse insertPost(PostRequest postDTO, MultipartFile file) {

		ImageFile savedImage = imageFileService.saveImage(file);
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

	@Override
	public List<PostResponse> getAllPost() {
		List<Post> postList = postRepository.findAll();
		if (postList.size() > 0) {
			// List<PostResponse> postResponseList = postList.stream().map(post ->
			// PostResponse.toDTO(post)).toList();
			List<PostResponse> postResponseList = postList.stream().map(PostResponse::toDTO).toList();
			return postResponseList;
		} else {
			return new ArrayList<>(); // 없는 경우 빈 list return
		}
	}

	@Override
	public PostResponse getPostById(Long id) {
		Post post = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시물을 찾을 수 없음"));
		PostResponse postResponse = PostResponse.toDTO(post);
		return postResponse;
	}

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
		ImageFile savedImage = imageFileService.saveImage(file);
		if (savedImage != null) {
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

	@Override
	public PostResponse deletePost(Long id, PostRequest postDTO) {
		User user = userRepository.findById(postDTO.getAuthorId())
				.orElseThrow(() -> new IllegalArgumentException("해당 유저를 찾을 수 없음"));
		Post post = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시물을 찾을 수 없음"));

		if (!post.getAuthor().getId().equals(user.getId())) {
			throw new IllegalArgumentException("본인이 작성한 글만 삭제할 수 있음");
		}

		if (!post.getPassword().equals(postDTO.getPassword())) {
			throw new IllegalArgumentException("비밀번호가 일치하지 않음");
		}

		postRepository.delete(post);
		return PostResponse.toDTO(post);
	}

	@Override
	public List<PostResponse> search(String keyword) {
		List<Post> postList = postRepository.findByTitleContainsOrContentContains(keyword, keyword);
		return postList.stream().map(p -> PostResponse.toDTO(p)).toList();
	}

}
