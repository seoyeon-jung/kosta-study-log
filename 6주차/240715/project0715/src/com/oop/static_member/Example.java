package com.oop.static_member;

public class Example {
	public static int staticCount = 0;
	public int instanceCount = 0;

	public static void incrementStaticCount() {
		staticCount++;
	}

	public void incrementInstanceCount() {
		instanceCount++;
	}

	public static void main(String[] args) {
		Example example1 = new Example();
		Example example2 = new Example();

		Example.incrementStaticCount(); // staticCount = 1
		Example.incrementStaticCount(); // staticCount = 2

		example1.incrementInstanceCount(); // example1 = 1
		example2.incrementInstanceCount(); // example2 = 1
		example2.incrementInstanceCount(); // example2 = 2

		System.out.println("Static Count: " + Example.staticCount); // 2
		System.out.println("Example1 Instance Count: " + example1.instanceCount); // 1
		System.out.println("Example2 Instance Count: " + example2.instanceCount); // 2

	}

}
