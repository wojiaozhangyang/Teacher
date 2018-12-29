package com.anweitech.teacher.domain;


public class StudentAll_fuben {
	
	private Integer num;
	private String sid;
	private String sname;
	private String slogtime;
	private String gkeyid;
	private String gtime;
	private String nodeid;
	private String nodetime;
	private String netkeyid;
	private String nettime;
	private String gcnonce;
	private String gctime;
	private String ncnumber;
	private String nctime;
	private String netcnumber;
	private String netctime;
	private String ckey;
	private String cvalue;
	private String ctime;
	private String uuid;
	private String sgroup;
	private String level;
	
	public StudentAll_fuben() {
		super();
		// TODO Auto-generated constructor stub
	}


	public StudentAll_fuben(Integer num, String sid, String sname, String slogtime, String gkeyid, String gtime,
			String nodeid, String nodetime, String netkeyid, String nettime, String gcnonce, String gctime,
			String ncnumber, String nctime, String netcnumber, String netctime, String ckey, String cvalue,
			String ctime, String uuid) {
		super();
		this.num = num;
		this.sid = sid;
		this.sname = sname;
		this.slogtime = slogtime;
		this.gkeyid = gkeyid;
		this.gtime = gtime;
		this.nodeid = nodeid;
		this.nodetime = nodetime;
		this.netkeyid = netkeyid;
		this.nettime = nettime;
		this.gcnonce = gcnonce;
		this.gctime = gctime;
		this.ncnumber = ncnumber;
		this.nctime = nctime;
		this.netcnumber = netcnumber;
		this.netctime = netctime;
		this.ckey = ckey;
		this.cvalue = cvalue;
		this.ctime = ctime;
		this.uuid = uuid;
	}
	
	public String getSgroup() {
			return sgroup;
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

	
	

	public Integer getNum() {
		return num;
	}


	public void setNum(Integer num) {
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


	public String getSlogtime() {
		return slogtime;
	}


	public void setSlogtime(String slogtime) {
		this.slogtime = slogtime;
	}


	public String getGkeyid() {
		return gkeyid;
	}


	public void setGkeyid(String gkeyid) {
		this.gkeyid = gkeyid;
	}


	public String getGtime() {
		return gtime;
	}


	public void setGtime(String gtime) {
		this.gtime = gtime;
	}


	public String getNodeid() {
		return nodeid;
	}


	public void setNodeid(String nodeid) {
		this.nodeid = nodeid;
	}


	public String getNodetime() {
		return nodetime;
	}


	public void setNodetime(String nodetime) {
		this.nodetime = nodetime;
	}


	public String getNetkeyid() {
		return netkeyid;
	}


	public void setNetkeyid(String netkeyid) {
		this.netkeyid = netkeyid;
	}


	public String getNettime() {
		return nettime;
	}


	public void setNettime(String nettime) {
		this.nettime = nettime;
	}


	public String getGcnonce() {
		return gcnonce;
	}


	public void setGcnonce(String gcnonce) {
		this.gcnonce = gcnonce;
	}


	public String getGctime() {
		return gctime;
	}


	public void setGctime(String gctime) {
		this.gctime = gctime;
	}


	public String getNcnumber() {
		return ncnumber;
	}


	public void setNcnumber(String ncnumber) {
		this.ncnumber = ncnumber;
	}


	public String getNctime() {
		return nctime;
	}


	public void setNctime(String nctime) {
		this.nctime = nctime;
	}


	public String getNetcnumber() {
		return netcnumber;
	}


	public void setNetcnumber(String netcnumber) {
		this.netcnumber = netcnumber;
	}


	public String getNetctime() {
		return netctime;
	}


	public void setNetctime(String netctime) {
		this.netctime = netctime;
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


	public String getCtime() {
		return ctime;
	}


	public void setCtime(String ctime) {
		this.ctime = ctime;
	}


	public String getUuid() {
		return uuid;
	}


	public void setUuid(String uuid) {
		this.uuid = uuid;
	}


	@Override
	public String toString() {
		return "StudentAll_fuben [num=" + num + ", sid=" + sid + ", sname=" + sname + ", slogtime=" + slogtime
				+ ", gkeyid=" + gkeyid + ", gtime=" + gtime + ", nodeid=" + nodeid + ", nodetime=" + nodetime
				+ ", netkeyid=" + netkeyid + ", nettime=" + nettime + ", gcnonce=" + gcnonce + ", gctime=" + gctime
				+ ", ncnumber=" + ncnumber + ", nctime=" + nctime + ", netcnumber=" + netcnumber + ", netctime="
				+ netctime + ", ckey=" + ckey + ", cvalue=" + cvalue + ", ctime=" + ctime + ", uuid=" + uuid + "]";
	}

}
