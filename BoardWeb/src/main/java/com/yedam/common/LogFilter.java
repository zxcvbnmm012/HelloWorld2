package com.yedam.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LogFilter implements Filter{
	
	public LogFilter() {
		System.out.println("필터객체 생성.");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("서블릿 실행 전.");
		
		String host = req.getRemoteAddr(); // 접속하는 ip 주소
		String port = "" + req.getRemotePort(); // 포트번호 int -> string
		System.out.println("Host: " + host + "\nport: " + port);
		
		HttpServletRequest request = (HttpServletRequest) req;
		String uri = request.getRequestURI();
		String context = request.getContextPath();
		String page = uri.substring(context.length());
		
		if(!host.equals("0:0:0:0:0:0:0:1")) {
			System.out.println("IP: " + host + ", Page: " + page);
		
			return;
		}
		chain.doFilter(req, resp);  // 서블릿 실행.
		
		System.out.println("서블릿 실행 후.");

	}
	
}
