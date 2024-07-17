package com.oop.interface4;

public class InterfaceExample {
	public static void main(String[] args) {
		// 구현 객체: InterfaceImpl 가 자식 인터페이스에 대입되면, 자식과 부모 추상 메서드 모두 호출 가능
		Child ic = new InterfaceImpl();
		// mother, father, child 모두 사용 가능
		ic.methodM();
		ic.methodF();
		ic.methodC();

		Mother im = new InterfaceImpl();
		im.methodM(); // mother 만 사용 가능

		Father iF = new InterfaceImpl();
		iF.methodF(); // father 만 사용 가능

		Father ifa = new InterfaceImpl();
		Child c = (Child) ifa;
		c.methodM(); // child 로 변경하면 전부 사용 가능
	}
}
