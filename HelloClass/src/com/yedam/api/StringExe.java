package com.yedam.api;

public class StringExe {
	public static void main(String[] args) {
		String str1 = new String("Hello");
//		str1 = new String(new byte[] { 72, 101, 108, 108, 111 }); // 알파벳의 바이트 배열에 해당하는 값을 반환하여 문자열 만들기
		
		System.out.println(str1);
		
		// charAt(i) : 문자열에서 i번째 문자를 반환
		System.out.println(str1.charAt(0)); // 'H'
		System.out.println(str1.charAt(1)); // 'e'
		System.out.println(str1.charAt(2)); // 'l'
		System.out.println(str1.charAt(3)); // 'l'
		System.out.println(str1.charAt(4)); // 'o'
		
		// indexOf("문자") : 문자가 있는 인덱스 번호를 반환
		System.out.println(str1.indexOf("H")); // 0
		System.out.println(str1.indexOf("e")); // 1
		System.out.println(str1.indexOf("l")); // 2
		// 문자가 처음으로 나타나는 위치를 반환
		System.out.println(str1.indexOf("l")); // 2
		System.out.println(str1.indexOf("o")); // 4
		// 없는 문자는 -1을 반환
		System.out.println(str1.indexOf("k")); // -1
		
	}
}
