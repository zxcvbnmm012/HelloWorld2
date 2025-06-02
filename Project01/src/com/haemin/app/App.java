package com.haemin.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.haemin.ClassApp;
import com.haemin.common.DAO;
import com.haemin.common.SqlDAO;
import com.haemin.person.Member;
import com.haemin.person.Teacher;

public class App {
	static Scanner scn = new Scanner(System.in);
	static boolean run = true;
	static boolean run2 = true;
	static int memberId = 0;
	static Member member = new Member();
	static String centerName = null;

	public static void execute() {

		System.out.println();
		System.out.println("                                                      ❤ WELCOME ❤");
		System.out.println("                                       __________________________________________");
		System.out.println("                                     /                                            \\");
		System.out.println("                                    /              🏠 해민 문화센터 홈페이지 🏠           \\");
		DAO.msg2();
		System.out.println();
		System.out.println("                                                     1. 😎 로그인");
		System.out.println("                                                     2. 😎 회원가입");
		System.out.println("                                                     3. 😎 프로그램 소개    \n");
		DAO.msg2();
		System.out.printf("                                                 ▶ 메뉴선택 :   ");
		int menu = Integer.parseInt(scn.nextLine());
		DAO.msg2();
		DAO.msg3();

		switch (menu) {
		case 1:
			login();
			break;
		case 2:
			DAO.msg2();
			System.out.println("                                                      😎 회원가입 😎 ");
			join();
			System.out.println("                                              환영합니다! 회원가입이 완료되었습니다.");
			DAO.msg3();
			member.setLoginId(null);
			execute();
			break;
		case 3:
			DAO.introProg(member);
			break;

		}

	} // end of execute()

	public static void login() {
		DAO.msg2();
		System.out.println("                                                      😎 로그인 😎 ");
		DAO.msg2();
		System.out.println();
		System.out.print("                                                   ▶ 아이디  :   ");
		String inputid = scn.nextLine();
		System.out.print("                                                   ▶ 비밀번호 :   ");
		String inputpw = scn.nextLine();
		System.out.println();
		DAO.msg2();
		System.out.println();

		member = new Member(inputid, inputpw);
		Member user = SqlDAO.selectUser(member);

		if (user == null) {
			System.out.println("                                               !! 회원정보가 일치하지 않습니다 !! ");
			System.out.println();
			DAO.msg2();
			System.out.println("                                      1.🏠 회원가입  2.⏪ 로그인 재시도  3.🌞 비밀번호 찾기  ");
			DAO.msg2();
			System.out.printf("                                       ▶ 메뉴선택 :   ");
			int menu = Integer.parseInt(scn.nextLine());
			DAO.msg2();
			DAO.msg3();

			switch (menu) {
			case 1:
				join();
				System.out.println("                                              환영합니다! 회원가입이 완료되었습니다.");
				break;
			case 2:
				login();
				break;
			case 3:
				DAO.msg2();
				System.out.println("                                                      😎 비밀번호 찾기 😎 ");
				DAO.msg2();
				System.out.println();
				System.out.println("                                                 !!  본인확인을 진행하겠습니다  !!");
				System.out.println();

				System.out.print("                                              ▶ 이름  :    ");
				String name = scn.nextLine();
				System.out.print("                                              ▶ 아이디 :    ");
				String id = scn.nextLine();

				member.setName(name);
				member.setLoginId(id);

				member = SqlDAO.findPw(member);
				DAO.msg2();
				System.out.println();
				System.out.println("                                                     !!  본인확인 완료  !!");
				DAO.msg3();
				DAO.msg2();
				System.out.printf("                                                 '%s' 님의 비밀번호 >> %s  \n",
						member.getName(), member.getLoginPw());
				DAO.msg2();

			} // end of switch
			DAO.msg3();
			execute();

		} else if (user != null) {
			System.out.println("                                                     !! 로그인 성공 !!");

			String name = user.getName();
			String permission = user.getPermission();
			DAO.msg3();

			System.out.println();
			DAO.msg2();
			System.out.println();

			System.out.printf("                                                 '%s'님은 '%s' 권한입니다.\n", name,
					permission);
			System.out.printf("                                               '%s' 권한이 조회 가능한 메뉴입니다.\n", permission);
			System.out.println();
			while (run) {
				DAO.msg2();
				System.out.printf("                                                    🌞🌞 %s 메뉴 🌞🌞        \n",
						permission);
				DAO.msg2();
				System.out.println();

				if (permission.equals("회원")) {
					DAO.msg4();
					System.out.println();
					DAO.msg2();
					DAO.MemberMenu(user);
				} else if (permission.equals("강사")) {
					DAO.msg5();
					System.out.println();
					DAO.msg2();
					DAO.teacherMenu(user);
				} else if (permission.equals("관리자")) {
					DAO.msg6();
					System.out.println();
					DAO.msg2();
					DAO.managerMenu(user);
				}

			}

		}
	} // end of login()

