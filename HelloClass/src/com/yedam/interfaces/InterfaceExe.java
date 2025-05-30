package com.yedam.interfaces;

public class InterfaceExe {
	public static void main(String[] args) {
		final int num = 10; // 상수
		
		// 인터페이스 변수에 구현클래스의 인스턴스를 할당
//		CellPhone phone = new Smartphone();
		RemoteControl rc = new Television();
		rc.turnOn();
		rc.turnOff();
		
		// 같은 변수에 다른 구현클래스의 인스턴스 할당 -> 다형성
		rc = new Radio();
		rc.turnOn();
		rc.turnOff();
	
	}
}
