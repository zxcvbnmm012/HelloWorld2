package com.yedam.ref.app;

import java.util.Scanner;

/*
 * 회원 추가, 수정, 삭제, 조회 기능
 * 1) 추가 
 *   - 아이디, 이름, 전화번호, 포인트
 * 2) 수정
 *   - 아이디를 입력받아 전화번호를 바꿈
 * 3) 삭제
 *   - 삭제할 아이디를 입력받아 삭제
 *   - 삭제할 아이디가 없으면 '찾는 아이디가 없습니다'
 * 4) 조회
 *   - 이름으로 조회  
 */
public class MemberExe {	
	public static void main(String[] args) {
		boolean run = true;
		Scanner scanner = new Scanner(System.in);
		Member[] members = new Member[10];
		Member member = new Member();
		// 클래스 : 객체를 만들기 위한 설계도
		// 클래스 변수 : 클래스로 선언한 변수, 해당 클래스의 객체 주소가 저장됨
		// new 연산자 : 객체 생성 연산자, 생성자를 호출, 객체 생성 주소를 리턴
		// 객체(클래스의 객체 : 인스턴스) : 클래스로부터 생성, new클래스()로 생성
		
		while(run) {
			System.out.println("1.회원추가 2.수정 3.삭제 4.조회 5.종료");
			System.out.println("선택>> ");
			int selectNo = Integer.parseInt(scanner.nextLine());
			
			if (selectNo == 2 || selectNo == 3 || selectNo == 4) {
				if (members == null) {
					System.out.println("회원정보를 추가하세요");
					continue;
				}
			}
			
			if (selectNo == 1) {
				member = new Member();
				
				System.out.println("추가할 회원 정보를 입력하세요");
				System.out.println("아이디>> ");
				String id = scanner.nextLine();
				member.id = id;
				
				System.out.println("이름>> ");
				String name = scanner.nextLine();
				member.name = name;
				
				System.out.println("전화번호>> ");
				String phone = scanner.nextLine();
				member.phone = phone;
				
				System.out.println("포인트>> ");
				int point = Integer.parseInt(scanner.nextLine());
				member.point = point;
				
				
				for (int i = 0; i < members.length; i++) {
					if (members[i] == null) {
						members[i] = member; // member의 주소값에 담긴 값을 members[i]에 담아줌
						System.out.println("등록 완료");
						break;
						
					}
				}

				
				
			} // end of (selectNo == 1)
			
			else if(selectNo == 2) {
				System.out.print("전화번호를 수정할 아이디 >> ");
				String id2 = scanner.nextLine();
				System.out.printf("새로운 전화번호 >> ");
				String nextphone = scanner.nextLine();
				for (int i = 0; i < members.length; i++) {
					if (members[i] != null) {
						if(members[i].id.equals(id2)) {
							members[i].phone = nextphone;
							System.out.println("수정 완료");
							break;
						}
					}
					
				} 
			} // end of (selectNo == 2)
			
			else if(selectNo == 3) {
				System.out.println("삭제할 아이디를 입력하세요 >> ");
				String id3 = scanner.nextLine();
				for (int i = 0; i < members.length; i++) {
					if (members[i] != null) {
						if (members[i].id.equals(id3)) {
							members[i] = null;
							System.out.println("삭제 완료");
							break;
						}
					}
				}
			} // end of (selectNo == 3)
			
			else if(selectNo == 4) {
				System.out.println("조회할 이름을 입력하세요\n>> ");
				String id4 = scanner.nextLine();
				System.out.println(members.length);
				for ( int i = 0; i < members.length; i++) {
					if ( members[i] != null && (id4.equals("") || id4.equals(members[i].name))) {
						System.out.printf("%s님의 회원정보입니다\n아이디: %s, 이름: %s, 전화번호: %s, 포인트: %d\n", members[i].name, members[i].id, members[i].name, members[i].phone, members[i].point);
						
					}
				}
			} // end of (selectNo == 4)
			
			else if(selectNo == 5) {
				System.out.println("종료하겠습니다");
				run = false;
			}
			
		}
	} // end of main
	
	
	
/*	교수님 코드
	package com.yedam.ref.app;

	import java.util.Scanner;

	public class MemberExe {
		public static void main(String[] args) {
			boolean run = true; // 반복문 실행/종료
			Member[] members = new Member[10]; // 저장공간으로 배열을 선언.

			Scanner scn = new Scanner(System.in);
			while (run) {
				System.out.println("--------------------------------------------");
				System.out.println("1.추가 2.수정 3.삭제 4.조회 5.종료");
				System.out.println("--------------------------------------------");
				System.out.print("선택>> ");

				int selectNo = Integer.parseInt(scn.nextLine());

				switch (selectNo) {
				case 1: // 추가.
					System.out.print("아이디를 입력>> ");
					String id = scn.nextLine();
					System.out.print("이름를 입력>> ");
					String name = scn.nextLine();
					System.out.print("전화번호를 입력>> ");
					String telNo = scn.nextLine();
					System.out.print("포인트를 입력>> ");
					int point = Integer.parseInt(scn.nextLine());
					// 멤버변수 선언과 값 할당.
					Member member = new Member();
					member.memberId = id;
					member.memberName = name;
					member.phone = telNo;
					member.point = point;

					// 배열에 추가.
					for (int i = 0; i < members.length; i++) {
						if (members[i] == null) {
							members[i] = member;
							System.out.println("등록완료.");
							break; // 한건을 추가했으면 반복문 종료.
						}
					}
					break; // switch의 case 1 종료.

				case 2: // 수정.
					System.out.print("아이디를 입력>> ");
					id = scn.nextLine();
					System.out.print("전화번호를 입력>> ");
					telNo = scn.nextLine();

					// 같은 값을 찾아서 변경하기.
					for (int i = 0; i < members.length; i++) {
						if (members[i] != null) {
							if (members[i].memberId.equals(id)) {
								members[i].phone = telNo;
								System.out.println("수정완료.");
							}
						}
					}
					break;

				case 3: // 삭제.
					System.out.print("아이디를 입력>> ");
					id = scn.nextLine();

					// 같은 값을 찾아서 삭제하기.
					for (int i = 0; i < members.length; i++) {
						if (members[i] != null) {
							if (members[i].memberId.equals(id)) {
								members[i] = null;
								System.out.println("삭제완료.");
							}
						}
					}
					break;

				case 4: // 조회.
					System.out.print("이름를 입력>> ");
					name = scn.nextLine();

					// 조회.
					System.out.printf("%-10s %-5s %-15s\n", "UserId", "회원명", "TelNo");
					for (int i = 0; i < members.length; i++) {
						if (members[i] != null && (name.equals("") || name.equals(members[i].memberName))) {
							System.out.printf("%-10s %-5s %-15s\n", members[i].memberId, members[i].memberName,
									members[i].phone);
						}
					}
					break;

				case 5: // 종료.
					run = false;
					break;

				default:
					System.out.println("메뉴를 다시 선택하세요.");

				}

			} // end of while.
			System.out.println("*** end of prog ***");

		} // end of main.
	}
*/ // 교수님 코
	
	
	
} // end of class
