package com.kosta.controller;

import java.sql.Connection;
import java.util.Scanner;

import com.kosta.service.UserService;
import com.kosta.util.DBConnection;

public class KostagramExample {
	// 입출력 받는 Scanner
	public static Scanner sc = new Scanner(System.in);
	// 무한 루프 boolean
	public static boolean isActive = true;
	// UserService 인스턴스 생성
	public static UserService us = new UserService();

	public static void main(String[] args) {

		// 데이터베이스 연결
		// try-with-resources 블록을 사용하는 것 -> 예외 발생 여부와 상관없이 리소스를 자동으로 닫아준다
		try (Connection conn = DBConnection.getConnection()) {

			// 무한 루프
			while (isActive) {
				// 메뉴 출력
				System.out.println("\n --------------- KOSTAGRAM MENU ---------------");
				System.out.println("1. 회원가입 | 2. 회원 탈퇴 | 3. 회원 전체 목록 | 4. 회원 팔로우 | 5. 회원 언팔로우 | 6. 종료");

				int num = sc.nextInt();

				switch (num) {
				case 1:
					us.signUpUser(); // 회원 가입
					break;
				case 2:
					us.withdrawalUser(); // 회원 탈퇴
					break;
				case 3:
					us.printAllusers(); // 회원 전체 목록
					break;
				case 4:
					us.followUser(); // 회원 팔로우
					break;
				case 5:
					us.unfollowUser(); // 회원 언팔로우
					break;
				case 6:
					isActive = false; // 종료
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sc != null)
				sc.close();
		}

	}

}
