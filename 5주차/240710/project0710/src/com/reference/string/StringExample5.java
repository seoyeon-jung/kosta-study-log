package com.reference.string;

public class StringExample5 {

	public static void main(String[] args) {
		String rainbow = "빨,주,노,초,파,남,보";
		String[] rainbowArr = rainbow.split(",");

//		System.out.println(rainbowArr[0]);
//		System.out.println(rainbowArr[1]);
//		System.out.println(rainbowArr[2]);
//		System.out.println(rainbowArr[3]);
//		System.out.println(rainbowArr[4]);
//		System.out.println(rainbowArr[5]);
//		System.out.println(rainbowArr[6]);

		for (int i = 0; i < rainbowArr.length; i++) {
			String color = rainbowArr[i];
			System.out.println(color);
		}
	}

}
