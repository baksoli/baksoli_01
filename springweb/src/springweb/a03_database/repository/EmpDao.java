package springweb.a03_database.repository;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import springweb.z01_vo.Emp;

/*
1. 인터페이스 이름: springweb.a03_database.repository.EmpDao
2. 메서드 구성요소 
	ArrayList<Emp> emplist() 
	1) return 유형
	2) 메서드명
	3) 매개변수

 */
@Repository
public interface EmpDao {
	// sql을 통해서 나타난 데이터베이스 결과값
	// java의 객체에 할당.
	// table ==> ArrayList<VO>
	// 리턴값, 메서드명, 입력값.
	public ArrayList<Emp> emplist(Emp sch);
	
}
