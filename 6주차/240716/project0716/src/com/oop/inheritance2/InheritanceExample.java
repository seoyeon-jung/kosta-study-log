package com.oop.inheritance2;

public class InheritanceExample {

	public static void main(String[] args) {
		Parents p = new Parents();
		System.out.println(p.getEyeColor());
		p.eat();// 냠냠
		p.walk(); // 뒤뚱뒤뚱

		System.out.println("Parents p는 Parents의 객체이다? " + (p instanceof Parents)); // true
		System.out.println("Parents p는 Parents의 객체이다? " + (p instanceof Child)); // false
		System.out.println();

		Child c = new Child();
		System.out.println(c.getEyeColor());
		System.out.println(c.getJob());
		c.eat(); // 냠냠
		c.walk(); // 뚜벅뚜벅
		c.hello(); // 안녕하세요

		System.out.println("Child c는 Chld의 객체이다? " + (c instanceof Child)); // true
		System.out.println("Child c는 Parents의 객체이다? " + (c instanceof Parents)); // true
		System.out.println();

		Parents pc = c;
		System.out.println(pc.getEyeColor());
		pc.eat();
		pc.walk(); // 뚜벅뚜벅
		// 오버라이딩 된 걸 쓰기 때문에 자식에서 가져온 부모는 '뚜벅뚜벅'
		System.out.println("Parents pc는 Chld의 객체이다? " + (pc instanceof Child)); // true
		System.out.println("Parents pc는 Parents의 객체이다? " + (pc instanceof Parents)); // true
		System.out.println();

		Child cc = (Child) pc;
		cc.hello();
		System.out.println("Child cc는 Chld의 객체이다? " + (c instanceof Child)); // true
		System.out.println("Child cc는 Parents의 객체이다? " + (c instanceof Parents)); // true

	}

}
