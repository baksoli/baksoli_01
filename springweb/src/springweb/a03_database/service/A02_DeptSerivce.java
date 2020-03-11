package springweb.a03_database.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springweb.a03_database.repository.DeptDao;
import springweb.z01_vo.Dept;

@Service
public class A02_DeptSerivce {

	@Autowired(required = false)
	private DeptDao dao;
	
	// 검색할 매개변수 Dept 객체를 받아서, dao에 전달 처리.
	public ArrayList<Dept> dlist(Dept sch){
		return dao.dlist(sch);
	}
	
	public void insertDept(Dept ins) {
		dao.insertDept(ins);
	}
	
	public Dept detailDept(int deptno) {
		return dao.detailDept(deptno);
	}
	
	public void updateDept(Dept dept){
		dao.updateDept(dept);
	}
	
	public void deleteDept(int deptno){
		dao.deleteDept(deptno);
	}
	
}
