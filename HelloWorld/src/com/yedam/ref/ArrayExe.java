package com.yedam.ref;

import java.util.Scanner;

public class ArrayExe {
	public static void main(String[] args) {
		test3();
	} // end of main

// test1()
	public static void test1() {
		Scanner scn = new Scanner(System.in);
		String[] stringAry = new String[10];

		// 빈 배열에 값 추가
		while (true) {
			System.out.print("이름을 입력>> \n");
			String name = scn.nextLine();

			if (name.equals("quit")) {
				break;
			}

			for (int i = 0; i < stringAry.length; i++) {
				// 빈공간(null)이 있는지 체크하고 빈공간을 하나 찾으면 name 값을 입력
				if (stringAry[i] == null) {
					stringAry[i] = name;
					System.out.println("입력 성공");
					break;
				}
			}
		} // end of while

		for (int i = 0; i < stringAry.length; i++) {
			if (stringAry[i] != null) {
				System.out.printf("strAry [%d]번째의 값: %s\n", i, stringAry[i]);
			}
		}
		System.out.println("end of prog");

	} // end of test1()

// test2() : delete Array
	public static void test2() {
		Scanner scn = new Scanner(System.in);

		String[] stringAry = new String[10];
		stringAry[0] = "김해민";
		stringAry[1] = "홍길동";
		stringAry[2] = "김태완";
		stringAry[3] = "김태희";

		System.out.println("삭제할 친구 이름>> ");
		String name = scn.nextLine();

		// 입력받은 name이 배열에 있으면 null로 초기화 -> 삭제
		for (int i = 0; i < stringAry.length; i++) {
			if (stringAry[i] != null && stringAry[i].equals(name)) {
				// null 값을 참조하는 곳에 equals method 사용 : 에러 -> NullPointerException
				// stringary[i] != null 조건 추가해서 null이 아닐때만 name과 비교
				stringAry[i] = null; // 초기화
			}
		}
		for (int i = 0; i < stringAry.length; i++) {
			if (stringAry[i] != null) {
				System.out.printf("strAry [%d]번째의 값: %s\n", i, stringAry[i]);
			}
		}
		System.out.println("end of prog");
	} // end of test2()

// test3() : friendApp
	public static void test3() {
		Scanner scn = new Scanner(System.in);
		
		String[] friendAry = new String[10];
		
		boolean run = true;
		while(run) {
			System.out.println("1.추가 2.목록 3.삭제 4.종료");
			System.out.print("선택>> ");
			
			// 메뉴 선택
			int menu = Integer.parseInt(scn.nextLine());
			
			switch(menu) {
			case 1: // 이름 추가
				System.out.print("추가할 이름 입력>> ");
				String name = scn.nextLine();
				for (int i = 0; i < friendAry.length; i++) {
					if (friendAry[i] != null && friendAry[i].equals(name)) {
						Scanner scn2 = new Scanner(System.in);
						System.out.println("동일한 이름이 있습니다. 추가하시겠습니까?");
						System.out.println("1.추가 2.취소");
						int namecheck = Integer.parseInt(scn.nextLine());
						if (namecheck == 1) {
							for (int j = 0; j < friendAry.length; j++) {
								if (friendAry[j] == null && friendAry[j] != name) {
									friendAry[j] = name;
									System.out.println("이름 입력 성공");
									break;
								}
							}
							break;
						} else if (namecheck == 2) {
							break;
						}
					} else if (friendAry[i] == null && friendAry[i] != name) {
						friendAry[i] = name;
						System.out.println("이름 입력 성공");
						break;
					} 
				}
				break;
			case 2: // 목록 확인
				for (int i = 0; i < friendAry.length; i++) {
					if (friendAry[i] != null) {
						System.out.printf("[%d]번째 친구이름: %s\n", i+1, friendAry[i]);
					}
				}
				
				break;
			case 3: // 이름 삭제
				System.out.println("삭제할 이름 입력>> ");
				String name2 = scn.nextLine();				
				for (int i = 0; i < friendAry.length; i++) {
					if (friendAry[i] != null && friendAry[i].equals(name2)) {
						friendAry[i] = null;
						System.out.println("삭제 성공");
						break;
						
						}
					if (friendAry[i] != null && friendAry[i] != name2) {
						System.out.println("삭제할 이름 없음 ");
						break;
					}
				}
				
				break;
			case 4: // 종료
				run = !run;

			}
		}
		System.out.println("end of prog");
		
	} // end of test3()
	
	
	
	
	
}
// end of class
