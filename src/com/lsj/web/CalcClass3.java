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

@WebServlet("/calc3")
public class CalcClass3 extends HttpServlet{

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
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
		}else {
			exp += value == null ? "" : value;
			exp += operator == null ? "" : operator;
			exp += dot == null ? "" : dot;
		}
		
		Cookie valueCookie = new Cookie("exp", exp);
		
		res.addCookie(valueCookie);
		res.sendRedirect("/calcpage");
	}
}

