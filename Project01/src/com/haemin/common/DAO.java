package com.haemin.common;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.haemin.ClassApp;
import com.haemin.User;
import com.haemin.app.App;
import com.haemin.person.Member;
import com.haemin.person.Teacher;

// 기능 구현

public class DAO {
	static Scanner scn = new Scanner(System.in);
	static int memberId = 0;
	
	public static Member login(Member member) {
		if (!(SqlDAO.selectLogin(member))) {
			return null;
			
		} 
		return member;
	} // end of login()
	
	
	public static void join() {
		System.out.println(" ////////////////// 😎 회원가입 😎 /////////////////");

		System.out.println("회원 정보를 입력해주세요.");
		
		System.out.println("이름: ");
		String name = scn.nextLine();
		
		System.out.println("아이디: ");
		String id = scn.nextLine();

		System.out.println("비밀번호: ");
		String pw = scn.nextLine();

		System.out.println("주민번호(앞 6자리): ");
		int birth = Integer.parseInt(scn.nextLine());

		System.out.println("전화번호: ");
		String phone = scn.nextLine();
		
		++memberId;
		
		Member member = new Member(memberId, name, id, pw, birth, phone);
		System.out.printf("%d, %s, %s, %s, %d, %s", memberId, name, id, pw, birth, phone);
		SqlDAO.insert(member);
		

	} // end of join()
	
	
	public static void position(Member member) {
		User user = SqlDAO.selectUser(member);
		String username = user.getName();
		String position = user.getPosition();
		

		if (position.equals("회원")) {
			userMenu(user);
		} else if (position.equals("강사")) {
			teacherMenu(user);
		} else if (position.equals("관리자")) {
			managerMenu(user);
		}
	} // end of position()
	
	public static void userMenu(User user) {
		String username = user.getName();
		System.out.println("                        ◾");
		System.out.println("                        ◾");
		System.out.println("                        ◾");
		System.out.println("                        ◾");

		System.out.println();
		System.out.println(" 🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻");
		System.out.printf("              '%s'님은 '회원' 등급입니다.\n", username);
		System.out.printf("            '회원' 등급이 조회 가능한 메뉴입니다.\n");
		System.out.println();
		System.out.println("           ============================");
		System.out.println("                   🌞🌞 회원메뉴 🌞🌞        ");
		System.out.println("           ============================");
		System.out.println();
		System.out.println("               1.프로그램 소개 \n"
				         + "               2.프로그램 수강 신청 \n"
				         + "               3.회원 정보 수정");
		System.out.println();
		System.out.println("           ============================");

		System.out.printf("               ▶ 메뉴선택 :   ");

		
		int menu = Integer.parseInt(scn.nextLine());
		System.out.println();
		System.out.println("                        ◾");
		System.out.println("                        ◾");
		System.out.println("                        ◾");
		System.out.println("                        ◾");
		switch(menu) {
		case 1:
			introProg();
			break;
		case 2:
			application(user);
			break;
		}
	} // end of userMenu()
	
	public static User teacherMenu(User user) {
		String teachername = user.getName();
		System.out.println("                        ◾");
		System.out.println("                        ◾");
		System.out.println("                        ◾");
		System.out.println("                        ◾");

		System.out.println();
		System.out.println(" 🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻");
		System.out.printf("              '%s'님은 '강사' 등급입니다.\n", teachername);
		System.out.printf("              '강사' 등급이 조회 가능한 메뉴입니다.\n");
		System.out.println();
		System.out.println("           ============================");
		System.out.println("                   🌞🌞 강사메뉴 🌞🌞        ");
		System.out.println("           ============================");
		System.out.println();
		System.out.println("               1.프로그램 일정 \n"
				         + "               2.프로그램 회원 목록");
		System.out.println();
		System.out.println("           ============================");

		System.out.printf("               ▶ 메뉴선택 :   ");
		
		int menu = Integer.parseInt(scn.nextLine());
		System.out.println();
		System.out.println("                        ◾");
		System.out.println("                        ◾");
		System.out.println("                        ◾");
		System.out.println("                        ◾");
		String name = user.getName();
		Teacher teacher = new Teacher();
		teacher.setTeacherName(name);
		teacher = SqlDAO.teacherInfo(teacher);
		switch(menu) {
		case 1:
			String name2 = teacher.getTeacherName();
			List<ClassApp> list = new ArrayList<>();
			list = SqlDAO.t1Sql(name2);
			
			System.out.println(" 🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻");
			System.out.printf("'%s'님의 프로그램 일정입니다\n", name);
			showSchedProg(list);
			break;
		case 2:
			String className = teacher.getTeacherClass();
			List<Member> list2 = new ArrayList<>();
			list2 = SqlDAO.t2Sql(className);
			showMember(list2);
			break;
		}
		return user;
	} // end of teacherMenu()
	
