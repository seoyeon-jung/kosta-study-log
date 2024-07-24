package com.stream6;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StreamExample {

	public static void main(String[] args) throws Exception {
		String absolutePath = "C:\\Users\\WD\\Desktop\\kosta-study-log\\7주차\\240724\\data.txt";
		Path path = Paths.get(absolutePath);

		Stream<String> stream = Files.lines(path, Charset.defaultCharset());
		stream.forEach(line -> {
			String[] productInfo = line.split(" ");
			int pno = Integer.parseInt(productInfo[0]);
			String pName = productInfo[1];
			String pCompany = productInfo[2];
			int price = Integer.parseInt(productInfo[3]);
			Product p = new Product(pno, pName, pCompany, price);
			System.out.println(p);
		});
		stream.close();

	}

}
