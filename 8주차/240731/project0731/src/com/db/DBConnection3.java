package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.model.User;

public class DBConnection3 {
	// static으로 선언하고, 필요한 때에 재할당해서 사용하면 된다.
	public static Connection connection = null;
	public static PreparedStatement pstmt = null;
	public static ResultSet rs = null;
	public static String sql;
	public static int resultRow;

	// 입력받기 위한 Scanner 생성
	public static Scanner sc = new Scanner(System.in);

	// 회원가입 (C)
	public static void addUser() throws SQLException {
		System.out.println("\n =============== 회원 가입 ===============");
		sql = "INSERT INTO users (name, email, password) VALUES(?, ?, ?)";

		String[] userInfo = new String[3];
		System.out.print("name : ");
		userInfo[0] = sc.nextLine();
		System.out.print("email : ");
		userInfo[1] = sc.nextLine();
		System.out.print("password : ");
		userInfo[2] = sc.nextLine();

		pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, userInfo[0]);
		pstmt.setString(2, userInfo[1]);
		pstmt.setString(3, userInfo[2]);

		resultRow = pstmt.executeUpdate();
		System.out.println(resultRow + "개의 회원 정보가 추가되었습니다.");
	}

	// 회원 전체 조회 (R)
	public static List<User> getAllUsers() throws SQLException {
		System.out.println("\n =============== 회원 전체 조회 ===============");
		// 탈퇴한 회원은 전체 회원에 포함되지 않으므로 WHERE문을 추가해야 한다.
		sql = "SELECT * FROM users WHERE deleted_at IS NULL"; // sql에 재할당
		rs = connection.prepareStatement(sql).executeQuery();

		// userList를 만들어서 그 리스트 안에 전체 회원들 데이터를 넣는다.
		List<User> userList = new ArrayList<>();
		while (rs.next()) {
			User u = new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("password"));
			userList.add(u);
		}
		return userList;

	}

	// 게시물 등록 (C)
	public static void addPost() throws SQLException {
		System.out.println("\n =============== 게시물 등록 ===============");
		// 탈퇴한 회원의 id를 입력하지 못하도록 조건 추가
		pstmt = connection.prepareStatement("SELECT name FROM users WHERE id = ? AND deleted_at is null");
		System.out.print("글을 작성할 작성자 ID 입력하기: ");
		int user_id = sc.nextInt();
		sc.nextLine();

		pstmt.setInt(1, user_id);
		rs = pstmt.executeQuery();

		if (rs.next()) {
			// 사용자가 존재하는 경우
			sql = "INSERT INTO posts (user_id, content, image) VALUES (?, ?, ?)";
			pstmt = connection.prepareStatement(sql);

			System.out.print("작성할 내용: ");
			String newContent = sc.nextLine();
			System.out.print("이미지 파일명: ");
			String newImage = sc.next();

			pstmt.setInt(1, user_id);
			pstmt.setString(2, newContent);
			pstmt.setString(3, newImage);

			resultRow = pstmt.executeUpdate();
			System.out.println(rs.getString("name") + "이/가 작성한 글 " + resultRow + "개가 게시판에 추가되었습니다.");

		} else {
			System.out.println("탈퇴하였거나 없는 사용자 아이디입니다.");
		}
	}

	// 게시물 전체 보기 (R)
	public static void getAllPosts() throws SQLException {
		System.out.println("\n =============== 게시물 전체 보기 ===============");
		sql = "SELECT * FROM posts WHERE deleted_at IS NULL";

		pstmt = connection.prepareStatement(sql);
		rs = pstmt.executeQuery();

		System.out.println("id \t user_id \t content \t image \t created \t updated");

		while (rs.next()) {
			System.out.println(rs.getInt(1) + " \t " + rs.getInt(2) + " \t " + rs.getString(3) + " \t "
					+ rs.getString(4) + " \t " + rs.getDate(5) + " \t " + rs.getDate(6));
		}
	}

	// 게시글 수정 (U)
	public static void modifyPost() throws SQLException {
		System.out.println("\n =============== 게시물 수정 ===============");
		sql = "UPDATE posts SET content = ? WHERE id = ? AND deleted_at IS NULL";

		System.out.print("수정할 게시물 id : ");
		int updateID = sc.nextInt();
		sc.nextLine();
		System.out.print("새로 작성할 글 내용 : ");
		String updateContent = sc.nextLine();

		pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, updateContent);
		pstmt.setInt(2, updateID);

		resultRow = pstmt.executeUpdate();
		System.out.println(resultRow + "개의 게시물이 수정되었습니다.");
	}

	// 특정 게시물 보기 (R)
	public static void getPost() throws SQLException {
		System.out.println("\n =============== 특정 게시물 조회 ===============");

		sql = "SELECT * FROM posts WHERE id = ? AND deleted_at IS NULL";
		System.out.print("확인할 게시물 ID 입력하기 : ");
		int postID = sc.nextInt();
		sc.nextLine();

		pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, postID);
		rs = pstmt.executeQuery();

		if (rs.next()) {
			System.out.println(rs.getInt(1) + "\t" + rs.getInt(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4)
					+ "\t" + rs.getDate(5) + "\t" + rs.getDate(6));
		}

	}

	// 게시물 삭제 (D)
	public static void deletePost() throws SQLException {
		System.out.println("\n =============== 특정 게시물 삭제 ===============");
		// delete가 아니라 update로 상태를 '삭제 상태'로 변경해주면 된다.
		sql = "UPDATE posts SET deleted_at = now() WHERE id = ? AND deleted_at IS NULL";

		System.out.print("삭제할 게시물 id: ");
		int deleteID = sc.nextInt();
		sc.nextLine();

		pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, deleteID);

		resultRow = pstmt.executeUpdate();
		System.out.println(resultRow + "개의 게시물이 삭제되었습니다.");
	}

	public static void main(String[] args) {

		try {
			// 드라이버 생성
			Class.forName("com.mysql.cj.jdbc.Driver");

			// DB 연결
			String url = "jdbc:mysql://localhost:3306/kostagram";
			String root = "root";
			String pw = "1234";
			connection = DriverManager.getConnection(url, root, pw);

			boolean action = true;

			while (action) {
				System.out.println("1. 회원가입 | 2. 회원조회 | 3. 게시글 조회 | 4. 게시물 등록 | 5. 종료");
				int num = sc.nextInt();
				sc.nextLine();

				switch (num) {
				case 1:
					addUser();
					break;
				case 2:
					// 회원들의 이름만 출력할 수 있다.
					List<User> allUsers = getAllUsers();
					allUsers.stream().forEach(u -> System.out.println(u.getName()));
					break;
				case 3: {
					getAllPosts();
					System.out.println("1. 특정 게시물 보기 | 2. 게시물 수정 | 3. 게시물 삭제");
					int num2 = sc.nextInt();
					sc.nextLine();

					if (num2 == 1) {
						getPost();
					} else if (num2 == 2) {
						modifyPost();
					} else if (num2 == 3) {
						deletePost();
					}
					break;
				}
				case 4:
					addPost();
					break;
				default:
					action = false;
				}
			}

		}
//		catch (InputMismatchException e) {
//			System.out.println("잘못된 접근입니다. 숫자를 입력하세요.");
//			// 바로 프로그램이 종료된다.
//		} 
		catch (ClassNotFoundException e) {
			// JDBC 드라이버 로딩 실패
			e.printStackTrace();
			System.out.println("JDBC Driver 로딩 실패");
		} catch (SQLException e) {
			// 연결 실패
			e.printStackTrace();
			System.out.println("DB 연결 실패");
		} finally {
			// DB 연결 끊기
			try {
				if (sc != null) {
					sc.close();
				}
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				System.out.println("객체 종료 실패");
			}
		}

	}
}
