package com.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerExample {
	public static ServerSocket ss = null;

	public static void main(String[] args) {
		System.out.println("서버를 종료하려면 q를 입력하세요.");

		// 서버 시작
		startServer();

		Scanner sc = new Scanner(System.in);

		// 서버니까 무한 루프로 안 꺼지도록
		while (true) {
			if (sc.nextLine().toLowerCase().equals("q")) {
				break;
			}
		}

		sc.close();

		// 서버 종료
		stopServer();
	}

	private static void startServer() {
		// thread 선언
		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					ss = new ServerSocket(8080);
					System.out.println("[서버] 서버 시작");

					// 무한반복
					while (true) {
						System.out.println("[서버] 요청 기다리는 중...");

						// 클라이언트 요청
						Socket s = ss.accept();
						// 들어온 요청 확인
						InetSocketAddress isa = (InetSocketAddress) s.getRemoteSocketAddress();
						String clientIP = isa.getHostString(); // 클라이언트 IP
						System.out.println("[서버] " + clientIP + "와의 연결 오청 수락");

						// 연결 종료
						s.close();
						System.out.println("[서버] " + clientIP + "와의 연결 정료");
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};

		// thread 시작
		thread.start();
	}

	private static void stopServer() {
		try {
			ss.close();
			System.out.println("[서버] 종료");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
