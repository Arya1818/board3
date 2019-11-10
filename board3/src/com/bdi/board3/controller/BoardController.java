package com.bdi.board3.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bdi.board3.service.Impl.BoardServiceImpl;

@WebServlet("/BoardController")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BoardServiceImpl bs = new BoardServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		String cmd = uri.substring(7);
		String path = "/views/board/list";
		String biNum = request.getParameter("biNum");//view,delete할때 씀
		
		Map<String,String> board = new HashMap<>();
		
		if("list".equals(cmd)) {
			List<Map<String,String>> list = bs.getBoardList(board);
			request.setAttribute("list", list);
			
		}else if("view".equals(cmd)) {
			path = "/views/board/view";
			board.put("biNum",biNum);
			board = bs.getBoard(board);
			request.setAttribute("board", board);
			
		}else if("delete".equals(cmd)) {
			board.put("biNum",biNum);
			
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Map<String,String> board = new HashMap<>();//위로뺌 왜?
		String uri = request.getRequestURI();
		String cmd = uri.substring(7);
		String biTitle = request.getParameter("biTitle");
		String biContent = request.getParameter("biContent");
		String path="/views/msg";
		
		if("insert".equals(cmd)) {
			
			board.put("biTitle",biTitle);
			board.put("biContent", biContent);
			
			HttpSession hs = request.getSession();
			Map<String,String> user = (Map<String,String>)hs.getAttribute("user"); //여기는 java파일이라 <%@include file 못씀
			board.put("uiNum",user.get("uiNum"));
			
			Map<String,String> rMap = bs.insertBoard(board);
			request.setAttribute("msg", rMap.get("msg"));
			request.setAttribute("url", rMap.get("url"));
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
	

}
