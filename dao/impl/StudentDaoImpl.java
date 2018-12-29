package com.anweitech.teacher.dao.impl;

import java.util.List;
import java.util.UUID;


import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

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

@SuppressWarnings("unchecked")
public class StudentDaoImpl extends HibernateDaoSupport implements StudentDao {
	
	//Update specific actions to the process table
	@Override
	public void updataTDate(TData_fuben tf) {
		
		Session session = getSessionFactory().getCurrentSession();
		session.update(tf);
		
	}
	
	//select student_fuben
	@Override
	public List findStudent_fuben(String num) {
		
		Session session = getSessionFactory().getCurrentSession();
		String sql = "select * from data_fuben where num = '" +num +"'";
		List list = session.createSQLQuery(sql).list();
		
		return list;
	}
	
	//Add specific actions to the process table
	@Override
	public void addTProcess(TProcess tProcess) {

		Session session = getSessionFactory().getCurrentSession();
		
		session.save(tProcess);
	}
	
	//init data
	@Override
	public void deleteData() {
		
		Session session = getSessionFactory().getCurrentSession();

		TData data = new TData();
		String sql = "delete from data";
		
		session.createSQLQuery(sql);
	}
	
	//backup table uuid
	public List<?> findByUUID(String uuid) {
		
		Session session = getSessionFactory().getCurrentSession();
		
		String sql = "select * from studentall_fuben where uuid = '" +uuid +"'";
		List list = session.createSQLQuery(sql).list();
		
		return list;
	}
	
	//delete table
	public void removeStudentAll(String sid) {
//		Student s = new Student();
//		s.setSid(sid);
		
		Session session = getSessionFactory().getCurrentSession();
//		session.delete(s);
		

		String sql = "delete from Cnt where sid= ?"; 
		SQLQuery query = session.createSQLQuery(sql);
		query.setString(0, sid);
		query.executeUpdate();
		
		sql = "delete from Cnt where sid= ?"; 
		query = session.createSQLQuery(sql);
		query.setString(0, sid);
		query.executeUpdate();
		
		sql = "delete from GChallenge where sid= ?"; 
		query = session.createSQLQuery(sql);
		query.setString(0, sid);
		query.executeUpdate();
		
		sql = "delete from NConsult where sid= ?"; 
		query = session.createSQLQuery(sql);
		query.setString(0, sid);
		query.executeUpdate();
		
		sql = "delete from NetConsult where sid= ?"; 
		query = session.createSQLQuery(sql);
		query.setString(0, sid);
		query.executeUpdate();
		
		sql = "delete from NetKey where sid= ?"; 
		query = session.createSQLQuery(sql);
		query.setString(0, sid);
		query.executeUpdate();
		
		sql = "delete from NodeKey where sid= ?"; 
		query = session.createSQLQuery(sql);
		query.setString(0, sid);
		query.executeUpdate();
		
		sql = "delete from GatewayKey where sid= ?"; 
		query = session.createSQLQuery(sql);
		query.setString(0, sid);
		query.executeUpdate();
		
		sql = "delete from data where sid= ?"; 
		query = session.createSQLQuery(sql);
		query.setString(0, sid);
		query.executeUpdate();
		
		sql = "delete from Student where sid= ?"; 
		query = session.createSQLQuery(sql);
		query.setString(0, sid);
		query.executeUpdate();
	}
	
