package com.yedam.api;

public class SystemExe {
	public static void main(String[] args) {
		long start = System.currentTimeMillis(); // 시스템의 현재 시간을 1/1000초로 표현 -> long 타입으로 반환
		System.out.println(start); // 1747964966279 => 1747964966초 60*60*24
		
		int sum = 0;
		for(int i = 0; i < 100000000; i++){
			sum += i;
		}
		long end = System.currentTimeMillis();
		System.out.printf("합계 %d, 걸린시간 0.0%d초\n", sum, (end - start));

		
		long start2 = System.nanoTime(); // 현재 시간을 1/10^초로 표현
		int sum2 = 0;
		for(int i = 0; i < 100000000; i++){
			sum2 += i;
		}
		long end2 = System.nanoTime();
		System.out.printf("합계 %d, 걸린시간 %d초\n", sum2, (end2 - start2));
		System.out.println();
		
		long time = 1747964917;
		long year = time / (60*60*24*365);
		long day = (time % (60*60*24*365)) / (60*60*24);
		long hour = ((time % (60*60*24*365)) % (60*60*24)) / (60*60);
		long minute = (((time % (60*60*24*365)) % (60*60*24)) % (60*60)) / 60;
		long second = (((time % (60*60*24*365)) % (60*60*24)) % (60*60)) % 60;
		
		System.out.printf("%d년 %d일 %d시 %d분 %d초", year, day, hour, minute, second);
	
	
	} // end of main
	
} // end of class

