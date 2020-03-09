package springweb.a01_start;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//springweb.a01_start.A03_Con2Controller
@Controller
public class A03_Con2Controller {
	//http://localhost:7080/springweb/start.do2
	 @RequestMapping("/start.do2")
	 public String start(Model d) {
		 d.addAttribute("greet", "두번째 front 컨트롤러에서 시작!!");
		 return "WEB-INF\\view\\a03_start.jsp";
	 }
}
