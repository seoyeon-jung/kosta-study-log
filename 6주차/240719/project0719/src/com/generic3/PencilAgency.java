package com.generic3;

public class PencilAgency implements Rentable<Pencil> {

	@Override
	public Pencil rent() {
		return new Pencil();
	}

}
