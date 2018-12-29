package com.anweitech.teacher.service.impl;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.fastjson.JSON;
import com.anweitech.teacher.dao.impl.StudentDaoImpl;
import com.anweitech.teacher.domain.Cnt;
import com.anweitech.teacher.domain.GChallenge;
import com.anweitech.teacher.domain.GatewayKey;
import com.anweitech.teacher.domain.NConsult;
import com.anweitech.teacher.domain.NetConsult;
import com.anweitech.teacher.domain.NetKey;
import com.anweitech.teacher.domain.NodeKey;
import com.anweitech.teacher.domain.Student;
import com.anweitech.teacher.domain.StudentAll;
import com.anweitech.teacher.domain.TData;
import com.anweitech.teacher.domain.TProcess;
import com.anweitech.teacher.pojo.DetailedOperationInput;
import com.anweitech.teacher.service.MessageProcessing;
import com.anweitech.teacher.service.StudentService;

public class MessageProcessingImpl implements MessageProcessing {

	@Autowired
	private StudentService ss;

	@Autowired
	private StudentDaoImpl sdi;
	
	private DetailedOperationInput doi = new DetailedOperationInput();
	private String operation;
	
	
	static private String uuuid = null;
	public static String getUuuid() {
		return uuuid;
	}

	//获取学生信息
	static private Student sstudnet;
	
