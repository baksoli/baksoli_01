package springweb.a01_start;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import springweb.z01_vo.MemberReg_hw;

@Controller
@RequestMapping("/memRegHW.do")
// http://localhost:7080/springweb/memRegHW.do
public class H03_ValidateController {
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
	@RequestMapping(method=RequestMethod.GET)
	public String form(@ModelAttribute("memberReg") MemberReg_hw mreg) {
		return "WEB-INF\\view\\h03_memRegisterForm.jsp";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String memberRegHW(@ModelAttribute("memberReg") MemberReg_hw mReg,
							BindingResult bindingResult) {
		
		new MemRegisterValidatorHW().validate(mReg, bindingResult);
		
		if(bindingResult.hasErrors()) {
			return "WEB-INF\\view\\h03_memRegisterForm.jsp";
		}
		
		return "WEB-INF\\view\\h03_memRegisterSuccess.jsp";
	}
}
