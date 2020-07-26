package com.lsj.web;

import java.io.IOException;
import java.io.PrintWriter;

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
				"		<form action=\"/calc3\" method=\"post\">\r\n" + 
				"			<table>\r\n" + 
				"				<tr>\r\n" + 
				"					<td colspan=\"4\" class=\"output\">"+ exp +"</td>\r\n" + 
				"				</tr>\r\n" + 
				"				<tr>\r\n" + 
				"					<td><input type=\"submit\" value=\"CE\" name=\"CE\"/></td>\r\n" + 
				"					<td><input type=\"submit\" value=\"C\" name=\"C\"/></td>\r\n" + 
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
}

