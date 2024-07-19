package com.generic3;

public class HouseAgency implements Rentable<House> {

	@Override
	public House rent() {
		return new House();
	}

}
