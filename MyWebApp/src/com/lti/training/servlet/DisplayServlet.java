package com.lti.training.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lti.training.auth.UserRegistration;
import com.lti.training.servlet.RegisterServlet;

@WebServlet("/DisplayServlet")
public class DisplayServlet extends HttpServlet {

	@SuppressWarnings("unchecked")
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		/*
		 * Creating an array list object by the name --> list of type UserRegistration.
		 * Used to hold the objects of type UserRegistration. request.getAttribute() is
		 * used to fetch the attribute from the previous servlet where "thelist" is the identifier
		 * assigning the parameter to the variable list. Iterating through the list and printing it
		 * using print writer object
		 */
		List<UserRegistration> list = new ArrayList<UserRegistration>();
		list = (List<UserRegistration>) request.getAttribute("thelist");
		for(UserRegistration users : list ) {
			out.println(users.getName());
			out.println(users.getCity());
			out.println(users.getEmail());
			out.println(users.getUsername());
			out.println(users.getPassword());
			out.println("\t");
		}
		
		
	}

}
