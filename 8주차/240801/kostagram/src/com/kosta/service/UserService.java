package com.kosta.service;

import java.util.List;

import com.kosta.controller.KostagramExample;
import com.kosta.dao.UserDAO;
import com.kosta.model.User;

// Service : 비지니스 로직 수행
public class UserService {
	// UserDAO 인스턴스 생성
	private UserDAO userDAO = new UserDAO();

	// 콘솔에서 값을 입력 받는 메소드
	// 매개변수로 필수값인지 선택값인지 boolean 추가
	private String getInput(String name, boolean isRequire) {
		System.out.print(name + " 입력 : ");
		String input = KostagramExample.sc.nextLine();

		// 소개글, 프로필 사진은 입력하지 않아도 null로 초기화되도록 제한하기 (소개글, 프로필은 선택값)
		if (input.equals("") && isRequire == false) {
			input = null;
		}
		// 필수값을 입력하지 않고 엔터를 누른 경우 다시 필수값을 입력하게 돌아가야 한다.
		else {
			while (input.equals("") && isRequire == true) {
				input = getInput(name, isRequire);
			}
		}
		return input;
	}

	// 유저 정보 가져오기
	private User getUser(int id) throws Exception {
		User user = userDAO.getUser(id);
		return user;
	}

	// 회원 가입
	public void signUpUser() throws Exception {
		System.out.println("\n ---------- 회원가입을 진행합니다 ----------");
		String name = getInput("이름", true);
		String email = getInput("이메일", true);
		String password = getInput("비밀번호", true);
		String bio = getInput("소개글", false);
		String profile = getInput("프로필 사진 파일명", false);

		// DB에 저장
		// user 객체 생성해서 addUser에 추가
		User newUser = new User(0, name, email, password, bio, profile, null, null, null);
		// 데이터 삽입 동작 수행
		int resultRow = userDAO.addUser(newUser);
		// 결과 출력
		if (resultRow > 0) {
			System.out.println("회원 가입 성공");
		} else {
			System.out.println("회원 가입 실패");
		}
	}

	// 회원 탈퇴
	public void withdrawalUser() throws Exception {
		System.out.println("\n ---------- 회원 탈퇴를 진행합니다 ----------");
		int user_id = Integer.parseInt(getInput("사용자 아이디", true));

		// user_id를 통한 유저 정보를 가져오기
		User user = getUser(user_id);
		if (user != null) {
			System.out.println(user.getName() + " 을/를 정말 삭제하시겠습니까? (Y/N)");
			String answer = KostagramExample.sc.nextLine().toUpperCase();

			if (answer.equals("Y")) {
				// 데이터 삭제 수행 (UserDAO에서 delteUser 실행)
				int resultRow = userDAO.deleteUser(user_id);
				if (resultRow > 0) {
					System.out.println("정상적으로 탈퇴되었습니다.");
					return;
				}
			} else
				return;
		}
		System.out.println("이미 탈퇴되었거나 없는 사용자입니다.");
	}

	// 회원 전체 목록 가져오기
	public void printAllusers() throws Exception {
		System.out.println("\n ---------- 회원 전체를 출력합니다 ----------");

		// DB에서 회원 전체 목록을 리스트로 가져오기
		List<User> userList = userDAO.getUserList();

		// id와 이름을 출력
		System.out.println("ID \t 이름");
		for (User user : userList) {
			System.out.println(user.getId() + "\t" + user.getName());
		}
	}

	// 팔로우하기
	public void followUser() throws Exception {
		// 1. 회원 전체 목록 출력
		printAllusers();

		// 2. '나'를 지정 (로그인 기능이 없으므로)
		System.out.println("이 중에 당신은 누구입니까?");
		int user_id = Integer.parseInt(getInput("당신의 아이디", true)); // 내 아이디 입력
		User user = getUser(user_id); // 해당 user 찾기

		// 3. 팔로우할 사람 지정
		System.out.println("\n ----------" + user.getName() + " 이/가 팔로우를 진행합니다 ----------");
		System.out.println("누구를 팔로우하시겠습니까?");
		int target_id = Integer.parseInt(getInput("팔로우할 아이디", true));
		User target = getUser(target_id); // 팔로우할 user 찾기

		// 만약 user_id와 target_id가 동일한 경우 팔로우 불가능
		if (user_id == target_id) {
			System.out.println("자기 자신을 팔로우할 수 없습니다.");
		} else {
			// 4. 팔로우하기 (DB에서 user_id가 target_id를 팔로우했음을 업데이트하기)
			int resultRow = UserDAO.addFollower(user_id, target_id);
			if (resultRow > 0) {
				// 팔로우했음을 출력
				System.out.println(user.getName() + " 이/가 " + target.getName() + " 을/를 팔로우했습니다.");

				// user의 팔로우 리스트 출력
				System.out.println("\n ----------" + user.getName() + " 이/가 팔로우하는 회원 전체를 출력합니다 ----------");
				printAllFollowers(user_id);
			}
		}

	}

	// 선택한 user의 팔로우 리스트 출력
	public void printAllFollowers(int id) throws Exception {
		List<User> userList = userDAO.getFollowers(id);

		// id와 이름을 출력
		System.out.println("ID \t 이름");
		for (User user : userList) {
			System.out.println(user.getId() + "\t" + user.getName());
		}
	}

	// 언팔로우 하기
	public void unfollowUser() throws Exception {
		// 1. 회원 전체 목록 출력
		printAllusers();

		// 2. '나'를 지정 (로그인 기능이 없으므로)
		System.out.println("이 중에 당신은 누구입니까?");
		int user_id = Integer.parseInt(getInput("당신의 아이디", true)); // 내 아이디 입력
		User user = getUser(user_id); // 해당 user 찾기

		// 3. 언팔로우할 사람 지정
		// user의 현재 팔로우 리스트 출력 (-> 언팔로우할 사람의 id를 입력할 수 있도록)
		System.out.println("\n ----------" + user.getName() + " 이/가 팔로우하는 회원 전체를 출력합니다 ----------");
		printAllFollowers(user_id);

		System.out.println("\n ----------" + user.getName() + " 이/가 언팔로우를 진행합니다 ----------");
		System.out.println("누구를 언팔로우하시겠습니까?");
		int target_id = Integer.parseInt(getInput("언팔로우할 아이디", true));
		User target = getUser(target_id); // 언팔로우할 user 찾기

		// 4. 언팔로우하기 (DB에서 user_id가 target_id를 언팔로우했음을 업데이트하기)
		int resultRow = UserDAO.deleteFollower(user_id, target_id);
		if (resultRow > 0) {
			// 언팔로우했음을 출력
			System.out.println(user.getName() + " 이/가 " + target.getName() + " 을/를 언팔로우했습니다.");

		}

	}
}
