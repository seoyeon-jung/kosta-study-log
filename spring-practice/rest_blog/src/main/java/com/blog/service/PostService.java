package com.blog.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.blog.domain.FileDTO;
import com.blog.domain.PostRequest;
import com.blog.domain.PostResponse;

public interface PostService {

	PostResponse insertPost(PostRequest post, MultipartFile file);

	List<PostResponse> getAllPost();

	PostResponse getPostById(Long id);

	PostResponse updatePost(PostRequest post);

	PostResponse deletePost(Long id, PostRequest post);

	FileDTO getImageById(Long id);

}
