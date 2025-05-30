package com.yedam.ref;

/* 
 * 2차원 배열
 * intAry[2][3]
 */

public class ArrayExe2 {
	public static void main(String[] args) {

		test2();

	} // end of main
	
	
	
	
// test1()
	public static void test1() {
		int[][] intAry = {{17, 22, 31}, {28, 38, 12}};
		// 1행과 2행의 열(요소)의 개수는 다를 수 있음 -> {{17, 22, 31, 55, 63}, {28, 38, 12}}
		// intAry[0] => { 17, 22, 31 }; intAry[0][0]
		// intAry[1] => { 28, 38, 12 }; intAry[1][1]
		
		intAry[0][2] = 44; // 31 -> 44 로 값을 변경
		
		for(int outer = 0; outer < intAry.length; outer++) {
			for(int inner = 0; inner < intAry[outer].length; inner++) {
				System.out.printf("intAry[%d][%d] => %d \n", outer, inner, intAry[outer][inner]);
			} // end of for(inner)
		} // end of for(outer)
	
	} // end of test1()
	
	
	
	
// test2() : 2차원 배열의 크기 지정 [3][4]
	public static void test2() {

		int[][] ary2 = new int[3][4];
		//    ary2[3][4]
		// [ ] [ ] [ ] [ ]
		// [ ] [ ] [ ] [ ] 
		// [ ] [ ] [ ] [ ] 
		
		for (int outer = 0; outer < ary2.length; outer++) {
			for(int inner = 0; inner < ary2[outer].length; inner++) {
				ary2[outer][inner] = (int)(Math.random() * 100)+1;
			} // end of for(inner)
		} // end of for(outer)
		
		for(int outer = 0; outer < ary2.length; outer++) {
			for(int inner = 0; inner < ary2[outer].length; inner++) {
				System.out.printf("intAry[%d][%d] => %d \n", outer, inner, ary2[outer][inner]);
			} // end of for(inner)
		} // end of for(outer)
		
		int sum = 0;
		for (int inner = 0; inner < ary2[1].length; inner++) {
			sum += ary2[1][inner];
		}
		System.out.printf("ary2[1]의 요소의 합: %d", sum);
		
	} // end of test2()
	
	
} // end of class
