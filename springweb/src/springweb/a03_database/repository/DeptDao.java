package springweb.a03_database.repository;
//springweb.a03_database.repository.DeptDao

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import springweb.z01_vo.Dept;

@Repository
public interface DeptDao {
	// 매개변수로 검색할 부서정보를 vo로 전달.
	// getDname(), getLoc() 전달.
	public ArrayList<Dept> dlist(Dept dept);
	
	// sql로 ampper에 처리되는 실습
	// INSERT INTO DEPT01 VALUES(dept_seq.nextval, "인사", "서초");
	// deptDao.java deptMapper.xml 구현
	
	public void insertDept(Dept dept);
	
	public Dept detailDept(int deptno);
	
	public void updateDept(Dept dept);
	
	public void deleteDept(int deptno);
}