	//According to the time query
	@Override
	public List<StudentAll> findTimeStudentAll(String begin) {
		
		try {
			
			String sql = 
					"select "
					+ "a.*, b.gkeyid, b.gtime, c.nodeid, c.nodetime, d.netkeyid, d.nettime, "
					+ "e.gcnonce, e.gctime, f.nctime, f.ncnumber, g.netcnumber, g.netctime, "
					+ "h.ckey, h.cvalue, h.ctime "
					+ "from "
					+ "student a LEFT JOIN gatewaykey b ON "
					+ "a.sid = b.sid "
					+ "LEFT JOIN nodekey c ON "
					+ "b.sid = c.sid "
					+ "LEFT JOIN netkey d ON "
					+ "c.sid = d.sid "
					+ "LEFT JOIN gchallenge e ON "
					+ "d.sid = e.sid "
					+ "LEFT JOIN nconsult f ON "
					+ "e.sid = f.sid "
					+ "LEFT JOIN netconsult g ON "
					+ "f.sid = g.sid "
					+ "LEFT JOIN cnt h ON "
					+ "g.sid = h.sid "
					+ "where "
					+ "slogtime >= '" +begin +"' and level='1'";
			
			Session session = getSessionFactory().getCurrentSession();
			List<StudentAll> list = session.createSQLQuery(sql).addEntity(StudentAll.class).list();
			
			return list;
			
		} catch (Exception e) {
			// TODO: handle exception
            e.printStackTrace();  
            throw new RuntimeException(e);  
		}
		
	}
	//According to the time query
	@Override
	public List<TData> findTimeTData(String sid) {
		
		try {
			
			String sql = 
					"select * "
					+ "from "
					+ "data "
					+ "where "
					+ "sid = '" +sid +"' ";
			
			Session session = getSessionFactory().getCurrentSession();
			List<TData> list = session.createSQLQuery(sql).addEntity(TData.class).list();
			
			return list;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();  
			throw new RuntimeException(e);  
		}
		
	}
	
	//Add data to the backup table StudenAll_fuben
	@Override
	public void addStudentAll(StudentAll_fuben studentAll_fuben) {
		
		Session session = getSessionFactory().getCurrentSession();
		session.save(studentAll_fuben);
		
	}
	//Add data to the backup table TData_fuben
	@Override
	public void addTData(TData_fuben sf) {
		
		Session session = getSessionFactory().getCurrentSession();
		session.save(sf);
		
	}
	
	
	/**
	 * StudentAll==========================================================
	 * find all entities
	 */
	@Override
	public List<StudentAll> findByStudentAll() {
		
		try{
			String hql = 
					"select "
							+ "a.*, b.gkeyid, b.gtime, c.nodeid, c.nodetime, d.netkeyid, d.nettime, "
							+ "e.gcnonce, e.gctime, f.nctime, f.ncnumber, g.netcnumber, g.netctime, "
							+ "h.ckey, h.cvalue, h.ctime "
							+ "from "
							+ "student a LEFT JOIN gatewaykey b ON "
							+ "a.sid = b.sid "
							+ "LEFT JOIN nodekey c ON "
							+ "b.sid = c.sid "
							+ "LEFT JOIN netkey d ON "
							+ "c.sid = d.sid "
							+ "LEFT JOIN gchallenge e ON "
							+ "d.sid = e.sid "
							+ "LEFT JOIN nconsult f ON "
							+ "e.sid = f.sid "
							+ "LEFT JOIN netconsult g ON "
							+ "f.sid = g.sid "
							+ "LEFT JOIN cnt h ON "
							+ "g.sid = h.sid ";
	
			Session session = getSessionFactory().getCurrentSession();
			List<StudentAll> list = session.createSQLQuery(hql).addEntity(StudentAll.class).list();
			
			return list;
		}catch (Exception e){
            e.printStackTrace();  
            throw new RuntimeException(e);  
		}
	}
	
	/**
	 * Student=============================================================
	 * find Student 'id'.
	 * Used to determine whether to update or add operations.
	 * If the database has, update the data, else insert data. 
	 */
	@Override
	public Student findAllStudent(String sid) {
		try{
			String hql = "from Student where sid = ?";
			
			List<Student> list = (List<Student>) getHibernateTemplate().find(hql, sid);
			
			if (list.size() == 0)
				return new Student();
			else
				return list.get(0);
		}catch (Exception e){
            e.printStackTrace();  
            throw new RuntimeException(e);  
		}
	}

