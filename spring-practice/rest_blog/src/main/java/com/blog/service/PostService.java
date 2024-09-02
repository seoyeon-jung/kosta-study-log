package com.blog.service;

import java.util.List;

import com.blog.domain.PostRequest;
import com.blog.domain.PostResponse;

public interface PostService {

	PostResponse insertPost(PostRequest post);

	List<PostResponse> getAllPost();

	PostResponse getPostById(Long id);

	PostResponse updatePost(PostRequest post);

}
