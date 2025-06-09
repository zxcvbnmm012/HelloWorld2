package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.common.PageDTO;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

// boardList.do -> boardList.jsp
public class BoardListControl implements Control{

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
//		req.setAttribute("myName", "Hongkildong"); -> setAttribute로 넘긴 값은 getAttribute로 반환 가능
		
		String page = req.getParameter("page");
		page = page == null ? "1" : page;  // boardList.do => 1페이지 출력
		
		BoardService svc = new BoardServiceImpl();
		List<BoardVO> list = svc.boardList(Integer.parseInt(page));
		
		// 페이징 계산
		int totalCnt = 112;
		PageDTO paging = new PageDTO(Integer.parseInt(page), totalCnt);
		
		req.setAttribute("blist", list);  // 요청정보에 값을 담아서 객체형태로 boardList.jsp 페이지로 전달
		req.setAttribute("pageInfo",  paging);
		
		// 요청재지정(페이지이동)
		req.getRequestDispatcher("WEB-INF/jsp/boardList.jsp").forward(req, resp);
	}

}
