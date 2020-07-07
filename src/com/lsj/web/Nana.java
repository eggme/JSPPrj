package com.lsj.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello1")
public class Nana extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = resp.getWriter();
		String cnt = req.getParameter("cnt");
		if( cnt != null && !cnt.equals("")) {
			for(int i=0;i<Integer.parseInt(cnt);i++)
				writer.println("¾È³ç Servlet <br />");
		}
	}
}
