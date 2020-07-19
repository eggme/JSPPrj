package com.lsj.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calc2")
public class CalcClass2 extends HttpServlet{

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = res.getWriter();
		// Application 객체 사용
		
		String value = req.getParameter("value");
		String oper = req.getParameter("operator");
		ServletContext application = req.getServletContext();
		// ServletContext -> 컬렉션이라고 생각
		
		// Session
		HttpSession session = req.getSession();
		// application
		/* 
		if(oper.equals("=")){
			String operator = application.getAttribute("oper").toString();
			int t = 0;
			if(operator.equals("+")) {
				t = Integer.parseInt(value) + Integer.parseInt(application.getAttribute("value").toString());
			}else {
				t = Integer.parseInt(value) - Integer.parseInt(application.getAttribute("value").toString());
			}
			writer.print("result : " + t);
			
		}else{
			if(application.getAttribute("oper") == null && application.getAttribute("value") == null) {
				application.setAttribute("value", value);
				application.setAttribute("oper", oper);
			}else {
				if(application.getAttribute("oper").equals("+")) {
					String temp = (Integer.parseInt(value) + Integer.parseInt(application.getAttribute("value").toString())) + "";
					application.setAttribute("value", temp);
				}else {
					String temp = (Integer.parseInt(value) - Integer.parseInt(application.getAttribute("value").toString())) + "";
					application.setAttribute("value", temp);
				}
			}
			res.sendRedirect("./calc2.html");
		} */
		// session
		if(oper.equals("=")){
			String operator = session.getAttribute("oper").toString();
			int t = 0;
			if(operator.equals("+")) {
				t = Integer.parseInt(session.getAttribute("value").toString()) + Integer.parseInt(value);
			}else {
				t = Integer.parseInt(session.getAttribute("value").toString()) - Integer.parseInt(value);
			}
			writer.print("result : " + t);
			
		}else{
			if(session.getAttribute("oper") == null || session.getAttribute("oper").equals("")) {
				session.setAttribute("oper", oper);
			}else if(session.getAttribute("value") == null ) {
				session.setAttribute("value", value);
			}else {
				System.out.println(session.getAttribute("oper"));
				if(session.getAttribute("oper").equals("+")) {
					String temp = (Integer.parseInt(value) + Integer.parseInt(session.getAttribute("value").toString())) + "";
					session.setAttribute("value", temp);
					session.setAttribute("oper", "");
				}else {
					String temp = (Integer.parseInt(session.getAttribute("value").toString())) - Integer.parseInt(value) + "";
					session.setAttribute("value", temp);
					session.setAttribute("oper", "");
				}
			}
			System.out.println(session.getAttribute("value") + " : " + session.getAttribute("oper"));
			res.sendRedirect("./calc2.html");
		} 
	}
}
