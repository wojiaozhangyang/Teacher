package com.anweitech.teacher.domain;

import java.sql.Timestamp;

public class NConsult {
	
	private String sid;
	
	private String ncnumber;
	
	private Timestamp nctime;

	public NConsult() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NConsult(String sid, String ncnumber, Timestamp nctime) {
		super();
		this.sid = sid;
		this.ncnumber = ncnumber;
		this.nctime = nctime;
	}

	public String getSid() {
			return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getNcnumber() {
		return ncnumber;
	}

	public void setNcnumber(String ncnumber) {
		this.ncnumber = ncnumber;
	}

	public Timestamp getNctime() {
		return nctime;
	}

	public void setNctime(Timestamp nctime) {
		this.nctime = nctime;
	}
	
	
	
	
}
