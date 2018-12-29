package com.anweitech.teacher.domain;

import java.sql.Timestamp;

public class GatewayKey {
	
	private String sid;
	
	private String gkeyid;
	
	private Timestamp gtime;

	public GatewayKey() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GatewayKey(String sid, String gkeyid, Timestamp gtime) {
		super();
		this.sid = sid;
		this.gkeyid = gkeyid;
		this.gtime = gtime;
	}

	public String getSid() {
			return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getGkeyid() {
		return gkeyid;
	}

	public void setGkeyid(String gkeyid) {
		this.gkeyid = gkeyid;
	}

	public Timestamp getGtime() {
		return gtime;
	}

	public void setGtime(Timestamp gtime) {
		this.gtime = gtime;
	}
	
	
}	
