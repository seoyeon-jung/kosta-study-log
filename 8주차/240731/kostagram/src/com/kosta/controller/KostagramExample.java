package com.kosta.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.kosta.service.PostService;
import com.kosta.service.PostServiceImpl;
import com.kosta.service.UserService;
import com.kosta.service.UserServiceImpl;

public class KostagramExample {
	public static Scanner sc = new Scanner(System.in);
	public static Connection conn = null;
	public static PreparedStatement pstmt = null;
	public static ResultSet rs = null;
	public static boolean isActive = true;

	private static UserService us = new UserServiceImpl();
	private static PostService ps = new PostServiceImpl();

	public static void main(String[] args) {
		// 드라이버 생성
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// DB 연결
			String url = "jdbc:mysql://localhost:3306/kostagram";
			String root = "root";
			String pw = "1234";
			conn = DriverManager.getConnection(url, root, pw);

			while (isActive)
				switchMenu();
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
				if (sc != null) {
					sc.close();
				}
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("객체 종료 실패");
			}
		}

	}

	// 사용자 메인 메뉴
	public static int mainMenu() {
		System.out.println("1. 회원 관리 | 2. 게시물 관리 | 3. 프로그램 종료");
		int num = sc.nextInt();
		sc.nextLine();

		return num;
	}

	// 회원 관리 선택 시 user 관련 메뉴
	public static int userMenu() {
		System.out.println("1. 회원 가입 | 2. 팔로우하기 | 3. 언팔로우하기 | 4. 팔로우 리스트 | 5. 회원 탈퇴");
		int num = sc.nextInt();
		sc.nextLine();

		return num;
	}

	// 게시물 관리 선택 시 post 관련 메뉴
	public static int postMenu() {
		System.out.println("1. 전체 게시물 | 2. 게시물 등록");
		int num = sc.nextInt();
		sc.nextLine();

		return num;
	}

	// 게시물 관리 > 전체 게시물 선택 시 post 관련 세부 메뉴
	public static int postSubMenu() {
		System.out.println("1. 게시물 좋아요 | 2. 게시물 좋아요 취소 | 3. 게시물 수정 | 4. 게시물 삭제");
		int num = sc.nextInt();
		sc.nextLine();

		return num;
	}

	// 메인 메뉴 switch문
	public static void switchMenu() throws SQLException {
		switch (mainMenu()) {
		case 1:
			switchUserMenu();
			break;
		case 2:
			switchPostMenu();
			break;
		default:
			exit();
		}
	}

	// case 1번 (회원 관리 선택 시 switch문)
	public static void switchUserMenu() throws SQLException {
		switch (userMenu()) {
		case 1:
			us.addUser();
			break;
		case 2:
			System.out.println("팔로우");
			break;
		case 3:
			System.out.println("팔로우 취소");
			break;
		case 4:
			System.out.println("팔로우 리스트");
			break;
		case 5:
			System.out.println("회원 탈퇴");
			break;
		}
	}

	// case 2번 (게시물 관리 선택 시 switch문)
	public static void switchPostMenu() throws SQLException {
		switch (postMenu()) {
		case 1:
			ps.getPostList();
			switchPostSubMenu();
			break;
		case 2:
			System.out.println("게시물 등록");
			break;
		}
	}

	// case 2번 > 1번 (전체 게시물 클릭 시 switch문)
	public static void switchPostSubMenu() {
		switch (postSubMenu()) {
		case 1:
			System.out.println("게시물 좋아요");
			break;
		case 2:
			System.out.println("게시물 좋아요 취소");
			break;
		case 3:
			System.out.println("게시물 수정");
			break;
		case 4:
			System.out.println("게시물 삭제");
			break;
		}
	}

	// 프로그램 종료
	public static void exit() {
		isActive = false;
	}

}
