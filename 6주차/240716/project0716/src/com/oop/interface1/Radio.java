package com.oop.interface1;

public class Radio implements RemoteControl {
	private int volume;
	private int memoryVolume;

	@Override
	public void turnOn() {
		System.out.println("Radio를 켭니다");
	}

	@Override
	public void turnOff() {
		System.out.println("Radio를 끕니다.");

	}

	@Override
	public void setVolume(int volume) {
		if (volume > RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		} else if (volume < RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		} else {
			this.volume = volume;
		}

	}

	public int getVolume() {
		return volume;
	}

	// 음소거 해제 후에 다시 설정된 volume 으로 돌아가도록 오버라이드
	@Override
	public void setMute(boolean mute) {
		if (mute) {
			System.out.println("음소거되었습니다.");
			this.memoryVolume = volume;
			setVolume(MIN_VOLUME);
		} else {
			System.out.println("음소거 해제되었습니다.");
			setVolume(memoryVolume);
		}
	}

}
