package springweb.a01_start;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import springweb.z01_vo.Code;
import springweb.z01_vo.Product;
import springweb.z01_vo.SearchType;
import springweb.z01_vo.SearchVO;

@Controller
public class A04_ModelController {
/*
	# controller 에서 처리 해주는 내용.
	1. 요청값 처리.
	2. model 데이터를 만들어 설정하기.
		1) spring 에서 지원하는 form 태그와 함께 효과적으로 처리할 수 있다.
			- list형 데이터
			- form 하위의 여러 요소 객체들을 mapping 하여 처리한다.
			예제) modelExp() 함수 참고
			
	3. View단 호출하기.
	
	- 위 내용이 각각의 기능 keyword로 처리된다.
	1. 요청값 처리 + Model 
		1) ModelAttribute : 받는 요청값을 VO 객체로 mapping하여, 
			model 데이터로 연동시켜 처리를 한다.
			ex) 주로 검색조건 처리 시, spring message 와 함께 처리한다.
			예제) search(),main(),search1()
	2. model + view
		1) ModelAndView : 해당 model 객체를 설정과 함께 View단을 선언할 수 있는 객체.
	
 */
	
	// http://localhost:7080/springweb/modelExp.do
	@RequestMapping("/modelExp.do")
	public String modelExp(Model d) {
		// key, value 형식의 모델 데이터 처리.
		List<Code> clist = new ArrayList<Code>();
		clist.add(new Code("10","인사"));
		clist.add(new Code("20","재무"));
		clist.add(new Code("30","회계"));
		clist.add(new Code("40","아이티사업부"));
		d.addAttribute("clist",clist);
		
		return "WEB-INF\\view\\a22_modelExp.jsp";
	}
	
	// 검색 처리하는 VO와 선택할 수 있는 VO를 mapping 시켜 modelAttribute를 처리해보자.
	// 요청값의 데이터를 설정할 수 있는 ModelAttribute 선언.
	// controller 공통의 요청값 처리를 위한 기본 값을 설정할 때
	// ==> ModelAttribute를 활용한다.
	@ModelAttribute("searchTypeList")
	public List<SearchType> search(){
		List<SearchType> list = new ArrayList<SearchType>();
		list.add(new SearchType(1,"제목"));
		list.add(new SearchType(2,"작성자"));
		list.add(new SearchType(3,"내용"));
		return list;
	}
	
	// http://localhost:7080/springweb/main.do
	// 검색하는 초기 화면.
	@RequestMapping("/main.do")
	public String main() {
		return "WEB-INF\\view\\a23_searchMain.jsp";
	}
	
	// 검색결과를 처리하는 화면.
	@RequestMapping("/search.do")
	public String search1(SearchVO vo, Model d) {
		System.out.println("검색된 요청값1 : "+vo.getType());
		System.out.println("검색된 요청값2 : "+vo.getQuery());

		d.addAttribute("search", vo);
		return "WEB-INF\\view\\a24_searchResult.jsp";
	}
	// ModelAttribute("search") : 요청값 + model 값 동시에 
	// http://localhost:7080/springweb/search2.do
	@RequestMapping("/search2.do")
	public String search2(@ModelAttribute("search") SearchVO vo) {
		System.out.println("요청값 내용.. ");
		return "WEB-INF\\view\\a25_searchForm.jsp";
	}
	
	/* 2020.02.25 과제
 	ex) 모델어트리뷰트를 이용해서
	종류(전자제품/식품류/잡화) --> CodeVO 
	 물건명  가격  갯수를
	검색처리하는 화면을 구성하세요  

	 */
	
	@ModelAttribute("searchProdList")
	public List<Code> prodsearch(){
		List<Code> clist = new ArrayList<Code>();
		clist.add(new Code("1","전자제품"));
		clist.add(new Code("2","식품류"));
		clist.add(new Code("3","잡화"));
		return clist;
	}
	
	// http://localhost:7080/springweb/prodMain.do
	// 검색하는 초기 화면
	@RequestMapping("/prodMain.do")
	public String prodMain(@ModelAttribute("search") SearchVO vo, Model d) {
		List<Product> plist = new ArrayList<Product>();
		plist.add(new Product("전자제품", "갤럭시20", 160, 3));
		plist.add(new Product("전자제품", "컴퓨터", 200, 4));
		plist.add(new Product("식품류", "바나나", 4, 5));
		plist.add(new Product("잡화", "가위", 3, 10));
		d.addAttribute("prodList", plist);
		return "WEB-INF\\view\\a26_prodSearchMain.jsp";
	}

	@RequestMapping("/{codeId}.do")
	public String codeIdSearch(@PathVariable("codeId") String code, Model d) {
		List<Product> plist = new ArrayList<Product>();
		if (code.equals("all")) {
			plist.add(new Product("전자제품", "갤럭시20", 160, 3));
			plist.add(new Product("전자제품", "컴퓨터", 200, 4));
			plist.add(new Product("식품류", "바나나", 4, 5));
			plist.add(new Product("잡화", "가위", 3, 10));
		} else if (code.equals("1")) {
			plist.add(new Product("전자제품", "갤럭시20", 160, 3));
			plist.add(new Product("전자제품", "컴퓨터", 200, 4));
		} else if (code.equals("2")) {
			plist.add(new Product("식품류", "바나나", 4, 5));
		} else if (code.equals("3")) {
			plist.add(new Product("잡화", "가위", 3, 10));
		}
		d.addAttribute("prodList", plist);
		return "WEB-INF\\view\\a26_prodSearchDetail.jsp";
	}

	// 물건의 종류 list ModelAttribute 설정.
	@ModelAttribute("prodTypes")
	public List<Code> prodType(){
		List<Code> types = new ArrayList<Code>();
		types.add(new Code("10", "전자제품"));
		types.add(new Code("20", "식품류"));
		types.add(new Code("30", "잡화"));
		return types;
	}
	
	/*
		1. ModelAttribute 을 통해서 요청값 + model 처리 함께 처리
		2. Model 은 화면에
	 */
	
	// 2020.02.25 과제 풀이
	// http://localhost:7080/springweb/buySearch.do
	@RequestMapping("/buySearch.do")
	public String buySearch(@ModelAttribute("product") Product prod, Model d) {
		
		// 검색할 내용 prod
		System.out.println("검색1 : "+prod.getType());
		System.out.println("검색2 : "+prod.getName());
		System.out.println("검색3 : "+prod.getPrice());
		System.out.println("검색4 : "+prod.getCnt());
		
		// list할 model 데이터 d
		ArrayList<Product> plist = new ArrayList<Product>();
		plist.add(new Product("전자제품", "LED TV", 1600000, 3));
		plist.add(new Product("전자제품", "컴퓨터", 2000000, 4));
		plist.add(new Product("전자제품", "스마트폰", 1100000, 4));
		plist.add(new Product("식품류", "바나나", 4000, 5));
		plist.add(new Product("잡화", "가위", 3000, 10));
		d.addAttribute("plist", plist);
		
		return "WEB-INF\\view\\a26_buyList.jsp";
	}
	
}
