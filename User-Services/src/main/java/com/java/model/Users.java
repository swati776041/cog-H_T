package com.java.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Users
{
@Id
private int userid;
private String username;
private String userrole;
private String emailid;
public Users(int userid, String username, String userrole, String emailid) {
	super();
	this.userid = userid;
	this.username = username;
	this.userrole = userrole;
	this.emailid = emailid;
}
public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getUserrole() {
	return userrole;
}
public void setUserrole(String userrole) {
	this.userrole = userrole;
}
public String getEmailid() {
	return emailid;
}
public void setEmailid(String emailid) {
	this.emailid = emailid;
}
@Override
public String toString() {
	return "Users [userid=" + userid + ", username=" + username + ", userrole=" + userrole + ", emailid=" + emailid
			+ "]";
}

}