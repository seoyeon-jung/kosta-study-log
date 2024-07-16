package com.oop.interface1;

public interface RemoteControl {
	// public 정적 상속 필드
	public static final int MAX_VOLUME = 10;
	/* public static final */int MIN_VOLUME = 0;

	// public 추상 메서드
	public /* abstract */ void turnOn();

	public void turnOff();

	void setVolume(int volume); // setter와 다름

	// 정적 메소드(public, private으로만 만들 수 있음)
	/* public */ static void changeBattery() {
		staticMethod();
		System.out.println("건전지를 교환합니다.");
	}

	// private => public 메소드 혹은 default 메소드에서 사용 가능
	// 내부에서 흐름을 감출 때 사용 (잘 안 씀)
	private static void staticMethod() {
		System.out.println("(private)정적 메소드를 호출합니다.");
	}

	// default 메소드 (음소거 해제 후에도 소리는 0)
	default void setMute(boolean mute) {
		method();
		if (mute) {
			System.out.println("음소거되었습니다.");
			setVolume(MIN_VOLUME);
		} else {
			System.out.println("음소거 해제되었습니다.");
		}
	}

	private void method() {
		System.out.println("(private) 메소드를 호출합니다.");
	}

}
