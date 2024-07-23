package com.lambda5;

public class MethodReferenceExample {
	public static void main(String[] args) {
		Person p = new Person();
		// CalculateService cs = new CalculateService();
		// p.action(cs::sum);
		// p.action(cs::multiply);

		// p.action(인터페이스); -> 인터페이스의 메소드 calc(10, 4) 호출 -> 결과값 출력
		// <= person이 가지고 있는 메소드의 역할
		// 어떤 인터페이스지? -> Calculabe = 추상 메서드 double calc(double x, double y);
		// 매개변수 10, 4로 무엇을 하는가?
		// sum을 찾아 CalculateService 파일로 가서 sum을 찾아서 계산
		// multiply도 동일

		// static 메소드이므로 참조변수.메소드()로 확인
		// CalculateService의 메소드 sum을 참조하여 계산
		p.action((x, y) -> CalculateService.sum(x, y));
		p.action(CalculateService::sum);

		p.action((x, y) -> CalculateService.sum(x, y));
		p.action(CalculateService::multiply);

	}
}
