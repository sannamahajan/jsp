<%@page import="com.lti.dao.*"%>
<%@page import="com.lti.model.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	Employee emp = (Employee) session.getAttribute("employee");
%>
Employee Number : <%= emp.getEmpno() %><br/>
Name : <%= emp.getEname() %><br/>
Job : <%= emp.getJob() %><br/>
Hire Date : <%= emp.getHiredate() %><br/>
Salary : <%= emp.getSal() %><br/>
Commission : <%= emp.getComm() %><br/>
Department Number : <%= emp.getDeptno() %><br/>
Department Name : <%= emp.getDname() %><br/>
Location : <%= emp.getLoc() %><br/>

</body>
</html>