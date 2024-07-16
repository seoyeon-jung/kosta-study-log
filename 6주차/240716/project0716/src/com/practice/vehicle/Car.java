package com.practice.vehicle;

public class Car extends Vehicle {
	private double restOil;
	private int curWeight;

	// 기본 생성자
	public Car() {
		super();
	}

	// maxWeight, oilTankSize, efficiency 받는 생성자
	public Car(int maxWeight, double oilTankSize, double efficiency) {
		super(maxWeight, oilTankSize, efficiency);
		setRestOil(restOil);
		setCurWeight(curWeight);
	}

	public double getRestOil() {
		return restOil;
	}

	public void setRestOil(double restOil) {
		this.restOil = restOil;
	}

	public int getCurWeight() {
		return curWeight;
	}

	public void setCurWeight(int curWeight) {
		this.curWeight = curWeight;
	}

	// addOil : 현재 오일량에 추가
	// [조건] 오일 탱크 크기를 넘어서지 않을 것
	public void addOil(int oil) {
		if (restOil + oil <= getOilTankSize()) {
			setRestOil(restOil + oil);
		} else {
			System.out.println("오일을 추가할 수 없습니다.");
		}
	}

	// moving : 연비와 주행거리에 따라 오일량 감소
	public void moving(int distance) {
		double oilConsumed = distance / getEfficiency();
		if (oilConsumed <= restOil) {
			setRestOil(restOil - oilConsumed);
		} else {
			System.out.println("오일량이 0입니다.");
		}
	}

	// addWeight : 현재 적재량에 물건 추가
	// [조건] 최대 적재 중량을 넘어서지 않을 것
	public void addWeight(int weight) {
		if (curWeight + weight <= maxWeight) {
			setCurWeight(curWeight + weight);
		} else {
			System.out.println("최대 적재 중량을 넘어섰습니다.");
		}
	}

	// toString() : 부모의 toString()에 잔여오일량과 현재적재중량을 추가하여 리턴
	@Override
	public String toString() {
		return super.toString() + restOil + "\t\t" + curWeight;
	}
}
