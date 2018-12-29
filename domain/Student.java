package com.anweitech.teacher.domain;

import java.sql.Timestamp;

public class Student {

	private String sid;

	private String sname;
	
	private Timestamp slogtime;
	
	private String uuid;
	
	private String whether_online;
	
	private String sgroup;
	
	private String level;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String sid, String sname, Timestamp slogtime, String uuid, String whether_online, String sgroup,
			String level) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.slogtime = slogtime;
		this.uuid = uuid;
		this.whether_online = whether_online;
		this.sgroup = sgroup;
		this.level = level;
	}

	public String getSid() {
		return sid;
	}	

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Timestamp getSlogtime() {
		if(this.slogtime!=null) {
			return slogtime;
		}else {
			return new Timestamp(0);
		}
	}

	public void setSlogtime(Timestamp slogtime) {
		this.slogtime = slogtime;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getWhether_online() {
		return whether_online;
	}

	public void setWhether_online(String whether_online) {
		this.whether_online = whether_online;
	}

	public String getSgroup() {
		if(sgroup!=null)
			return sgroup;
		else
			return "空组";
	}

	public void setSgroup(String sgroup) {
		this.sgroup = sgroup;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", slogtime=" + slogtime + ", uuid=" + uuid
				+ ", whether_online=" + whether_online + ", sgroup=" + sgroup + ", level=" + level + "]";
	}




	

}
