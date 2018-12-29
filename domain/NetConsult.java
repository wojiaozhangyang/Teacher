package com.anweitech.teacher.domain;

import java.sql.Timestamp;

public class NetConsult {

	private String sid;

	private String netcnumber;
	
	private Timestamp netctime;

	public NetConsult() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NetConsult(String sid, String netcnumber, Timestamp netctime) {
		super();
		this.sid = sid;
		this.netcnumber = netcnumber;
		this.netctime = netctime;
	}

	public String getSid() {
			return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getNetcnumber() {
		return netcnumber;
	}

	public void setNetcnumber(String netcnumber) {
		this.netcnumber = netcnumber;
	}

	public Timestamp getNetctime() {
		return netctime;
	}

	public void setNetctime(Timestamp netctime) {
		this.netctime = netctime;
	}
	
	
	
	
}
