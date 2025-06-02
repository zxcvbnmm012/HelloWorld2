package com.yedam.app;

import java.util.Scanner;

import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceDAO;
import com.yedam.vo.Member;

/*
 * 사용자의 입력값을 등록, 수정, 삭제, 목록 기능을 실행
 */

public class MemberApp {
	public void execute() {
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		while(run) {
		MemberService svc = new MemberServiceDAO();
		System.out.println("---------------------------------------");
		System.out.println("1.회원등록 2.정보수정 3.회원삭제 4.목록보기 5.종료");
		System.out.println("---------------------------------------");
		System.out.println("선택>> ");
		
		int menu = scn.nextInt();
		scn.nextLine();
		
		
			switch(menu) {
			case 1: // 등록
				System.out.println("회원아이디>> ");
				String mid = scn.nextLine();
				
				System.out.println("회원이름>> ");
				String name = scn.nextLine();
				
				System.out.println("연락처>> ");
				String phone = scn.nextLine();
				
				System.out.println("포인트>> ");
				String point = scn.nextLine();
				
				Member member = new Member(mid, name, phone, Integer.parseInt(point));
				if(svc.addMember(member)) {
					System.out.println("등록완료");
				} else {
					System.out.println("등록실패");
				}
				break;
				
			case 2:
				System.out.println("수정할 회원아이디>> ");
				mid = scn.nextLine();
				
				System.out.println("연락처>> ");
				phone = scn.nextLine();
				
				System.out.println("포인트>> ");
				point = scn.nextLine();
				
				Member member2 = new Member(mid, phone, Integer.parseInt(point));
				if(svc.modifyMember(member2)) {
					System.out.println("수정완료");
				} else {
					System.out.println("수정실패");
				}
				break;
				
			case 3:
				System.out.println("삭제할 회원아이디>> ");
				mid = scn.nextLine();
				Member member3 = new Member(mid);
				if(svc.modifyMember(member3)) {
					System.out.println("삭제완료");
				} else {
					System.out.println("삭제실패");
				}
				break;
				
			case 5:
				System.out.println("end of prog.");
				run = false;
				break;
			} // end of switch
			
		}
	} // end of execute
}
