package com.practice06;

public class ParseExample {
	public static void main(String[] args) {
		String strByte = "10";
		byte byteValue = Byte.parseByte(strByte); // 숫자 타입으로 변환
		System.out.println(byteValue); // 10

		String strInt = "200";
		int intValue = Integer.parseInt(strInt); // int 타입으로 변환
		System.out.println(intValue); // 200

		String x = "10";
		String y = "20";
		System.out.println(x + y); // 1020 (문자열이므로 숫자처럼 더해지지 않음)

		int xValue = Integer.parseInt(x);
		int yValue = Integer.parseInt(y);
		System.out.println(xValue + yValue); // 30 (숫자로 계산된다)

		// 숫자 형태가 아닌 경우 숫자로 변환하려고 하면 오류 발생
		short shortValue = Short.parseShort("200");
		long longValue = Long.parseLong("40000000000");
		float floatValue = Float.parseFloat("12.345");
		double doubleValue = Double.parseDouble("12.345");
		boolean booleanValue = Boolean.parseBoolean("true");
		System.out.println(shortValue); // 200
		System.out.println(longValue); // 40000000000
		System.out.println(floatValue); // 12.345
		System.out.println(doubleValue); // 12.345
		System.out.println(booleanValue); // true

	}
}
