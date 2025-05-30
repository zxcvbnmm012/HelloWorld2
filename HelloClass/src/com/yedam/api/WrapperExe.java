package com.yedam.api;

public class WrapperExe {
	public static void main(String[] args) {
		int num = 10;
		Integer num2 = 20; // boxing으로 int타입 20이 Integer 타입에 담김
		// Integer num2 = new Integer(20);
		
		// 기본타입(int) -> 참조타입(Integer) : boxing
		// 참조타입 -> 기본타입 : unboxing

		num = num2.intValue(); // Integer 클래스에 있는 변수인 num2를 실제 int타입으로 바꿈
		
		String str = "10";
		num = Integer.parseInt(str);
		
		double num3 = Double.parseDouble(str);
		num3 = Float.parseFloat(str); // 자동 형변환 발생
		
		Integer num4 = new Integer(10);  
		Integer num5 = new Integer(10);
		System.out.println(num4.intValue() == num5.intValue());
	}
	
}
