package com.lsj.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calcurator")
public class Calc extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// service 에서 request method를 확인하는 방법
		if(req.getMethod().equals("GET")) { // 반드시 대문자
			System.out.println("Get요청이 왔습니다.");
		}else if(req.getMethod().equals("POST")) {
			System.out.println("Post요청이 왔습니다.");
		}
		super.service(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost메서드가 호출되었습니다.");
	}
	
	
}
