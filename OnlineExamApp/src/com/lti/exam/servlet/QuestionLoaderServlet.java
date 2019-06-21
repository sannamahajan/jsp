package com.lti.exam.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lti.exam.model.Question;
import com.lti.exam.model.QuestionBankLoader;


@WebServlet("/QuestionLoaderServlet")
public class QuestionLoaderServlet extends HttpServlet {
	
	private int questionNo;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QuestionBankLoader qb1 = new QuestionBankLoader();
		List<Question> questions = qb1.fetchQuestionsOnJava();
		
		HttpSession session = request.getSession();
		/*
		 * session.setMaxInactiveInterval(10);
		 * Activate this part of the code to make sure the session times out after 10 seconds of inactivity.
		 */
		
		Integer questionNo = (Integer) session.getAttribute("questionNo");
		
		if(questionNo == null)
			questionNo = 0;
		
		if(questionNo<questions.size()) {
			Question q = questions.get(questionNo++);
			request.getSession().setAttribute("currentQs", q);
			response.sendRedirect("showQuestion.jsp");
		}
		else
			response.sendRedirect("showScore.jsp");
		session.setAttribute("questionNo", questionNo);
	}

}
