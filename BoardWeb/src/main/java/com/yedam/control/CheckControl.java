package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class CheckControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ~.do?id=user01
		String user = req.getParameter("id");
		MemberService svc = new MemberServiceImpl();
		if(svc.getMemberInfo(user)) {
			resp.getWriter().print("{\"retCode\":\"Exist\"}");  // {"retCode":"Exist"}
		} else {
			resp.getWriter().print("{\"retCode\":\"NotExist\"}");  // {"retCode":"Exist"}
		}
	}

}
