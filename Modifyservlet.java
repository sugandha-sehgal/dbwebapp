package com.wipro.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Modifyservlet")
public class Modifyservlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = null;
		  try {
	          Class.forName("oracle.jdbc.driver.OracleDriver");
	          con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "HR", "HR");
	          System.out.println("Connection successful");
	      } catch (Exception e) {
	    	  System.out.println(e);
	          System.out.println("Connection could not be established");
	      }
		  String sql = "update MarksData set dos= ? , poits= ? where st_name= ? and subj= ? and assign_cat= ?";
		  String name=request.getParameter("st_name2");
		  String subject= request.getParameter("subj2");
		  String cat= request.getParameter("assign_cat2");
		  String dos= request.getParameter("dos2");
		  int marks=0;
		  try {
			  marks= Integer.parseInt(request.getParameter("poits2"));} catch(Exception e) {response.sendRedirect("Failure.jsp"); return;}
		  if(name.isEmpty()||subject.isEmpty()||cat.isEmpty()||dos.isEmpty()) {response.sendRedirect("Failure.jsp");return;}
			try {
		        PreparedStatement prep = con.prepareStatement(sql);
		        prep.setString(1, dos);
		        prep.setInt(2, marks);
		        prep.setString(3, name);
		        prep.setString(4, subject);
		        prep.setString(5, cat);
		        prep.executeQuery();
		        response.sendRedirect("NewFile.jsp");
				} 
				catch(Exception e) {
					 response.sendRedirect("Failure.jsp");
				}
	}


}
