package com.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.control.AddBoardControl;
import com.yedam.control.BoardControl;
import com.yedam.control.BoardListControl;
import com.yedam.control.LoginControl;
import com.yedam.control.LoginFormControl;
import com.yedam.control.LogoutControl;
import com.yedam.control.MemberListControl;
import com.yedam.control.ModifyBoardControl;
import com.yedam.control.RemoveBoardControl;

/*
 * M-V-Control 역할
 * url 패턴 - 실행서블릿 관리.
 */

// HttpServlet을 상속받아 구현되는 서블릿 FrontController
// 처리순서 : init 호출 -> service 호출
public class FrontController extends HttpServlet {
	Map<String, Control> map;  // key : String  /  value : Control
	
	public FrontController() {
		map = new HashMap<String, Control>();
	}
	
	@Override  // *.do url을 처리하는 기능
	public void init(ServletConfig config) throws ServletException {
		// boardList.do - 글목록 출력 기능
		map.put("/boardList.do", new BoardListControl()); // 글목록
		map.put("/board.do", new BoardControl());         // 상세화면
		map.put("/addBoard.do", new AddBoardControl());   // 등록화면
		map.put("/modifyBoard.do", new ModifyBoardControl());   // 수정화면
		map.put("/removeBoard.do", new RemoveBoardControl());  // 삭제화면
		
		
		// member 관련
		map.put("/loginForm.do", new LoginFormControl()); // 화면
		map.put("/login.do", new LoginControl()); // id, pw 로그인처리
		map.put("/logout.do", new LogoutControl()); // id, pw 로그인처리
		
		// 회원목록
		map.put("/memberList.do", new MemberListControl());
		
		
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// url이 호출(http://localhost:8080/BoardWeb/boardList.do) -> 페이지 호출 -> Control 반환 
		// uri : /BoardWeb/boardList.do
		String uri = req.getRequestURI(); // /BoardWeb/boardList.do
		String context = req.getContextPath(); // /BoardWeb or /HelloWorld
		String page = uri.substring(context.length()); // /boardList.do
		Control sub = map.get(page);
		sub.exec(req, resp);
	}
}
