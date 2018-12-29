package com.anweitech.teacher.service.impl;

import java.util.List;
import com.anweitech.teacher.dao.StudentDao;
import com.anweitech.teacher.domain.Cnt;
import com.anweitech.teacher.domain.GChallenge;
import com.anweitech.teacher.domain.GatewayKey;
import com.anweitech.teacher.domain.NConsult;
import com.anweitech.teacher.domain.NetConsult;
import com.anweitech.teacher.domain.NetKey;
import com.anweitech.teacher.domain.NodeKey;
import com.anweitech.teacher.domain.Student;
import com.anweitech.teacher.domain.StudentAll;
import com.anweitech.teacher.domain.StudentAll_fuben;
import com.anweitech.teacher.domain.TData;
import com.anweitech.teacher.domain.TData_fuben;
import com.anweitech.teacher.domain.TProcess;
import com.anweitech.teacher.domain.TeacherUser;
import com.anweitech.teacher.pojo.PageBean;
import com.anweitech.teacher.service.StudentService;

public class StudentServiceImpl implements StudentService {
	
	private StudentDao sd;
	
	public void setSd(StudentDao sd) {
		this.sd = sd;
	}
	
	//向流程表添加具体操作
	@Override
	public void addTProcess(TProcess tProcess) {

		sd.addTProcess(tProcess);
	}

	
	//清空当前data表数据、初始化
	@Override
	public void deleteData() {
		sd.deleteData();
	}
	
	//清空主表数据
	public void removeStudentAll(List<StudentAll> list) {
		for (StudentAll studentAll : list) {
			String sid = studentAll.getSid();
			sd.removeStudentAll(sid);
		}
	}
	
	//根据时间查询数据
	@Override
	public List<StudentAll> findTimeStudentAll(String begin) {
		
		return sd.findTimeStudentAll(begin);
		
	}
	@Override
	public List<TData> findTimeTData(String sid) {
		
		return sd.findTimeTData(sid);
	}
	
	
	//向备份表增加数据StudentAll_fuben、data_fuben、用于初始化
	@Override
	public void addStudentAll() {

		List<StudentAll> findAll = sd.findByStudentAll();
		
		for (StudentAll sa : findAll) {
			
			String uuid = sa.getUuid();
			
			//判断uuid是否存在、如果存在返回false不添加、不存在返回true并保存
			if(sd.findByUUID(uuid).size() == 0) {
				StudentAll_fuben sf = new StudentAll_fuben();
				sf.setSid(sa.getSid());
				sf.setSname(sa.getSname());
				sf.setSlogtime(sa.getSlogtime());
				sf.setGkeyid(sa.getGkeyid());
				sf.setGtime(sa.getGtime());
				sf.setNodeid(sa.getNodeid());
				sf.setNodetime(sa.getNodetime());
				sf.setNetkeyid(sa.getNetkeyid());
				sf.setNettime(sa.getNettime());
				sf.setGcnonce(sa.getGcnonce());
				sf.setGctime(sa.getGctime());
				sf.setNcnumber(sa.getNcnumber());
				sf.setNctime(sa.getNctime());
				sf.setNetcnumber(sa.getNetcnumber());
				sf.setNetctime(sa.getNetctime());
				sf.setCkey(sa.getCkey());
				sf.setCvalue(sa.getCvalue());
				sf.setCtime(sa.getCtime());
				sf.setUuid(sa.getUuid());
				sf.setLevel(sa.getLevel());
				sf.setSgroup(sa.getSgroup());
				sd.addStudentAll(sf);
			}
			
		}
	}
	//向备份表增加数据data_fuben、用于初始化
	@Override
	public void addTData() {
		
		List<TData> findAll = sd.findByTData();
		
		for (TData sa : findAll) {
			List st = sd.findStudent_fuben(sa.getnum());
			if(st.size() == 0) {
				TData_fuben sf = new TData_fuben();
				sf.setNum(sa.getnum());
				sf.setSid(sa.getSid());
				sf.setNodeidd(sa.getNodeidd());
				sf.setSubtype(sa.getSubtype());
				sf.setDatavalue(sa.getDatavalue());
				sf.setDtime(sa.getDtime());
				sf.setMac(sa.getMac());
				sf.setEncryptionflag(sa.getEncryptionflag());
				sf.setData(sa.getData());
				sf.setRetention1(sa.getRetention1());
				sf.setRetention2(sa.getRetention2());
				
				sd.addTData(sf);
			}
		}
	}
	//向备份表增加数据data_fuben
	@Override
	public void addTData(List<TData> findAll, String sidd) {
		
		for (TData sa : findAll) {
			
			TData_fuben sf = new TData_fuben();
			sf.setNum(sa.getnum());
			sf.setSid(sidd);
			sf.setNodeidd(sa.getNodeidd());
			sf.setSubtype(sa.getSubtype());
			sf.setDatavalue(sa.getDatavalue());
			sf.setDtime(sa.getDtime());
			sf.setMac(sa.getMac());
			
			sd.addTData(sf);
		}
	}
	
