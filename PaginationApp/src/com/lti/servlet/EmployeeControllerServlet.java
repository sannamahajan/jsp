package com.lti.servlet;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lti.dao.EmployeeDao;
import com.lti.exception.DataAccessException;
import com.lti.model.Employee;

@WebServlet("/EmployeeControllerServlet")
public class EmployeeControllerServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int empno = Integer.parseInt(request.getParameter("empno"));
		
		EmployeeDao edao = new EmployeeDao();
		
		Employee employee = edao.fetchEmp(empno);
		
		HttpSession session =request.getSession();
		session.setAttribute("employee", employee);
		response.sendRedirect("showEmployee.jsp");
		
	}

}
