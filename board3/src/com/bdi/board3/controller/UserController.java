package com.bdi.board3.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bdi.board3.service.Impl.UserServiceImpl;

@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserServiceImpl us = new UserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//잊지말고 해주자.
		String uri = request.getRequestURI();
		String cmd = uri.substring(7);
		String uiId = request.getParameter("uiId");
		String uiPwd = request.getParameter("uiPwd");
		String uiName = request.getParameter("uiName");
		String path = "/views/msg";
		if ("login".equals(cmd)) {
			Map<String, String> user = us.doLogin(uiId, uiPwd);
			if (user != null) {
				HttpSession hs = request.getSession();
				hs.setAttribute("user", user); // 꼭넣어줘!
				request.setAttribute("msg", "로그인성공");
				request.setAttribute("url", "/views/index");
			} else {

				request.setAttribute("msg", "로그인실패");
				request.setAttribute("url", "/views/user/login");
			}
		} else if ("signup".equals(cmd)) {
			Map<String, String> user = us.doSignup(uiName, uiId, uiPwd);
			if(user!=null) {
				request.setAttribute("msg", "회원가입완료");
				request.setAttribute("url", "/views/index");
			}else {
				request.setAttribute("msg", "회원가입실패");
				request.setAttribute("url", "/views/user/signup");
			}
		} else if ("update".equals(cmd)) {

		} else if ("delete".equals(cmd)) {

			doGet(request, response);
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	}
}
