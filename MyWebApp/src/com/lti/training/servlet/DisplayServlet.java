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

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
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