	/**
	 * add Student
	 */
	@Override
	public void addStudent(Student s) {
		try{
			s.setWhether_online("0");
			getHibernateTemplate().save(s);
		}catch (Exception e){
            e.printStackTrace();  
            throw new RuntimeException(e);  
		}
	}

	/**
	 * update Student
	 */
	@Override
	public void updateStudent(Student s) {
		try{
			s.setWhether_online("0");
			getHibernateTemplate().update(s);
		}catch (Exception e){
            e.printStackTrace();  
            throw new RuntimeException(e);  
		}		
	}
	
	/**
	 * Cnt=============================================================
	 * find Cnt 'id'.
	 * Used to determine whether to update or add operations.
	 * If the database has, update the data, else insert data. 
	 */
	@Override
	public Cnt findAllCnt(String sid) {

		try {
			String hql = "from Cnt where sid = ?";
			List<Cnt> list = (List<Cnt>) getHibernateTemplate().find(hql, sid);
			
			if (list.size() == 0)
				return null;
			else
				return list.get(0);
			
		}catch (Exception e){
            e.printStackTrace();  
            throw new RuntimeException(e);  
		}
		
	}

	/**
	 * add Cnt
	 */
	@Override
	public void addCnt(Cnt c) {
		try{
			getHibernateTemplate().save(c);		
		}catch (Exception e){
            e.printStackTrace();  
            throw new RuntimeException(e);  
		}
	}

	/**
	 * update NConsult
	 */
	@Override
	public void updateCnt(Cnt c) {
		try{
			getHibernateTemplate().update(c);
		} catch (Exception e) {
            e.printStackTrace();  
            throw new RuntimeException(e);  
		}
	}
		
	/**
	 * Data=============================================================
	 * find Data 'id'.
	 * Used to determine whether to update or add operations.
	 * If the database has, update the data, else insert data.
	 */
	@Override
	public TData findAllData(String sid) {
		try{
			String hql = "from TData where sid = ?";
			
			List<TData> list = (List<TData>) getHibernateTemplate().find(hql, sid);
			
			if (list.size() == 0)
				return null;
			else
				return list.get(0);
		}catch (Exception e){
            e.printStackTrace();  
            throw new RuntimeException(e);  
		}
	}

	/**
	 * add TData
	 */
	@Override
	public void addData(TData tData) {
		try{
			tData.setnum(UUID.randomUUID().toString());
			getHibernateTemplate().save(tData);		
		}catch (Exception e){
            e.printStackTrace();  
            throw new RuntimeException(e);  
		}
	}

	/**
	 * update TData
	 */
	@Override
	public void updateData(TData tData) {
		try{
			getHibernateTemplate().update(tData);
		}catch (Exception e){
            e.printStackTrace();  
            throw new RuntimeException(e);  
		}
	}

	/**
	 * NodeKey=============================================================
	 * find NodeKey 'id'.
	 * Used to determine whether to update or add operations.
	 * If the database has, update the data, else insert data.
	 */
	@Override
	public NodeKey findAllNodeKey(String sid) {
		try {
			
			String hql = "from NodeKey where sid = ?";
			
			List<NodeKey> list = (List<NodeKey>) getHibernateTemplate().find(hql, sid);
			
			if (list.size() == 0)
				return null;
			else
				return list.get(0);
		
		} catch (Exception e) {
            e.printStackTrace();  
            throw new RuntimeException(e);  
		}
	}

	/**
	 * add NodeKey
	 */
	@Override
	public void addNodeKey(NodeKey nodeKey) {
		
		try{
			getHibernateTemplate().save(nodeKey);		
		} catch (Exception e) {
            e.printStackTrace();  
            throw new RuntimeException(e);  
		}
	}

	/**
	 * update NodeKey
	 */
	@Override
	public void updateNodeKey(NodeKey nodeKey) {
		try{
			getHibernateTemplate().update(nodeKey);	
		} catch (Exception e) {
            e.printStackTrace();  
            throw new RuntimeException(e);  
		}
	}

