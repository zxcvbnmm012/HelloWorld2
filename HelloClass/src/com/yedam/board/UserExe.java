package com.yedam.board;

import java.util.Scanner;

/* 
 * User: 아이디, 비밀번호, 이름
 */

class User {
	private String userId;
	private String passwd;
	private String userName;

	public User(String userId, String passwd, String userName) {
		this.userId = userId;
		this.passwd = passwd;
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	};
}

public class UserExe {
	static User[] users = { new User("holy", "1111", "김영광"), new User("cutie", "2222", "홍예쁨"),
			new User("guest", "3333", "밤손님") };

//	login 내 코드
//	static boolean login(String uname, String passwd) {
//		Scanner scn = new Scanner(System.in);
//		for (int i = 0; i < 3; i++) {
//			System.out.println("아이디를 입력하세요>> ");
//			uname = scn.nextLine();
//
//			for (int j = 0; j < users.length; j++) {
//				if (users[j] != null && users[j].getUserId().equals(uname)) {
//					System.out.println("비밀번호를 입력하세요>> ");
//					passwd = scn.nextLine();
//					if (users[j].getPasswd().equals(passwd)) {
//						System.out.println("로그인 성공");
//						return true;
//
//					}
//					System.out.println("로그인 실패; 비밀번호가 다릅니다!");
//				} else {
//					break;
//				}
//			}
//		}
//		return false;
//	} // end of login

	
	
	static boolean login(String uname, String passwd) {
		// 매개값과 같은 User가 있는지 체크.
		for (int i = 0; i < users.length; i++) {
			if (users[i].getUserId().equals(uname)//
					&& users[i].getPasswd().equals(passwd)) {
				return true; // 아이디 & 비번이 정확.
			}
		}
		return false;
	}

} // end of UserExe
