package com.wipro.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Studentservlet")
public class Studentservlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		String st_name= request.getParameter("st_name");
		out.print("<h1>Rating of ");
		out.print(st_name);
		out.print("</h1>");
		out.print("<table border='1'><tr><th>Subject</th><th>Test</th><th>Quiz</th><th>Lab</th><th>Project</th><th>Rating</th></tr>");
		if(st_name.isEmpty()) {response.sendRedirect("Failure.jsp");return;}
		Database db= new Database();
		db.createConnection();
		db.fetchData();
		ArrayList<Student_Rating_Model>ans=db.showRatingForStudent(st_name);
		for(int i=0;i<ans.size();i++) {
			out.print("<tr><td>");
			out.print(ans.get(i).Subject);
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