	public static User managerMenu(User user) {
		String managername = user.getName();
		System.out.println("                        ◾");
		System.out.println("                        ◾");
		System.out.println("                        ◾");
		System.out.println("                        ◾");

		System.out.println();
		System.out.println(" 🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻");
		System.out.printf("              '%s'님은 '관리자' 등급입니다.\n", managername);
		System.out.printf("              '관리자' 등급이 조회 가능한 메뉴입니다.\n");
		System.out.println();
		System.out.println("           ============================");
		System.out.println("                   🌞🌞 관리자메뉴 🌞🌞        ");
		System.out.println("           ============================");
		System.out.println();
		System.out.println("               1.회원 관리 \n"
				         + "               2.강사 관리 \n"
				         + "               3.프로그램 관리");
		System.out.println();
		System.out.println("           ============================");

		System.out.printf("               ▶ 메뉴선택 :   ");
		
		int menu = Integer.parseInt(scn.nextLine());
		System.out.println();
		System.out.println("                        ◾");
		System.out.println("                        ◾");
		System.out.println("                        ◾");
		System.out.println("                        ◾");
		switch(menu) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		}
		return user;
	} // end of managerMenu()
	
	
	public static void introProg() {
		System.out.println();
		System.out.println(" 🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻");
		System.out.println("         🏠 해민 문화센터 프로그램을 소개합니다 🏠          ");

		System.out.println();
		
		boolean run = true;
		
		while(run) {
			System.out.println("           ============================");
			System.out.println("                  📝 센터 목록 📝");
			System.out.println("           ============================");
			System.out.println();
			System.out.println("               1. 스포츠센터 \n"
					         + "               2. 어린이센터 \n"
					         + "               3. 시니어센터 \n"
					         + "               4. 문화예술센터");
			System.out.println();
			System.out.println("           ============================");
			System.out.print("               ▶ 센터선택 :   ");
			int center = Integer.parseInt(scn.nextLine());
			
			switch(center) {
			case 1:
				System.out.println("           ============================");
				System.out.println("                  ⚽⚽ 스포츠센터 ⚽⚽       ");
				System.out.println("           ============================");
				System.out.println();
				System.out.println("               ✔ 수영 \n"
						         + "               ✔ 필라테스 \n"
						         + "               ✔ 요가 \n"
						         + "               ✔ 테니스");
				
				System.out.println();
				System.out.println("           ============================");
				System.out.println("       1.🏠 홈으로  2.⏪ 이전 페이지로  3.🌞 회원메뉴로  ");
				System.out.println();
				System.out.printf("         ▶ 선택 :");
				
				int selectNum = Integer.parseInt(scn.nextLine());
				switch(selectNum) {
				case 1:
					run = false;
					System.out.println();
					System.out.println("                        ◾");
					System.out.println("                        ◾");
					System.out.println("                        ◾");
					System.out.println("                        ◾");
					App.execute();
					break;
				case 2: 
					break;
				case 3:
 // ----------------------------- 작성해야함
				}
				break;
			case 2:
				System.out.println("           ============================");
				System.out.println("                  🐥🐤 어린이센터 🐥🐤        ");
				System.out.println("           ============================");
				System.out.println();
				System.out.println("               ✔ 엄마아빠랑 아기랑 \n"
						         + "               ✔ 숲속을 걸어요 \n"
						         + "               ✔ 오늘은 내가 요리왕 \n"
					             + "               ✔ Hello 친구들");
				
				System.out.println();
				System.out.println("           ============================");
				System.out.println("       1.🏠 홈으로  2.⏪ 이전 페이지로  3.🌞 회원메뉴로  ");
				System.out.println();
				System.out.printf("         ▶ 선택 :");
				
				selectNum = Integer.parseInt(scn.nextLine());
				switch(selectNum) {
				case 1:
					run = false;
					System.out.println();
					System.out.println("                        ◾");
					System.out.println("                        ◾");
					System.out.println("                        ◾");
					System.out.println("                        ◾");
					App.execute();
					break;
				case 2: 
					break;
				case 3:
 // ----------------------------- 작성해야함
				}
				
				break;
			case 3:
				System.out.println("           ============================");
				System.out.println("                  👵👴 시니어센터 👵👴       ");
				System.out.println("           ============================");
				System.out.println();
				System.out.println("               ✔ 도레미 합창단 \n"
						         + "               ✔ 스마트 디지털 교육 \n"
						         + "               ✔ 웰빙 라이프 \n"
						         + "               ✔ 치매야 가라!");
				
				System.out.println();
				System.out.println("           ============================");
				System.out.println("       1.🏠 홈으로  2.⏪ 이전 페이지로  3.🌞 회원메뉴로  ");
				System.out.println();
				System.out.printf("         ▶ 선택 :");
				
				selectNum = Integer.parseInt(scn.nextLine());
				switch(selectNum) {
				case 1:
					run = false;
					System.out.println();
					System.out.println("                        ◾");
					System.out.println("                        ◾");
					System.out.println("                        ◾");
					System.out.println("                        ◾");
					App.execute();
					break;
				case 2: 
					break;
				case 3:
 // ----------------------------- 작성해야함
				}
				
				break;
			case 4:
				System.out.println("           ============================");
				System.out.println("                  🎵🎵 문화예술센터 🎵🎵    ");
				System.out.println("           ============================");
				System.out.println();
				System.out.println("               ✔ Movie스타  \n"
						         + "               ✔ 도전! 클래식 마스터 \n"
						         + "               ✔ 독서로 마음 수련하기 \n"
						         + "               ✔ 종이접기야~놀자!");
				
				System.out.println();
				System.out.println("           ============================");
				System.out.println("       1.🏠 홈으로  2.⏪ 이전 페이지로  3.🌞 회원메뉴로  ");
				System.out.println();
				System.out.printf("         ▶ 선택 :");
				
				selectNum = Integer.parseInt(scn.nextLine());
				switch(selectNum) {
				case 1:
					run = false;
					System.out.println();
					System.out.println("                        ◾");
					System.out.println("                        ◾");
					System.out.println("                        ◾");
					System.out.println("                        ◾");
					App.execute();
					break;
				case 2: 
					break;
				case 3:
					
				}
				
				break;
				
				
			} // end of switch
		}
		

	} // end of introProg()
	
	
	public static void application(User user) {
		System.out.println();
		System.out.println(" 🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻");
		System.out.println("             🏠 프로그램 등록을 시작합니다 🏠          ");
		System.out.println();
		
		System.out.println("               📝 해민 문화센터 프로그램 목록           ");
		System.out.println("           ============================");
		System.out.println("                  ⚽⚽ 스포츠센터 ⚽⚽       ");
		System.out.println("           ============================");
		System.out.println();
		System.out.println("               ✔ 수영 \n"
				         + "               ✔ 필라테스 \n"
				         + "               ✔ 요가 \n"
				         + "               ✔ 테니스");
		
		System.out.println();
		System.out.println("           ============================");
		System.out.println("                  🐥🐤 어린이센터 🐥🐤        ");
		System.out.println("           ============================");
		System.out.println();
		System.out.println("               ✔ 엄마아빠랑 아기랑 \n"
				         + "               ✔ 숲속을 걸어요 \n"
				         + "               ✔ 오늘은 내가 요리왕 \n"
				         + "               ✔ Hello 친구들");
		
		System.out.println();
		System.out.println("           ============================");
		System.out.println("                  👵👴 시니어센터 👵👴       ");
		System.out.println("           ============================");
		System.out.println();
		System.out.println("               ✔ 도레미 합창단 \n"
				         + "               ✔ 스마트 디지털 교육 \n"
				         + "               ✔ 웰빙 라이프 \n"
				         + "               ✔ 치매야 가라!");
		
		System.out.println();
		System.out.println("           ============================");
		System.out.println("                  🎵🎵 문화예술센터 🎵🎵    ");
		System.out.println("           ============================");
		System.out.println();
		System.out.println("               ✔ Movie스타  \n"
				         + "               ✔ 도전! 클래식 마스터 \n"
				         + "               ✔ 독서로 마음 수련하기 \n"
				         + "               ✔ 종이접기야~놀자!");
		
		System.out.println();
		System.out.println("           ============================");
		
		System.out.println();
		System.out.println(" ////////////////// 😎 수강신청 😎 /////////////////");
		System.out.print("               ▶ 수강 과목 :   ");
		
		String selectClass = scn.nextLine();
		
		System.out.println();
		System.out.println("                        ◾");
		System.out.println("                        ◾");
		System.out.println("                        ◾");
		System.out.println("                        ◾");
		System.out.println();
		System.out.println("           ============================");
		System.out.printf("                 📌 '%s' 시간표\n", selectClass);
		System.out.println("           ============================");
		
		List<ClassApp> list = SqlDAO.selectClass(selectClass);
		showSchedProg(list);
		User user3 = new User();
		user3 = classIf(selectClass, user);
		SqlDAO.appInsertSql(user3);

//		System.out.println();
//		System.out.println("           ============================");
//		System.out.println("               1.♥ 수강신청하기 2.🏠 홈으로");
//		System.out.println();
//		System.out.printf("         ▶ 선택 :");
		
//		int selectNum = Integer.parseInt(scn.nextLine());
//		switch(selectNum) {
//		case 1:
//			System.out.println();
//			System.out.println("                        ◾");
//			System.out.println("                        ◾");
//			System.out.println("                        ◾");
//			System.out.println("                        ◾");
//			appInsert(user);
//			break;
//		case 2: 
//			App.execute();
//
//			break;
//		case 3:
//// ----------------------------- 작성해야함
//		} // end of switch
//		
		
	} // end of application
	
	public static void showSchedProg(List<ClassApp> list) {
		for (ClassApp cla : list) {
		    System.out.printf(" %10s |강좌명: %10s |분반: %6s |요일: %5s |시간: %6s |금액: %8d원 |강사: %5s |수강신청: %7d/%d명\n",
		    	cla.getClassCenter(),
		    	cla.getClassName(),
		        cla.getClassLevel(),
		        cla.getClassDate(),
		        cla.getClassTime(),
		        cla.getClassFee(),
		        cla.getClassTeacher(),
		        cla.getClassNow(),
		        cla.getClassLimit());
		}
	} // end of showSchedProg()
	
