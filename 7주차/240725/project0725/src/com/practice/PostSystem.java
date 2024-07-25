package com.practice;

import java.util.List;
import java.util.Map;

public interface PostSystem {
	// 특정 작성자(author)가 작성한 게시물들을 필터링하여 반환하는 메소드
	public List<Post> filterPostsByAuthor(List<Post> posts, String author);

	// 모든 게시물의 댓글을 추출하여 리스트로 반환하는 메소드
	public List<Comment> getAllComments(List<Post> posts);

	// 모든 게시물의 제목을 추출하여 리스트로 반환하는 메소드
	public List<String> getAllPostTitles(List<Post> posts);

	// 특정 키워드(keyword)를 포함하는 게시물들을 필터링하여 반환하는 메소드
	public List<Post> filterPostsByKeyword(List<Post> posts, String keyword);

	// 각 게시물의 댓글 수를 계산하여 맵 형태로 반환하는 메소드
	// 게시물 ID를 키로 하고 댓글 수를 값으로 하는 맵
	public Map<Integer, Integer> getCommentCountByPost(List<Post> posts);

	// 최신 게시물 3개를 추출하여 리스트로 반환하는 메소드
	public List<Post> getLatestPosts(List<Post> posts);

	// 게시글 번호 중 가장 높은 게시글 번호를 반환하는 메소드
	public int getHighestPostId(List<Post> posts);

	// 게시물 추가 메소드 (Scanner로 입력 받아서 추가하기)
	public void insertPost(List<Post> pList);

}
