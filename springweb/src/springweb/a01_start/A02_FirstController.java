package springweb.a01_start;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * 1. controller 생성
 * 2. annotation 선언 @Controller
 * 3. url 주소 매핑 @RequestMapping("주소")
 * 	메소드 생성 public String start(Model d){}
 * 4. WEB-INF 아래 view 폴더 생성 후 view 파일 생성 후 controller에서 보낸 모델 이엘 태그로 선언 
 * 5. container에 controller 를 bean 클래스 에 등록 <bean class="패키지명.클래명">
 * 6. 서버 리스타트.!! restart!! 화면 호출
 */
@Controller
public class A02_FirstController {
	
	//http://localhost:7080/springweb/first.do
	
	@RequestMapping("/first.do")
	public String first(Model d) {
		
		d.addAttribute("greet", "model로 내가 만들 스프링 첫화면!!");
		return "WEB-INF\\view\\a02_first.jsp";
	}
	
	// 쿠키 확인 예제 (2020.02.24)
	// ex) cookie로 물건 갯수, 물건명(영문명)을 쿠키 2개에 할당하고,
	//		쿠키를 확인할 페이지에서 물건명과  갯수를 출력 처리.
	//		http://localhost:7080/springweb/cart.do : 쿠키 생성
	//		http://localhost:7080/springweb/cartList.do : 쿠키 내용 출력
	
	@RequestMapping("/cart.do")
	public String createCart(HttpServletResponse response, Model d) {
		
		// 쿠키를 key, value에 의해서 생성.
		// request.getCookies
		// 2개의 쿠키 생성.
		String prodName = "snack";
		int prodCnt = (int)(Math.random()*20);
		
		// addCookie 하는 순간 client에 쿠키를 넘겨준다.
		response.addCookie(new Cookie("ck_prodName", prodName));
		response.addCookie(new Cookie("ck_prodCnt", ""+prodCnt));
		
		// 특정 controller를 바로 호출하는 방식 2가지
		// 1. 요청값을 넘기면서 호출하는 방식. : forward:/호출주소.
		// 2. 요청값을 넘기지 않고 호출하는 방식. : redirect:/호출주소
		// response.sendRedirect(arg0);
		 return "redirect:/cartList.do";
		//return "WEB-INF\\view\\a12_createCartCookie.jsp";
	}

	@RequestMapping("/cartList.do")
	public String cartList(@CookieValue(value="ck_prodName", required = false) String prodName, 
			@CookieValue(value="ck_prodCnt", required = false) Integer prodCnt, Model d) {
		System.out.println("쿠키에 저장된 물건 명 : " + prodName);
		System.out.println("쿠키에 저장된 물건 갯수 : " + prodCnt);
		d.addAttribute("prodName", prodName);
		d.addAttribute("prodCnt", prodCnt);
		return "WEB-INF\\view\\a13_createCartListCookie.jsp";
	}
	
}


