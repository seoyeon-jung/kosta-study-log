package com.kosta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.kosta.model.User;
import com.kosta.util.DBConnection;

// DAO : Data Access Object (데이터베이스에 접근)
public class UserDAO {
	// 자주쓰는 SQL문 상수로 지정
	private static final String DEL_CHK = " AND deleted_at IS NULL";

	// DB에 유저를 추가하는 메소드 (=회원가입)
	public int addUser(User user) throws Exception {
		String sql = "INSERT INTO users (name, email, password, bio, profile_pic) VALUES (?, ?, ?, ?, ?)";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getBio());
			pstmt.setString(5, user.getProfile_pic());

			return pstmt.executeUpdate();
		}
	}

	// DB에서 user_id를 통해 해당 유저 정보를 가져오는 메소드
	public User getUser(int id) throws Exception {
		String sql = "SELECT * FROM users WHERE id = ?" + DEL_CHK;
		try (Connection conn = DBConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				return new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("password"),
						rs.getString("bio"), rs.getString("profile_pic"), rs.getDate("created_at"),
						rs.getDate("update_at"), rs.getDate("deleted_at"));
			}
		}
		return null;
	}

	// DB에서 선택한 user_id를 통해 해당 유저 삭제
	public int deleteUser(int user_id) throws Exception {
		String sql = "UPDATE users SET deleted_at = now() WHERE id = ?" + DEL_CHK;
		try (Connection conn = DBConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, user_id);
			return pstmt.executeUpdate();
		}

	}

	// DB에서 회원 전체 리스트 가져오기
	public List<User> getUserList() throws Exception {
		String sql = "SELECT * FROM users WHERE deleted_at IS NULL";
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {
			List<User> userList = new ArrayList<>();

			while (rs.next()) {
				User user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"),
						rs.getString("password"), rs.getString("bio"), rs.getString("profile_pic"),
						rs.getDate("created_at"), rs.getDate("update_at"), rs.getDate("deleted_at"));
				userList.add(user);
			}
			return userList;
		}
	}

	// DB에 팔로우 추가 (user_id가 target_id를 팔로우함)
	public static int addFollower(int user_id, int target_id) throws Exception {
		String sql = "INSERT INTO follows (following_id, followed_id) VALUES (?, ?) "
				+ "ON DUPLICATE KEY UPDATE deleted_at = NULL";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, user_id);
			pstmt.setInt(2, target_id);
			return pstmt.executeUpdate();
		}
	}

	// DB에서 user(위 user_id와 동일)가 팔로우하는 사용자 리스트 가져오기
	// (예) sy가 장원영을 팔로우합니다. => sy가 팔로우한 리스트 가져오기
	public List<User> getFollowers(int id) throws Exception {
		String sql = "SELECT ed.* FROM follows f JOIN users ing ON ing.id = f.following_id "
				+ "JOIN users ed ON ed.id = f.followed_id " + "WHERE ing.id = ? AND f.deleted_at IS null";

		try (Connection conn = DBConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			List<User> userList = new ArrayList<>();

			while (rs.next()) {
				User user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"),
						rs.getString("password"), rs.getString("bio"), rs.getString("profile_pic"),
						rs.getDate("created_at"), rs.getDate("update_at"), rs.getDate("deleted_at"));
				userList.add(user);
			}
			return userList;
		}
	}

	// DB에서 언팔로우했음을 추가 (user_d가 target_id를 언팔로우함)
	public static int deleteFollower(int user_id, int target_id) throws Exception {
		String sql = "UPDATE follows SET deleted_at = now() WHERE following_id = ? AND followed_id = ? " + DEL_CHK;
		try (Connection conn = DBConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, user_id);
			pstmt.setInt(2, target_id);
			return pstmt.executeUpdate();
		}
	}
}
