package com.practice.mobile;

public abstract class Mobile {
	String mobileName, osType;
	int batterySize;

	// 기본 생성자
	public Mobile() {
		super();
	}

	// String mobileName, int batterySize, String osType 생성자
	public Mobile(String mobileName, int batterySize, String osType) {
		setMobileName(mobileName);
		setBatterySize(batterySize);
		setOsType(osType);
	}

	// getter, setter
	public String getMobileName() {
		return mobileName;
	}

	public void setMobileName(String mobileName) {
		this.mobileName = mobileName;
	}

	public String getOsType() {
		return osType;
	}

	public void setOsType(String osType) {
		this.osType = osType;
	}

	public int getBatterySize() {
		return batterySize;
	}

	public void setBatterySize(int batterySize) {
		this.batterySize = batterySize;
	}

	// operate(int time): int 사용을 통한 배터리 감소 (분단위로 입력)
	public abstract int operate(int time);

	// charge(int time): int 충전을 통한 배터리 증가 (분단위로 입력)
	public abstract int charge(int time);

	@Override
	public String toString() {
		return mobileName + "\t\t" + batterySize + "\t\t" + osType;
	}

}
