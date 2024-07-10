package com.reference.string;

public class StringPractice2 {

	public static void main(String[] args) {
		String address = "cik@java.co.kr";
		String userId = address.substring(0, 3);
		String companyName = address.substring(4, 8);
		String domainAddr = address.substring(4);

		System.out.println("userId: " + userId); // cik
		System.out.println("companyName: " + companyName); // java
		System.out.println("domainADdr: " + domainAddr); // java.co.kr

	}

}
