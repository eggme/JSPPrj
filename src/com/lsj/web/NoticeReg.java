package com.lsj.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/notice-reg")
public class NoticeReg extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		//request.setCharacterEncoding("UTF-8");
		// Servlet Filter로 변경
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		String temp = request.getParameter("cnt");
		
		int cnt = 0;
		if(temp != null) cnt = Integer.parseInt(temp);
		PrintWriter writer = response.getWriter();
		for(int i=0;i<cnt;i++){
			writer.print("안녕하세요<br />");
		}
		writer.print("--------------------------<br />");
		writer.print("제목 : "+ title + "<br />");
		writer.print("내용 : "+ contents);
		
	}

	
	
}
