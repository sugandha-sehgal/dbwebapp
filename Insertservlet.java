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

@WebServlet("/Insertservlet")
public class Insertservlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.sendRedirect("NewFile.jsp");
	  Connection con = null;
	  try {
          Class.forName("oracle.jdbc.driver.OracleDriver");
          con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "HR", "HR");
          System.out.println("Connection successful");
      } catch (Exception e) {
    	  System.out.println(e);
          System.out.println("Connection could not be established");
      }
	  
	  String sql = "INSERT INTO MarksData VALUES(?, ?, ?, ?, ?)";
	  String name=request.getParameter("st_name");
	  String subject= request.getParameter("subj");
	  String cat= request.getParameter("assign_cat");
	  String dos= request.getParameter("dos");
	  int marks=0;
	  try {
	  marks= Integer.parseInt(request.getParameter("poits"));} catch(Exception e) {response.sendRedirect("Failure.jsp"); return;}
	  if(name.isEmpty()||subject.isEmpty()||cat.isEmpty()||dos.isEmpty()) {response.sendRedirect("Failure.jsp");return;}
		try {
	        PreparedStatement prep = con.prepareStatement(sql);
	        prep.setString(1, name);
	        prep.setString(2, subject);
	        prep.setString(3, cat);
	        prep.setString(4, dos);
	        prep.setInt(5, marks);
	        prep.executeQuery();
	        response.sendRedirect("NewFile.jsp");
			} 
			catch(Exception e) {
				 response.sendRedirect("Failure.jsp");
			}
	}

}
