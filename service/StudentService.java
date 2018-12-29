package com.anweitech.teacher.service;

import java.util.List;

import com.anweitech.teacher.domain.Cnt;
import com.anweitech.teacher.domain.GChallenge;
import com.anweitech.teacher.domain.GatewayKey;
import com.anweitech.teacher.domain.NConsult;
import com.anweitech.teacher.domain.NetConsult;
import com.anweitech.teacher.domain.NetKey;
import com.anweitech.teacher.domain.NodeKey;
import com.anweitech.teacher.domain.Student;
import com.anweitech.teacher.domain.TData;
import com.anweitech.teacher.domain.TData_fuben;
import com.anweitech.teacher.domain.TProcess;
import com.anweitech.teacher.domain.TeacherUser;
import com.anweitech.teacher.pojo.PageBean;
import com.anweitech.teacher.domain.StudentAll;
import com.anweitech.teacher.domain.StudentAll_fuben;

public interface StudentService {
	
	//向流程表添加具体操作
	void addTProcess(TProcess tProcess);
	
	//清空当前data表数据、初始化
	void deleteData();
	
	//清空主表数据
	void removeStudentAll(List<StudentAll> lsit);
	
	//根据时间查询数据
	List<StudentAll> findTimeStudentAll(String begin);
	List<TData> findTimeTData(String sid);
	
	//向备份表增加数据StudentAll_fuben、用于初始化
	void addStudentAll();
	//向备份表增加数据data_fuben、用于初始化
	void addTData();
	//向备份表增加数据data_fuben
	void addTData(List<TData> findAll, String sidd);
	
	//分页
	PageBean findlimit(Integer currentPage, Integer pageSize);
	
	//Student
	//添加
	void saveStudent(Student s);
	//查询
	Student findByStudent(String sid);
	//更新
	void updataStudent(Student student);
	
	//Cnt
	//添加
	void saveCnt(Cnt c);
	//查询
	Cnt findByCntId(String sid);
	//更新
	void updataCnt(Cnt c);
	
	//TData
	//添加
	void saveTData(TData tData);
	//查询
	TData findByTData(String sid);
	//更新
	void updataTData(TData tData);
	
	//NodeKey
	//添加
	void saveNodeKey(NodeKey nodeKey);
	//查询
	NodeKey findByNodeKey(String sid);
	//更新
	void updataNodeKey(NodeKey nodeKey);
	
	
	//NetKey
	//添加
	void saveNetKey(NetKey netKey);
	//查询
	NetKey findByNetKey(String sid);
	//更新
	void updataNetKey(NetKey netKey);
	
	//NetConsult
	//添加
	void saveNetConsult(NetConsult netConsult);
	//查询
	NetConsult findByNetConsult(String sid);
	//更新
	void updataNetConsult(NetConsult netConsult);
	
	//NConsult
	//添加
	void saveNConsult(NConsult nConsult);
	//查询
	NConsult findByNConsult(String sid);
	//更新
	void updataNConsult(NConsult nConsult);
	
	//GChallenge
	//添加
	void saveGChallenge(GChallenge gChallenge);
	//查询
	GChallenge findByGChallenge(String sid);
	//更新
	void updataGChallenge(GChallenge gChallenge);
	
	//GatewayKey
	//添加
	void saveGatewayKey(GatewayKey gatewayKey);
	//查询
	GatewayKey findByGatewayKey(String sid);
	//更新
	void updataGatewayKey(GatewayKey gatewayKey);
	
	
	/////////////////////////《wh》
	
	//tData find
	List<TData> findTDataAll(String Sid);
	
	//StudentAll_fuben find
	List<StudentAll> findStudent_fubenBetweenTime(String data1 , String data2 ,String pg) ;
	
	//StudentAll_fuben find count
	int findStudent_fubenBetweenTimeCount(String data1 , String data2);
	
	//TData_fuben find
	List<TData_fuben> findTData_fubenBySid(String sid,String pg,String data1,String data2);
	
	//TData_fuben find count
	int findTData_fubenBySidCount(String sid);
	
	//find StudentAll_fuben.*
	List<StudentAll_fuben> findStudentAll_fuben(String data1,String data2);
	//find TData_fuben.*
	List<TData_fuben> findTdata_fuben(String sid,String data1,String data2);
	//find Data by sid
	List<TData> findTDataBySid(String sid);
	//find student.*
	List<Student> findStudent();
	//find studentsname by sid where sid in 8 tables's sid
	String findStudentSnameBySid(String sid);
	//find TProcess between time
	List<TProcess> findTprocessBetweenTime(String time1,String time2);
	//find TProcess limit
	List<TProcess> findTprocessLimite(String data1,String data2,String pg);
	//find Tprocess count limit dtime
	int findCountFromTprocessLimitTime(String data1,String data2);
	//find StudentAll sname by sid
	String findStudentAllSname(String sid);
	//find Tdata.*
	List<TData> findTdata();
	//find * from Tdata by sid and slogtime
	List<TData_fuben> findTDataBySidAndSlogtime(String sid);
	//获取登陆的用户名信息
	TeacherUser findTeacherUserByUser(String user);
	//初始化数据
	void removeFromStudentAll(String sid);
	//得到组员的字符串
	List<Student> findGroupMember(String sgroup);
	//////////////////////////《/wh》
}
