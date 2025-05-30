package com.yedam.board;

// 필드 : 글번호, 제목, 내용, 작성자
// 메소드 : getter, setter
// 생성자 : 기본생성자, 전체매개값을 가진 생성자

public class Board {
	
	// 필드
	private int     boardNo;   // 글번호
	private String  title;     // 제목
	private String  content;   // 내용
	private String  writer;    // 작성자
	
	// 생성자
	public Board() {
		
	}
	
	public Board(int boardNo, String title, String content, String writer) {
		this.boardNo = boardNo;
		this.title = title;
		this.content = content;
		this.writer = writer;
	}

	
	// 메소드: getter, setter
	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public void showInfo() {
		System.out.printf(" %3d     %-12s  %s\n", boardNo, title, writer);
	}
	
	public void showAllInfo() {
		String strFormat = "글번호: %d  작성자: %s\n";
		strFormat += "제목: %s\n";
		strFormat += "내용: %s\n";
		System.out.printf(strFormat, boardNo, writer, title, content);
	}
	
}