	public static void join() {
		DAO.msg2();
		System.out.println();
		System.out.println("                                               !!  회원 정보를 입력해주세요 !!");
		System.out.println();
		System.out.print("                                              ▶ 이름: ");
		String name = scn.nextLine();

		System.out.print("                                              ▶ 아이디: ");
		String id = scn.nextLine();

		System.out.print("                                              ▶ 비밀번호: ");
		String pw = scn.nextLine();

		System.out.print("                                              ▶ 주민번호(앞 6자리): ");
		String birth = scn.nextLine();

		System.out.print("                                              ▶ 전화번호: ");
		String phone = scn.nextLine();
		System.out.println();

		memberId = SqlDAO.selectMemberId();
		memberId++;

		member = new Member(memberId, name, id, pw, birth, phone);
		DAO.join(member);

		System.out.println();
		DAO.msg2();
		System.out.println();

	} // end of join()

	public static int selectMenu() {
		System.out.printf("                                                 ▶ 메뉴선택 :   ");
		int menu = Integer.parseInt(scn.nextLine());
		DAO.msg2();
		DAO.msg3();
		return menu;
	}

	public static void manager1() {
		run2 = true;
		while (run2) {
			List<Member> member = new ArrayList<>();

			DAO.msg2();
			System.out.println("                                                      😎 회원 관리 😎");
			DAO.msg2();
			System.out.println();
			System.out.println("                                                   1.회원 추가 \n"
					+ "                                                   2.회원 삭제 \n"
					+ "                                                   3.회원 정보 수정 \n"
					+ "                                                   4.회원 목록");
			System.out.println();
			DAO.msg2();
			System.out.print("                                                ▶ 선택 :   ");
			int menu = Integer.parseInt(scn.nextLine());
			DAO.msg2();

			DAO.msg3();

			switch (menu) {
			case 1:
				DAO.msg2();
				System.out.println("                                                      😎 회원 추가 😎 ");
				join();
				System.out.printf("                                                   !!  회원 정보 추가 완료  !!");
				System.out.println();
				break;

			case 2:
				DAO.msg2();
				System.out.println("                                                      😎 회원 삭제 😎");
				DAO.msg2();

				System.out.println();
				System.out.println("                                              !!  삭제할 회원 이름을 입력해주세요  !!");
				System.out.println();
				System.out.print("                                                ▶ 이름: ");
				String name = scn.nextLine();
				System.out.println();
				DAO.msg2();

				DAO.removeMember(name);
				System.out.println();
				System.out.printf("                                               !!  '%s' 회원 정보 삭제 완료  !!", name);
				System.out.println();
				break;
			case 3:
				DAO.msg2();
				System.out.println("                                              !!  수정할 회원 정보를 입력해주세요  !!");
				DAO.msg2();
				System.out.println();
				System.out.print("                                         ▶ 회원 이름 :   ");
				name = scn.nextLine();
				System.out.print("                                         ▶ 수정할 항목 :  ");
				String col = scn.nextLine();
				System.out.print("                                         ▶ 수정할 값 :    ");
				String newData = scn.nextLine();
				System.out.println();
				DAO.msg2();
				System.out.println();
				System.out.printf("                                              !!  '%s' 회원 정보 수정 완료  !!", name);
				System.out.println();
				member = DAO.modifyMember(name, col, newData);
				System.out.println();
				
				DAO.showMember(member);
				
				break;
			case 4:
				DAO.msg2();
				System.out.print("                                               🌞🌞 해민 문화센터 '회원' 목록 🌞🌞        \n");
				DAO.msg2();
				member = SqlDAO.memberTable();
				System.out.println();
				DAO.showMember(member);
				
				break;
			}
			System.out.println();
			DAO.msg2();
			System.out.println("                                        1.🏠 홈으로  2.⏪ 이전 페이지로  3.🌞 관리자 메뉴로  ");
			DAO.msg2();
			System.out.printf("                                         ▶ 선택 :    ");
			int selectNum = Integer.parseInt(scn.nextLine());
			DAO.msg2();
			DAO.msg3();

			switch (selectNum) {
			case 1:
				run = false;
				DAO.msg2();
				App.execute();
				break;
			case 2:
				break;
			case 3:
				run2 = false;
				break;
			}
		}
	}

