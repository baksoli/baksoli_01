package springweb.a01_start;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import springweb.z01_vo.Member;

// springweb.a01_start.A02_FirstController
@Controller
public class A02_FirstController {
	// http://localhost:7080/springweb/first.do
	@RequestMapping("/first.do")
	public String first(Model d) {
		d.addAttribute("msg", "내가 만들 스프링 첫화면!!");
		return "WEB-INF\\views\\a02_first.jsp";
	}
	// http://localhost:7080/springweb/cart.do
	@RequestMapping("/cart.do")
	public String cart(HttpServletResponse response, Model model) {
		// 쿠키를 key, value에 의해서 생성..
		// request.getCookies
		// 2개의 쿠키 생성.
		// client에 쿠키는 넘겨주고,
		response.addCookie(new Cookie("pname","apple"));
		response.addCookie(new Cookie("pcnt", "5"));
		// 특정 controller을 바로 호출하는 방식
		// 1. 요청값을 넘기면서 호출하는 방식: forward:/호출주소.
		// 2. 요청값을 넘기지않고 호출하는 방식: redirect:/호출주소
		//    response.sendRedirect(arg0);
		return "redirect:/cartList.do";
	}	
	@RequestMapping("/cartList.do")
	public String simple(@CookieValue(value="pname", 
							required=false) String pname,
						  @CookieValue(value="pcnt", 
							required=false) Integer pcnt,
						 Model d) {
		System.out.println("물건명:"+pname);
		System.out.println("가격:"+pcnt);
		d.addAttribute("pname", pname);
		d.addAttribute("pcnt", pcnt);
		return "WEB-INF\\views\\a12_cartList.jsp";
	}	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String loginForm01() {
		return "WEB-INF\\views\\a15_login.jsp";
	}	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String loginForm02(Member member, 
								HttpServletRequest request) {
		// name="id"  setName  name="pass" setPass()
		// 로 데이터 입력 처리..
		if(member.getId().equals("himan")
			&&member.getPass().equals("7777")) {
			// session 값 설정.
			HttpSession session = request.getSession();
			session.setAttribute("member", member);
			// 성공 페이지로 이동..
			return "WEB-INF\\views\\a16_success.jsp";
		}else {
			// 실패시 redirct로 기존 로그인 페이지 이동..
			return "redirect:/login.do";
		}
		
		
		
	}		
}
