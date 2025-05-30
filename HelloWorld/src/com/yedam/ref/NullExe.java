package com.yedam.ref;

public class NullExe {
	public static void main(String[] args) {
		test1();
	} // end of main()
	
	
	
	
// 배열 선언 방법
// 1) int[] ary = { 10, 20, 30 };
// 2) int ary[] = { 10, 20, 30 };
// 3) 변수 선언 후 값을 할당 int[] ary;
//                     ayr = new int[] { 10, 20, 30 };

	

// test1()
	public static void test1() {
		String str1 = "홍길동";
		String str2 = null;    // 참조하고 있는 값이 없음 : null
		// str.toString() -> NullPointerException 발생 : null은 toString을 사용할 수 없음

		// java 규칙 : 동일한 datatype의 값만 배열에 넣을 수 있음
		int[] ary = { 10, 20, 30 }; // 정수형 배열 ary 선언
		System.out.printf("ary 배열의 크기 %d\n", ary.length);
		System.out.println("");
		
		int[] intAry;
		intAry = new int[] { 40, 50, 60 }; // new int[] : 배열의 값을 담을 변수의 데이터타입이 배열임을 알려주는 키워드문 
		
		// 첫번째 위치의 40 => 400 변경
		intAry[0] = 400;
		
		// java 규칙 : 배열을 선언하면 배열의 크기가 고정됨
		// intAry[3] = 10; -> 크기를 벗어나서 값을 입력하면 오류 : ArrayIndexOurOfBoundsException...
		
		// 배열의 크기 조정 -> 새로 선언해야함
		// 배열에 값을 초기화하지 않으면 초기값인 0이 들어감 intAry -> { 0, 0, 0, 0, 0 }
        intAry = new int[5];  // intAry 배열의 크기를 5로 조정 
        intAry[0] = 40;
        intAry[1] = 50;
        intAry[2] = 60;
        intAry[3] = 10;		
		
		// for 반복문
		for (int i = 0; i < intAry.length ; i++) {
			System.out.printf("intAry [%d]번째의 값: %d\n", i, intAry[i]);
		}
		System.out.println("");
	
		// double 값을 담는 배열 db1Ary
		double[] db1Ary = { 10.2, 23.3, 34.5 };
		for (int i = 0; i < db1Ary.length ; i++) {
			System.out.printf("db1Ary [%d]번째의 값: %.1f\n", i, db1Ary[i]);
		}
		System.out.println("");

		// String 값을 담는 배열 strAry
		// 배열에 값을 초기화하지 않으면 null(빈공간) : strAry -> {  }
		String[] strAry = new String[10];
		for (int i = 0; i < strAry.length ; i++) {
			System.out.printf("strAry [%d]번째의 값: %s\n", i, strAry[i]);
		}
		System.out.println("");

	} // end of test1()

} // end of class
