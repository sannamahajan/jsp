package com.lti.exam.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lti.exam.model.Question;
import com.lti.exam.model.QuestionBankLoader;


@WebServlet("/QuestionLoaderServlet")
public class QuestionLoaderServlet extends HttpServlet {
	
	private int questionNo;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QuestionBankLoader qb1 = new QuestionBankLoader();
		List<Question> questions = qb1.fetchQuestionsOnJava();
		
		Question q = questions.get(questionNo++);
		request.getSession().setAttribute("currentQs", q);
		
		response.sendRedirect("showQuestion.jsp");
	}

}
