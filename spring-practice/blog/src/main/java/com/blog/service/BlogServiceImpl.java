package com.blog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.blog.entity.Post;
import com.blog.repository.BlogRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BlogServiceImpl implements BlogService {
	private final BlogRepository blogRepository;

	@Override
	public List<Post> getAllList() throws Exception {
		return blogRepository.findAll();
	}

	@Override
	public Post addPost(Post post) throws Exception {
		return blogRepository.save(post);
	}

	@Override
	public Post findPostById(Long id) throws Exception {
		Optional<Post> optPost = blogRepository.findById(id);
		Post post = optPost.orElseThrow(() -> new Exception("ID가 없습니다."));
		return post;
	}

	@Override
	public void deletePostById(Long id) throws Exception {
		Post post = findPostById(id);
		blogRepository.deleteById(post.getId());
	}

	@Override
	public Post updatePost(Post post) throws Exception {
		Post originalPost = findPostById(post.getId());
		originalPost.setTitle(post.getTitle());
		originalPost.setContent(post.getContent());

		Post updatedPost = blogRepository.save(originalPost);
		return updatedPost;
	}

	@Override
	public List<Post> searchAndOrder(String keyword, String order) throws Exception {
		// 정렬 기준만 체크
		if (order.equals("desc")) {
			// 내림차순 결과 반환
			return blogRepository.findByTitleContainsOrContentContainsOrderByTitleDesc(keyword, keyword);
		}
		// 오름차순 결과 반환
		return blogRepository.findByTitleContainsOrContentContainsOrderByTitleAsc(keyword, keyword);
	}

}