//	public static void appInsert(User user) {
//		SqlDAO.appInsertSql(user);
//	}
	
	public static User classIf(String selectClass, User user) {
		String classLevel;
		User user2 = new User();
		if(selectClass.equals("수영")) {
			System.out.printf("               ▶ 반_난이도 :   ");
			classLevel = scn.nextLine();
			user2.setUserClassLevel(classLevel);
		} else if(selectClass.equals("필라테스")) {
			System.out.printf("               ▶ 반_난이도 :   ");
			classLevel = scn.nextLine();
			user2.setUserClassLevel(classLevel);
		} else if (selectClass.equals("요가")) {
			System.out.printf("               ▶ 반_난이도 :   ");
			classLevel = scn.nextLine();
			user2.setUserClassLevel(classLevel);
		} else if(selectClass.equals("테니스")) {
			System.out.println("               ▶ 반_난이도 :   ");
			classLevel = scn.nextLine();
			user2.setUserClassLevel(classLevel);
		}
		user2.setName(user.getName());
		user2.setUserClassName(selectClass);
		return user2;
	} // end of classIf()
	
	
	public static void showMember(List<Member> list) {
		for (Member member : list) {
		    System.out.printf(" 회원번호: %3d |이름: %6s |전화번호: %15s |수강강좌: %20s |분반: %10s\n",
		    	member.getMemberId(),
		    	member.getMemberName(),
		        member.getMemberPhone(),
		        member.getMemberClassName(),
		        member.getMemberClassLevel());

		}
	} // end of showSchedProg()
	
	public static void managerMenu(Member member) {
		
	} // end of managerMenu()
	


} // end of class
