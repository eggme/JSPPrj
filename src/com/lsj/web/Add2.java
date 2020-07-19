package com.lsj.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/add2")
public class Add2 extends HttpServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=utf-8"); 
		
		PrintWriter writer = res.getWriter();
		String[] values = req.getParameterValues("value");
		int value = 0;
		for(int i=0;i<values.length;i++) {
			value += Integer.parseInt(values[i]);
		}
		writer.print("°á°ú : "+ value);
	}

	
}
