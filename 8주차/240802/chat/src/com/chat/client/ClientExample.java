package com.chat.client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientExample {
	public static void main(String[] args) {
		try {
			Socket s = new Socket("localhost", 8080);
			System.out.println("[클라이언트] 연결 성공");

			// 메세지 입력
			Scanner sc = new Scanner(System.in);
			System.out.print("메세지 입력 : ");
			String msg = sc.nextLine();

			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			dos.writeUTF(msg);
			dos.flush();

			sc.close();

			s.close();
			System.out.println("[클라이언트] 연결 종료");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}