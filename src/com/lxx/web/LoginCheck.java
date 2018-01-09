package com.lxx.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String checkcode = request.getParameter("checkcode");
//		checkcode=new String(checkcode.getBytes("iso8859-1"), "utf-8");
		System.out.println(checkcode);
//		String word = (String) this.getServletContext().getAttribute("words");
		HttpSession session = request.getSession();
		String word = (String) session.getAttribute("words");
		System.out.println(word);
		if(checkcode!=null&&!"".equals(checkcode)){
			if(checkcode.equals(word)){
				response.getWriter().write("登陆成功");
			}
			else{
				response.getWriter().write("验证码输入错误");
			}
		}else{
			response.getWriter().write("请输入验证码");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}