	/**
	 * NetKey=============================================================
	 * find NetKey 'id'.
	 * Used to determine whether to update or add operations.
	 * If the database has, update the data, else insert data.
	 */
	@Override
	public NetKey findAllNetKey(String sid) {
		try{
			String hql = "from NetKey where sid = ?";
			
			List<NetKey> list = (List<NetKey>) getHibernateTemplate().find(hql, sid);
			
			if (list.size() == 0)
				return null;
			else
				return list.get(0);
		} catch (Exception e) {
            e.printStackTrace();  
            throw new RuntimeException(e);  
		}
	}

	/**
	 * add NetKey
	 */
	@Override
	public void addNetKey(NetKey netKey) {
		try{
			getHibernateTemplate().save(netKey);	
		} catch (Exception e) {
            e.printStackTrace();  
            throw new RuntimeException(e);  
		}
	}

	/**
	 * update NetKey
	 */
	@Override
	public void updateNetKey(NetKey netKey) {
		try{
			getHibernateTemplate().update(netKey);	
		} catch (Exception e) {
            e.printStackTrace();  
            throw new RuntimeException(e);  
		}
	}

	/**
	 * NetConsult=============================================================
	 * find NetConsult 'id'.
	 * Used to determine whether to update or add operations.
	 * If the database has, update the data, else insert data.
	 */
	@Override
	public NetConsult findAllNetConsult(String sid) {
		
		String hql = "from NetConsult where sid = ?";
		
		List<NetConsult> list = (List<NetConsult>) getHibernateTemplate().find(hql, sid);
		
		if (list.size() == 0)
			return null;
		else
			return list.get(0);
	}

	/**
	 * add NetConsult
	 */
	@Override
	public void addNetConsult(NetConsult netConsult) {
		try{
			getHibernateTemplate().save(netConsult);
		} catch (Exception e) {
            e.printStackTrace();  
            throw new RuntimeException(e);  
		}
	}

	/**
	 * update NetConsult
	 */
	@Override
	public void updateNetConsult(NetConsult netConsult) {
		try{
			getHibernateTemplate().update(netConsult);	
		} catch (Exception e) {
            e.printStackTrace();  
            throw new RuntimeException(e);  
		}
	}

	/**
	 * NConsult=============================================================
	 * find NConsult 'id'.
	 * Used to determine whether to update or add operations.
	 * If the database has, update the data, else insert data.
	 */
	@Override
	public NConsult findAllNConsult(String sid) {
		
		String hql = "from NConsult where sid = ?";
		
		List<NConsult> list = (List<NConsult>) getHibernateTemplate().find(hql, sid);
		
		if (list.size() == 0)
			return null;
		else
			return list.get(0);
	}

	/**
	 * add NConsult
	 */
	@Override
	public void addNConsult(NConsult NConsult) {
		try{
			getHibernateTemplate().save(NConsult);	
		} catch (Exception e) {
            e.printStackTrace();  
            throw new RuntimeException(e);  
		}
	}
	
	/**
	 * update NConsult
	 */
	@Override
	public void updateNConsult(NConsult NConsult) {
		try{
			getHibernateTemplate().update(NConsult);
		} catch (Exception e) {
            e.printStackTrace();  
            throw new RuntimeException(e);  
		}
	}

	/**
	 * GChallenge=============================================================
	 * find GChallenge 'id'.
	 * Used to determine whether to update or add operations.
	 * If the database has, update the data, else insert data.
	 */
	@Override
	public GChallenge findAllGChallenge(String sid) {
		
		String hql = "from GChallenge where sid = ?";
		
		List<GChallenge> list = (List<GChallenge>) getHibernateTemplate().find(hql, sid);
		
		if (list.size() == 0)
			return null;
		else
			return list.get(0);
	}

	/**
	 * add GChallenge
	 */
	@Override
	public void addGChallenge(GChallenge gChallenge) {
		try{
			getHibernateTemplate().save(gChallenge);
		} catch (Exception e) {
            e.printStackTrace();  
            throw new RuntimeException(e);  
		}
	}

