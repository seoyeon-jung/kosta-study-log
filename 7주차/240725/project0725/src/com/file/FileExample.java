package com.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileExample {

	public static void main(String[] args) throws IOException {
		String dataPath = "C:\\Users\\WD\\data.txt";
		File file = new File(dataPath);

		if (file.createNewFile()) {
			System.out.println("파일이 생성되었습니다.");
		} else {
			System.out.println("이미 존재하는 파일입니다.");
		}

		System.out.println();
		System.out.println("파일 경로 : " + file.getAbsolutePath()); // 절대경로 출력
		System.out.println("쓰기 가능 여부 : " + file.canWrite());
		System.out.println("읽기 가능 여부 : " + file.canRead());
		System.out.println("파일 크기 : " + file.length() + "바이트");
		System.out.println();

		BufferedWriter bw = new BufferedWriter(new FileWriter(dataPath));
		bw.write("사건은 다가와 ah, ho, ayy");
		bw.newLine();
		bw.write("거세게 커져가 ah, oh, ayy");
		bw.newLine();
		bw.write("That tick, that tick, tick bomb");
		bw.newLine();
		bw.write("That tick, that tick, tick bomb");
		bw.newLine();
		bw.write("감히 건드리지 못할 걸 (누구도 말이야)");
		bw.newLine();
		bw.write("지금 내 안에선 su-su-su-supernova");
		bw.newLine();

		bw.close();

		System.out.println("파일 크기 : " + file.length() + "바이트"); // 227바이트

	}

}