	/**
	 * 1:Student		学生表
	 * 2:GatewayKey		网关秘钥表
	 * 3:NodeKey		节点秘钥表
	 * 4:NetKey			网络秘钥表
	 * 5:GChallenge		网关响应挑战表
	 * 6:NConsult		对秘钥协商表
	 * 7:NetConsult		网络协商表
	 * 8:TData			传感数据表
	 * 9：初始化			清空当前TData
	 * 10:Cnt			计算表
	 */
	@Override
	public void message(String text) {

		String[] split = text.split("-");
		String sid = null;
		TProcess process = new TProcess();
		
		
		switch (split[0]) {
		
			/**
			 * 每次请求过来后、判断sid是否存在数据库中、
			 * 如果存在执行修改操作、覆盖掉上一次登陆信息
			 */
			case "1":
				sstudnet = JSON.parseObject(split[1], Student.class);
				String uuid = UUID.randomUUID().toString();
				sstudnet.setUuid(uuid);
				
				if(sstudnet.getSid() == null || sstudnet.getSid().equals(""))
				{
					
				}

				//根据传入的student对象的sid去查询数据库、
				//查看该sid是否注册过
				Student student = null;
				try {
					student = ss.findByStudent(sstudnet.getSid());
				}catch(Exception e){
					sstudnet.setSid("身份不明");
				}

//				if(student != null) {
//					sid = sstudnet.getSid();
//					sname = sstudnet.getSname();
//				}
				if(student.getSid() == null || student.getSid().equals(""))
					ss.saveStudent(sstudnet);
				else
					ss.updataStudent(sstudnet);
				
				process.setSid(sstudnet.getSid());
				process.setSname(sstudnet.getSname());
				process.setStatus("登陆");
				process.setBehavior("登陆成功");
				process.setOperate(sstudnet.getSname());
				process.setPtime(sstudnet.getSlogtime());
				
				if(sstudnet.getSid()!=null) {
					ss.addTProcess(process);
				}
				if(sstudnet.getSid()!=null) {
					if(sstudnet.getLevel().equals("1"))
						operation=""+sstudnet.getSgroup()+"|登陆|登陆成功|组长:"+sstudnet.getSname()+"|"+sstudnet.getSlogtime();
					else
						operation=""+sstudnet.getSgroup()+"|登陆|登陆成功|组员:"+sstudnet.getSname()+"|"+sstudnet.getSlogtime();
					doi.WhiteInLine(operation);
				}
				else
					operation="";
				break;
				
			case "2":
				GatewayKey g = JSON.parseObject(split[1], GatewayKey.class);
				
				//根据传入的student对象的sid去查询数据库、
				//查看该sid是否注册过
				GatewayKey gatewayKey = ss.findByGatewayKey(g.getSid());
				if(gatewayKey != null)
					sid = g.getSid();
				
				if(sid == null || sid.equals(""))
					ss.saveGatewayKey(g);
				else
					ss.updataGatewayKey(g);
				
				process.setSid(g.getSid());
				process.setSname(ss.findStudentSnameBySid(g.getSid()));
				process.setStatus("设置网关密钥");
				process.setBehavior("成功");
				process.setOperate(g.getGkeyid());
				process.setPtime(g.getGtime());
				
				if(g.getSid()!=null)
					ss.addTProcess(process);
				
				if(g.getSid()!=null) {
					operation=ss.findStudentSnameBySid(g.getSid())+"|设置网关密钥|成功|"+g.getGkeyid()+"|"+g.getGtime();
					doi.WhiteInLine(operation);
				}
				
				else
					operation=null;
				break;
				
			case "3":
				NodeKey nk = JSON.parseObject(split[1], NodeKey.class);
				
				//根据传入的student对象的sid去查询数据库、
				//查看该sid是否注册过
				NodeKey nodeKey = ss.findByNodeKey(nk.getSid());
				if(nodeKey != null)
					sid = nk.getSid();
				
				if(sid == null || sid.equals(""))
					ss.saveNodeKey(nk);
				else
					ss.updataNodeKey(nk);
				
				process.setSid(nk.getSid());
				process.setSname(ss.findStudentSnameBySid(nk.getSid()));
				process.setStatus("设置节点秘钥");
				process.setBehavior("成功");
				process.setOperate(nk.getNodeid());
				process.setPtime(nk.getNodetime());
				
				if(nk.getSid()!=null)
					ss.addTProcess(process);
				
				
				if(nk.getSid()!=null) {
					operation=ss.findStudentSnameBySid(nk.getSid())+"|设置节点秘钥|成功|"+nk.getNodeid()+"|"+nk.getNodetime();
					doi.WhiteInLine(operation);
				}
				else
					operation=null;
				
				break;
				
			case "4":
				NetKey netK = JSON.parseObject(split[1], NetKey.class);
				
				//根据传入的student对象的sid去查询数据库、
				//查看该sid是否注册过
				NetKey netKey = ss.findByNetKey(netK.getSid());
				if(netKey != null)
					sid = netK.getSid();
				
				if(sid == null || sid.equals(""))
					ss.saveNetKey(netK);
				else
					ss.updataNetKey(netK);
				
				process.setSid(netKey.getSid());
				process.setSname(ss.findStudentSnameBySid(netKey.getSid()));
				process.setStatus("设置广播身份密钥");
				process.setBehavior("成功");
				process.setOperate(netKey.getNetkeyid());
				process.setPtime(netKey.getNettime());
				
				if(netKey.getSid()!=null)
					ss.addTProcess(process);
				
				if(netK.getSid()!=null) {
					operation=ss.findStudentSnameBySid(netKey.getSid())+"|设置广播密钥|成功|"+netK.getNetkeyid()+"|"+netK.getNettime();
					doi.WhiteInLine(operation);
				}
				else
					operation=null;
				
				break;
				
			case "5":
				GChallenge gc = JSON.parseObject(split[1], GChallenge.class);
				
				//根据传入的student对象的sid去查询数据库、
				//查看该sid是否注册过
				GChallenge gChallenge = ss.findByGChallenge(gc.getSid());
				if(gChallenge != null)
					sid = gc.getSid();
				
				if(sid == null || sid.equals(""))
					ss.saveGChallenge(gc);
				else
					ss.updataGChallenge(gc);
				
				process.setSid(gChallenge.getSid());
				process.setSname(ss.findStudentSnameBySid(gc.getSid()));
				process.setStatus("设置网关响应挑战数");
				process.setBehavior("成功");
				process.setOperate(gChallenge.getGcnonce());
				process.setPtime(gChallenge.getGctime());
				
				if(gChallenge.getSid()!=null)
					ss.addTProcess(process);				
				if(gc.getSid()!=null) {
					operation=ss.findStudentSnameBySid(gc.getSid())+"|设置网关响应挑战数|成功|"+gc.getGcnonce()+"|"+gc.getGctime();
					doi.WhiteInLine(operation);
				}else
					operation=null;
				
				break;
				
			case "6":
				NConsult nc = JSON.parseObject(split[1], NConsult.class);

				//根据传入的student对象的sid去查询数据库、
				//查看该sid是否注册过
				NConsult nConsult = ss.findByNConsult(nc.getSid());
				if(nConsult != null)
					sid = nc.getSid();
				
				if(sid == null || sid.equals(""))
					ss.saveNConsult(nc);
				else 
					ss.updataNConsult(nc);
				
				process.setSid(nConsult.getSid());
				process.setSname(ss.findStudentSnameBySid(nc.getSid()));
				process.setStatus("身份密钥协商");
				process.setBehavior("成功");
				process.setOperate(nConsult.getNcnumber());
				process.setPtime(nConsult.getNctime());
				
				if(nConsult.getSid()!=null)
					ss.addTProcess(process);
				
				if(nConsult.getSid()!=null) {
					operation=ss.findStudentSnameBySid(nc.getSid())+"|身份密钥协商|成功|"+nConsult.getNcnumber()+"|"+nConsult.getNctime();
					doi.WhiteInLine(operation);
				}else {
					operation=null;
				}
				
				break;
				
			case "7":
				NetConsult netC = JSON.parseObject(split[1], NetConsult.class);

				//根据传入的student对象的sid去查询数据库、
				//查看该sid是否注册过
				NetConsult netConsult = ss.findByNetConsult(netC.getSid());
				if(netConsult != null)
					sid = netC.getSid();
				
				if(sid == null || sid.equals(""))
					ss.saveNetConsult(netC);
				else
					ss.updataNetConsult(netC);
				
				//将具体操作添加到process表
				process.setSid(netConsult.getSid());
				process.setSname(ss.findStudentSnameBySid(netC.getSid()));
				process.setStatus("网络协商");
				process.setBehavior("成功");
				process.setOperate(netConsult.getNetcnumber());
				process.setPtime(netConsult.getNetctime());
				
				if(netConsult.getSid()!=null)
					ss.addTProcess(process);
				
				if(netC.getSid()!=null) {
					operation=ss.findStudentSnameBySid(netC.getSid())+"|网络协商|成功|"+netC.getNetcnumber()+"|"+netC.getNetctime();
					doi.WhiteInLine(operation);
				}else {
					operation=null;
				}
				
				break;
				
			case "8":
				TData td = JSON.parseObject(split[1], TData.class);

				//根据传入的student象的sid去查询数据库、
				//查看该sid是否注册过
				TData tData = ss.findByTData(td.getSid());
				if(tData != null)
					sid = td.getSid();
				
				//subtype字段意义转换
				if(td.getSubtype().equals("1")) {
					td.setSubtype("光照");
				}else if(td.getSubtype().equals("6")) {
					td.setSubtype("湿度");
				}else if(td.getSubtype().equals("7")) {
					td.setSubtype("温度");
				}
				
				//subtype字段意义转换
				if(td.getEncryptionflag().equals("1")) {
					td.setEncryptionflag("present");
				}else if(td.getEncryptionflag().equals("2")) {
					td.setEncryptionflag("ZUC");
				}else if(td.getEncryptionflag().equals("3")) {
					td.setEncryptionflag("未知加密类型");
				}else if(td.getEncryptionflag().equals("4")) {
					td.setEncryptionflag("未认证");
				}
				
				ss.saveTData(td);
								

				
				if(tData.getSid()!=null)
					ss.addTProcess(process);

//				if(tData.getSid()!=null) {
//					operation=ss.findStudentSnameBySid(tData.getSid())+"|温湿度|"+"上传成功|成功"+"|"+tData.getDtime();
//					doi.WhiteInLine(operation);
//				}else {
//					operation=null;
//				}
				
				break;
				
			case "9":
				Student s = JSON.parseObject(split[1], Student.class);
				ss.removeFromStudentAll(sid);
				break;
				
			case "10":
				Cnt cnt = JSON.parseObject(split[1], Cnt.class);
				
				Cnt ccnt = ss.findByCntId(cnt.getSid());
				if(ccnt != null)
					sid = cnt.getSid();
				
				if(sid == null || sid.equals(""))
					ss.saveCnt(cnt);
				else
					ss.updataCnt(cnt);
				
				process.setSid(cnt.getSid());
				process.setStatus("merkle树计算");
				process.setBehavior("选取的merkle树路径");
				process.setOperate(cnt.getCkey());
				process.setPtime(cnt.getCtime());
				
				if(cnt.getSid()!=null) {
					operation=ss.findStudentSnameBySid(cnt.getSid()+"|merkle树计算|"+"选取的merkle树路径"+"|"+cnt.getCkey()+"|"+cnt.getCtime());
					doi.WhiteInLine(operation);
				}else {
					operation=null;
				}
				
				break;
				
			case "error":
				TProcess p = JSON.parseObject(split[1], TProcess.class);
				if(p !=null && p.getSid() != null && p.getSname() != null) {//如果有sid，和sname
					ss.addTProcess(p);
				}else {
					p.setSid("错误组");
					p.setSname("错误名字");
					ss.addTProcess(p);
				}
				if(p.getSid()!=null) {
					operation=ss.findStudentSnameBySid(p.getSid())+"|"+p.getStatus()+"|"+p.getBehavior()+"|"+p.getOperate().replaceAll("\\[","").replaceAll("\\]", "")+"|"+p.getPtime();
					doi.WhiteInLine(operation);
				}else {
					operation=null;
				}
				
				break;
				
//			case "login":
//				JSONObject json = JSON.parseObject(split[1]);
//				sstudnet = ss.findByStudent(json.getString("sid"));
//				
//				if(sstudnet != null) {
//					uuuid = json.getString("uuid");
//					HeartListener hl = new HeartListener(json.getString("sid"), json.get("uuid").toString());
//					hl.start();
//				}
//				
//				break;
				
			default:
				System.out.println("传入的参数:丨" +split[0] +"|不合法。|将不做任何处理");
				break;
		}
		
	}

}
