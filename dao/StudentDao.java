package com.anweitech.teacher.dao;

import java.util.List;

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

public interface StudentDao {
	
	//select student_fuben
	List findStudent_fuben(String sid);
	
	//Update specific actions to the process table
	void updataTDate(TData_fuben tf);
	
	//Add specific actions to the process table
	void addTProcess(TProcess tProcess);
	
	//init data
	void deleteData();
	
	//find uuid
	List<?> findByUUID(String uuid);
	
	//remove table
	void removeStudentAll(String sid);
	
	//According to the time query
	List<StudentAll> findTimeStudentAll(String begin);
	List<TData> findTimeTData(String begin);
	
	//Add data to the backup table StudentAll_fuben
	void addStudentAll(StudentAll_fuben studentAll);
	//Add data to the backup table TData_fuben
	void addTData(TData_fuben sf);
	
	//find data
	List<TData> limitData(String sid, Integer currentPage, Integer pageSize);
	//find studnet
	List<StudentAll> limitStudent(Integer currentPage, Integer pageSize);
	
	//find student total number
	int findStudentCount();
	
	//find student total number
	int findTDataCount(String sid);
	
	
	//find all StudentAll
	List<StudentAll> findByStudentAll();
	//find all TData
	List<TData> findByTData();
	
	//Student
	//find all Student
	Student findAllStudent(String sid);
	//add information
	void addStudent(Student s);
	//update information
	void updateStudent(Student s);
	
	//Cnt
	//find all Can
	Cnt findAllCnt(String sid);
	//add information
	void addCnt(Cnt c);
	//update information
	void updateCnt(Cnt c);
	
	//Data
	//find Data 'id'
	TData findAllData(String sid);
	//add information
	void addData(TData s);
	//update information
	void updateData(TData s);
	
	//NodeKey
	//find all NodeKey
	NodeKey findAllNodeKey(String sid);
	//add information
	void addNodeKey(NodeKey s);
	//update information
	void updateNodeKey(NodeKey s);
	
	//NetKey
	//find all NetKey
	NetKey findAllNetKey(String sid);
	//add information
	void addNetKey(NetKey s);
	//update information
	void updateNetKey(NetKey s);
	
	//NetConsult
	//find all NetConsult
	NetConsult findAllNetConsult(String sid);
	//add information
	void addNetConsult(NetConsult s);
	//update information
	void updateNetConsult(NetConsult s);
	
	//NConsult
	//find all NConsult
	NConsult findAllNConsult(String sid);
	//add information
	void addNConsult(NConsult s);
	//update information
	void updateNConsult(NConsult s);
	
	//GChallenge
	//find all GChallenge
	GChallenge findAllGChallenge(String sid);
	//add information
	void addGChallenge(GChallenge s);
	//update information
	void updateGChallenge(GChallenge s);
	
	//GatewayKey
	//find all GatewayKey
	GatewayKey findAllGatewayKey(String sid);
	//add information
	void addGatewayKey(GatewayKey s);
	//update information
	void updateGatewayKey(GatewayKey s);
	
	//////////// <wh>
	//find TData all
	List<TData> findTData(String Sid);
	//find StudentAll_fuben between time1 and time2
	List<StudentAll> findStudentAll_fubenBetweenTime(String data1 , String data2 , String pg);
	//find StudentAll_fuben between time1 and time2 count
	int findStudentAll_fubenBetweenTimeCount(String data1 , String data2);
	//find Data_fube between time1 and time2
	List<TData_fuben> findTData_fubenBySid(String sid,String pg,String data1,String data2);
	//find Data_fube between time1 and time2 count
	int findTData_fubenBySidCount(String sid);
	//find StudentAll_fuben.*
	List<StudentAll_fuben> findStudentAll_fuben(String data1,String data2);
	//find TData_fuben.*
	List<TData_fuben> findTdata_fuben(String sid,String data1,String data2);
	//find TData.*
	List<TData> findTDataBySid(String sid);
	//find student
	List<Student> findStudent();
	//find student Sname
	String finsStudentSname(String sid);
	//find tprocess by time
	List<TProcess> findTprocessBetweenTime(String time1,String time2);
	//find tprocess limit
	List<TProcess> findTprocessLimite(String data1,String data2,String pg);
	//find tprocess count limit
	int findCountFromTprocessLimitTime(String data1,String data2);
	//find studentAll sname
	String findStudentAllSname(String sid);
	//find TData
	List<TData> findTData();
	//find distanctName from data
	List<String> findTDataDistanctSid();
	//find * from Tdata by sid and slogtime
	List<TData_fuben> findTDataBySidAndSlogtime(String sid);
	//查询教师表
	TeacherUser findTeacherUserByUser(String user);
	//查询组员
	List<Student> findGroupMemberBySid(String sgroup);
	/////////// </wh>
}
