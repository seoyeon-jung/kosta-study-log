package com.oop.basic.practice02;

public class BookExample {

	public static void main(String[] args) {
		Book book1 = new Book("SQL Plus", 50000, 5.0);
		Book book2 = new Book("Java 2.0", 40000, 3.0);
		Book book3 = new Book("JSP Servlet", 60000, 6.0);

		// 배열에 book1~3 넣기
		Book[] bookArr = { book1, book2, book3 };

		System.out.println("책이름\t 가격\t할인율\t할인후금액");
		System.out.println("------------------------------------------");

		// 반복문으로 동일한 코드 지우고 출력
//		for (int i = 0; i < bookArr.length; i++) {
//			System.out.println(bookArr[i].bookName + "      " + bookArr[i].bookPrice + "원      "
//					+ bookArr[i].bookDiscountRate + "%      " + bookArr[i].getDiscountBookPrice() + "원");
//		}
		for (Book b : bookArr) {
			System.out.println(b.bookName + "\t" + b.bookPrice + "원\t" + b.bookDiscountRate + "%\t"
					+ b.getDiscountBookPrice() + "원");
		}

//		System.out.println(book1.bookName + "      " + book1.bookPrice + "원      " + book1.bookDiscountRate + "%      "
//				+ book1.getDiscountBookPrice() + "원");
//		System.out.println(book2.bookName + "      " + book2.bookPrice + "원      " + book2.bookDiscountRate + "%      "
//				+ book2.getDiscountBookPrice() + "원");
//		System.out.println(book3.bookName + "      " + book3.bookPrice + "원      " + book3.bookDiscountRate + "%      "
//				+ book3.getDiscountBookPrice() + "원");

	}

}
