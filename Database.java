package com.wipro.main;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {
	
	public static Connection con=null;
	public static ArrayList<DataModel> mydata= new ArrayList<DataModel>();
	
	public void createConnection(){
		try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "HR", "HR");
            System.out.println("Connection successful");
        } catch (Exception e) {
            System.out.println("Connection could not be established");
        }
	}

	public void fetchData() {
		try {
			Statement prep= con.createStatement();
			ResultSet rs = prep.executeQuery("SELECT * FROM MarksData");
			while(rs.next()) {
				mydata.add(new DataModel(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5))); 
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public ArrayList<Subject_Rating_Model> showRatingForSubject(String subj_id) {
		Map<String, String> mp = new HashMap<String, String>();
		Rating rt= new Rating();
		ArrayList<Subject_Rating_Model> ans= new ArrayList<Subject_Rating_Model>();
		for(int i=0;i<mydata.size();i++) {
			String st_name= mydata.get(i).st_name;
			
			if(!mp.containsKey(st_name)) {
				mp.put(st_name, "yes");
				ans.add(rt.getfinaldataSubj(mydata,st_name,subj_id));
			}
		}
		for(int i=0;i<mydata.size();i++) System.out.println(mydata.get(i).st_name);
		for(int i=0;i<5;i++)
		System.out.println("");
      System.out.printf("%-30s%-20s%-20s%-20s%-20s%-20s\n","Student","Test", "Quiz","Lab", "Project", "Rating");
		
		for(int i=0;i<ans.size();i++) {
			System.out.printf("%-30s%-20s%-20s%-20s%-20s%-20s\n",ans.get(i).student_name,ans.get(i).test, ans.get(i).quiz,ans.get(i).lab, ans.get(i).project, ans.get(i).rating);
			
		}
		
		return ans;
	
	}
	
	public ArrayList<Student_Rating_Model> showRatingForStudent(String stud_id) {
		Map<String, String> mp = new HashMap<String, String>();
		Rating rt= new Rating();
		ArrayList<Student_Rating_Model> ans= new ArrayList<Student_Rating_Model>();
		for(int i=0;i<mydata.size();i++) {
			String subj= mydata.get(i).subj;
			
			if(!mp.containsKey(subj)) {
				mp.put(subj, "yes");
				ans.add(rt.getfinaldataStud(mydata,subj,stud_id));
			}
		}
		for(int i=0;i<5;i++)
		System.out.println("");
      System.out.printf("%-30s%-20s%-20s%-20s%-20s%-20s\n","Student","Test", "Quiz","Lab", "Project", "Rating");
		
		for(int i=0;i<ans.size();i++) {
			System.out.printf("%-30s%-20s%-20s%-20s%-20s%-20s\n",ans.get(i).Subject,ans.get(i).test, ans.get(i).quiz,ans.get(i).lab, ans.get(i).project, ans.get(i).rating);
			
		}
		return ans;
	
	}

}
