package com.practice.vehicle;

public class Vehicle {
	protected int maxWeight;
	protected double oilTankSize;
	protected double efficiency;

	// maxWeight, oilTankSize, efficiency 받는 생성자
	public Vehicle(int maxWeight, double oilTankSize, double efficiency) {
		setMaxWeight(maxWeight);
		setOilTankSize(oilTankSize);
		setEfficiency(efficiency);
	}

	public int getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	}

	public double getOilTankSize() {
		return oilTankSize;
	}

	public void setOilTankSize(double oilTankSize) {
		this.oilTankSize = oilTankSize;
	}

	public double getEfficiency() {
		return efficiency;
	}

	public void setEfficiency(double efficiency) {
		this.efficiency = efficiency;
	}

	@Override
	public String toString() {
		return maxWeight + " \t " + oilTankSize + " \t ";
	}

}
