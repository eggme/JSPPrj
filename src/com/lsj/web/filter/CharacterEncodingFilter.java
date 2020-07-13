package com.lsj.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class CharacterEncodingFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request
			, ServletResponse response
			, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// 다음 페이지로 넘기는 권한은 FilterChain
		System.out.println("Hello Filter");
		request.setCharacterEncoding("UTF-8");
		chain.doFilter(request, response);
		// 흐름을 넘기는 것 해당 request와 response에 담긴 요청 실행
		// 말그대로 한번 들렸다가 거르는 것
	}

}
