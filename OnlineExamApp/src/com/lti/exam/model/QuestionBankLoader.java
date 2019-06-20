package com.lti.exam.model;

import java.util.ArrayList;
import java.util.List;

public class QuestionBankLoader {

	public List<Question>  fetchQuestionsOnJava() {
		QuestionBank qb = new QuestionBank();
		qb.addNewSubject("Java");
		
		Question q = new Question();
		q.setQuestion("What is a class");
		List<Option> opts = new ArrayList<Option>();
		
		Option o1 = new Option();
		o1.setOption("Class is a template for an object");
		o1.setRightAnswer(true);
		
		Option o2 = new Option();
		o2.setOption("Class is an instance for an object");
		o2.setRightAnswer(false);

		Option o3 = new Option();
		o3.setOption("Class is another name for an object");
		o3.setRightAnswer(false);

		Option o4 = new Option();
		o4.setOption("all of the above");
		o4.setRightAnswer(false);
		
		opts.add(o1);
		opts.add(o2);
		opts.add(o3);
		opts.add(o4);
		
		q.setOptions(opts);
		qb.addNewQuestion("Java", q);
		
		/*
		 * 
		 */
		
		q = new Question();
		q.setQuestion("Who is responsible for optimizing the bytecode?");
		opts = new ArrayList<Option>();
		
		o1 = new Option();
		o1.setOption("JVM");
		o1.setRightAnswer(false);
		
		o2 = new Option();
		o2.setOption("JIT");
		o2.setRightAnswer(true);

		o3 = new Option();
		o3.setOption("JDK");
		o3.setRightAnswer(false);

		o4 = new Option();
		o4.setOption("JRE");
		o4.setRightAnswer(false);
		
		opts.add(o1);
		opts.add(o2);
		opts.add(o3);
		opts.add(o4);
		
		q.setOptions(opts);
		qb.addNewQuestion("Java", q);
		
		/*
		 * 
		 */
		
		q = new Question();
		q.setQuestion("What is the full form of JVM");
		opts = new ArrayList<Option>();
		
		o1 = new Option();
		o1.setOption("Java Virtual Machine");
		o1.setRightAnswer(true);
		
		o2 = new Option();
		o2.setOption("Java Viral Mechanism");
		o2.setRightAnswer(true);

		o3 = new Option();
		o3.setOption("Juugar vardan mera");
		o3.setRightAnswer(false);

		o4 = new Option();
		o4.setOption("Java Vishesagya Majrul");
		o4.setRightAnswer(false);
		
		opts.add(o1);
		opts.add(o2);
		opts.add(o3);
		opts.add(o4);
		
		q.setOptions(opts);
		qb.addNewQuestion("Java", q);
		
		/*
		 * 
		 */
		
		q = new Question();
		q.setQuestion("What is not a primitive data type?");
		opts = new ArrayList<Option>();
		
		o1 = new Option();
		o1.setOption("int");
		o1.setRightAnswer(false);
		
		o2 = new Option();
		o2.setOption("Array");
		o2.setRightAnswer(true);

		o3 = new Option();
		o3.setOption("float");
		o3.setRightAnswer(false);

		o4 = new Option();
		o4.setOption("boolean");
		o4.setRightAnswer(false);
		
		opts.add(o1);
		opts.add(o2);
		opts.add(o3);
		opts.add(o4);
		
		q.setOptions(opts);
		qb.addNewQuestion("Java", q);
		
		return qb.getQuestionsFor("Java");
		}
}
