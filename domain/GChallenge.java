package com.anweitech.teacher.domain;

import java.sql.Timestamp;

public class GChallenge {
	
	private String sid;

	private String gcnonce;
	
	private Timestamp gctime;

	public GChallenge() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GChallenge(String sid, String gcnonce, Timestamp gctime) {
		super();
		this.sid = sid;
		this.gcnonce = gcnonce;
		this.gctime = gctime;
	}

	public String getSid() {
			return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getGcnonce() {
		return gcnonce;
	}

	public void setGcnonce(String gcnonce) {
		this.gcnonce = gcnonce;
	}

	public Timestamp getGctime() {
		return gctime;
	}

	public void setGctime(Timestamp gctime) {
		this.gctime = gctime;
	}
	
	
	
	
}
