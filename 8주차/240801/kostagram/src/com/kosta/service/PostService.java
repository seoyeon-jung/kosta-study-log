package com.kosta.service;

import java.util.List;

import com.kosta.controller.KostagramExample;
import com.kosta.dao.PostDAO;
import com.kosta.dao.UserDAO;
import com.kosta.model.Post;
import com.kosta.model.User;

public class PostService {
	// 게시글 DAO 인스턴스 생성
	private PostDAO postDAO = new PostDAO();
	private UserDAO userDAO = new UserDAO();

	// 콘솔에서 값을 입력받는 메소드
	private String getInput(String name, boolean isRequire) {
		System.out.print(name + " 입력 : ");
		String input = KostagramExample.sc.nextLine();

		// 필수값인 경우에는 무조건 입력해야 하고, 아니면 그냥 엔터 치고 넘어가도 된다.
		if (input.equals("") && isRequire == false) {
			input = null;
		} else {
			while (input.equals("") && isRequire == true) {
				input = getInput(name, isRequire);
			}
		}
		return input;
	}

	// 게시글 작성
	public void writePost() throws Exception {
		// 1. userList를 통해 전체 userList 출력
		List<User> userList = userDAO.getUserList();
		System.out.println("ID\t이름");
		for (User user : userList) {
			System.out.println(user.getId() + "\t" + user.getName());
		}

		// 2. 작성할 user 선택
		System.out.println("이 중에 당신은 누구입니까?");
		int user_id = Integer.parseInt(getInput("당신의 아이디", true)); // 내 아이디 입력
		User user = userDAO.getUser(user_id); // 해당 user 찾기

		if (user == null) {
			System.out.println("존재하지 않는 사용자입니다.");
			return;
		}

		// 3. 작성할 content, image 입력받기
		System.out.println("-----" + user.getName() + " 이/가 게시글 작성을 시작합니다. -----");
		String content = getInput("게시글 내용", false); // 선택값 (없어도 게시글 작성 가능하도록 설정)
		String image = getInput("게시글 이미지 파일명", true); // 필수 입력값

		// 4. DB에 저장
		Post newPost = new Post(0, user.getId(), content, image, null, null, null);
		int resultRow = postDAO.addPost(newPost);
		if (resultRow > 0) {
			System.out.println("게시글 작성 완료");
		} else {
			System.out.println("게시글 작성 실패");
		}
	}

	// 게시글 전체 목록 출력
	public void printAllPosts() throws Exception {
		System.out.println("\n ---------- 전체 게시물 출력 ----------");

		// DB에서 전체 게시글을 가져오기
		List<Post> postList = postDAO.getPostList();

		// user name과 content, image 출력
		System.out.println("ID \t 작성자 \t content \t image");
		for (Post post : postList) {
			User writer = userDAO.getUser(post.getUser_id());
			String writerName = writer == null ? "탈퇴한 사용자" : writer.getName();
			String content = post.getContent() == null ? "내용 없음" : post.getContent();
			System.out.println(post.getId() + "\t" + writerName + "\t" + content + "\t" + post.getImage());
		}

	}

	// 게시글 수정
	public void updatePost() throws Exception {
		// 1. 게시물List 출력
		printAllPosts();

		// 2. 수정할 게시물의 id 선택
		System.out.println("이 중에 어떤 게시물을 수정하시겠습니까?");
		int id = Integer.parseInt(getInput("수정할 게시물", true)); // 수정할 게시물 id 입력
		Post post = postDAO.getPost(id);

		if (post == null) {
			System.out.println("없는 게시물입니다.");
			return;
		}

		// 3. 게시물 수정 (content, image 자유롭게 수정 가능)
		System.out.println("----- " + post.getId() + " 수정을 시작합니다.");
		String updateContent = getInput("게시글 수정", false) == null ? post.getContent() : getInput("게시글 수정", false);
		String updateImage = getInput("이미지 파일명 수정", false) == null ? post.getImage() : getInput("이미지 파일명 수정", false);

		// 4. DB에 수정된 게시물 업데이트
		Post updatedPost = new Post(post.getId(), post.getUser_id(), updateContent, updateImage, post.getCreated_at(),
				post.getUpdate_at(), post.getDeleted_at());
		int resultRow = postDAO.updatePost(updatedPost);
		if (resultRow > 0) {
			System.out.println("게시글 수정 완료");
		} else {
			System.out.println("게시글 수정 실패");
		}
	}