	/**
	 * update GChallenge
	 */
	@Override
	public void updateGChallenge(GChallenge gChallenge) {
		try{
			getHibernateTemplate().update(gChallenge);
		} catch (Exception e) {
            e.printStackTrace();  
            throw new RuntimeException(e);  
		}
	}

	/**
	 * GatewayKey=============================================================
	 * find GatewayKey 'id'.
	 * Used to determine whether to update or add operations.
	 * If the database has, update the data, else insert data.
	 */
	@Override
	public GatewayKey findAllGatewayKey(String sid) {
		
		String hql = "from GatewayKey where sid = ?";
		
		List<GatewayKey> list = (List<GatewayKey>) getHibernateTemplate().find(hql, sid);
		
		if (list.size() == 0)
			return null;
		else
			return list.get(0);
	}

	/**
	 * add GatewayKey
	 */
	@Override
	public void addGatewayKey(GatewayKey gatewayKey) {
		try{
			getHibernateTemplate().save(gatewayKey);	
		} catch (Exception e) {
            e.printStackTrace();  
            throw new RuntimeException(e);  
		}
	}

	/**
	 * update GatewayKey
	 */
	@Override
	public void updateGatewayKey(GatewayKey gatewayKey) {
		try{
			getHibernateTemplate().update(gatewayKey);
		} catch (Exception e) {
            e.printStackTrace();  
            throw new RuntimeException(e);  
		}
	}

	//paging
	@Override
	public List<StudentAll> limitStudent(Integer currentPage, Integer pageSize) {
		try{
			String hql = 
					"select "
						+ "a.*, b.gkeyid, b.gtime, c.nodeid, c.nodetime, d.netkeyid, d.nettime, "
						+ "e.gcnonce, e.gctime, f.nctime, f.ncnumber, g.netcnumber, g.netctime, "
						+ "h.ckey, h.cvalue, h.ctime "
						+ "from "
						+ "student a LEFT JOIN gatewaykey b ON "
						+ "a.sid = b.sid "
						+ "LEFT JOIN nodekey c ON "
						+ "b.sid = c.sid "
						+ "LEFT JOIN netkey d ON "
						+ "c.sid = d.sid "
						+ "LEFT JOIN gchallenge e ON "
						+ "d.sid = e.sid "
						+ "LEFT JOIN nconsult f ON "
						+ "e.sid = f.sid "
						+ "LEFT JOIN netconsult g ON "
						+ "f.sid = g.sid "
						+ "LEFT JOIN cnt h ON "
						+ "g.sid = h.sid "
						+ "LIMIT "
						+currentPage 
						+","
						+pageSize;
			
			Session session = getSessionFactory().getCurrentSession();
			List<StudentAll> list = session.createSQLQuery(hql).addEntity(StudentAll.class).list();
			
			return list;
		}catch(Exception e){
            e.printStackTrace();  
            throw new RuntimeException(e);
		}
		
	}

