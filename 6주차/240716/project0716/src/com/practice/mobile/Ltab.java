package com.practice.mobile;

public class Ltab extends Mobile {
	// 기본 생성자
	public Ltab() {
		super();
	}

	// 3개의 변수 생성자
	public Ltab(String mobileName, int batterySize, String osType) {
		super(mobileName, batterySize, osType);
	}

	// operate(int time):int 1분 사용시 배터리 10 감소 / 잔여 배터리 리턴
	@Override
	public int operate(int time) {
		setBatterySize(getBatterySize() - (time * 10));
		return getBatterySize();
	}

	// charge(int time):int 1분 충전시 배터리 10 증가 / 잔여 배터리 리턴
	@Override
	public int charge(int time) {
		setBatterySize(getBatterySize() + (time * 10));
		return getBatterySize();
	}
}
