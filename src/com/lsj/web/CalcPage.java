package com.lsj.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calcpage")
public class CalcPage extends HttpServlet{

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		super.service(req, res);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = res.getWriter();
		
		Cookie[] cookies = req.getCookies();
		String exp = "0";
		if(cookies != null) {
			for(Cookie c : cookies) {
					if(c.getName().equals("exp")) {
						exp = c.getValue();
						break;
				}
			}
		}
		
		String page = "<!DOCTYPE html>\r\n" + 
				"		<html>\r\n" + 
				"		<head>\r\n" + 
				"		<meta charset=\"UTF-8\">\r\n" + 
				"		<title>Insert title here</title>\r\n" + 
				"		</head>\r\n" + 
				"		<style>\r\n" + 
				"		input{\r\n" + 
				"			width:50px;\r\n" + 
				"			height:50px;\r\n" + 
				"		}\r\n" + 
				"		.output{\r\n" + 
				"			text-align:right;\r\n" + 
				"			height:50px;\r\n" + 
				"			background: #e9e9e9;\r\n" + 
				"			font-size: 18px;\r\n" + 
				"			font-weight: bold;\r\n" + 
				"			padding: 0 5px;\r\n" + 
				"		}\r\n" + 
				"		</style>\r\n" + 
				"		<body>\r\n" + 
				"		<form action=\"/calcpage\" method=\"post\">\r\n" + 
				"			<table>\r\n" + 
				"				<tr>\r\n" + 
				"					<td colspan=\"4\" class=\"output\">"+ exp +"</td>\r\n" + 
				"				</tr>\r\n" + 
				"				<tr>\r\n" + 
				"					<td><input type=\"submit\" value=\"CE\" name=\"CE\"/></td>\r\n" + 
				"					<td><input type=\"submit\" value=\"C\" name=\"operator\"/></td>\r\n" + 
				"					<td><input type=\"submit\" value=\"BS\" name=\"BS\"/></td>\r\n" + 
				"					<td><input type=\"submit\" value=\"/\" name=\"operator\"/></td>\r\n" + 
				"				</tr>\r\n" + 
				"				<tr>\r\n" + 
				"					<td><input type=\"submit\" value=\"7\" name=\"value\"/></td>\r\n" + 
				"					<td><input type=\"submit\" value=\"8\" name=\"value\"/></td>\r\n" + 
				"					<td><input type=\"submit\" value=\"9\" name=\"value\"/></td>\r\n" + 
				"					<td><input type=\"submit\" value=\"*\" name=\"operator\"/></td>\r\n" + 
				"				</tr>\r\n" + 
				"				<tr>\r\n" + 
				"					<td><input type=\"submit\" value=\"4\" name=\"value\"/></td>\r\n" + 
				"					<td><input type=\"submit\" value=\"5\" name=\"value\"/></td>\r\n" + 
				"					<td><input type=\"submit\" value=\"6\" name=\"value\"/></td>\r\n" + 
				"					<td><input type=\"submit\" value=\"-\" name=\"operator\"/></td>\r\n" + 
				"				</tr>\r\n" + 
				"				<tr>\r\n" + 
				"					<td><input type=\"submit\" value=\"1\" name=\"value\"/></td>\r\n" + 
				"					<td><input type=\"submit\" value=\"2\" name=\"value\"/></td>\r\n" + 
				"					<td><input type=\"submit\" value=\"3\" name=\"value\"/></td>\r\n" + 
				"					<td><input type=\"submit\" value=\"+\" name=\"operator\"/></td>\r\n" + 
				"				</tr>\r\n" + 
				"				<tr>\r\n" + 
				"					<td colspan=\"2\"><input type=\"submit\" value=\"0\" name=\"value\" style=\"width:104px;\"/></td>\r\n" + 
				"					<td><input type=\"submit\" value=\".\" name=\"dot\"/></td>\r\n" + 
				"					<td><input type=\"submit\" value=\"=\" name=\"operator\"/></td>\r\n" + 
				"				</tr>\r\n" + 
				"			</table>\r\n" + 
				"		</form>\r\n" + 
				"		</body>\r\n" + 
				"		</html>\r\n";
		writer.print(page);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		
		String value = req.getParameter("value");
		String operator = req.getParameter("operator");
		String dot = req.getParameter("dot");
		
		Cookie[] cookies = req.getCookies();
		String exp = "";
		if(cookies != null) {
			for(Cookie c : cookies) {
				if(c.getName().equals("exp")) {
					exp = c.getValue();
					break;
				}
			}
		}
		
		if(operator != null && operator.equals("=")) {
			ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
			// javascript nashorn 엔진
			try {
				exp = String.valueOf(engine.eval(exp));
				// 자바스크립트 실행
			} catch (ScriptException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(operator != null && operator.equals("C")){
			exp = "";
		}else {
			exp += value == null ? "" : value;
			exp += operator == null ? "" : operator;
			exp += dot == null ? "" : dot;
		}
		Cookie valueCookie = new Cookie("exp", exp);
		if(operator != null && operator.equals("C")) {
			valueCookie.setMaxAge(0);
		}
		valueCookie.setPath("/calcpage");
		res.addCookie(valueCookie);
		res.sendRedirect("/calcpage");
	}
	
	
	
}

