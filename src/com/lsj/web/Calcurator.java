package com.lsj.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/add")
public class Calcurator extends HttpServlet{

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		
		int value1 = Integer.parseInt(request.getParameter("value1"));
		int value2 = Integer.parseInt(request.getParameter("value2"));
		writer.print("µ¡¼À °á°ú : " + (value1 + value2));
	}

	
	
}
