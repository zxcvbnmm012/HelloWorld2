package com.yedam.board;

import java.util.Scanner;

public class BoardExe {
	// 필드
	private Board[] boards;
	private Scanner scn = new Scanner(System.in);
	private int bno = 2; // 배열의 인덱스에 사용하기 위한 int 값

	// 생성자
	public BoardExe() {
		boards = new Board[100];
		boards[0] = new Board(10, "날씨가 좋습니다.", "오늘 기온이 10도입니다", "김민규");
		boards[1] = new Board(11, "자바가 힘들어요.", "오늘 기온이 11도입니다", "김민규");
		boards[2] = new Board(12, "날씨가 좋습니다.", "오늘 기온이 12도입니다", "김민규");
		boards[3] = new Board(13, "자바가 힘들어요.", "오늘 기온이 13도입니다", "김민규");
		boards[4] = new Board(14, "날씨가 좋습니다.", "오늘 기온이 14도입니다", "김민규");
		boards[5] = new Board(15, "자바가 힘들어요.", "오늘 기온이 15도입니다", "김민규");
		boards[6] = new Board(16, "날씨가 좋습니다.", "오늘 기온이 16도입니다", "김민규");
		boards[7] = new Board(17, "자바가 힘들어요.", "오늘 기온이 17도입니다", "김민규");
		boards[8] = new Board(18, "날씨가 좋습니다.", "오늘 기온이 18도입니다", "김민규");
		boards[9] = new Board(19, "자바가 힘들어요.", "오늘 기온이 19도입니다", "김민규");
		boards[10] = new Board(20, "날씨가 좋습니다.", "오늘 기온이 20도입니다", "김민규");
	}
	
	
	boolean loginCheck() {
		for (int i = 1; i <= 3; i++) {
			String id = userMessage("아이디를 입력");
			String pw = userMessage("비밀번호를 입력");
			if (!UserExe.login(id, pw)) {  // 로그인 실패할 경우
				System.out.println("아이디와 비밀번호를 확인하세요.");
				if (i == 3) {
					System.out.println("3번 실패했습니다. 종료합니다.");
					break;
				}
				continue;
			} // end of 로그인 실패할 경우
			// 로그인을 성공하면 언제라도 반복문을 빠져 나와서 아래 코드를 실행. -> true 반환
			return true; 
		} // 3번의 기회를 제공.
		return false; // for 문을 타지 않을 경우에도 반환값은 있어야함 -> for문 안에 return 넣으면 오류
		
	} // end of loginCheck()

	// 메소드
	void execute() {
		
		// 아이디 입력
		// 비밀번호 입력
		
//		login 내 코드
//		boolean run = UserExe.login(null, null);
		
		if (!loginCheck()) {
			return; // loginCheck() 반환값이 false -> execute() 종료
		}

		
		
		boolean run = true;
		System.out.println("환영합니다!!!");
		
		// 로그인 성공하면 while문 실행
		while (run) {
			
			System.out.println("--------------------------------------");
			System.out.println("   1.추가  2.수정  3.삭제  4.목록  5.종료");
			System.out.println("--------------------------------------");
			System.out.print("선택>> ");
			int selectNo = 0;
			
			// 사용자가 문자를 입력하면 숫자로 변경할 때 예외 발생 : NumberFormatException
			try {
				selectNo = Integer.parseInt(scn.nextLine());
				
			} catch(NumberFormatException e) {
				System.out.println("메뉴를 1 ~ 5번 중에 선택하세요");
				continue;
			}
			
			switch (selectNo) {
			case 1: // 추가
				addBoard();
				break;
			case 2: // 수정
				modifyBoard();
				break;
			case 3: // 삭제
				removeBoard();
				break;
			case 4: // 목록
				boardList();
				break;
			case 5: // 종료
				System.out.println("end of prog.");
				run = false;
				break;
			default:
				System.out.println("메뉴를 다시 선택하세요");
				
			} // end of switch
		} // end of while
	} // end of execute()

