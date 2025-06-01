package com.haemin.common;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.haemin.ClassApp;
import com.haemin.app.App;
import com.haemin.person.Member;
import com.haemin.person.Teacher;

// 기능 구현

public class DAO {
	static Scanner scn = new Scanner(System.in);	
	
	public static void join(Member member) {
		SqlDAO.insert(member);
		

	} // end of join()

	public static void removeTeacher(String name) {
		SqlDAO.deleteTeacher(name);
	}
	
	public static void removeMember(String name) {
		SqlDAO.deleteMember(name);
	}
	
	public static void MemberMenu(Member member) {
		int menu = App.selectMenu();
		
		switch(menu) {
		case 1:
			introProg(member);
			break;
		case 2:
			application(member);
			break;
		case 3:
			msg2();
			System.out.println("                                             !!  수정할 회원 정보를 입력해주세요  !!");
			msg2();
			System.out.println();
			String name = member.getName();
			System.out.print("                                               ▶ 수정할 항목 :  ");
			String col = scn.nextLine();
			System.out.print("                                               ▶ 수정할 값 :    ");
			String newData = scn.nextLine();
			System.out.println();
			msg2();
			List<Member> listMember = new ArrayList<>();
			listMember = DAO.modifyMember(name, col, newData);
			System.out.println();
			showMember(listMember);
			System.out.println();
			msg2();
			System.out.println();
			System.out.printf("                                          !! '%s' 님의 회원 정보를 수정했습니다  !!           ", name);
			System.out.println();
			msg3();
			
			break;
		case 4:
			msg2();
			System.out.println("                                                    !! 로그아웃 완료  !!           ");
			msg2();
			System.out.println();
			msg3();
			App.execute();
			break;
		}
	} // end of MemberMenu()
	
	public static Member teacherMenu(Member member) {
		String name = member.getName();
		Teacher teacher = new Teacher();
		teacher.setTeacherName(name);
		teacher = SqlDAO.teacherInfo(teacher);
		
		int menu = App.selectMenu();
		boolean run = true;
		
		while(run) {
			switch(menu) {
			case 1:
				String name2 = teacher.getTeacherName();
				List<ClassApp> list = new ArrayList<>();
				list = SqlDAO.t1Sql(name2);
				
				msg2();
				System.out.printf("                                              '%s'님의 프로그램 일정입니다\n", name);
				msg2();
				System.out.println();
				showSchedProg(list);
				
				break;
			case 2:
				String className = teacher.getTeacherClass();
				List<Member> list2 = new ArrayList<>();
				list2 = SqlDAO.t2Sql(className);
				msg2();
				System.out.printf("                                             '%s'님의 프로그램 회원 목록입니다\n", name);
				msg2();
				System.out.println();
				showMember(list2);
				System.out.println();
				break;
			case 3:
				msg2();
				System.out.println("                                                    !! 로그아웃 완료  !!           ");
				msg2();
				System.out.println();
				msg3();
				App.execute();
				break;
				
			}
			msg2();
			System.out.println("                                               1.🏠 홈으로  2.🌞 강사메뉴로  ");
			msg2();
			System.out.printf("                                               ▶ 선택 :    ");
			int selectNum = Integer.parseInt(scn.nextLine());
			msg2();
			msg3();
			
			switch(selectNum) {
			case 1:
				run = false;
			
				App.execute();
				break;
			case 2:
				run = false;
				break;
			}
			
		}
		return member;
	} // end of teacherMenu()
	