	// 게시글 삭제
	public void deletePost() throws Exception {
		// 1. 게시물List 출력
		printAllPosts();

		// 2. 삭제할 게시물의 id 선택
		System.out.println("이 중에 어떤 게시물을 삭제하시겠습니까?");
		int id = Integer.parseInt(getInput("수정할 게시물", true)); // 삭제할 게시물 id 입력
		Post post = postDAO.getPost(id);

		// 3. 게시물 삭제 (deleted_at을 now()로 변경)
		if (post != null) {
			System.out.println(post.getId() + " 을/를 정말 삭제하시겠습니까? (Y/N)");

			String answer = KostagramExample.sc.nextLine().toUpperCase();

			if (answer.equals("Y")) {
				// 4. DB에 삭제된 게시물 업데이트
				int resultRow = postDAO.deletePost(id);
				if (resultRow > 0) {
					System.out.println("게시글 삭제 완료");
				} else {
					System.out.println("게시글 삭제 실패");
				}
			} else
				return;
		} else {
			System.out.println("이미 삭제되었거나 존재하지 않는 게시물입니다.");
		}

	}

	// 게시글 좋아요 누르기
	public void likePost() throws Exception {
		// 1. 좋아요 누를 user 선택
		List<User> userList = userDAO.getUserList();
		System.out.println("ID \t 이름");
		for (User user : userList) {
			System.out.println(user.getId() + "\t" + user.getName());
		}

		System.out.println("이 중에 당신은 누구입니까?");
		int user_id = Integer.parseInt(getInput("당신의 아이디", true)); // 내 아이디 입력
		User user = userDAO.getUser(user_id); // 해당 user 찾기

		if (user == null) {
			System.out.println("존재하지 않는 사용자입니다.");
			return;
		}

		// 2. 게시물 List 출력
		printAllPosts();

		// 3. 좋아요 누를 post id 선택
		int post_id = Integer.parseInt(getInput("좋아요 누를 게시물", true)); // 좋아요 누를 게시물 id 입력
		Post post = postDAO.getPost(post_id);

		if (post == null) {
			System.out.println("없는 post입니다.");
		}

		int resultRow = postDAO.addLike(user_id, post_id);
		if (resultRow > 0) {
			System.out.println(user.getName() + " 님이 해당 게시글을 좋아합니다");
		}

	}

	// 게시글 좋아요 취소하기
	public void unlikePost() throws Exception {
		printAllPosts();
		// 1. 좋아요 취소할 user 선택
		List<User> userList = userDAO.getUserList();
		System.out.println("ID \t 이름");
		for (User user : userList) {
			System.out.println(user.getId() + "\t" + user.getName());
		}

		System.out.println("이 중에 당신은 누구입니까?");
		int user_id = Integer.parseInt(getInput("당신의 아이디", true)); // 내 아이디 입력
		User user = userDAO.getUser(user_id); // 해당 user 찾기

		if (user == null) {
			System.out.println("존재하지 않는 사용자입니다.");
			return;
		}

		// 2. 해당 사용자가 좋아요한 게시물 출력
		List<Post> likedPostList = postDAO.getLikedPostListByUser(user_id);
		System.out.println("ID \t 작성자 \t content \t image");
		for (Post post : likedPostList) {
			User writer = userDAO.getUser(post.getUser_id());
			String writerName = writer == null ? "탈퇴한 사용자" : writer.getName();
			String content = post.getContent() == null ? "내용 없음" : post.getContent();
			System.out.println(post.getId() + "\t" + writerName + "\t" + content + "\t" + post.getImage());
		}

		// 3. 좋아요 취소할 post id 선택
		int post_id = Integer.parseInt(getInput("좋아요 취소할 게시물", true)); // 좋아요 취소할 게시물 id 입력
		Post post = postDAO.getPost(post_id);

		if (post == null) {
			System.out.println("없는 post입니다.");
		}

		int resultRow = postDAO.deleteLike(user_id, post_id);
		if (resultRow > 0) {
			System.out.println(user.getName() + " 님이 해당 게시글 좋아요를 취소했습니다");

		}

	}

}
