package com.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileExample3 {

	public static void main(String[] args) throws Exception {
		// image.jpg 파일을 복사하여, image2.jpg 파일 만들기
		String inputImage = "C:\\Users\\WD\\image.jpg";
		String outputImage = "C:\\Users\\WD\\image2.jpg";

//		FileInputStream finput = new FileInputStream(inputImage);
//		BufferedInputStream br = new BufferedInputStream(finput);
//		FileOutputStream foutput = new FileOutputStream(outputImage);
//		BufferedOutputStream bw = new BufferedOutputStream(foutput);

		BufferedInputStream br = new BufferedInputStream(new FileInputStream(inputImage));
		BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream(outputImage));

		byte[] buffer = new byte[1024];
		int bytesRead;

		while ((bytesRead = br.read(buffer)) != -1) {
			bw.write(buffer, 0, bytesRead);
		}

		br.close();
		bw.flush();
		bw.close();

	}

}
