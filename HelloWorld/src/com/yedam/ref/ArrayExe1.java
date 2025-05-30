package com.yedam.ref;

public class ArrayExe1 {
	public static void main(String[] args) {
		test8();
	} // end of main
	
// test1()	
	public static void test1() {
		int[] intAry = {10, 17, 22, 31, 55, 24};
		
		int max = 0;
		for (int i = 0; i < intAry.length; i++) {
			if (max < intAry[i]) {
				max = intAry[i];
			}
		}
		System.out.printf("최대값은 %d\n", max);
		
		if (max != 0) {
			return;
		}
		
		int sum = 0;
		int cnt = 0;
		for (int i = 0; i < intAry.length; i++ ) {
			if (intAry[i] % 2 == 0) {
				sum += intAry[i];
				cnt++;
				System.out.printf("sum: %d, i: %d, 값: %d\n", sum, i, intAry[i]);
			}
		}
		double avg = 1.0*sum/cnt;
		System.out.printf("평균: %.1f\n", avg);
		
	} // end of test1()
	
	
	
	
	
// test2() : p.183 5번
	public static void test2() {
		for ( int i = 0; i <= 4; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
	} // end of test2()
	
	
// test3() : p.183 6번
	public static void test3() {
			for (int i = 0; i <= 4 ; i++) {
				for ( int j = 4; j > i; j--) {
					System.out.print(" ");
				}
				for ( int z = 0; z <= i; z++) {
					System.out.print("*");
				}
				System.out.print("\n");
			}
			
	} // end of test3()
	
// test4()
	public static void test4() {
		for (int i = 0; i <= 4 ; i++) {
			for ( int j = 4; j > i; j--) {
				System.out.print("*");
			}
			for ( int z = 0; z <= i; z++) {
				System.out.print(" ");
			}
			System.out.print("\n");
		}
	} // end of test4()
	
	public static void test5() {
		for (int i = 1; i <= 4 ; i++) {
			for ( int j = 1; j <= 4; j++) {
				if (i+j >= 5) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			} System.out.print("\n");
		}
	} // end of test5()


	
// test6()	: p183 3번
	public static void test6() {
		while(true) {
			int num1 = (int)(Math.random()*6)+1;
			int num2 = (int)(Math.random()*6)+1;
			System.out.printf("(%d, %d)", num1, num2);
			System.out.println();
			
			if ((num1+num2) != 5) {
				continue;
			} else {
				break;
			}
		}
	} // end of test6()
	
	
// test7()
	public static void test7() {
		int[] intAry = { 10, 17, 22, 31, 55, 24 };
		int temp = 0;
		
		for (int j = 0; j < intAry.length - 1; j++) { // for1
			for (int i = 0; i < intAry.length - 1; i++) { // for2
				if (intAry[i] < intAry[i+1]) {
					temp = intAry[i];
					intAry[i] = intAry[i+1];
					intAry[i+1] = temp;
				} 
			} // end of for2
		} // end of for1
		
		for (int i = 0; i < intAry.length; i++) {
			System.out.printf("%d ", intAry[i]);
		}
	} // end of test7()
	
	
	
// test8()
	public static void test8() {
		int[] scoreAry = new int[10];
		for (int i = 0; i < 10; i++) {
			int num = (int)(Math.random()*91+10);
			scoreAry[i] = num;
		}
		
		int sum = 0; // 합
		for (int i = 0; i < scoreAry.length; i++) {
			sum += scoreAry[i];
		}
		
		int max = 0; // 최고점수
		for (int i = 0; i < scoreAry.length; i++) {
			if (max < scoreAry[i]) {
				max = scoreAry[i];
			}
		}
		
		int avg = sum / 10; // 평균
		
		System.out.printf("평균: %d, 최고점수: %d", avg, max);
	}
} // end of class

