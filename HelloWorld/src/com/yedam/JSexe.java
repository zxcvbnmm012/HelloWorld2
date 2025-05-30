package com.yedam;

import java.util.Scanner;
// java의 util 패키지에 있는 Scanner 클래스를 사용하겠다 -> import 해줌

public class JSexe {
	public static void main(String[] args) {
		test8();
	} // end of main()

// test1()
	public static void test1() { // main 에서 test 함수를 호출해서 실행
		int sum = 0;
		// 1 ~ 10 까지의 누적 반복문
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 1) { // 홀수 : 1, 3, 5, 7, 9
				sum += i;
			}
		}
		System.out.println("결과: " + sum);

	} // end of test()

// test2() : 평균 구하기	
	public static void test2() {
		// 임의의 수를 생성 : 1~100 사이의 임의의 값 생성
		int sum = 0;
		for (int i = 1; i <= 5; i++) {
			int result = (int) (Math.random() * 100) + 1; // 1 <= x < 11
			// Math.random() : 0 <= x < 1 범위의 실수를 생성하는 메소드
			// 실수를 생성하므로 int 타입으로 casting 필요
			sum += result;
		}
		System.out.println("결과: " + sum);

	} // end of test2()

// test3() : 평균 구하기 -> 소숫점 n 번째 자리까지 나타내기
	public static void test3() {
		int sum = 0;
		for (int i = 1; i <= 7; i++) {
			int r_num = (int) (Math.random() * 71) + 30;
			System.out.println("r_num: " + r_num);
			sum += r_num;
			System.out.println("sum: " + sum);

		}
		double avg = sum / 7.0;
		avg = Math.round(avg * 1000) / 1000.0; // 소수점 셋째자리까지 출력
		System.out.println("합계: " + sum + ", 평균: " + avg);

	} // end of test3()

	
	
	
// java 에서 문자열 생성하기
// 1) 리터럴 "" 사용  -> String 변수 = "문자열";
// 2) new 키워드 사용 -> String 변수 = new String("문자열");
// 1) vs 2) : 어느 곳에 메모리를 할당받아 저장하는지의 차이
// 1) heap 영역 내부의 String constant pool 영역에 메모리 할당
// 2) heap 영역에 메모리 할당
// https://rlaehddnd0422.tistory.com/184
	

// new 키워드
// 클래스명 참조변수명 = new 생성자();
// -> 생성자로 만든 객체를 힙 메모리에 넣고 위칫값을 클래스 타입의 참조변수에 저장하라
// new : 생성자의 결과물로 나온 객체를 힙 메모리에 넣음
// 참조변수에는 new를 통해 힙 메모리에 저장된 실제 객체의 위칫값이 저장됨
	
// test4() : scanner 사용하기
	public static void test4() {
		// int 값 비교 -> 비교 연산자
		int num1 = 30;
		int num2 = 30;
		System.out.println(num1 == num2);

		// string 값 비교 -> equals()
		String str1 = new String("Hello");
		String str2 = new String("Hello");
		System.out.println(str1.equals(str2)); // 문자값 비교 -> equals method 사용

		// string 값과 int 값 비교
		// 1) 숫자를 문자로 변환 : "" + 변수
		// 2) 문자를 숫자로 변환 : Integer.parseInt(변수)
		String str3 = "30";
		int num3 = 30;
		System.out.println(str3.equals("" + num3)); // int 타입의 num3를 string 타입으로 바꿈
		int num4 = Integer.parseInt(str3); // string 타입 str3를 문자열 숫자로 변환
		System.out.println(num3 == num4);

	} // end of test4()

// 다른 패키지에 있는 클래스 사용하기
// 1) import java.패키지.클래스명; -> 메인단 위에서 import 해주기
//    public static void 클래스() {
//         클래스명.변수;
// 2) public static void 클래스() {
//         java.패키지.클래스명;
	
	
// test5()
// 사용자의 입력값을 읽어들이기
	public static void test5() {
		Scanner scn = new Scanner(System.in); // system.in : 사용자로부터 입력
		// java의 util의 패키지에 있는 클래스인 Scanner를 scn이라는 이름으로 사용하겠다
		int sum = 0;
		for (int i = 1; i <= 3; i++) {
			System.out.println("학생의 점수를 입력 >>"); // system.out : 출력
			String value = scn.nextLine(); // 입력값을 문자열 형태로 변환
			int score = Integer.parseInt(value);
			sum += score;
		}
		double avg = sum / 3.0;
		avg = Math.round(avg * 100) / 100.0; // 소수점 둘째자리까지 출력
		System.out.println("합계: " + sum + ", 평균: " + avg);
	} // end of test5()
	
	
	
// test6()
	public static void test6() {
		Scanner scn = new Scanner(System.in);
		while (true) {
			System.out.println("메세지 입력. 종료하려면 quit >> ");
			String msg = scn.nextLine();  // 엔터를 치기 전까지의 문장 전체를 입력으로 받음
			if (msg.equals("quit")) {
				break;
			}
			System.out.println("입력한 값은 " + msg);
		}
		System.out.println("end of prog.");  // quit 누르면 while문 빠져나와서 실행됨
	} // end of test6()

	
	
// test7()
	public static void test7() {
		Scanner scn = new Scanner(System.in);
		String str = "친구목록은 ";
		boolean isFirst = true;  // 첫번째 입력값에만 처리를 해주기 위한 변수 선언
		while (true) {
			System.out.println("친구 이름을 입력하세요");
			String msg = scn.nextLine();
			if (msg.equals("quit")) {
				str += "입니다.";
				break;
			}
			if (isFirst) {
				str += msg;        // 첫번째 입력값이 들어오면 str에 추가하고
				isFirst = false;   // 변수를 false로 바꿔 두번째 입력값부터는 else에 조건을 받도록 한다
			} else {
				str += "," + msg;
			}
		}
		System.out.println(str);
	} // end of test7()
	
	
	
	
// test8() : 출력 method
// 1) print : 줄바꿈 없이 출력
// 2) printf : 뒤에 나열한 값을 매개값으로 받아 입력한 데이터타입으로 출력
// 3) println : 줄바꿈하여 출력
	public static void test8() {
		System.out.print("문자");  // print : 줄바꿈 없음
		System.out.print("문자");
		System.out.println("");

		System.out.printf("%s", "문자");           // printf : %s -> 문자 값을 매개값으로 받아 출력
		System.out.printf("%s %d", "문자", 30);    // printf : %d -> 10진수 값을 매개값으로 받아 출력
		System.out.printf("%s %d\n", "문자", 30);  // %d\n : 줄바꿈
		System.out.printf("%.2f\n", 30.3);        // %.2f : 실수 값을 매개값으로 받아 소수점 둘째자리까지 출력
		System.out.println("");
		
		
		System.out.println("안녕하세요. 김해민입니다");
		System.out.printf("%s %d %s", "나이는 ", 20, "세입니다.");
		System.out.printf("%s %.1f %s", "몸무게는 ", 67.8, "입니다.");
		
	} // end of test8()
} // end of class
