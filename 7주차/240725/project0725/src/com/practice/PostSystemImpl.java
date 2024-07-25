package com.practice;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class PostSystemImpl implements PostSystem {

	// 특정 작성자(author)가 작성한 게시물들을 필터링하여 반환하는 메소드
	@Override
	public List<Post> filterPostsByAuthor(List<Post> posts, String author) {
		return posts.stream().filter(post -> post.getAuthor().equals(author)).collect(Collectors.toList());
	}

	// 모든 게시물의 댓글을 추출하여 리스트로 반환하는 메소드
	@Override
	public List<Comment> getAllComments(List<Post> posts) {
		return posts.stream().flatMap(post -> post.getComments().stream()).toList();
	}

	// 모든 게시물의 제목을 추출하여 리스트로 반환하는 메소드
	@Override
	public List<String> getAllPostTitles(List<Post> posts) {
		return posts.stream().map(Post::getTitle).toList();
	}

	// 특정 키워드(keyword)를 포함하는 게시물들을 필터링하여 반환하는 메소드
	@Override
	public List<Post> filterPostsByKeyword(List<Post> posts, String keyword) {
		return posts.stream().filter(post -> post.getTitle().contains(keyword) || post.getContent().contains(keyword))
				.collect(Collectors.toList());
	}

	// 각 게시물의 댓글 수를 계산하여 맵 형태로 반환하는 메소드
	// 게시물 ID를 키로 하고 댓글 수를 값으로 하는 맵
	@Override
	public Map<Integer, Integer> getCommentCountByPost(List<Post> posts) {
		return posts.stream().collect(Collectors.toMap(Post::getId, post -> post.getComments().size()));
	}

	// 최신 게시물 3개를 추출하여 리스트로 반환하는 메소드
	@Override
	public List<Post> getLatestPosts(List<Post> posts) {
		return posts.stream().sorted(Comparator.comparing(Post::getCreatedAt).reversed()).limit(3)
				.collect(Collectors.toList());
		// return posts.stream().sorted((p1, p2) ->
		// p2.getCreateAt().coompareTo(p1.getCreateAt()))
		// -> 이 방법으로도 사용할 수 있음
	}

	// 게시글 번호 중 가장 높은 게시글 번호를 반환하는 메소드
	@Override
	public int getHighestPostId(List<Post> posts) {
		Optional<Post> optMaxPost = posts.stream().max(Comparator.comparing(Post::getId));
		Post p = optMaxPost.orElse(null);

		return p == null ? 0 : p.getId();

		// return posts.stream().mapToInt(Post::getId).max().getAsInt();
	}

}
