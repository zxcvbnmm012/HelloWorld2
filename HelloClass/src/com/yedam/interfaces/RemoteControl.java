package com.yedam.interfaces;

/*
 * interface : 상수만 선언 가능
 *             한번 정의한 값은 변경 불가 (final int의 의미)
 *             메소드는 추상메소드로 선언됨
 */

public interface RemoteControl {
	public int MAX_VOLUME = 10;
	
	
	// 추상메소드
	public void turnOn();
	public abstract void turnOff();
}
