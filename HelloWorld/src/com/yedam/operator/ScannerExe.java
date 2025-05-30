package com.yedam.operator;

import java.util.Scanner;

public class ScannerExe {
	public static void main(String[] args) {
		test2();
	} // end of main

// test1()
	public static void test1() {
		Scanner scn = new Scanner(System.in);

		while (true) {
			System.out.println("1.메뉴 2.메뉴 3.메뉴 4.종료");
			int menu = Integer.parseInt(scn.nextLine()); // Integer.parseInt("30") = 30

			if (menu == 1) {
				System.out.println("1번 메뉴를 선택했습니다");
			} else if (menu == 2) {
				System.out.println("2번 메뉴를 선택했습니다");
			} else if (menu == 3) {
				System.out.println("3번 메뉴를 선택했습니다");
			} else if (menu == 4) {
				break;
			} else {
				System.out.println("1 ~ 4번 중에 선택하세요");
			}
		} // end of while
		System.out.println("end of prog.");
	}// end of test1()


	
	
// test2()
	public static void test2() {
		Scanner scn = new Scanner(System.in);
		int balance = 0; // 계좌의 금액
		while (true) {
			System.out.println("1.입금 2.출금 3.잔액 4.종료");
			int menu = Integer.parseInt(scn.nextLine()); // Integer.parseInt("30") = 30

			if (menu == 1) {
				System.out.println("입금액을 입력>> ");
				Scanner scn2 = new Scanner(System.in);
				int intscn2 = Integer.parseInt(scn2.nextLine()); 
				int balance2 = balance + intscn2;
				if (intscn2 <= 0)
				{
					System.out.println("마이너스는 입력할 수 없습니다");
					System.out.printf("현재 계좌 금액 : %d\n", balance);
					continue;
				}
				if (balance2 < 100000) {
					balance = balance2;
					
				} else {
					System.out.println("계좌 금액이 10만원을 초과할 수 없습니다");
					System.out.printf("현재 계좌 금액 : %d\n", balance);
					continue;
				}
				// 입금 기능 구현

			} else if (menu == 2) {
				System.out.println("출금액을 입력>> ");
				Scanner scn3 = new Scanner(System.in);
				int intscn3 = Integer.parseInt(scn3.nextLine()); 
				int balance3 = balance - intscn3;
				if (balance3 > 0) {
					balance = balance3;
					
				} else {
					System.out.println("잔액을 초과하여 출금할 수 없습니다");
					System.out.printf("현재 계좌 금액 : %d\n", balance);
					continue;
				}
				// 출금 기능 구현

			} else if (menu == 3) {
				System.out.printf("현잔액>> %d\n", balance);

				// 현재 잔액
			} else if (menu == 4) {
				System.out.println("프로그램을 종료>>");
				break;

			} else {
				System.out.println("1 ~ 4번 중에 선택하세요");
			}
		} // end of while
		System.out.println("end of prog.");
	}// end of test2()

} // end of class