	public static void manager2() {
		run2 = true;
		while (run2) {

			List<Teacher> teacher = new ArrayList<>();
			DAO.msg2();
			System.out.println("                                                      😎 강사 관리 😎");
			DAO.msg2();
			System.out.println();
			System.out.println("                                                   1.강사 추가 \n"
					+ "                                                   2.강사 삭제 \n"
					+ "                                                   3.강사 정보 수정 \n"
					+ "                                                   4.강사 목록");
			System.out.println();
			DAO.msg2();
			System.out.print("                                                ▶ 선택 :   ");
			int menu = Integer.parseInt(scn.nextLine());
			DAO.msg2();

			DAO.msg3();
			switch (menu) {
			case 1:
				DAO.msg2();
				System.out.println("                                                      😎 강사 추가 😎");
				joinTeacher();
				break;
			case 2:
				
				DAO.msg2();
				System.out.println("                                                      😎 강사 삭제 😎");
				DAO.msg2();
				System.out.println();
				System.out.println("                                              !!  삭제할 강사 이름을 입력해주세요  !!");
				System.out.println();
				System.out.print("                                                ▶ 강사 이름: ");
				String name = scn.nextLine();
				System.out.println();
				DAO.msg2();
				System.out.println();
				DAO.removeTeacher(name);
				System.out.printf("                                               !!  '%s' 강사 정보 삭제 완료  !!", name);
				System.out.println();
				break;

			case 3:
				DAO.msg2();
				System.out.println("                                                      😎 강사 수정 😎");
				DAO.msg2();
				System.out.println();
				System.out.println("                                              !!  수정할 강사 정보를 입력해주세요  !!");
				System.out.println();
				System.out.print("                                         ▶ 강사 이름  :    ");
				name = scn.nextLine();
				System.out.print("                                         ▶ 수정할 항목 :   ");
				String col = scn.nextLine();
				System.out.print("                                         ▶ 수정할 값  :    ");
				String newData = scn.nextLine();
				System.out.println();
				DAO.msg2();
				System.out.println();
				System.out.printf("                                              !!  '%s' 강사 정보 수정 완료  !!", name);
				System.out.println();
				teacher = DAO.modifyTeacher(name, col, newData);
				System.out.println();
				DAO.showTeacher(teacher);
				System.out.println();
				
				break;
			case 4:
				DAO.msg2();
				System.out.print("                                               🌞🌞 해민 문화센터 '강사' 목록 🌞🌞        \n");
				DAO.msg2();

				teacher = SqlDAO.teacherTable();
				System.out.println();
				DAO.showTeacher(teacher);
				System.out.println();
				
				break;
			}
			System.out.println();
			DAO.msg2();
			System.out.println("                                        1.🏠 홈으로  2.⏪ 이전 페이지로  3.🌞 관리자 메뉴로  ");
			DAO.msg2();
			System.out.printf("                                         ▶ 선택 :    ");
			int selectNum = Integer.parseInt(scn.nextLine());
			DAO.msg2();
			DAO.msg3();

			switch (selectNum) {
			case 1:
				run = false;
				DAO.msg2();
				App.execute();
				break;
			case 2:
				break;
			case 3:
				run2 = false;
				break;
			}
		}
	}

