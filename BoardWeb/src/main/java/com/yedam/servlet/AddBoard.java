package com.yedam.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

//@WebServlet("/addBoard.serv")
public class AddBoard extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) //
					throws ServletException, IOException {
		// 파라미터를 사용해서 웹 상에 입력되는 값을 서블릿이 전달함
		// 2개 이상의 파라미터를 사용할때는 & 사용해서 연결
		// addBoard.serv?title=제목&content=내용&writer=user01
		// req : client(브라우저)로부터 들어온 요청을 처리할 때 사용 -> 
		// resp : client(브라우저)에게 응답을 보낼 때
		String title = req.getParameter("title"); // getParameter("title") : title 파라미터 뒤에 들어있는 값을 반환함 -> 제목
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");
		
		// 메소드의 매개값
		BoardVO board = new BoardVO();
		board.setTitle(title);
		board.setContent(content);
		board.setWriter(writer);
		
		// 업무 서비스 (서비스 로직으로 처리)
		BoardService svc = new BoardServiceImpl();
		if(svc.registerBoard(board)) {
			System.out.println("등록성공");
			// 목록페이지로 이동
			resp.sendRedirect("servlet/boardList.serv"); // sendRedirect : 현재 페이지에서 ()안의 페이지로 새롭게 요청 -> 이동
		} else {
			System.out.println("등록실패");
		}
	}
}
