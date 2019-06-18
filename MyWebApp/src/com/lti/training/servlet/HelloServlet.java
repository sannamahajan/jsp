package com.lti.training.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello.ltihub")			//URI/URL
public class HelloServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.setContentType("text/html");			//MIME 
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1>Namaste Duniya</h1>");
		out.println("</body></html>");	
	}
}
