package com.yedam.exception;

/*
 * 1) 일반예외 - 컴파일러가 에러부분을 파악
 * 2) 실행예외 - 실행시점(런타임)에 에러가 발생
 */

public class ExceptionExe {
	// 예외클래스에서 최상위 부모 클래스는 Exception
	// Exception <- ClassNotFoundException, ..., RuntimeException
	public static void main(String[] args) {
		// 일반예외 처리 : try... catch...문
		// try 블럭 안에서 에러가 발생하면 catch 블럭이 실행되고 프로그램을 정상 실행.
		// try { 예외가 발생하는 구문 } catch { 예외가 발생하면 대체할 구문 }
//		try { 
//			Class.forName("java.util.Scanner11");
//			
//		} catch(ClassNotFoundException e) {
//			System.out.println("일반예외 발생.");
//		}
		
		
		// 실행예외 처리
		String numStr = "a";
		int num = 0;
		try {
			num = Integer.parseInt(numStr);
		} catch(NumberFormatException e) {
			System.out.println("실행예외 발생.");
		}
		System.out.println(num);
		
		// 일반예외 처리 -> 이클립스로 처리 가능
		try {
			Class.forName("java.util.Scanner");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();  // 예외에 대한 로그를 보여주는 메소드
		}
		System.out.println("end of prog.");
		
	} // end of main
} // end of class