	public static Member managerMenu(Member member) {
		String name = member.getName();

		int menu = App.selectMenu();
		
		switch(menu) {
		case 1:
			App.manager1();
			break;
		case 2:
			App.manager2();
			break;
		case 3:
			App.manager3();
			break;
		case 4:
			msg2();
			System.out.println("                                                    !! 로그아웃 완료  !!           ");
			msg2();
			System.out.println();
			msg3();
			App.execute();
			break;
		}
		return member;
	} // end of managerMenu()
	
	
	public static void introProg(Member member) {
		System.out.println();
		msg2();
		System.out.println("                                             🏠 해민 문화센터 프로그램을 소개합니다 🏠          ");

		
		boolean run = true;
		
		while(run) {
			msg2();
			System.out.println("                                                      📝 센터 목록 📝");
			msg2();
			System.out.println();
			List<ClassApp> list = SqlDAO.Center();
			showClassCenter(list);
			System.out.println();
			msg2();
			System.out.print("                                               ▶ 센터선택 :   ");
			int center = Integer.parseInt(scn.nextLine());
			msg2();
			msg3();
			
			switch(center) {
			case 1:
				msg2();
				System.out.println("                                                   ⚽⚽ 스포츠센터 ⚽⚽       ");
				msg2();
				System.out.println();
				String selectCenter = "스포츠센터";
				list = SqlDAO.selectCenter(selectCenter);
				showClassList(list);
				
				break;
			case 2:
				msg2();
				System.out.println("                                                   🐥🐤 어린이센터 🐥🐤        ");
				msg2();
				System.out.println();
				selectCenter = "어린이센터";
				list = SqlDAO.selectCenter(selectCenter);
				showClassList(list);
			
				break;
			case 3:
				msg2();
				System.out.println("                                                   👵👴 시니어센터 👵👴       ");
				msg2();
				System.out.println();
				selectCenter = "시니어센터";
				list = SqlDAO.selectCenter(selectCenter);
				showClassList(list);
				
				
				break;
			case 4:
				msg2();
				System.out.println("                                                    🎵🎵 문화예술센터 🎵🎵    ");
				msg2();
				System.out.println();
				selectCenter = "문화예술센터";
				list = SqlDAO.selectCenter(selectCenter);
				showClassList(list);
				
				break;
				
				
			} // end of switch
			System.out.println();
			msg2();
			if(member.getLoginId() != null) {
				System.out.println("                                        1.🏠 홈으로  2.⏪ 이전 페이지로  3.🌞 회원메뉴로  ");
				msg2();
				System.out.printf("                                         ▶ 선택 :    ");
				int selectNum = Integer.parseInt(scn.nextLine());
				msg2();
				msg3();
				
				switch(selectNum) {
				case 1:
					run = false;
					msg2();
					App.execute();
					break;
				case 2: 
					break;
				case 3:
					run = false;
					break;
				}
			} // end of if(member != null)
			else if(member.getLoginId() == null) {
				System.out.println("                                                1.🏠 홈으로  2.⏪ 이전 페이지로  ");
				msg2();
				System.out.printf("                                               ▶ 선택 :    ");
				int selectNum = Integer.parseInt(scn.nextLine());
				msg2();
				msg3();
				
				switch(selectNum) {
				case 1:
					run = false;
					msg2();
					App.execute();
					break;
				case 2: 
					break;
				}
			} // end of else if(member == null)
			
		} // end of while
		

	} // end of introProg()
	
	
	public static void application(Member member) {
		System.out.println();
		System.out.println("                                             🏠 프로그램 수강 신청을 시작합니다 🏠          ");
		msg2();
		System.out.println();		
		System.out.println("                                         !! 강좌명을 확인하고 수강 신청을 진행해주세요  !!           ");
		System.out.println("                                                 해민 문화센터 프로그램 목록           ");
		System.out.println();
		msg2();
		System.out.println("                                                  ⚽⚽ 스포츠센터 ⚽⚽       ");
		msg2();
		System.out.println();
		String selectCenter = "스포츠센터";
		List<ClassApp>list = SqlDAO.selectCenter(selectCenter);
		showClassList(list);
		
		System.out.println();
		msg2();
		System.out.println("                                                  🐥🐤 어린이센터 🐥🐤        ");
		msg2();
		System.out.println();
		selectCenter = "어린이센터";
		list = SqlDAO.selectCenter(selectCenter);
		showClassList(list);
		
		System.out.println();
		msg2();
		System.out.println("                                                  👵👴 시니어센터 👵👴       ");
		msg2();
		System.out.println();
		selectCenter = "시니어센터";
		list = SqlDAO.selectCenter(selectCenter);
		showClassList(list);
		
		System.out.println();
		msg2();
		System.out.println("                                                  🎵🎵 문화예술센터 🎵🎵    ");
		msg2();
		System.out.println();
		selectCenter = "문화예술센터";
		list = SqlDAO.selectCenter(selectCenter);
		showClassList(list);
		System.out.println();
		msg2();
		msg3();
		
		msg2();
		System.out.println("                                                       😎 수강신청 😎 ");
		msg2();
		System.out.print("                                              ▶ 수강 과목 :   ");
		
		String selectClass = scn.nextLine();
		
		msg3();
		msg2();
		System.out.printf("                                                  📌 '%s' 시간표\n", selectClass);
		msg2();
		System.out.println();
		list = SqlDAO.selectClass(selectClass);
		showSchedProg(list);
		Member member3 = new Member();
		member3 = classIf(selectClass, member);
		SqlDAO.appInsertSql(member3);
		msg2();
		System.out.println();
		System.out.println("                                                   !! 수강 신청 완료  !!");
		System.out.println("                                           !! 해민 문화센터를 이용해주셔서 감사합니다  !!");
		System.out.println();
		msg3();
		

		
	} // end of application
	
