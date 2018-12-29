package com.anweitech.teacher.domain;

import java.sql.Timestamp;

public class TProcess {
	
	private int num;
	private String sid;
	private String sname;
	private String status;
	private String behavior;
	private String operate;
	private Timestamp ptime;
	
	public TProcess() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TProcess(int num, String sid, String sname, String status, String behavior, String operate,
			Timestamp ptime) {
		super();
		this.num = num;
		this.sid = sid;
		this.sname = sname;
		this.status = status;
		this.behavior = behavior;
		this.operate = operate;
		this.ptime = ptime;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBehavior() {
		return behavior;
	}

	public void setBehavior(String behavior) {
		this.behavior = behavior;
	}

	public String getOperate() {
		return operate;
	}

	public void setOperate(String operate) {
		this.operate = operate;
	}

	public Timestamp getPtime() {
		return ptime;
	}

	public void setPtime(Timestamp ptime) {
		this.ptime = ptime;
	}

	@Override
	public String toString() {
		return "TProcess [num=" + num + ", sid=" + sid + ", sname=" + sname + ", status=" + status + ", behavior="
				+ behavior + ", operate=" + operate + ", ptime=" + ptime + "]";
	}
	
}
