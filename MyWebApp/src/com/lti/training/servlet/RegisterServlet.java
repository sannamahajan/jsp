package com.lti.training.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lti.training.auth.DatabaseManager;
import com.lti.training.auth.UserRegistration;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String city = request.getParameter("city");
		String username = request.getParameter("uname");
		String password = request.getParameter("pass");
		
		DatabaseManager dm = new DatabaseManager();
		dm.registerUser(name, email, city, username, password);
		
		List<UserRegistration> un = new ArrayList<UserRegistration>();
		un = dm.fetchAll();
		request.setAttribute("thelist", un);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/DisplayServlet");
		dispatcher.forward(request, response);
		//dispatcher.include(request, response);
		//response.sendRedirect("display.html");
		
	}

}
