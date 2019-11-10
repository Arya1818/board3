package com.bdi.board3.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class URIController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PREFIX ="/WEB-INF";
	private static final String SUFFIX =".jsp";
	
	private String getForwardURI(HttpServletRequest request) {
		return PREFIX + request.getRequestURI() + SUFFIX;
	}
   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println(getForwardURI(request));
		RequestDispatcher rd = request.getRequestDispatcher(getForwardURI(request));
		rd.forward(request,response);
	} 

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