	// "제목을 입력하세요>> "
	// "내용을 입력하세요>> "
	// "작성자를 입력하세요>> "
	// "추가성공 / 추가실패"
	void addBoard() {   	// 기능 : 추가
		int no = nextSequence();
		String title = userMessage("제목을 입력하세요");
		String content = userMessage("내용을 입력하세요");
		String writer = userMessage("작성자를 입력하세요");
		
		Board board = new Board(no, title, content, writer);
		
		boards[bno++] = board;
		System.out.println("추가성공");

	} // end of addBoard()
	
	
	//  글번호       제목     작성자
	//===========================
	//   1      날씨가 좋아요  홍길동
	//   2      클래스 멋짐요  김민규
	//   3      자바는 어려움  박석민
	//   4      그래도 열심히  김민규
	// --------------------------
	// 상세보기: 글번호입력, 메뉴로 이동(q)
	// --------------------------
	void boardList() {   	// 기능 : 목록
//		sort();
		int page = 1;
		while(true) {
			int start = (page-1)*5;
			int end = page * 5;
			System.out.println(" 글번호 |      제목      |   작성자 ");
			for ( int i = start; i < end; i++) {
				if (boards[i] != null) {
					boards[i].showInfo();
				}
			}
			// 상세 보기
			System.out.println("--------------------------------------------");
			System.out.println("상세보기: 글번호입력, 다음(n), 이전(p), 메뉴로 이동(q)");
			System.out.println("--------------------------------------------");
			
			String str = scn.nextLine();
			
			
			
			if(str.equals("q")) {
				break;
			} else if(str.equals("n")) {
				page++;
			} else if(str.equals("p")) {
				page--;
			} else {
				int no = 0;
				try {
					no = Integer.parseInt(str);
					
				} catch(NumberFormatException e) {
					System.out.println("목록에 있는 글번호를 선택하세요.");
					continue;
				}
				
				Board sboard = getBoard(no);
				if (sboard == null) {
					System.out.println("조회결과 없습니다.");
					return;
				}
				sboard.showAllInfo();
			}
			
		} // end of while
		System.out.println();
	} // end of boardList()
	
	
	
	void modifyBoard() {   // 기능 : 수정
		int bno = userMenu("수정할 글번호 입력");
		Board result = getBoard(bno);
		if (result == null) {
			System.out.println("조회결과 없습니다");
			return;
		}
		String title = userMessage("수정할 제목 입력");
		String content = userMessage("수정할 내용 입력");
		
		result.setContent(content);
		result.setTitle(title);
		System.out.println("수정 완료");
	} // end of modifyBoard()
	
	
	void removeBoard() {
		int bno = userMenu("삭제할 글번호 입력");
		Board result2 = getBoard(bno);
		if (result2 == null) {
			System.out.println("조회결과 없습니다");
			return;
		}
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && boards[i].getBoardNo() == bno){
				boards[i] = null;
				System.out.println("삭제완료");
			}
		}
	}
	
	
	Board getBoard(int bno) {   // 기능 : 글번호를 활용해서 배열에서 조회하고 Board 반환
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && boards[i].getBoardNo() == bno) {
				return boards[i];
			}
		}
		return null; // 조건에 맞는 글번호 없으면 null 반환
	} // end of getBoard()
	
	

	String userMessage(String msg) {   // 기능 : 사용자의 입력값을 문자열로 반환
		System.out.print(msg + ">> ");
		return scn.nextLine();
	} // end of userMessage()
	
	
	
	int userMenu(String msg) {   // 기능 : 사용자의 입력값을 정수로 반환
		System.out.print(msg + ">> ");
		return Integer.parseInt(scn.nextLine());
	} // end of userMessage()
	
	
	void sort() {   // 기능 : 글번호 내림차순 정렬
		Board temp = null;
		for (int j = 0; j < boards.length - 1; j++) {
			for (int i = 0; i < boards.length - 1; i++) {
				if (boards[i + 1] == null) {
					continue;
				}
				if (boards[i] == null) {
					temp = boards[i];
					boards[i] = boards[i + 1];
					boards[i + 1] = temp;
					continue;
				}
				if (boards[i].getBoardNo() < boards[i + 1].getBoardNo()) {
					temp = boards[i];
					boards[i] = boards[i + 1];
					boards[i + 1] = temp;
				}
			}
		}
	} // end of sort.
	
	
	
	int nextSequence() {
		int max = 0;
		for ( int i = 0; i < boards.length; i++) {
			if ( boards[i] != null && max < boards[i].getBoardNo()) {
				max = boards[i].getBoardNo();
			}
		} 
		return max + 1;
	} // end of nextSequence()
}
