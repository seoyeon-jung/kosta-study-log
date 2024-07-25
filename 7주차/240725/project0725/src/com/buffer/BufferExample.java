package com.buffer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class BufferExample {

	public static void main(String[] args) {
		String inputPath = "C:\\Users\\WD\\input.txt";
		String outputPath = "C:\\Users\\WD\\output.txt";

		try {
			// 파일 읽기 위한 BufferedReader
			BufferedReader br = new BufferedReader(new FileReader(inputPath));
			// 파일 쓰기 위한 BufferedWriter
			BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath));

			String line;

			// 파일의 각 줄을 읽는다(line)
			while ((line = br.readLine()) != null) {
				bw.write(line);
				bw.newLine(); // 각 라인마다 새로운 줄 추가(\n 추가)
			}

			br.close();
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
