package com.yedam.api;

public class StringUtil {

	public static String getGender(String string) {
		String male = "남자";
		String female = "여자";
		int num = 6;
		while(true) {
			char checknum = string.charAt(num);
			if (checknum == '1'|| checknum == '3') {
				return male;
				
			} else if (checknum == '2' || checknum == '4') {
			} else {
				num += 1;
				continue;
			}
		return female;
		
		}
	}

	// 교수님 코드 확인하기
	public static Object getExtName(String string) {
		// substring('.')
		// lastindexOf() : 뒤에서부터 찾음
		int num1 = string.indexOf("jpeg");
		int num2 = string.indexOf("jpg");
		int num3 = string.indexOf("png");
		
		if (num1 > 0) {
			return "jpeg";
			
		} else if (num2 > 0) {
			return "jpg";
			
		} else if (num3 > 0) {
		}
		return "png";
	}

}
