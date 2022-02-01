package com.wipro.main;

import java.util.ArrayList;

public class Rating {
	public Subject_Rating_Model getfinaldataSubj(ArrayList<DataModel>mydata, String name, String id) {
		Subject_Rating_Model x= new Subject_Rating_Model();
		try{x.student_name=name;
		double sum_test=0, sum_quiz=0, sum_lab=0, sum_project=0, rating=0;
		int size_test=0, size_quiz=0, size_lab=0, size_project=0;
		for(int i=0;i<mydata.size();i++) {
			if((mydata.get(i).st_name).equals(name) && (mydata.get(i).subj).equals(id)) {
			String assign= mydata.get(i).assign_cat;
			String assign2= assign.substring(0,assign.indexOf('_'));
			if(assign2.equals("test")) {sum_test+=(double)mydata.get(i).pts; size_test++;}
			else if(assign2.equals("quiz")) { sum_quiz+=(double) mydata.get(i).pts; size_quiz++;}
			else if(assign2.equals("lab")) {sum_lab+=(double) mydata.get(i).pts; size_lab++;}
			else if(assign2.equals("project")) {sum_project+=(double) mydata.get(i).pts; size_project++;}
			}
		}
		
		//System.out.println(sum_project);
		
		if(size_test==0) x.test="NA"; else {double k=(double)(sum_test/(size_test*100))*40; x.test=String.valueOf(k); rating+=k; }
		if(size_quiz==0) x.quiz="NA"; else {double k=(double)(sum_quiz/(size_quiz*100))*20; x.quiz=String.valueOf(k); rating+=k;}
		if(size_lab==0) x.lab="NA"; else {double k=(double)(sum_lab/(size_lab*100))*10; x.lab=String.valueOf(k); rating+=k;}
		if(size_project==0) x.project="NA"; else {double k=(double)(sum_project/(size_project*100))*30; x.project=String.valueOf(k); rating+=k;}
		x.rating=String.valueOf(rating);
		}
		catch(Exception e) {System.out.println(e);}
		return x;
	  }
	
public Student_Rating_Model getfinaldataStud(ArrayList<DataModel>mydata, String subj, String id){
		
		Student_Rating_Model x= new Student_Rating_Model();
		x.Subject=subj;
		double sum_test=0, sum_quiz=0, sum_lab=0, sum_project=0, rating=0;
		int size_test=0, size_quiz=0, size_lab=0, size_project=0;
		for(int i=0;i<mydata.size();i++) {
			if((mydata.get(i).st_name).equals(id) && (mydata.get(i).subj).equals(subj)) {
			String assign= mydata.get(i).assign_cat;
			String assign2= assign.substring(0,assign.indexOf('_'));
			if(assign2.equals("test")) {sum_test+=(double)mydata.get(i).pts; size_test++;}
			else if(assign2.equals("quiz")) { sum_quiz+=(double) mydata.get(i).pts; size_quiz++;}
			else if(assign2.equals("lab")) {sum_lab+=(double) mydata.get(i).pts; size_lab++;}
			else if(assign2.equals("project")) {sum_project+=(double) mydata.get(i).pts; size_project++;}
			}
		}
		
		//System.out.println(sum_project);
		
		if(size_test==0) x.test="NA"; else {double k=(double)(sum_test/(size_test*100))*40; x.test=String.valueOf(k); rating+=k; }
		if(size_quiz==0) x.quiz="NA"; else {double k=(double)(sum_quiz/(size_quiz*100))*20; x.quiz=String.valueOf(k); rating+=k;}
		if(size_lab==0) x.lab="NA"; else {double k=(double)(sum_lab/(size_lab*100))*10; x.lab=String.valueOf(k); rating+=k;}
		if(size_project==0) x.project="NA"; else {double k=(double)(sum_project/(size_project*100))*30; x.project=String.valueOf(k); rating+=k;}
		x.rating=String.valueOf(rating);
		return x;
	}
}
