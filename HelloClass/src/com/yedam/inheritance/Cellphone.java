package com.yedam.inheritance;

/*
 * 부모: Cellphone
 *      - 전원켜기, 전원끄기, 볼륨 up, 볼륨 down, 통화
 *      - Model, Color
 * 자식: Smartphone
 *      - TV 보기
 */

public class Cellphone {  // 모든 클래스의 최상위 부모 클래스 : Object -> publid class Cellphone extends Object
	String model;
	String color;
	
	// 생성자
	public Cellphone() {
		
	}
	
	public Cellphone(String model, String color) {
		this.model = model;
		this.color = color;
	}
	
	// 메소드
	public void powerOn() {
		System.out.println("전원을 켜기.");
	}

	public void powerOff() {
		System.out.println("전원을 끄기.");
	}

	void 통화하기() {
		System.out.println("통화하다.");
	}

	@Override
	public String toString() {
		return "Cellphone [model=" + model + ", color=" + color + "]";
	}


}
