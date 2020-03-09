package springweb.a03_database.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import springweb.a03_database.service.A01_EmpService;
import springweb.z01_vo.Emp;

@Controller
public class A01_EmpController {
	// http://localhost:7080/springweb/emplist.do
	
	@Autowired(required = false)
	private A01_EmpService service;	
	// controller --> service --> dao --> mybatis 객체 sql을 통한 결과 처리
	//	 		 <--		<--	      <--  ArrayList<VO>

	@RequestMapping("/emplist.do")
	public String empList(@ModelAttribute("sch") Emp sch, Model md) {
		System.out.println("사원명 : "+sch.getEname());
		System.out.println("직책 : "+sch.getJob());
		// model 이름은 emplist로, 객체는 service.emplist()
		md.addAttribute("emplist", service.emplist(sch));
		return "WEB-INF\\view\\a03_db\\a01_empList.jsp";
	}
	
	@RequestMapping("/empInsForm.do")
	public String empInsForm() {
		
		return "WEB-INF\\view\\a03_db\\a01_empInsert.jsp";
	}
	
	//등록 처리 프로세스
	// ex) 부서 정보 등록처리 화면 구성면 process 처리 하기! (과제)
	@RequestMapping("/empInsert.do")
	public String empInsert(Emp insert, Model d) {
		System.out.println("등록명: "+insert.getEname());
		return "WEB-INF\\view\\a03_db\\a01_empInsert.jsp";
	}
}