	//Student
	//添加
	@Override
	public void saveStudent(Student s) {

		sd.addStudent(s);
	}
	//查询
	@Override
	public Student findByStudent(String sid) {
		
		return sd.findAllStudent(sid);
	}
	//更新
	@Override
	public void updataStudent(Student student) {

		sd.updateStudent(student);
	}
	
	//Cnt
	//添加
	@Override
	public void saveCnt(Cnt c) {
		
		sd.addCnt(c);
	}
	//查询
	@Override
	public Cnt findByCntId(String sid) {
		
		return sd.findAllCnt(sid);
	}
	//更新
	@Override
	public void updataCnt(Cnt c) {

		sd.updateCnt(c);
	}
	

	//TData
	//增加
	@Override
	public void saveTData(TData tData) {

		sd.addData(tData);
	}
	//查询
	@Override
	public TData findByTData(String sid) {

		return sd.findAllData(sid);
	}
	//更新
	@Override
	public void updataTData(TData tData) {

		sd.updateData(tData);
	}

	//NodeKey
	//增加
	@Override
	public void saveNodeKey(NodeKey nodeKey) {

		sd.addNodeKey(nodeKey);
	}
	//查询
	@Override
	public NodeKey findByNodeKey(String sid) {
		
		return sd.findAllNodeKey(sid);
	}
	//更新
	@Override
	public void updataNodeKey(NodeKey nodeKey) {

		sd.updateNodeKey(nodeKey);
	}
	

	//NetKey
	//增加
	@Override
	public void saveNetKey(NetKey netKey) {

		sd.addNetKey(netKey);
	}
	//查询
	@Override
	public NetKey findByNetKey(String sid) {

		return sd.findAllNetKey(sid);
	}
	//更新
	@Override
	public void updataNetKey(NetKey netKey) {


		sd.updateNetKey(netKey);
	}
	
	
	//NetConsult
	//增加
	@Override
	public void saveNetConsult(NetConsult netConsult) {

		sd.addNetConsult(netConsult);
	}
	//查询
	@Override
	public NetConsult findByNetConsult(String sid) {

		return sd.findAllNetConsult(sid);
	}
	//更新
	@Override
	public void updataNetConsult(NetConsult netConsult) {

		sd.updateNetConsult(netConsult);
	}
	

	//NConsult
	//增加
	@Override
	public void saveNConsult(NConsult nConsult) {

		sd.addNConsult(nConsult);
	}
	//查询
	@Override
	public NConsult findByNConsult(String sid) {

		return sd.findAllNConsult(sid);
	}
	//更新
	@Override
	public void updataNConsult(NConsult nConsult) {

		sd.updateNConsult(nConsult);
	}
	

	//GChallenge
	//增加
	@Override
	public void saveGChallenge(GChallenge gChallenge) {

		sd.addGChallenge(gChallenge);
	}
	//查询
	@Override
	public GChallenge findByGChallenge(String sid) {

		return sd.findAllGChallenge(sid);
	}
	//更新
	@Override
	public void updataGChallenge(GChallenge gChallenge) {

		sd.updateGChallenge(gChallenge);
	}
	

