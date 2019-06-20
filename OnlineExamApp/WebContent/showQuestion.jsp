<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.lti.exam.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
		Question q = (Question) session.getAttribute("currentQs");
%>

<h3>Q. <%= q.getQuestion() %></h3>
<ul>

<%
		for(Option o : q.getOptions()) {
%>
<li><%= o.getOption() %><br /></li>
<% } %>
</ul>
</body>
</html>