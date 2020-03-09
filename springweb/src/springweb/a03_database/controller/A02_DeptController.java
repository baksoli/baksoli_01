package springweb.a03_database.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import springweb.a03_database.service.A02_DeptSerivce;
import springweb.z01_vo.Dept;


// http://localhost:7080/springweb/deptlist.do
@Controller
public class A02_DeptController {
	
	@Autowired(required=false)
	private A02_DeptSerivce service;
	
	//ex) 부서명, 부서위치를 검색하여 controller에 출력.
	//ex) 부서명, 부서위치를 검색하면 화면에 출력.
	//	1) dao, service, controller 검색 VO처리
	//	2) DeptMapper.xml에서 검색가능하게 sql 처리.
	@RequestMapping("/deptlist.do")
	public String deptList(@ModelAttribute("sch") Dept sch, Model md){
		System.out.println("부서명 : "+sch.getDname());
		System.out.println("부서위치 : "+sch.getLoc());
		// 요청값으로 넘겨운 Dept 객체를 sch 참조 변수로 전달.
		md.addAttribute("dlist",service.dlist(sch));
		return "WEB-INF\\view\\a03_db\\a02_deptList.jsp";
	}
	
	@RequestMapping("/deptInsForm.do")
	public String deptInsForm(){
		System.out.println("부서 추가");
		return "WEB-INF\\view\\a03_db\\a02_deptInsert.jsp";
	}
}
