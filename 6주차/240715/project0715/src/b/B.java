package b;

import a.ClassName;

public class B {
	public static void main(String[] args) {
		byte byteValue = 1;
		// short shortValue = 1;
		// int intValue = 1;

		// 다른 패키지에서 생성자 호출 가능

		ClassName cn1 = new ClassName(byteValue);

		// default : 같은 패키지 내에서만 사용 가능
		// ClassName cn2 = new ClassName(shortValue);

		// private : 같은 객체 내에서만 사용 가능;
		// ClassName cn3 = new ClassName(intValue);

		// 기본 생성자 호출
		ClassName cn = new ClassName();
		System.out.println(cn.publicField);
		// defaultField is not visible
		// System.out.println(cn.defaultField);
		// privateField is not visible
		// System.out.println(cn.privateField);

		// 다른 패키지에서 메소드 호출
		cn.publicMethod();
		// cn.defaultMethod();
		// cn.privateMethod();

	}

}