	public static void joinTeacher() {
		DAO.msg2();
		System.out.println();
		System.out.println("                                               !!  추가할 강사 정보를 입력해주세요 !!");
		System.out.println();
		System.out.print("                                              ▶ 이름:    ");
		String name = scn.nextLine();

		System.out.print("                                              ▶ 아이디:   ");
		String id = scn.nextLine();

		System.out.print("                                              ▶ 비밀번호:  ");
		String pw = scn.nextLine();

		System.out.print("                                              ▶ 주민번호(앞 6자리): ");
		String birth = scn.nextLine();

		System.out.print("                                              ▶ 전화번호:  ");
		String phone = scn.nextLine();
		System.out.println();

		Teacher teacher = new Teacher(name, id, pw, birth, phone);
		SqlDAO.insertTeacher(teacher);

		System.out.println();
		DAO.msg2();
		System.out.println();
		System.out.printf("                                                !!  '%s' 강사 정보 추가 완료  !!", name);
		System.out.println();
		System.out.println();
		DAO.msg2();
		System.out.println();
		DAO.showTeacher(SqlDAO.teacherTable());

	} // end of join()

	public static void manager3() {
		run2 = true;
		DAO.msg2();
		while (run2) {

			System.out.println("                                                      😎 프로그램 관리 😎");
			DAO.msg2();
			System.out.println();
			System.out.println("                                                   1.프로그램 수정 \n"
					+ "                                                   2.프로그램 목록");
			System.out.println();
			DAO.msg2();
			System.out.print("                                                ▶ 선택 :   ");
			int menuprog = Integer.parseInt(scn.nextLine());
			DAO.msg2();

			DAO.msg3();
			switch(menuprog) {
			case 1:
				System.out.println();
				System.out.println("                                                      📝 센터 목록 📝");
				DAO.msg2();
				System.out.println();
				List<ClassApp> list = SqlDAO.Center();
				DAO.showClassCenter(list);
				System.out.println();
				DAO.msg2();
				System.out.print("                                               ▶ 센터선택 :   ");
				int center2 = Integer.parseInt(scn.nextLine());

				switch (center2) {
				case 1:
					centerName = "스포츠센터";
					break;
				case 2:
					centerName = "어린이센터";
					break;
				case 3:
					centerName = "시니어센터";
					break;
				case 4:
					centerName = "문화예술센터";
					break;
				}
				DAO.msg2();
				DAO.msg3();
				List<ClassApp> list2 = SqlDAO.selectProg(centerName);
				DAO.showSchedProg(list2);
				DAO.msg2();
				System.out.println("                                                      😎 프로그램 수정 😎");
				DAO.msg2();
				System.out.println();

				System.out.println("                                          !!  수정할 프로그램 정보를 입력해주세요  !!");
				System.out.println();
				System.out.print("                                         ▶ 수정할 프로그램 :  ");
				String prog = scn.nextLine();
				System.out.print("                                         ▶ 수정할 분반 :  ");
				String level = scn.nextLine();
				System.out.print("                                         ▶ 수정할 항목 :  ");
				String col = scn.nextLine();
				System.out.print("                                         ▶ 수정할 값 :  ");
				String newData = scn.nextLine();
				System.out.println();
				DAO.msg2();
				DAO.msg3();
				DAO.msg2();
				System.out.println();
				System.out.println("                                              !!  프로그램 정보 수정 완료  !!");


				list2 = DAO.modifyProg(prog, level, col, newData);
				System.out.println();
				DAO.showSchedProg(list2);
				break;
			case 2:
				DAO.msg2();
				System.out.print("                                               🌞🌞 해민 문화센터 '프로그램' 목록 🌞🌞        \n");
				DAO.msg2();

				list2 = SqlDAO.classTable();
				System.out.println();
				DAO.showSchedProg(list2);
			}
			
			DAO.msg2();
			System.out.println("                                        1.🏠 홈으로  2.⏪ 이전 페이지로  3.🌞 관리자 메뉴로  ");
			DAO.msg2();
			System.out.printf("                                         ▶ 선택 :    ");
			int selectNum = Integer.parseInt(scn.nextLine());
			DAO.msg2();
			DAO.msg3();

			switch (selectNum) {
			case 1:
				run = false;
				DAO.msg2();
				App.execute();
				break;
			case 2:
				break;
			case 3:
				run2 = false;
				break;
			}
		}

	}

}
