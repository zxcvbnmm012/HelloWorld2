package com.yedam.operator;

public class OperatorExe {
	public static void main(String[] args) {
		test6();
	}

// test1() : 데이터타입	
// 정수 data type : 1) byte(1바이트) 2) short(2바이트) 3) int(4바이트) 4) long(8바이트) 
//	              5) char(2바이트) : 유니코드 형태로 데이터 저장 / 전 세계의 모든 문자를 정수타입으로 지정
	public static void test1() {
		byte num1 = -128; // byte : 8비트 중 맨 앞의 부호비트 1비트를 제외하고 숫자비트 7비트 (-128 ~ 127)
		num1 = 127;
		num1++;           // 127(01111111) + 1(00000001) => -128(10000000); 1의 보수
		System.out.println(num1);

		char ch1 = 'A'; // 66
		ch1 = 66; // 'B'
		ch1 = '가';
		ch1 = 0x29D7; // 16진수
		System.out.println((int) ch1);

		for (int i = 1; i <= 26; i++) {
			System.out.println(ch1++);
		}
	} // end of test1

	
	
	
// test2()	
// 정수형의 기본 타입은 int
	public static void test2() {
		byte num1 = 10;
		byte num2 = 20;
		byte sum = (byte) (num1 + num2); // 정수형 연산은 int 타입으로 바꿔서 연산함
		// 연산한 결과가 int 타입이므로 공간이 더 작은 byte 타입에 담을 수 없음 -> 형변환 필요
		System.out.println(sum);

		long num3 = 10000000000000L; // int 값의 범위를 넘는 수는 숫자 뒤에 L을 붙여줌
		long num4 = 100L; // long형 리터럴 값
		System.out.println(Long.MAX_VALUE); // Long 클래스가 가진 method

		System.out.println(Integer.MAX_VALUE); // int형의 클래스 Integer가 가진 method
	}// end of test2

	
	
	
// test3() : 증감연산자 / 논리부정연산자
	public static void test3() {
		int num1 = 10;
		int num2 = 20;
		
		int result = ++num1 + num2++;
		// ++num1 : num1에 1을 증가시킨 뒤 연산
		// num2++ : 연산을 하고 num2에 1을 증가
		System.out.printf("num1 => %d, num2 => %d, result => %d", num1, num2, result);
		
		boolean isTrue = true;
		if (!isTrue) {
			System.out.println("참입니다");  // 논리가 거짓이므로 출력 x
		}
		
		// (==의 부정 : !=), (>의 부정 : <=), (>=의 부정 : <)
		result = 30;
		if (!(result > 30)) {   // => (result <= 30)
			System.out.println("\nresult는 30보다 작음");
		}
		if (!(result >= 30)) {   // => (result < 30)
			System.out.println("\nresult는 30보다 작음");
		}
		if (num1 > 10) {
			System.out.printf("num1 => %d", num1); 
		}
		if (!(--num1 > 10)) {
			System.out.printf("\nnum1 => %d", num1); 
		}
		if (!(--num1 > 10|| num2 < 20)) {
			System.out.printf("\nnum1 => %d", num1); 
		}
	} // end of test3
	
	
	
	
	
// test4()	
	public static void test4() {
		boolean isTrue = true;
		for(int i = 1; i <= 10; i++) {
			if(isTrue) {
				System.out.printf("i값은 %d\n", i);
			}
			isTrue = !isTrue; // 토글(on <-> off) : true -> false, false -> true 변환
		}
	} // end of test4
	
	
	

//----------------------------------- 달력 만들기 ------------------------------------------//
	
// "월" 정보를 입력하면 "공란" 반환하는 메소드. getSpace()
// month를 매개변수로 받아 int 데이터타입을 반환하는 메소드 getSpace() 생성
	public static int getSpace(int month) {
		int space = 0;
		if(month == 3) {
			space = 6;
		} else if(month == 4){
			space = 2;
		} else if(month == 5) {
			space = 4;
		} else if(month == 7) {
			space = 2;
		}
		return space;
	} // end of getSpace()
	

	
// "월" 정보를 입력하면 마지막 날짜를 알려주는 메소드. getLastDate(월)
	public static int getLastDate(int month) {
		int lastDate = 31;
		switch(month) {
		case 2:
			lastDate = 28;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			lastDate = 30;
			break;
		}
		return lastDate;
	}
	
	
	
// test5()
	public static void test5() {
		// 달력 형태로 출력
		for(int day = 1; day <= 31; day++) {
			System.out.printf("%3d", day);  // 줄맞추기 -> %3d : 3자리에 표현
			if(day % 7 == 0) {
				System.out.println();
			}
		}
		
		System.out.println();
		System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
		
		// 공란을 포함해 달력 형태로 출력
		int mon = 7;  // 월 정보 입력하는 변수
		int space = getSpace(mon);      // 빈공간
		int lastDate = getLastDate(mon);  // 마지막 날짜
		for(int s = 1; s <= space; s++) {
			System.out.printf("%4s", " ");
		}
		for(int day2 = 1; day2 <=lastDate; day2++) {
			System.out.printf("%4d", day2);
			if((day2 + space) % 7 == 0) {
				System.out.println();
			}
		}
	} // end of test5()

// -------------------------------------------------------------------------------------- //	

	
	
	
	
// test6()
	public static void test6() {
		// if문으로 조건문
		String pass = "";
		int score = (int) (Math.random() * 100);
		if(score>60) {
			pass = "합격";
		} else {
			pass = "불합격";
		}
		System.out.printf("%d점은 %s\n", score, pass);
		
		// 삼항연산자로 조건문
		int score2 = (int) (Math.random() * 100);
		String pass2 ="";
		pass2 = (score2 > 60)?"합격":"불합격";
		System.out.printf("%d점은 %s\n", score2, pass2);
		
		
		// if문으로 조건문
		String pass3 = "";
		int score3 = (int) (Math.random() * 100);
		if(score3>60) {
			if(score3>=80) {
				pass3 = "우수";
			} else {
				pass3 = "합격";				
			}
		} else {
			pass3 = "불합격";
		}
		System.out.printf("%d점은 %s\n", score3, pass3);
		
		
		// 삼항연산자로 조건문
		int score4 = (int) (Math.random() * 100);
		String pass4 ="";
		pass4 = (score4 > 60)?(score4>=80)?"우수":"합격":"불합격";
		System.out.printf("%d점은 %s\n", score4, pass4);
		
		
		// if문으로 조건문
		String pass5 = "";
		int score5 = (int) (Math.random() * 100);
		if(score5>60) {
			if(score5>=80) {
				pass5 = "우수";
			} else {
				pass5 = "합격";				
			}
		} else {
			  if (score5>20) {
				pass5 = "불합격";
			} else {
				pass5 = "불불합격";
			}
		}
		System.out.printf("%d점은 %s\n", score5, pass5);
		
		
		// 삼항연산자로 조건문  
		int score6 = (int) (Math.random() * 100);
		String pass6 ="";
		pass6 = (score6>20)?(score6 > 60)?(score6>=80)?"우수":"합격":"불합격":"불불합격";
		System.out.printf("%d점은 %s\n", score6, pass6);
		
		
	} // end of test6()
	
	
	
	
} // end of class
