package com.anweitech.teacher.domain;

//老师登陆界面
public class TeacherUser {

	private String user; //用户
	private String pass; //密码

	public TeacherUser() {
		
	}
	
	public TeacherUser(String user,String pass) {
		this.user = user;
		this.pass = pass;
	}
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
}
