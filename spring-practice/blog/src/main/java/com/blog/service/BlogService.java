package com.blog.service;

import java.util.List;

import com.blog.entity.Post;

public interface BlogService {

	List<Post> getAllList() throws Exception;

	Post addPost(Post post) throws Exception;

	Post findPostById(Long id) throws Exception;

	void deletePostById(Long id) throws Exception;

	Post updatePost(Post post) throws Exception;

	List<Post> searchAndOrder(String keyword, String order) throws Exception;

}
