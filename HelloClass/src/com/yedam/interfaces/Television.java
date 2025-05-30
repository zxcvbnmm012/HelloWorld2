package com.yedam.interfaces;

// RemoteControl interface를 구현(상속x)하는 구현클래스

public class Television implements RemoteControl {

	@Override
	public void turnOn() {
		System.out.println("TV를 켭니다");
		
	}

	@Override
	public void turnOff() {
		System.out.println("TV를 끕니다");
		
	}

}
