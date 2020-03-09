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
}
