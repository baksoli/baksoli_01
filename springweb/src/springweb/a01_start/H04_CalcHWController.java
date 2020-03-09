package springweb.a01_start;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springweb.z01_vo.Answer;
import springweb.z01_vo.Number;

@Controller
@RequestMapping("/calcHW.do")
// http://localhost:7080/springweb/calcHW.do
public class H04_CalcHWController {
//	6. 구구단 입력
//	   [    ] X [    ] [계산] 
//	   계산을 클릭시, 1번째 입력 안되있으면 에러로 1번째 입력 메시지
//	   계산을 클릭시, 2번째 입력 안되있으면 에러로 2번째 입력 메시지
//	   둘다 정상 입력시에는 연산결과 출력..
	
	@RequestMapping(method=RequestMethod.GET)
	public String mainForm(
					@ModelAttribute("calculation") Answer answ,
			Model d){
		ArrayList<Number> nlist = new ArrayList<Number>();
		for (int i = 0; i < 2; i++) {
			int num1 = (int) (Math.random() * 10 + 1);
			int num2 = (int) (Math.random() * 10 + 1);

			nlist.add(new Number(num1, num2, (num1*num2)));
		}
		d.addAttribute("nlist",nlist);
		
		return "WEB-INF\\view\\h04_calcForm.jsp";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String calcRtn(
				@ModelAttribute("calculation") Answer answ,
						BindingResult bindingResult){
		
		new CalcFromValidator().validate(answ, bindingResult);
		if(bindingResult.hasErrors()){
			System.out.println("hasErrors~!~!");
			return "WEB-INF\\view\\h04_calcForm.jsp";
			
		}
		System.out.println("noErrors~~");
		return "WEB-INF\\view\\h04_resultView.jsp";
	}
}
