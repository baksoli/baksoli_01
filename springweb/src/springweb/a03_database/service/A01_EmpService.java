package springweb.a03_database.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springweb.a03_database.repository.EmpDao;
import springweb.z01_vo.Emp;

@Service
public class A01_EmpService {
	// dao autowire를 통해 할당.
	@Autowired(required = false)
	private EmpDao dao;
	
	public ArrayList<Emp> emplist(Emp sch){
		return dao.emplist(sch);
	}
	
	public void insertEmp(Emp ins) {
		dao.insertEmp(ins);
	}
	
	public Emp empOne(int empno) {
		return dao.empOne(empno);
	}
}
