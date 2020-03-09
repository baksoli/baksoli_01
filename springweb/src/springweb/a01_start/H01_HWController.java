package springweb.a01_start;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class H01_HWController {
	
	@RequestMapping("/call.do")
	public String call(Model d){
		d.addAttribute("call", "안녕하세요");
		return "WEB-INF\\view\\h01_homework.jsp";
	}
}
