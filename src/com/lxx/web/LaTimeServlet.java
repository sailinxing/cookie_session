package com.lxx.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LaTimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yy-MM-dd hh:mm:ss");
		String time = sdf.format(date);
		Cookie cookie =new Cookie("LATime", time);
		response.addCookie(cookie);
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
		for (Cookie c : cookies) {
			if("LATime".equals(c.getName())){
				String t = c.getValue();
				response.getWriter().write("您上次访问的时间是"+t);
			}
		}
		}else{
			response.getWriter().write("您是第一次访问");
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}