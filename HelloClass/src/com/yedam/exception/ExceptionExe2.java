package com.yedam.exception;

import java.util.Scanner;
//import java.util.NoSuchElementException;

// NullPointerException
// NumberFormatException
// ClassCastException
// ArrayIndexOutOfBoundsException

public class ExceptionExe2 {
	public static void main(String[] args) {
		백업2();

	} // end of main

	public static void 백업() {
		Scanner scanner = new Scanner(System.in); // 외부연결; resource
		System.out.println(">> ");
		String str = scanner.nextLine();
		// Resource leak: 'scanner' is never closed

		try {
			System.out.println(str.toString()); // String str = null;
			int num = Integer.parseInt(str);

		} catch (NullPointerException e) {  // 아무것도 입력하지 않으면 공백이 들어감 -> null이 아님
			System.out.println("Null값을 참조.");

		} catch (NumberFormatException e) {
			System.out.println("포맷이 비정상.");

		} finally {
			// 정상실행, 예외발생 상관없이 반드시 실행할 코드
			// scanner.close();
		}

//		여러 예외 한번에 처리
//		catch (NullPointerException | NumberFormatException e) {
//			System.out.println("다중예외처리");
//		}

//		잘못된 예외 처리
//		try {
//			System.out.print(str.toString());  // 문자열 반환
//			
//		} catch(NumberFormatException e) {     // 잘못된 예외처리
//			System.out.println("포맷이 비정상.");
//		} 

		System.out.println("end of prog.");

	}// end of 백업()

	public static void 백업2() {
		Scanner scn = new Scanner(System.in);
		boolean run = true;

		while (run) {
			System.out.println("1.메뉴 2.종료");
			System.out.print("선택>> ");
			int menu = 0;

			while(true) {   // 적절한 값(int)를 선택할 때까지 반복
				try {
					menu = Integer.parseInt(scn.nextLine());
					
				} catch (NumberFormatException  e) {
					System.out.println("1.메뉴 2.종료");
					System.out.println("메뉴를 다시 선택..");
					continue;
				} 
				break; // 정상적인 값을 넣어서 예외가 발생하지 않으면 break
				
			}
			
			switch (menu) {
			case 1:
				백업();
				break;

			case 2:
				run = false;
				break;
				
			default:  // 1, 2 외의 다른 int 값 입력
				System.out.println("없는 메뉴를 선택해서 종료합니다.");
				run = false;
				
			} // end of switch(menu)

		} // end of while(run)

		System.out.println("end of prog.");
		scn.close(); // 리소스를 환원
	} // end of 백업2()

} // end of class
