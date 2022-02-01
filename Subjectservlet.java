package com.wipro.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Subjectservlet")
public class Subjectservlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		String subj_name= request.getParameter("subj_name");
		System.out.print(subj_name);
		out.print("<h1>Rating of ");
		out.print(subj_name);
		out.print("</h1>");
		out.print("<table border='1'><tr><th>Student</th><th>Test</th><th>Quiz</th><th>Lab</th><th>Project</th><th>Rating</th></tr>");
		if(subj_name.isEmpty()) {response.sendRedirect("Failure.jsp");return;}
		Database db= new Database();
		db.createConnection();
		db.fetchData();
		ArrayList<Subject_Rating_Model>ans=db.showRatingForSubject(subj_name);
		for(int i=0;i<ans.size();i++) {
			out.print("<tr><td>");
			out.print(ans.get(i).student_name);
			out.print("</td>");
			out.print("<td>");
			out.print(ans.get(i).test);
			out.print("</td>");
			out.print("<td>");
			out.print(ans.get(i).quiz);
			out.print("</td>");
			out.print("<td>");
			out.print(ans.get(i).lab);
			out.print("</td>");
			out.print("<td>");
			out.print(ans.get(i).project);
			out.print("</td>");
			out.print("<td>");
			out.print(ans.get(i).rating);
			out.print("</td></tr>");
		}
		out.print("</table>");
	}

}
