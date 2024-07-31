package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DBConnection2 {
	public static Connection connection = null;
	public static PreparedStatement pstmt = null;
	public static ResultSet rs = null;

	public static void main(String[] args) {

		try {
			// 드라이버 생성
			Class.forName("com.mysql.cj.jdbc.Driver");

			// DB 연결
			String url = "jdbc:mysql://localhost:3306/kostagram";
			String root = "root";
			String pw = "1234";
			connection = DriverManager.getConnection(url, root, pw);
			// System.out.println("DB 연결 성공");

			// 입력받기 위한 Scanner 생성
			Scanner sc = new Scanner(System.in);

			// 회원가입 (C)
			String joinSQL = "INSERT INTO users (name, email, password) VALUES(?, ?, ?)";
			PreparedStatement joinPstmt = connection.prepareStatement(joinSQL);

			System.out.print("name : ");
			String newName = sc.nextLine();
			System.out.print("email : ");
			String newEmail = sc.nextLine();
			System.out.print("password : ");
			String newPW = sc.nextLine();

			joinPstmt.setString(1, newName);
			joinPstmt.setString(2, newEmail);
			joinPstmt.setString(3, newPW);

			int joinRow = joinPstmt.executeUpdate();
			System.out.println(joinRow + "개의 회원 정보가 추가되었습니다.");

			joinPstmt.close();

			// 회원 전체 확인 (R)
			String readUsersSQL = "SELECT * FROM users";
			ResultSet users = connection.prepareStatement(readUsersSQL).executeQuery();

			while (users.next()) {
				System.out.println("=====".repeat(4));
				System.out.println(users.getString("name"));
				System.out.println(users.getString("email"));
				System.out.println("=====".repeat(4));
			}
			users.close();

			// 게시물 등록 (C)
			System.out.print("글을 작성할 작성자 ID 입력하기: ");
			int userID = sc.nextInt();

			PreparedStatement nameStmt = connection.prepareStatement("SELECT name FROM users WHERE id = ?");
			nameStmt.setInt(1, userID);
			ResultSet getID = nameStmt.executeQuery();

			if (getID.next()) {
				String userName = getID.getString("name");

				String newPostSQL = "INSERT INTO posts (user_id, content, image) VALUES (?, ?, ?)";
				PreparedStatement newPostStmt = connection.prepareStatement(newPostSQL);

				System.out.print("작성할 내용: ");
				String newContent = sc.nextLine();
				System.out.print("이미지 파일명: ");
				String newImage = sc.next();

				newPostStmt.setInt(1, userID);
				newPostStmt.setString(2, newContent);
				newPostStmt.setString(3, newImage);

				int newPostRow = newPostStmt.executeUpdate();
				System.out.println(userName + "이 작성한 글 " + newPostRow + "개가 게시판에 추가되었습니다.");

				newPostStmt.close();
			} else {
				System.out.println("User를 찾을 수 없습니다");
			}
			nameStmt.close();

			// 게시글 수정 (U)
			String updateSQL = "UPDATE posts SET content = ? WHERE id = ?";
			PreparedStatement updateStmt = connection.prepareStatement(updateSQL);

			System.out.print("수정할 게시물 id : ");
			int updateID = sc.nextInt();
			sc.nextLine();
			System.out.print("새로 작성할 글 내용 : ");
			String updateContent = sc.nextLine();

			updateStmt.setString(1, updateContent);
			updateStmt.setInt(2, updateID);

			int updatedRow = updateStmt.executeUpdate();
			System.out.println(updatedRow + "개의 게시물이 수정되었습니다.");

			updateStmt.close();

			// 특정 게시물 보기 (R)
			System.out.print("확인할 게시물 ID 입력하기 : ");
			int postID = sc.nextInt();
			sc.nextLine();

			String getPostSQL = "SELECT * FROM posts WHERE id = ?";
			PreparedStatement postStmt = connection.prepareStatement(getPostSQL);

			postStmt.setInt(1, postID);

			ResultSet post = postStmt.executeQuery();

			while (post.next()) {
				System.out.println("=====".repeat(4));
				System.out.println("content: " + post.getString("content"));
				System.out.println("image: " + post.getString("image"));
				System.out.println("=====".repeat(4));
			}
			postStmt.close();

			// 게시물 삭제 (D)
			String deleteSQL = "DELETE FROM posts WHERE id = ?";
			PreparedStatement deleteStmt = connection.prepareStatement(deleteSQL);

			System.out.print("삭제할 게시물 id: ");
			int deleteID = sc.nextInt();

			deleteStmt.setInt(1, deleteID);

			int deleteRow = deleteStmt.executeUpdate();
			System.out.println(deleteRow + "개의 게시물이 삭제되었습니다.");

			deleteStmt.close();

			// scanner 종료
			sc.close();

		} catch (ClassNotFoundException e) {
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
