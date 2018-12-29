package com.anweitech.teacher.domain;

import java.sql.Timestamp;

public class NodeKey {
	private String sid;
	
	private String nodeid;
	
	private Timestamp nodetime;

	public NodeKey() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NodeKey(String sid, String nodeid, Timestamp nodetime) {
		super();
		this.sid = sid;
		this.nodeid = nodeid;
		this.nodetime = nodetime;
	}

	public String getSid() {
			return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getNodeid() {
		return nodeid;
	}

	public void setNodeid(String nodeid) {
		this.nodeid = nodeid;
	}

	public Timestamp getNodetime() {
		return nodetime;
	}

	public void setNodetime(Timestamp nodetime) {
		this.nodetime = nodetime;
	}


	
	
	
}