	//GatewayKey
	//增加
	@Override
	public void saveGatewayKey(GatewayKey gatewayKey) {

		sd.addGatewayKey(gatewayKey);
	}
	//查询
	@Override
	public GatewayKey findByGatewayKey(String sid) {

		return sd.findAllGatewayKey(sid);
	}
	//更新
	@Override
	public void updataGatewayKey(GatewayKey gatewayKey) {

		sd.updateGatewayKey(gatewayKey);
	}
	
	
	//查所有实验步骤

	//Student paging
	@Override
	public PageBean findlimit(Integer currentPage, Integer pageSize) {
		
		PageBean bean = new PageBean();
		//当前页
		bean.setCurrentPage(currentPage);
		
		//每页记录数
		bean.setPageSize(pageSize);
		
		//总页数
		if(sd.findStudentCount()%pageSize == 0)
			bean.setTotalPage(sd.findStudentCount()/pageSize);
		else
			bean.setTotalPage((sd.findStudentCount()/pageSize)+1);
		
		//总记录数
		bean.setTotalCount(sd.findStudentCount());
		
		List<StudentAll> limit = sd.limitStudent(currentPage, pageSize);
		bean.setStudentAll(limit);
		
		return bean;
	}
	
	@Override
	public List<TData> findTDataAll(String sid) {
		// TODO Auto-generated method stub
		return sd.findTData(sid);
	}
	
	@Override
	public List<StudentAll> findStudent_fubenBetweenTime(String data1 , String data2 ,String pg) {
		return sd.findStudentAll_fubenBetweenTime(data1, data2 , pg);
	}
	
	@Override
	public int findStudent_fubenBetweenTimeCount(String data1, String data2) {
		// TODO Auto-generated method stub
		return sd.findStudentAll_fubenBetweenTimeCount(data1, data2);
	}
	
	@Override
	public List<TData_fuben> findTData_fubenBySid(String sid,String pg,String data1,String data2) {
		return sd.findTData_fubenBySid(sid,pg,data1,data2);
	}
	
	@Override
	public int findTData_fubenBySidCount(String sid) {
		return sd.findTData_fubenBySidCount(sid);
	}

	@Override
	public List<StudentAll_fuben> findStudentAll_fuben(String data1,String data2){
		return sd.findStudentAll_fuben(data1,data2);
	}
	
	@Override
	public List<TData_fuben> findTdata_fuben(String sid,String data1,String data2){
		return sd.findTdata_fuben(sid,data1,data2);
	}
	
	@Override
	public List<TData> findTDataBySid(String sid){
		return sd.findTDataBySid(sid);
	}

	
	@Override
	public List<Student> findStudent(){
		return sd.findStudent();
	}

	@Override
	public String findStudentSnameBySid(String sid) {
		// TODO Auto-generated method stub
		return sd.finsStudentSname(sid);
	}

	@Override
	public List<TProcess> findTprocessBetweenTime(String time1, String time2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TProcess> findTprocessLimite(String data1, String data2, String pg) {
		// TODO Auto-generated method stub
		return sd.findTprocessLimite(data1, data2, pg);
	}
	
	@Override
	public int findCountFromTprocessLimitTime(String data1,String data2) {
		return sd.findCountFromTprocessLimitTime(data1, data2);
	}
	
	@Override
	public String findStudentAllSname(String sid) {
		return sd.findStudentAllSname(sid);
	}
	
	@Override
	public List<TData> findTdata() {
		return sd.findTData();
	}
	
	@Override
	public List<TData_fuben> findTDataBySidAndSlogtime(String sid){
		return sd.findTDataBySidAndSlogtime(sid);
	}
	
	@Override
	public TeacherUser findTeacherUserByUser(String user) {
		if(sd.findTeacherUserByUser(user)!=null)
			return sd.findTeacherUserByUser(user);
		else
			return new TeacherUser();
	}
	
	@Override
	public void removeFromStudentAll(String sid) {
		sd.removeStudentAll(sid);
	}
	
	@Override
	public List<Student> findGroupMember(String sgroup){
		return sd.findGroupMemberBySid(sgroup);
	}
}
