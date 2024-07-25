package com.read;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReadExample {

	public static void main(String[] args) {
		try {
			Reader r = new FileReader("C:\\Users\\WD\\output.txt");

//			while (true) {
//				int data = r.read();
//				if (data == -1)
//					break;
//				System.out.println((char) data);
//
//			}

			char[] cArr = new char[17];
			while (true) {
				int num = r.read(cArr);
				if (num == -1)
					break;
			}

			for (char ch : cArr) {
				System.out.println(ch);
			}

			r.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
