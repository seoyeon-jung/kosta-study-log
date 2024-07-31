package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DBConnection {
	private static Connection conn = null; // DB 연결 객체

	public static void main(String[] args) {
		try {
			// 1. JDBC 드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2. DB 연결
			String url = "jdbc:mysql://localhost:3306/kostagram";
			String user = "root";
			String password = "1234";
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("DB 연결 성공");

			Scanner sc = new Scanner(System.in);

			// 로그인하기
//			Scanner sc = new Scanner(System.in);
//			System.out.print("이메일 입력 : ");
//			String userEmail = sc.nextLine();
//			System.out.print("비밀번호 입력 : ");
//			String userPassword = sc.nextLine();
//			sc.close();
//			
//			String sql = "SELECT * FROM users WHERE email = ? and password = ?";
//			PreparedStatement pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, userEmail);
//			pstmt.setString(2, userPassword);
//			ResultSet rs = pstmt.executeQuery();
//			
//			if (rs.next()) {
//				System.out.println("로그인 성공");
//			} else {
//				System.out.println("로그인 실패");
//			}

			// 회원가입 하기
//			String insertsql = "INSERT INTO users (name, email, password) VALUES(?, ?, ?)";
//			PreparedStatement pstmt = conn.prepareStatement(insertsql);
//			
//			Scanner sc = new Scanner(System.in);
//			System.out.print("name : ");
//			String userName = sc.nextLine();
//			System.out.print("email : ");
//			String userEmail = sc.nextLine();
//			System.out.print("password : ");
//			String userPassword = sc.nextLine();
//			
//			pstmt.setString(1, userName);
//			pstmt.setString(2, userEmail);
//			pstmt.setString(3, userPassword);
//			
//			int insertedRow = pstmt.executeUpdate(); // 입력받은 값들로 한 줄 추가 (추가 개수 출력 가능함)
//			System.out.println(insertedRow + "개의 최원 정보가 추가되었습니다.");
//			
//			sc.close();
//			pstmt.close(); // pstmt 사용했으므로 종료시키기

//			// 글쓰기
//			// 1. 사용자 아이디 번호 입력 받기
//			Scanner sc = new Scanner(System.in);
//			System.out.print("사용자 아이디 번호 : ");
//			int user_id = sc.nextInt();
//
//			// 2. 사용자 아이디 번호를 통한 사용자 이름 조회
//			PreparedStatement nameStmt = conn.prepareStatement("SELECT name FROM users WHERE id = ?");
//			nameStmt.setInt(1, user_id);
//			ResultSet rs = nameStmt.executeQuery();
//
//			// 3. 아이디가 존재하는 경우 해당 블록 생성 (글쓰기)
//			if (rs.next()) {
//				// 3-1. 사용자 이름 가져오기
//				String userName = rs.getString("name");
//
//				// 3-2.게시물 작성
//				String sql = "INSERT INTO posts (user_id, content, image) VALUES (?, ?, ?)";
//				PreparedStatement postStmt = conn.prepareStatement(sql);
//
//				// 3-3. 게시글 내용, 이미지 파일명 입력 받기
//				System.out.print("게시글 내용 : ");
//				String postContent = sc.next();
//				System.out.print("이미지 파일명 : ");
//				String postImage = sc.next();
//
//				// 3-4. ? 파라미터에 입력 값 대입
//				postStmt.setInt(1, user_id); // user_id를 입력받아 글을 작성할 수 있다.
//				postStmt.setString(2, postContent);
//				postStmt.setString(3, postImage);
//
//				// 3-5. INSERT 실행 및 결과 출력
//				int insertRow = postStmt.executeUpdate();
//				System.out.println(userName + "이 작성한 " + insertRow + "개의 글이 작성되었습니다.");
//
//				// 3-6. 리소스 종료
//				postStmt.close();
//			} else {
//				// 4. 사용자 이름이 조회되지 않는 경우
//				System.out.println("해당 아이디가 존재하지 않습니다.");
//			}
//
//			// 5. 리소스 종료
//			sc.close();
//			nameStmt.close();

//			// 특정 게시글 수정하기
//			// 1. 특정 게시물 내용을 수정하기 위한 SQL문 생성
//			String updateSQL = "UPDATE posts SET content = ? WHERE id = ?"; // id = 게시글 ㅑd
//			// 2. SQL문을 이용해 PreparedStatement 생성
//			PreparedStatement updateStmt = conn.prepareStatement(updateSQL);
//
//			// 3. 입력을 통해 수정 내용과 게시물 번호 받아오기
//			System.out.print("수정할 게시글 번호 : ");
//			int post_id = sc.nextInt();
//			System.out.print("수정할 내용 : ");
//			String content = sc.nextLine();
//
//			// 4. ? 파라미터에 값 대입
//			updateStmt.setString(1, content);
//			updateStmt.setInt(2, post_id);
//
//			// 5. update 실행 및 결과 출력
//			int updatedRow = updateStmt.executeUpdate();
//			System.out.println("게시물 " + updatedRow + "개가 수정되었습니다.");
//
//			// 6. 리소스 종료
//			sc.close();
//			updateStmt.close();

//			// 특정 게시물 삭제하기
//			// 1. SQL문 작성
//			String deleteSql = "DELETE FROM posts WHERE id = ?";
//
//			// 2. 입력을 통해 수정할 게시물 번호 받아오기
//			System.out.print("삭제할 게시글 번호 : ");
//			int post_id = sc.nextInt();
//
//			// 3. PreparedStatement 생성
//			PreparedStatement deleteStmt = conn.prepareStatement(deleteSql);
//
//			// 4. ? 파라미터에 값 대입
//			deleteStmt.setInt(1, post_id);
//
//			// 5. delete 실행 및 결과 출력
//			int deleteRow = deleteStmt.executeUpdate();
//			System.out.println(deleteRow + "개가 삭제되었습니다.");
//
//			// 6. 리소스 종료
//			sc.close();
//			deleteStmt.close();

			// 전체 회원 조회
			// 1. SQL문 작성
			String allUserSql = "SELECT * FROM users";
			// ? 안 붙는 경우 statement, preparestatement 둘다 쓸 수 있음

			// 2. prepareStatement를 통해 실행
			PreparedStatement userStmt = conn.prepareStatement(allUserSql);
			ResultSet rs = userStmt.executeQuery();

			// 위의 두 줄과 동일한 한 줄 (같은 동작을 한다)
			// ResultSet rs = conn.prepareStatement(allUserSql).executeQuery();

			// 3. 반복자 돌려서 존재함 다음 열을 출력 (결과가 여러개인 경우 while문 사용해서 출력)
			while (rs.next()) {
				System.out.println("-------------------------");
				System.out.println(rs.getInt("id"));
				System.out.println(rs.getString("name")); // column 이름이 name인 데이터를 출력
				System.out.println(rs.getString("email"));
				System.out.println(rs.getString("password"));
				System.out.println("-------------------------");
			}
			rs.close();

			sc.close();

		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 클래스 찾을 수 없음");
		} catch (SQLException e) {
			System.out.println("DB 연결 실패");
		} finally {
			// 3. DB 연결 끊기
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println("conn 객체 종료 실패");
				}
			}
		}

	}

}
