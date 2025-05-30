package com.yedam.inheritance;

// Cellphone class 상속
// Cellphone의 자식클래스

public class Smartphone extends Cellphone { // 자식 extends 부모
	int channel;
	
	// 생성자
	public Smartphone() {
		
	}
	
	public Smartphone(String model, String color, int channel) {
		super(model, color); // 부모클래스의 사용자 정의 생성자를 활용
		this.channel = channel;
	}
	
	void watch() {
		System.out.println(channel + "을 시청합니다.");
	}

	// 부모클래스의 기능을 자식클래스에서 재정의 (overriding)
	@Override // 어노테이션 -> 부모클래스와 동일한지 타입을 체크해줌
	// java 규칙 : 부모의 접근제한자 보다 낮은 접근제한자는 자식에서 사용 불가 -> 같거나 더 커야함 (public, private... )
	public void powerOn() {
		System.out.println("🍨 전원을 켭니다 🍨");
	}

	public void powerOff() {
		System.out.println("🍨 전원을 끕니다 🍨");

	}

	@Override
	public String toString() {
		return super.toString() + "Smartphone [channel=" + channel + "]";  // super : 부모 -> Object class
	}

		
}
