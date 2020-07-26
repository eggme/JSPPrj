package com.lsj.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/spag")
public class Spag extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String temp = req.getParameter("cnt");
		int cnt = temp == null ? 10 : Integer.parseInt(temp);
		String result = cnt % 2 == 0 ? "짝수입니다." : "홀수입니다.";
		// redirect
		
		// forward
		req.setAttribute("result", result);
		RequestDispatcher dispatcher = req.getRequestDispatcher("spag.jsp");
		dispatcher.forward(req, resp);
	}

	
}
