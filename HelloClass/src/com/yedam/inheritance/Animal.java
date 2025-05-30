package com.yedam.inheritance;

/*
 * 추상클래스 : 인스턴스 생성 x
 *          추상메소드 가질 수 있음
 * 부모클래스의 인스턴스는 생성할 수 없음
 * 자식클래스를 위해서만 존재
 * 자식클래스: Bird, Fish
 */

// 추상클래스: 공통된 기능은 부모클래스에서 구현하고 일부 기능을 자식클래스가 정의해서 사용할 수 있게함. 
//          단, 자식클래스는 그 기능을 무조건 구현해야한다는 규칙이 있음



public abstract class Animal { // 추상클래스 Animal
	// Animal이라는 인스턴스를 만들 수 없음 -> 추상클래스의 특징
	
	String kind;
	
	public void breathe() {
		System.out.println("숨을 쉽니다");
	}
	
	// 추상메소드 : {} 없이 정의
	// -> 자식클래스에서 반드시 재정의 해야 함
	public abstract void sound();
	
} // end of class
