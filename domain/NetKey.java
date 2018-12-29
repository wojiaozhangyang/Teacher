package com.anweitech.teacher.domain;

import java.sql.Timestamp;

public class NetKey {
	
	private String sid;
	
	private String netkeyid;
	
	private Timestamp nettime;

	public NetKey() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NetKey(String sid, String netkeyid, Timestamp nettime) {
		super();
		this.sid = sid;
		this.netkeyid = netkeyid;
		this.nettime = nettime;
	}

	public String getSid() {
			return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getNetkeyid() {
		return netkeyid;
	}

	public void setNetkeyid(String netkeyid) {
		this.netkeyid = netkeyid;
	}

	public Timestamp getNettime() {
		return nettime;
	}

	public void setNettime(Timestamp nettime) {
		this.nettime = nettime;
	}
	
	
	
	
}
