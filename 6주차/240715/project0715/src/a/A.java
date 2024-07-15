package a;

public class A {
	byte byteValue = 1;
	short shortValue = 1;
	int intValue = 1;

	// 다른 패키지에서 생성자 호출 가능

	ClassName cn1 = new ClassName(byteValue);

	// default : 같은 패키지 내에서만 사용 가능
	ClassName cn2 = new ClassName(shortValue);

	// private : 같은 객체 내에서만 사용 가능;
	// ClassName cn3 = new ClassName(intValue);}
}