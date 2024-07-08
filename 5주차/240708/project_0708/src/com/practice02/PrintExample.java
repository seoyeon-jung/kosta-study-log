package com.practice02;

public class PrintExample {

	public static void main(String[] args) {
		/*System.out.println("화면출력");
		System.out.println("화면" + "출력");
		System.out.println(3.8);
		System.out.println(3+5);
		System.out.println("화면"+3);
		System.out.println("화면"+3+5);
		System.out.println(3+4+"화면");*/

		System.out.printf("%d\n",30);
		System.out.printf("%o\n",30);
		System.out.printf("%x\n",30);
		System.out.printf("%s\n","출력");
		System.out.printf("%f\n",5.8);
		System.out.printf("%4.2f\n",5.8);
		System.out.printf("%5.2f\n",5.8);
		System.out.printf("%d와 %4.2f\n",4,5.8);
	}

}
