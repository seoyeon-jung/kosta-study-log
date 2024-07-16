package com.practice.vehicle;

public class Truck extends Car {

	// maxWeight, oilTankSize, efficiency 받는 생성자
	public Truck(int maxWeight, double oilTankSize, double efficiency) {
		super(maxWeight, oilTankSize, efficiency);
	}

	// getEfficiency : 현재 중량 5kg 당 연비 0.2km 감소시킨 값 리턴
	@Override
	public double getEfficiency() {
		return super.getEfficiency() - (super.getCurWeight() / 5.0) * 0.2;
	}

	// moving : calcOil() 을 호출하여 오일 감소량 획득
	// 잔여 오일량에서 감소량을 뺀 새로운 잔여 오일량으로 재설정
	@Override
	public void moving(int distance) {
		double oilConsumed = calcOil(distance);
		if (oilConsumed <= getRestOil()) {
			setRestOil(getRestOil() - oilConsumed);
		} else {
			System.out.println("남은 오일이 없습니다.");
		}
	}

	// calcOil : 거리를 연비로 나누어 오일 소모량을 추출하고 리턴
	public double calcOil(int distance) {
		return distance / getEfficiency();
	}

	// getCost : calcOil() 호출하여 오일 감소량을 획득
	// 1L당 3000원의 요금을 산정하여 리턴 (소수점 이하는 버리기)
	public int getCost(int distance) {
		double oilConsumed = calcOil(distance);
		int costPerLiter = 3000;
		return (int) (oilConsumed * costPerLiter);
	}

	// toString() : 부모의 toString()에 연비를 추가하여 리턴
	@Override
	public String toString() {
		return super.toString() + " \t " + getEfficiency();
	}
}
