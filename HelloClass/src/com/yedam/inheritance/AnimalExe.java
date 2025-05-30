package com.yedam.inheritance;

/*
 * Animal을 실행할 main
 */

public class AnimalExe {
	public static void main(String[] args) {
		
//	추상클래스는 인스턴스 생성 불가
//	Animal animal = new Animal();
		
		// 자식클래스의 인스턴스는 생성 가능
		Animal a1 = new Bird();
		a1.breathe();
		a1.sound();
		
		a1 = new Fish();
		a1.breathe();
		a1.sound();
		
	}
}
