package com.lti.training.servlet;

import java.io.IOException;
import java.util.Base64;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login.lti")
public class LoginServlet extends HttpServlet {
	
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username.equals("majrul")&& password.equals("123")) {
			String rememberMe = request.getParameter("rememberMe");
			if(rememberMe != null && rememberMe.equals("yes")) {
					
					String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
					String excess="";
					Random r = new Random();
					StringBuilder sb = new StringBuilder(); 
					while (sb.length() < 10) { // length of the random string.
			            int index = (int) (r.nextFloat() *str.length());
			            sb.append(str.charAt(index));
			        }
					excess = sb.toString();
					String uname = username+excess;
					
					String encodeduname = Base64.getEncoder().encodeToString(uname.getBytes());
					String pass = password+excess;
					String encodedpass = Base64.getEncoder().encodeToString(pass.getBytes());
					Cookie c1 = new Cookie("tor",encodeduname);
					Cookie c2 = new Cookie("rot",encodedpass);
					c1.setMaxAge(60*60);				//1hr (60secs*60secs) The duration of cookie storage on a system
					c2.setMaxAge(60*60);				//1hr 
					response.addCookie(c1);
					response.addCookie(c2);
			}
			response.sendRedirect("welcome.html");	
		}
		else
			response.sendRedirect("login.html");
		}
}
