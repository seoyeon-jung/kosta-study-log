package com.write;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriteExample {

	public static void main(String[] args) {
		try {
			Writer w = new FileWriter("C:\\Users\\WD\\output.txt");

			char a = 'A';
			w.write(a);

			char[] arr1 = { 'B', 'C', 'D' };
			w.write(arr1);

			char[] arr2 = { 'C', 'D', 'E', 'F', 'G' };
			w.write(arr2, 2, 3);

			String str1 = "HIJK";
			w.write(str1);
			String str2 = "JKLMNOP";
			w.write(str2, 2, 5);

			w.flush();
			w.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