	public static void showClassCenter(List<ClassApp> list) {
		int i = 1;
		for (ClassApp cla : list) {
			System.out.printf("                                                  %d. %s\n", i++, cla.getClassCenter());
		}
	}
	
	public static void showClassList(List<ClassApp> list) {
		int i = 1;
		for (ClassApp cla : list) {
			System.out.printf("                                                  %d. %s\n", i++, cla.getClassName());
		}
	}
	
	
	public static void showSchedProg(List<ClassApp> list) {
		for (ClassApp cla : list) {
		    System.out.printf(" %10s |'강좌명': %10s |'분반': %5s |'요일': %5s |'시간': %6s |'금액': %7s원 |'강사': %5s |'수강신청현황': %3d/%s명\n",
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
		System.out.println();
	} // end of showSchedProg()
	
//	public static void appInsert(Member member) {
//		SqlDAO.appInsertSql(Member);
//	}
	
	public static Member classIf(String selectClass, Member member) {
		String classLevel;
		Member member2 = new Member();
		msg2();
		System.out.printf("                                               ▶ 분반 :    ");
		classLevel = scn.nextLine();
		member2.setClassLevel(classLevel);
		member2.setName(member.getName());
		member2.setClassName(selectClass);
		return member2;
	} // end of classIf()
	
	
	public static void showMember(List<Member> list) {
		for (Member member : list) {
		    System.out.printf("         '회원번호': %3d |'이름': %4s |'주민번호': %8s |'전화번호': %15s |'수강강좌': %10s |'분반': %5s\n",
		    	member.getId(),
		    	member.getName(),
		    	member.getBirth(),
		        member.getPhone(),
		        member.getClassName(),
		        member.getClassLevel());

		}
	} // end of showSchedProg()
	
	public static void showTeacher(List<Teacher> list) {
		for (Teacher teacher : list) {
		    System.out.printf(" '이름': %4s |'로그인아이디': %10s |'로그인비밀번호': %6s |'주민번호': %8s |'전화번호': %15s |'담당과목': %10s \n",
		    	teacher.getTeacherName(),
		    	teacher.getTeacherLoginId(),
		    	teacher.getTeacherLoginPw(),
		    	teacher.getTeacherBirth(),
		        teacher.getTeacherPhone(),
		        teacher.getTeacherClass());

		}
	} // end of showSchedProg()
	
	public static List<Member> modifyMember(String str1, String str2, String str3) {
		List<Member> member = SqlDAO.memberTable();
		member = SqlDAO.updateMember(str1, str2, str3);
		return member;

	}
	
	public static List<Teacher> modifyTeacher(String str1, String str2, String str3) {
		List<Teacher> teacher = SqlDAO.teacherTable();
		teacher = SqlDAO.updateTeacher(str1, str2, str3);
		return teacher;
		
	}
	public static List<ClassApp> modifyProg(String str1, String str2, String str3, String str4) {
		List<ClassApp> classApp = SqlDAO.classTable();
		classApp = SqlDAO.updateProg(str1, str2, str3, str4);
		
		return classApp;
		
	}
	
	public static void msg2() {
		System.out.println("                                   ==================================================");
	}
	
	public static void msg3() {
		System.out.println();
		System.out.println("                                                            ◾");
		System.out.println("                                                            ◾");
		System.out.println("                                                            ◾");
		System.out.println("                                                            ◾");
		System.out.println();
	}
	
	public static void msg4() {
		System.out.println("                                                    1.프로그램 소개 \n"
		                 + "                                                    2.프로그램 수강 신청 \n"
		                 + "                                                    3.회원 정보 수정 \n"
		                 + "                                                    4.로그아웃       ");
	}
	
	public static void msg5() {
		System.out.println("                                                    1.프로그램 일정 \n"
		                 + "                                                    2.프로그램 회원 목록 \n"
		                 + "                                                    3.로그아웃       ");
	}
	
	public static void msg6() {
		System.out.println("                                                    1.회원 관리 \n"
		                 + "                                                    2.강사 관리 \n"
		                 + "                                                    3.프로그램 관리 \n"
		                 + "                                                    4.로그아웃       ");

  	}
	
	

} // end of class
