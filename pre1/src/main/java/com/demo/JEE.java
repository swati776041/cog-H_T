package com.demo;

public class JEE {
 int courseid;
 String coursename;
 String courseteacher;
 int courseduration;
 int coursefees;
 public JEE(int courseid,String coursename,String courseteacher,int courseduration,double coursefees) {

this.courseid=courseid;
 this.coursename=coursename;
 this.courseteacher=courseteacher;
 this.courseduration=courseduration;
 this.coursefees=(int) coursefees;
 }
@Override
public String toString()
{
	return courseid + " "+coursename + " "+courseteacher+" "+courseduration+" "+coursefees;
	
}
public String getName() {
	
	return coursename;
}

public int getFees() {
	
	return coursefees;
}
}
