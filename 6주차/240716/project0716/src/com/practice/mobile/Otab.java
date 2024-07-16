package com.practice.mobile;

public class Otab extends Mobile {
	// 기본 생성자
	public Otab() {
		super();
	}

	// 3개의 변수 생성자
	public Otab(String mobileName, int batterySize, String osType) {
		super(mobileName, batterySize, osType);
	}

	// operate(int time): int 1분 사용시 배터리 12 감소 / 잔여 배터리 리턴
	@Override
	public int operate(int time) {
		setBatterySize(getBatterySize() - (time * 12));
		return getBatterySize();
	}

	// charge(int time): int 1분 충전시 배터리 8 증가 / 잔여 배터리 리턴
	@Override
	public int charge(int time) {
		setBatterySize(getBatterySize() + (time * 8));
		return getBatterySize();
	}
}
