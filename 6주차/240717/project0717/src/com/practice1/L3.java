package com.practice1;

public class L3 extends Car implements Temp {
	// 기본 생성자 사용
	L3() {
	}

	// 5개 클래스 변수를 받는 생성자 선언
	public L3(String name, String engine, int oilTank, int oilSize, int distance) {
		super(name, engine, oilTank, oilSize, distance);
	}

	@Override
	public void go(int distance) {
		setDistance(getDistance() + distance);

		// 10 주행 시 현재 주유량 1 감소
		int decrement = distance / 10; // 주행 거리를 10으로 나눈 몫을 감소량으로 설정
		setOilSize(getOilSize() - decrement);
	}

	// 현재 주유양 증가
	@Override
	public void setOil(int oilSize) {
		if (getOilSize() + oilSize <= getOilTank()) {
			setOilSize(getOilSize() + oilSize);
		} else {
			System.out.println("주유 가능 용량 초과");
		}
	}

	@Override
	public int getTempGage() {
		// 10 주행 시 엔진 온도 1 증가
		return getDistance() / 10;
	}

}
