package com.yedam.api;


public class MathExe {
	public static void main(String[] args) {
		// 절대값
		System.out.println(Math.abs(-100));
	
		// 올림, 버림
		System.out.println(Math.floor(12.3));  // 버림 : double
		System.out.println(Math.ceil(12.3));   // 올림 : double
		System.out.println(Math.round(12.3));  // 반올림 : int
		
		// 크기비교
		System.out.println(Math.max(Math.ceil(12.3), Math.floor(12.3)));  // 큰 값
		
	}
}
