package springweb.a01_start;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import springweb.z01_vo.Code;
import springweb.z01_vo.MemberReg;
import springweb.z01_vo.MemberReg_hw;

// 2020.02.26
@Controller
@RequestMapping("/memberReg.do")
public class A05_ValidateController {
	// 공통 선택형 modelAttribute
	@ModelAttribute("jobcodes")
	public List<Code> jobCodes(){
		return Arrays.asList(
				new Code("1","운동선수"),
				new Code("2","프로그래머"),
				new Code("3","예술가"),
				new Code("4","작가"));
	}
	@ModelAttribute("favoriteOsNames")
	public List<String> favoriteOs(){
		return Arrays.asList("윈도우10","윈도우7","맥OS","우분투");
	}
	@ModelAttribute("tools")
	public List<String> tools(){
		return Arrays.asList("이클립스","인텔리J","넷빈즈","Vim");
	}
	
	// 초기화면 get 방식 호출.
	// http://localhost:7080/springweb/memberReg.do
	@RequestMapping(method = RequestMethod.GET)
	public String form(@ModelAttribute("memberInfo") MemberReg memreg) {
		return "WEB-INF\\view\\a27_registerForm.jsp";
	}

	// 요청화면 post 방식 호출.
	@RequestMapping(method = RequestMethod.POST)
	public String register(@ModelAttribute("memberInfo") MemberReg memreg,
							BindingResult bindingResult
						) {
		
		// allowNoti,birthday ,jobcode,favorite,tool
		System.out.println("allowNoti: "+memreg.isAllowNoti() );
		System.out.println("birthday: "+memreg.getBirthday());
		System.out.println("jobcode: "+memreg.getJobCode());
		System.out.println("favorite: "+memreg.getFavoriteOs().length);
		System.out.println("tool: "+memreg.getTool());
		System.out.println("에러발생여부:"+bindingResult.hasErrors());
		
		// 유효성 check
		new MemberRegisterValidator().validate(memreg, bindingResult);
		
		// 요청값 처리시, 문제가 있을 때, 유효성 체크와 error에 대한 처리.
		// 1. 매개변수로 처리 BindingResult
			// error가 있을 때, 등록 page로 이동 처리.
		if(bindingResult.hasErrors()) {
			System.out.println("등록 에러 발생");
			return "WEB-INF\\view\\a27_registerForm.jsp";
		}
		// 2. 사용자 정의 Validator 객체 선언(RegistValidator)과 error 코드 등록.

		return "WEB-INF\\view\\a28_registerSuccess.jsp";
	}
	
	/*
	2020.02.26
	ex) 
		  회원정보 등록
		아이디 : [    ] 등록필수입니다.
		이름 : [   ] 등록필수입니다.
		  [등록]
		둘다 등록이 되면 등록완료 텍스트 호출
		등록이 안되면 다시 등록 처리.
	 */

	
}
