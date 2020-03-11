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
	// Emp 객체 서버에 데이터 등록하는 메서드 선언.
	// 1. 입력할 때는 return 값이 필요 없다.
	// 2. XXXmapper.xml 에서 이 메서드를 인식할 수 있는 식별자. : 메서드명
	// 	  insertEmp
	// 3. 어떤 데이터를 넣을 것인가? Emp 객체를 입력할 수 있는 매개변수를 선언.
	// 	    이 메서드를 통해서 전달. 
	// *** XXXmapper.xml 과 연동하는 연동 규칙으로 연동시키기
	// 		1. 인터페이스 명 : interface springweb.a03_database.repository.EmpDao
	//			인터페이스 명은 XXXMapper.xml의 최상위 단위인 namespace와 연결해주면 된다.
	//		2. 메서드 : void insertEmp(Emp ins);
	public void insertEmp(Emp ins);
	
	//상세화면 메서드 구현과, mapperXML 처리.
	/*
	 * select *
	 * from emp01
	 * where empno = 7955;
	 */
	//1. return 값 :Emp
	//2. 메서드명 : empOne
	//3. 매개변수 : int
	public Emp empOne(int empno);
	
	// 수정 처리 process 메서드, 
	public void updateEmp(Emp upt);
	
	// 삭제 처리 process 메서드
	public void deleteEmp(int empno);
	
	
}
