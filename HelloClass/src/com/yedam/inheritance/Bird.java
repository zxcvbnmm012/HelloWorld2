package com.yedam.inheritance;

/*
 * 부모클래스: Animal(추상)
 */

public class Bird extends Animal{

	@Override
	// 추상클래스 Animal의 추상메소드 soud() -> 자식클래스에서 반드시 재정의해줘야 함
	public void sound() {  
		System.out.println("짹짹");
		
	}
	

} // end of class
