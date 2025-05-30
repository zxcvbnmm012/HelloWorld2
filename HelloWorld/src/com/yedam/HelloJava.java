package com.yedam;

// ctrl+shift+f : 정렬 단축키
public class HelloJava {
	public static void main(String[] args) {     // ctrl+space : 자동완성 단축키
		// java 규칙 : main -> class를 실행하면 가장 먼저 실행하는 메소드
		
		// 변수 타입 : int(정수), double(실수), boolean(참/거짓)
		int num1 = 10; // 정수타입 변수 초기화 -> 변수선언 & 값 대입
		double num2 = 20;  // 실수타입 변수 초기화 ; 실수 > 정수 -> 자동형변환(promotion) 발생
		                   // 작은 데이터타입을 큰 데이터타입에 담으면 자동형변환 발생함
		num1 = (int) num2; // 강제형변환(casting) -> 큰 데이터타입을 작은 데이터타입에 담기 위해서는 형변환이 필요
		                   // java 규칙 -> 데이터타입이 같아야 연산 가능
		                   // double 타입의 num2를 int 타입으로 변환해서 연산이 가능하게 함
		
		int num3 = 100;
		double num4 = 200; // num4 == 200.0
		double result = num3 + num4;
		// int 타입과 double 타입을 연산하기 위해 int 타입의 데이터를 더 큰 데이터 타입인 double 형태로 형변환
		// result = (double) num3 + num4
		System.out.println("결과는 " + result); 
		
		
		// 문자열에서 산술연산자 + 는 두 문자를 연결해주는 기능
		System.out.println(20 + 30);              // 20 + 30 => 50
		System.out.println("결과는 " + 20 + 30);    // 20, 30을 문자열로 인식 => 결과는 2030
		System.out.println("결과는 " + (20 + 30));  // => 결과는 50
		
	}
}
