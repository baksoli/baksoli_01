package board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import board.service.A02_BoardService;
import board.vo.Board;
import board.vo.BoardSch;

// controller 동일한 url패턴을 사용하면서,
// 기능 method마다, 다른 기능 요청값을 선언하여 활용한다.
@Controller
@RequestMapping("/board.do")
public class A01_BoardController {
	// 객체가 있을 때 자동으로 autowire되고,
	// 서비스 객체가 없더라도(DB연결시, 값이 없더라도)
	// null Exception이 발생하지 않게 처리 -> required=false
	@Autowired(required = false)
	private A02_BoardService service;
	// http://localhost:7080/board/board.do?method=list
	// 1. 메인 조회
	@RequestMapping(params="method=list")
	public String list(@ModelAttribute("boardSch") BoardSch sch, Model d) {
		//System.out.println("검색할 내용1: "+sch.getSubject());
		//System.out.println("검색할 내용2: "+sch.getWriter());
		
		// 화면에 전달할 모델 데이터 설정 처리.
		// 화면(view단)에 blist 이름으로 데이터 전송.
		d.addAttribute("blist", service.boardList(sch));
		
		return "WEB-INF\\view\\a01_boardList.jsp";
	}

	// 2. 상세 화면
	// 	1) 수정 처리 기능 메서드
	// 	2) 삭제 처리 기능 메서드
	// 3. 등록 화면
	// 	1) 등록 화면 메서드
	// 	2) 등록 처리 기능 메서드
	/*
		# 등록 처리 프로세스.
		1. 메인화면에서 등록 버튼 이벤트를 통해, js로 등록화면으로 이동.
		2. controller로 등록화면이 로딩.
		3. 등록 form 화면에서 등록 처리 submit을 통해서
			controller에 등록 process 처리.
		4. 등록 후 메인 화면(리스트 화면)으로 처리(이동)되어 
			등록된 화면 list내용 확인 처리.
	 */
	@RequestMapping(params ="method=insertForm")
	public String insertForm(@ModelAttribute("board") Board ins) {
		return "WEB-INF\\view\\a02_boardInsert.jsp";
	}

	@RequestMapping(params="method=insert")
	public String isnert(Board ins, BindingResult bindingResult) {
		new BoardInsertValidator().validate(ins, bindingResult);
		
		if(bindingResult.hasErrors()){
			return "WEB-INF\\view\\a02_boardInsert.jsp";
		}
		
		

		// 서비스 단에 등록 처리 프로세스 호출.
		service.insert(ins);
		
		// 등록 후 메인 화면(조회 controller) 이동.
		// 특정 프로세스 후,
		// redirect와 forward 의 차이
		// redirect - 요청값 전송하지 않고 해당 controller 호출
		// forward - 요청값을 전송하면서 해당 controller 호출
		return "redirect:/board.do?method=list";
	}
	
	
}
