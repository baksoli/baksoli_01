package springweb.a03_database.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		System.out.println("#등록화면 로딩#");
		return "WEB-INF\\view\\a03_db\\a01_empInsert.jsp";
	}
	
	//등록 처리 프로세스
	// ex) 부서 정보 등록처리 화면 구성면 process 처리 하기! (과제)
	@RequestMapping("/empInsert.do")
	public String empInsert(Emp insert, Model d) {
		System.out.println("#등록 처리 화면 로딩#");
		System.out.println("등록명: "+insert.getEname());
		System.out.println("직챙 : "+insert.getJob());
		service.insertEmp(insert);
		
		// 처리 후, 전체 리스트 확인.
		// controller단 호출. redirect:/emplist.do
		// forward : \컨트롤 - 요청값 포함하여 전달.
		// redirect : \컨트롤 - 요청값 없이 전달.
		return "redirect:/emplist.do";
	}
	// 상세 화면 처리 (수정/삭제 할 수 있는 interface 화면)
	@RequestMapping("/empDetail.do")
	public String empDetail(@RequestParam("empno") int empno, Model d) {
		System.out.println("넘겨온 empno : "+empno);
		d.addAttribute("emp", service.empOne(empno));
		return "WEB-INF\\view\\a03_db\\a01_empDetail.jsp";
	}
	// 수정 처리 empUpdate.do
	@RequestMapping("/empUpdate.do")
	public String empUpdate(Emp upt) {
		System.out.println("수정할 데이터의 key: "+upt.getEmpno());
		System.out.println("수정할 데이터의 사원 명 : "+upt.getEname());
		service.updateEmp(upt);
		// 상세화면으로 다시 전송(empno 요청값을 전달)
		// 수정된 내용을 empno값을 전달하면서 검색되도록 처리.
		
		// 상세화면에 empno를 비롯한 수정데이터가 요청데이터로 넘어가지만
		// 실제 받는 데이터는 empno뿐이다.
		return "forward:/empDetail.do";
	}
	
	// 삭제 처리 /empDelete.do
	@RequestMapping("/empDelete.do")
	public String empDelete(@RequestParam("empno") int empno) {
		System.out.println("삭제할 데이터의 id :: "+empno);
		service.deleteEmp(empno);
		// 삭제 후 다시 emplist를 조회 처리.
		// 요청값을 redirect를 통해서 전달하지 않고, 조회를 처리한다.
		return "redirect:/emplist.do";
	}
	
	
}