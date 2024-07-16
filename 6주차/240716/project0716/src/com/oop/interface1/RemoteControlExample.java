package com.oop.interface1;

public class RemoteControlExample {
	public static void main(String[] args) {
//		TV tv = new TV();
//		Radio rd = new Radio();
//
//		tv.turnOn();
//		rd.turnOn();

		TV tv = new TV();
		RemoteControl rc = tv;
		rc.turnOn();
		rc.setVolume(5);
		System.out.println(tv.getVolume()); // 5
		rc.setMute(true);
		System.out.println(tv.getVolume()); // 0
		rc.setMute(false);
		System.out.println(tv.getVolume()); // 0
		rc.turnOff();

		// (private)정적 메소드를 호출합니다.
		// 건전지를 교환합니다.
		System.out.println();
		RemoteControl.changeBattery();
		System.out.println();

		rc = new Radio();
		rc.turnOn();
		rc.setVolume(8);
		Radio rd = (Radio) rc;
		System.out.println(rd.getVolume()); // 8
		rd.setMute(true);
		System.out.println(rd.getVolume()); // 0
		rd.setMute(false);
		System.out.println(rd.getVolume()); // 8
		rd.turnOff();

		// RemoteControl.MIN_VOLUME = 10;
		// => The final field RemoteControl.MIN_VOLUME cannot be assigned
		// RemoteControl.MAX_VOLUME = 10;
		// => The final field RemoteControl.MAX_VOLUME cannot be assigned
		// System.out.println(RemoteControl.MAX_VOLUME);
	}
}
