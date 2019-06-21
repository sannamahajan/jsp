package com.lti.servletnjsp.basics;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorld
 */
/*
 * @WebServlet("/HelloWorld")
 * @WebServlet(urlPatterns = "/HelloWord",loadOnStartup = 1)
 */

public class HelloWorld extends HttpServlet {
	
	int x=0;
	
	@Override
	public void init() throws ServletException {
		System.out.println("INIT..CALLED");
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet called.."+x);
		x++;
		response.getWriter().append("Served at Well:"+x);	
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy called..");
	}

}
