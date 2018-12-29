package com.anweitech.teacher.domain;

import java.sql.Timestamp;

public class TData {
	private String num;
	
	public String sid;

	private String nodeidd;
	
	private String subtype;

	private String datavalue;
	
	private Timestamp dtime;

	private String mac;
	
	private String encryptionflag;
	
	private String data;
	
	private String retention1;
	
	private String retention2;
	
	
	public TData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TData(String num, String sid, String nodeidd, String subtype, String datavalue,
			Timestamp dtime, String mac, String encryptionflag, String data,
			String retention1, String retention2) {
		super();
		this.num = num;
		this.sid = sid;
		this.nodeidd = nodeidd;
		this.subtype = subtype;
		this.datavalue = datavalue;
		this.dtime = dtime;
		this.mac = mac;
		this.encryptionflag = encryptionflag;
		this.data = data;
		this.retention1 = retention1;
		this.retention2 = retention2;
	}
	
	public String getnum(){
		return num;
	}
	
	public void setnum(String num){
		this.num = num;
	}

	public String getSid() {
			return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getNodeidd() {
		return nodeidd;
	}

	public void setNodeidd(String nodeidd) {
		this.nodeidd = nodeidd;
	}

	public String getSubtype() {
		return subtype;
	}

	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}

	public String getDatavalue() {
		return datavalue;
	}

	public void setDatavalue(String datavalue) {
		this.datavalue = datavalue;
	}

	public Timestamp getDtime() {
		if(dtime==null)
			return new Timestamp(0);
		return dtime;
	}

	public void setDtime(Timestamp dtime) {
		this.dtime = dtime;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getEncryptionflag() {
		return encryptionflag;
	}

	public void setEncryptionflag(String encryptionflag) {
		this.encryptionflag = encryptionflag;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getRetention1() {
		return retention1;
	}

	public void setRetention1(String retention1) {
		this.retention1 = retention1;
	}

	public String getRetention2() {
		return retention2;
	}

	public void setRetention2(String retention2) {
		this.retention2 = retention2;
	}

	@Override
	public String toString() {
		return "TData [num=" + num +", sid=" + sid + ", nodeidd=" + nodeidd + ", subtype="
				+ subtype + ", datavalue=" + datavalue + ", dtime=" + dtime
				+ ", mac=" + mac + ", encryptionflag=" + encryptionflag
				+ ", data=" + data + ", retention1=" + retention1
				+ ", retention2=" + retention2 + "]";
	}
	
}
