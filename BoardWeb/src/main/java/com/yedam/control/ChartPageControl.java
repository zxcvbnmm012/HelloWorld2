package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;

public class ChartPageControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// WEB-INF/jsp/chart/chart.jsp
		// chart/chart.tiles  -> 레이아웃이 필요할때 tiles 사용
		req.getRequestDispatcher("chart/chart.tiles").forward(req, resp);
		
	}

}
