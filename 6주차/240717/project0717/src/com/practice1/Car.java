package com.practice1;

public abstract class Car {
	// 인스턴스 필드 선언
	String name, engine;
	int oilTank, oilSize, distance;

	// 기본 생성자 생성
	Car() {
	}

	// 5개 클래스 변수를 받는 생성자 선언
	public Car(String name, String engine, int oilTank, int oilSize, int distance) {
		setName(name);
		setEngine(engine);
		setOilTank(oilTank);
		setOilSize(oilSize);
		setDistance(distance);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public int getOilTank() {
		return oilTank;
	}

	public void setOilTank(int oilTank) {
		this.oilTank = oilTank;
	}

	public int getOilSize() {
		return oilSize;
	}

	public void setOilSize(int oilSize) {
		this.oilSize = oilSize;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	// 추상 메소드 선언
	// 주행 : distance 만큼 주행하고 현재 우유량을 감소
	public abstract void go(int distance);

	// 주유 : 특정 양을 주유한다
	public abstract void setOil(int oilSize);

	@Override
	public String toString() {
		return "\t" + name + "\t\t" + engine + "\t\t" + oilTank + "\t\t" + oilSize + "\t\t" + distance;
	}

}
