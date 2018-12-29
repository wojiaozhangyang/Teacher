package com.anweitech.teacher.domain;

import java.sql.Timestamp;

public class Cnt {
	private String sid;
	
	private String ckey;

	private String cvalue;
	
	private Timestamp ctime;

	public Cnt() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cnt(String sid, String ckey, String cvalue, Timestamp ctime) {
		super();
		this.sid = sid;
		this.ckey = ckey;
		this.cvalue = cvalue;
		this.ctime = ctime;
	}

	public String getSid() {
			return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getCkey() {
		return ckey;
	}

	public void setCkey(String ckey) {
		this.ckey = ckey;
	}

	public String getCvalue() {
		return cvalue;
	}

	public void setCvalue(String cvalue) {
		this.cvalue = cvalue;
	}

	public Timestamp getCtime() {
		return ctime;
	}

	public void setCtime(Timestamp ctime) {
		this.ctime = ctime;
	}

	@Override
	public String toString() {
		return "Cnt [sid=" + sid + ", ckey=" + ckey + ", cvalue=" + cvalue + ", ctime=" + ctime + "]";
	}
	
	
	
}
