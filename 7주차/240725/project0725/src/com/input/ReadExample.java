package com.input;

import java.io.FileInputStream;
import java.io.InputStream;

public class ReadExample {

	public static void main(String[] args) {
		try {
			InputStream is = new FileInputStream("C:\\Users\\WD\\output.txt");

//			while (true) {
//				int data = is.read();
//				if (data == -1)
//					break;
//				System.out.println(data);
//			}

			byte[] data = new byte[4];
			while (true) {
				int num = is.read(data);
				if (num == -1)
					break;
			}

			for (byte b : data) {
				System.out.println(b);
			}

			is.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
