package com.oop.interface1;

public class ServiceExample {

	public static void main(String[] args) {
		//Service.staticMethod();
		//Service.staticMethod2();
		
		// Service s = new Service();
		// 인터페이스는 위와 같은 방식으로 생성하지 못한다.
		
		// 실제로 구현되는 서비스를 넣어야 한다
		// 인터페이스 변수 = new 구현 클래스();
		Service s = new ServiceImpl();
		s.defaultMethod();
		s.defaultMethod2();
		
		// 추상 메서드는 오버라이딩을 반드시 해야 호출할 수 있다.
		s.abstractMethod();
		
		System.out.println(Service.NAME);

	}

}
