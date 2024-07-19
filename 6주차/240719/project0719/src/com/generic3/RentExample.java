package com.generic3;

public class RentExample {
	public static void main(String[] args) {
		CarAgency ca = new CarAgency();
		Car rentCar = ca.rent();
		rentCar.drive();

		HouseAgency ha = new HouseAgency();
		House rentHouse = ha.rent();
		rentHouse.live();

		PencilAgency pa = new PencilAgency();
		Pencil rentPencil = pa.rent();
		rentPencil.write();
	}
}
