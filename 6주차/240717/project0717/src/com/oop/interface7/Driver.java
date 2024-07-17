package com.oop.interface7;

public class Driver {
	void drive(Vehicle v) {
		if (v instanceof Bus b) {
			b.checkFare();
		}

		// Bus b = (Bus) v;
		// b.checkFare();
		// => taxi 가 bus 로 형변환이 안되기 때문에 이대로 작성하면 오류가 난다.

		v.run();
	}
}
