package com.anweitech.teacher.domain;


public class StudentAll {
	
	private String sid;
	private String sname;		//学生姓名
	private String slogtime;	//登录时间
	private String gkeyid;		//网关密钥对密钥数
	private String gtime;		//认证时间
	private String nodeid;		//节点对密钥随机数
	private String nodetime;	//认证时间
	private String netkeyid;	//网络密钥随机数
	private String nettime;		//认证时间
	private String gcnonce;		//网关响应挑战数
	private String gctime;		//认证时间
	private String ncnumber;	//节点对密钥协商数
	private String nctime;		//认证时间
	private String netcnumber;	//网络协商数 
	private String netctime;	//认证时间
	private String ckey;		//ckey
	private String cvalue;		//cvalue
	private String ctime;		//ctime
	private String uuid;		//uuid
	private String sgroup;		//组号
	private String level;		//等级
	

	public StudentAll(String sid, String sname, String slogtime, String gkeyid, String gtime, String nodeid,
			String nodetime, String netkeyid, String nettime, String gcnonce, String gctime, String ncnumber,
			String nctime, String netcnumber, String netctime, String ckey, String cvalue, String ctime, String uuid) {
		super();
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
	public String getLevel() {
		return level;
	}


	public void setLevel(String level) {
		this.level = level;
	}
	
	public StudentAll() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getSgroup() {
			return sgroup;
	}


	public void setSgroup(String sgroup) {
		this.sgroup = sgroup;
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
		if(this.slogtime!=null) {
			return slogtime;
		}else {
			return "无登陆时间";
		}	
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
		return "StudentAll [sid=" + sid + ", sname=" + sname + ", slogtime=" + slogtime + ", gkeyid=" + gkeyid
				+ ", gtime=" + gtime + ", nodeid=" + nodeid + ", nodetime=" + nodetime + ", netkeyid=" + netkeyid
				+ ", nettime=" + nettime + ", gcnonce=" + gcnonce + ", gctime=" + gctime + ", ncnumber=" + ncnumber
				+ ", nctime=" + nctime + ", netcnumber=" + netcnumber + ", netctime=" + netctime + ", ckey=" + ckey
				+ ", cvalue=" + cvalue + ", ctime=" + ctime + ", uuid=" + uuid + "]";
	}
	
}
