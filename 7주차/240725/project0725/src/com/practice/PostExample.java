package com.practice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PostExample {

	public static void main(String[] args) {
		List<Comment> cList1 = Arrays.asList(new Comment(1, 1, "좋은 글이네요", "카리나", LocalDateTime.now().minusDays(1)),
				new Comment(2, 1, "저도 잘 읽었습니다", "닝닝", LocalDateTime.now().minusHours(3)));

		List<Comment> cList2 = Arrays.asList(new Comment(3, 2, "정말 유익합니다.", "윈터", LocalDateTime.now().minusDays(3)),
				new Comment(4, 2, "감사합니다.", "지젤", LocalDateTime.now().minusHours(2)));

		List<Comment> cList3 = Arrays.asList(new Comment(3, 2, "정말 유익합니다.", "윈터", LocalDateTime.now().minusDays(3)),
				new Comment(4, 2, "감사합니다.", "지젤", LocalDateTime.now().minusHours(2)));

		List<Comment> cList4 = Arrays.asList(new Comment(3, 2, "정말 유익합니다.", "윈터", LocalDateTime.now().minusDays(3)),
				new Comment(4, 2, "감사합니다.", "지젤", LocalDateTime.now().minusHours(2)));

		List<Post> pList = Arrays.asList(
				new Post(1, "Java를 잡아라", "Java는 객체지향 프로그래밍 언어입니다", "윈터", LocalDateTime.now().minusDays(7), cList1),
				new Post(2, "스트림 파헤치기", "Stream API는 내부 반복자입니다.", "카리나", LocalDateTime.now().minusDays(6), cList2),
				new Post(3, "Spring, 개발자에게 봄이 오다", "Spring을 사용하기 전에는 매우 추웠어요", "닝닝", LocalDateTime.now().minusDays(2),
						new ArrayList<Comment>()));

		PostSystem ps = new PostSystemImpl();

//		System.out.println("게시물 작성");
//		Scanner sc = new Scanner(System.in);
//		System.out.println("제목 입력 : ");
//		String title = sc.next();
//		System.out.println("내용 입력 : ");
//		String content = sc.next();
//		System.out.println("이름 입력 : ");
//		String author = sc.next();
//		ps.insertPost(pList, title, content, author); // 기존에 있는 pList에 글 추가

		System.out.println("윈터님이 작성한 게시물 보기");
		ps.filterPostsByAuthor(pList, "윈터").forEach(System.out::println);

		System.out.println();

		System.out.println("모든 댓글 보기");
		ps.getAllComments(pList).forEach(System.out::println);

		System.out.println();

		System.out.println("모든 게시물 제목 보기");
		ps.getAllPostTitles(pList).forEach(System.out::println);

		System.out.println();

		System.out.println("키워드로 필터링된 게시물 보기");
		ps.filterPostsByKeyword(pList, "Java").forEach(System.out::println);

		System.out.println();

		System.out.println("게시물별 댓글 수 보기");
		ps.getCommentCountByPost(pList).forEach((postId, count) -> {
			System.out.println(postId + "번 게시물 댓글 수 : " + count);
		});

		System.out.println();
		ps.getLatestPosts(pList).forEach(System.out::println);

		System.out.println();
		int highestNum = ps.getHighestPostId(pList);
		System.out.println(highestNum);

	}

}
