package com.kosta.service;

import java.sql.SQLException;

import com.kosta.controller.KostagramExample;
import com.kosta.model.User;

public class UserServiceImpl implements UserService {
	@Override
	public void getuser(int id) throws SQLException {
		String sql = "SELECT * FROM users WHERE id = ? AND deleted_at IS NULL";

		KostagramExample.pstmt = KostagramExample.conn.prepareStatement(sql);
		KostagramExample.pstmt.setInt(1, id);

		KostagramExample.rs = KostagramExample.pstmt.executeQuery();

		User u = null;
		if (KostagramExample.rs.next()) {
			u = new User(id, KostagramExample.rs.getString("name"), KostagramExample.rs.getString("email"),
					KostagramExample.rs.getString("password"), KostagramExample.rs.getString("bio"),
					KostagramExample.rs.getString("profile_pic"), null, null, null);
		}

	}

	@Override
	public User getUser(int user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addUser() throws SQLException {
		System.out.println("\n =============== 회원 가입 ===============");
		String sql = "INSERT INTO users (name, email, password, bio, profile_pic) VALUES (?, ?, ?, ?, ?)";

		System.out.print("이름 입력: ");
		String name = KostagramExample.sc.nextLine();
		System.out.print("이메일 입력: ");
		String email = KostagramExample.sc.nextLine();
		System.out.print("비밀번호 입력: ");
		String password = KostagramExample.sc.nextLine();
		System.out.print("소개글 입력: ");
		String bio = KostagramExample.sc.nextLine();
		bio = bio.equals("") ? null : bio; // bio가 비어있으면 null로 저장되도록 null값 처리
		System.out.print("프로필 파일명 입력: ");
		String profile_pic = KostagramExample.sc.nextLine();
		profile_pic = profile_pic.equals("") ? null : profile_pic; // profile_pic도 마찬가지

		KostagramExample.pstmt = KostagramExample.conn.prepareStatement(sql);
		KostagramExample.pstmt.setString(1, name);
		KostagramExample.pstmt.setString(2, email);
		KostagramExample.pstmt.setString(3, password);
		KostagramExample.pstmt.setString(4, bio);
		KostagramExample.pstmt.setString(5, profile_pic);

		int resultRow = KostagramExample.pstmt.executeUpdate();
		if (resultRow != 0) {
			System.out.println(resultRow + "명의 회원이 새로 가입했습니다.");
		} else {
			System.out.println("회원가입에 실패했습니다.");
		}
	}

	@Override
	public void delUser() {
		System.out.println("\n =============== 회원 탈퇴 ===============");

	}

	@Override
	public void addFollow() {
		System.out.println("\n =============== 팔로우 하기 ===============");

	}

	@Override
	public void delFollow() {
		System.out.println("\n =============== 언팔로우 하기 ===============");

	}

	@Override
	public void getFollowList() {
		System.out.println("\n =============== 팔로우 리스트 ===============");

	}

}
