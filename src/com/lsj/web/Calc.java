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
		// service ���� request method�� Ȯ���ϴ� ���
		if(req.getMethod().equals("GET")) { // �ݵ�� �빮��
			System.out.println("Get��û�� �Խ��ϴ�.");
		}else if(req.getMethod().equals("POST")) {
			System.out.println("Post��û�� �Խ��ϴ�.");
		}
		super.service(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost�޼��尡 ȣ��Ǿ����ϴ�.");
	}
	
	
}
