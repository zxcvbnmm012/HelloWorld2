package com.haemin.app;

import java.util.Scanner;

import com.haemin.common.DAO;
import com.haemin.person.Member;

public class App {
	public static void execute() {
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		System.out.println();
		System.out.println("              🏠 해민 문화센터 홈페이지 🏠              ");
		System.out.println("==================================================");
		System.out.println();
		System.out.println(" ////////////////// 😎 로그인 😎 /////////////////");
		System.out.print("               ▶ 아이디 :   ");
		String inputid = scn.nextLine();
		System.out.print("               ▶ 비밀번호 :   ");
		String inputpw = scn.nextLine();
		System.out.println(" ///////////////////////////////////////////////");
		System.out.println();


		Member member = new Member(inputid, inputpw);
		
		
		if(DAO.login(member) == null) {
			System.out.println(" 🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻");
			System.out.println("             회원정보가 일치하지 않습니다");
			System.out.println("               다시 로그인 시도하세요!");
			System.out.println();
			System.out.println("                        ◾");
			System.out.println("                        ◾");
			System.out.println("                        ◾");
			System.out.println("                        ◾");
			execute();
			
		} else if (DAO.login(member) != null){
			DAO.position(member);
		}

	} // end of execute()
}