	//find data Paging
	@Override
	public List<TData> limitData(String sid, Integer currentPage, Integer pageSize) {
		try{
			String sql = 
					"select "
					+"a.num, a.sid, a.nodeidd, a.subtype,"
					+"a.datavalue, a.dtime, a.mac, a.encryptionflag,"
					+"a.`data`, a.retention1, a.retention2 "
					+"from "
					+ "`data` a inner JOIN `student` b ON "
					+"a.sid = b.sid "
					+ "where "
					+ "a.sid = \'" +sid +"\'"
					+ " limit " +currentPage +"," +pageSize;
			
			
			
			Session session = getSessionFactory().getCurrentSession();
			List<TData> list = session.createSQLQuery(sql).addEntity(TData.class).list();
			
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	//find Student add entries
	public int findStudentCount(){
		try{
			String sql = "select count(*) from Student";
			Session session = getSessionFactory().getCurrentSession();
			Integer studentSize = ((Long) session.createQuery(sql).uniqueResult()).intValue();
			
			return studentSize;
		}catch (Exception e){
			e.printStackTrace();  
			throw new RuntimeException(e);
		}
	}

	//find TData add entries
	@Override
	public int findTDataCount(String sid) {
		try{
			String sql = "select count(*) from TData where sid = '" +sid + "'";
			Session session = getSessionFactory().getCurrentSession();
			Integer dataSize = ((Long) session.createQuery(sql).uniqueResult()).intValue();
			
			return dataSize;
		}catch (Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	//find TData
	@Override
	public List<TData> findByTData() {
		
		try{
			String hql = 
					"select "
					+ "* "
					+ "from "
					+ "data ";
	
			Session session = getSessionFactory().getCurrentSession();
			List<TData> list = session.createSQLQuery(hql).addEntity(TData.class).list();
			
			return list;
		}catch (Exception e){
            e.printStackTrace();  
            throw new RuntimeException(e);  
		}
	}
	
	
	//////////////////////////////////《wh》
	
	//findAll Tdata
	@Override
	public List<TData> findTData(String sid) {
		// TODO Auto-generated method stub
		Session session = null;
		try {
		String sql = "select * from data where sid='"+sid+"' order by dtime";
		session = getSessionFactory().openSession(); 
		List<TData> list = session.createSQLQuery(sql).addEntity(TData.class).list();
		return list;
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	
	//find StudentAll_fuben
	@Override
	public List<StudentAll> findStudentAll_fubenBetweenTime(String data1 , String data2 , String pg) {
		
		Session session = null;
		try {
		String Sql = "select * from StudentAll_fuben where slogtime between '"+data1+"' and '"+data2 + "' and level = '1' limit "+pg+",10";
		session = getSessionFactory().getCurrentSession();
		List<StudentAll> list = session.createSQLQuery(Sql).addEntity(StudentAll_fuben.class).list();
		
		return list;
		
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	//find StudentAll_fuben count
	public int findStudentAll_fubenBetweenTimeCount(String data1 , String data2) {
		Session session = null;
		try {
		String Sql = "select count(*) from StudentAll_fuben where slogtime between '"+data1+"' and '"+data2 + "' and level=1";
		session = getSessionFactory().getCurrentSession();
		int num =((Long) session.createQuery(Sql).uniqueResult()).intValue();
		return num;
		
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	//find Tdata_fuben
	@Override
	public List<TData_fuben> findTData_fubenBySid(String sid,String pg,String data1,String data2) {
		
		Session session = null;
		try {
		String Sql = "select * from Data_fuben where sid = "+sid+" between "+data1+" and "+data2+" order by dtime limit "+pg+",20";
		session = getSessionFactory().getCurrentSession();
		List<TData_fuben> list = session.createSQLQuery(Sql).addEntity(TData_fuben.class).list();
		
		return list;
		
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public int findTData_fubenBySidCount(String sid) {
		Session session = null;
		try {
		String Sql = "select count(*) from TData_fuben where sid = "+sid+"";
		session = getSessionFactory().getCurrentSession();
		int num =((Long) session.createQuery(Sql).uniqueResult()).intValue();
		return num;
		
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public List<StudentAll_fuben> findStudentAll_fuben(String data1,String data2) {
		Session session = null;
		try {
		String Sql = "select * from StudentAll_fuben where slogtime between '"+data1+"' and '"+data2+"' and level='1'";
		session = getSessionFactory().getCurrentSession();
		List<StudentAll_fuben> list = session.createSQLQuery(Sql).addEntity(StudentAll_fuben.class).list();
		return list;
		
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public List<TData_fuben> findTdata_fuben(String sid,String data1,String data2){
		Session session = null;
		try {
		String Sql = "select * from data_fuben where dtime between '"+data1+"' and '"+data2+"' order by dtime";
		session = getSessionFactory().getCurrentSession();
		List<TData_fuben> list = session.createSQLQuery(Sql).addEntity(TData_fuben.class).list();
		return list;
		
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public List<TData> findTDataBySid(String sid){
		Session session = null;
		try {
		String Sql = "select * from data where sid='"+sid+"'";
		session = getSessionFactory().getCurrentSession();
		List<TData> list = session.createSQLQuery(Sql).addEntity(TData.class).list();
		
		return list;
		
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Student> findStudent(){
		Session session = null;
		try {
		String Sql = "select * from student";
		session = getSessionFactory().getCurrentSession();
		List<Student> list = session.createSQLQuery(Sql).addEntity(Student.class).list();
		
		return list;
		
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}
	
	@Override
	public String finsStudentSname(String sid) throws NullPointerException {
		Session session = null;
		
		try {
		String Sql = "select sname from Student where sid = '"+sid+"'";
		session = getSessionFactory().getCurrentSession();
		String t = session.createQuery(Sql).uniqueResult().toString();
		return t;
		}catch(Exception e) {		
			return "null";
		}
	}
	
	@Override
	public String findStudentAllSname(String sid) {
		
		Session session = null;
		try {
		String Sql = "select sname from StudentAll_fuben where sid = '"+sid+"'";
		session = getSessionFactory().getCurrentSession();
		String t = session.createQuery(Sql).uniqueResult().toString();
		return t;
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@Override
	public List<TProcess> findTprocessBetweenTime(String time1,String time2){
		Session session = null;
		try {
		String Sql = "select * from Tprocess where ptime between '"+time1+"' and '"+time2+"' order by ptime";
		session = getSessionFactory().getCurrentSession();
		List<TProcess> list = session.createSQLQuery(Sql).addEntity(TProcess.class).list();
		
		return list;
		
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public List<TProcess> findTprocessLimite(String data1,String data2,String pg){
		Session session = null;
		try {
		String Sql = "select * from TProcess where ptime between '"+data1+"' and '"+data2+"' order by ptime desc limit "+pg+",20";
		session = getSessionFactory().getCurrentSession();
		List<TProcess> list = session.createSQLQuery(Sql).addEntity(TProcess.class).list();
		
		return list;
		
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public int findCountFromTprocessLimitTime(String data1,String data2) {
		Session session = null;
		try {
		String Sql = "select count(*) from TProcess where ptime between '"+data1+"' and '"+data2+"' order by ptime";
		session = getSessionFactory().getCurrentSession();
		int num =((Long) session.createQuery(Sql).uniqueResult()).intValue();
		return num;
		
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}	
	}
	
	@Override
	public List<TData> findTData(){
		Session session = null;
		try {
		String Sql = "select * from Data order by dtime";
		session = getSessionFactory().getCurrentSession();
		List<TData> list = session.createSQLQuery(Sql).addEntity(TData.class).list();
		return list;
		
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public List<String> findTDataDistanctSid(){
		Session session = null;
		try {
		String Sql = "select * from Data";
		session = getSessionFactory().getCurrentSession();
		List<String> list = session.createSQLQuery(Sql).addEntity(String.class).list();
		return list;
		
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public List<TData_fuben> findTDataBySidAndSlogtime(String sid){
		Session session = null;
		try {
		String Sql = "select * from Data_fuben where sid = '"+sid+"'";
		session = getSessionFactory().getCurrentSession();
		List<TData_fuben> list = session.createSQLQuery(Sql).addEntity(TData_fuben.class).list();
		return list;
		
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public TeacherUser findTeacherUserByUser(String user) {	
		Session session = null;
		try {
		session = getSessionFactory().getCurrentSession();
		String hql = "from TeacherUser where user = ?";		
		List<TeacherUser> list = (List<TeacherUser>) getHibernateTemplate().find(hql, user);
		
		if(list.size()==0)
			return new TeacherUser();	
		else
			return list.get(0);
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}	
	
	@Override
	public List<Student> findGroupMemberBySid(String sgroup){
		Session session = null;
		try {
		String Sql = "select * from student where sgroup = '"+sgroup+"'";	
		session = getSessionFactory().getCurrentSession();
		List<Student> list = session.createSQLQuery(Sql).addEntity(Student.class).list();
		return list;
		
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
