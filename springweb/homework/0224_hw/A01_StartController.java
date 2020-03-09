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
import org.springframework.web.bind.annotation.RequestParam;

import springweb.z01_vo.Person;

/*
# spring에서 controller를 통한 화면로딩..
1. controller 클래스 생성.
2. annotation 선언..
3. url mapping 주소 추가 메서드로 선언.
 	1) annotation RequestMapping으로 호출 주소 선언.
 	2) 메서드 선언.
 		public String 메서드명(Model d){
 			return "호출할 jsp페이지";
 		}
4. jsp(View단 호출)
	1) controller 마지막 return으로 선언된, View단의
		jsp파일 해당 위치로 생성.
	2) jsp 파일 controller 에서 보낸 모델 el태그로 선언.
5. container(@@.xml)에 controller를 Bean클래스 등록
6. 서버 restart, url로 호출 화면 확인..

*/
// 2. annotation 선언(controller 상단에 선언)
//     springweb.a01_start.A01_StartController
@Controller
public class A01_StartController {
	// 3. url mapping 주소 추가 메서드로 선언.
		// http://localhost:7080/springweb/start.do
		// 1. http://localhost:7080/springweb 기본 서버페이지 호출
		// 2. /start.do를 통해서 특정 controller에 메서드 호출.
//		1) 주소 선언.
	@RequestMapping("/start.do")
	public String start(Model d) { // ctrl+shift+o (import단축키)
//		2) 메서드 선언.
//			- 매개변수(요청값, Model)
		d.addAttribute("greet", "스프링 시작! 반갑습니다");
//			- return WebContent기준 특정 폴드의 jsp파일 선언.(View 호출)
//			/start.do를 url로 호출하면 	a01_start.jsp를 로딩 처리..
		return "WEB-INF\\views\\a01_start.jsp";
	}
	/*
ex) http://localhost:7080/springweb/first.do

	A02_FirstController.java
		model로  내가 만들 스프링 첫화면!!
	a02_first.jsp
	*/	
	
	// 요청값에 대한 처리..
	// get 방식 기준으로  url 요청값 전달 controller의 처리.
	// http://localhost:7080/springweb/start2.do?num01=27&num02=30
	// start2.do?요청키=요청값
	// 1. 요청값 처리 annotation : @RequestParam
	//     @RequestParam("요청key") 할당할타입 변수명
	//   ex) @RequestParam("num01") int number1
	/// controller의 매개변수 처리..
	//  public String 메서드명(요청값1, 요청값2...., Model d)
	//   url :start2.do?num01=27&num02=30
	//                  요청값1=요청데이터1
	//             RequestParam("num01") int number1
	//                   num01의 27데이터가 number1에 할당.
	@RequestMapping("/start2.do")
	public String start2(
							@RequestParam("num01") int number1,
							@RequestParam("num02") int number2,
							Model d
						) {
		System.out.println("받은 요청값 num01:"+number1);
		System.out.println("받은 요청값 num02:"+number2);		
		System.out.println("합산:"+(number1+number2));
		d.addAttribute("num01", number1);
		d.addAttribute("num02", number2);
		d.addAttribute("sum", number1+number2);
		return "WEB-INF\\views\\a02_start.jsp";
	}
	// 요청값 처리 연습예제
	// springweb/login100.do?id=himan&pass=7777
	// 화면 :
	// 로그인한 아이디 : @@@
	// 입력한 패스워드 : @@
	// 인증여부 : himan이고 7777일때 "성공" /실패
	// 입력하는 로그인화면에서 해당 내용 처리하기..
	// http://localhost:7080/springweb/loginForm.do
	@RequestMapping("/loginForm.do")
	public String loginForm() {
		return "WEB-INF\\views\\a05_loginForm.jsp";
	}
	@RequestMapping("/login100.do")
	public String login100(@RequestParam("id") String id,
						   @RequestParam("pass") String pass,
						   Model d
							) {
		System.out.println("아이디:"+id);
		System.out.println("패스워드:"+pass);
		d.addAttribute("id", id);
		d.addAttribute("pass", pass);
		// 3항 연산자 활용하여, id는 himan이고, pass는 7777일 때, 
		// "성공" 그외에는 "실패"
		d.addAttribute("result", 
						id.equals("himan")&&pass.equals("7777")
						?"성공":"실패");
		
		return "WEB-INF\\views\\a04_login.jsp";
	}
	private static final 
		String BUY_PAGE="WEB-INF\\views\\a06_buy.jsp";
	private static final 
		String RST_PAGE="WEB-INF\\views\\a07_result.jsp";	
	// 같은 url주소와 page를 GET방식과 POST방식을 구분해서 처리할 때,
	// 쓰이는 처리.
	// 1. 초기 화면..특정 url을 호출할 때는 get방식으로 호출한다.
	@RequestMapping(value="/buy.do",
					method=RequestMethod.GET)
	public String buy() {
		return BUY_PAGE;
	}
	// 2. 요청처리 화면..
	//  method방식이 post방식을 요청되는 메서드..
	//  form 형식의 method="post" 했을 때, action 속성값에 mapping
	//  주소..
	@RequestMapping(value="/buy.do",
					method=RequestMethod.POST)
	public String buyResult(@RequestParam("pname") String pname,
							@RequestParam("price") int price,
							@RequestParam("cnt") int cnt,
							Model d
							) {
		String msg = "구매한 물건은 "+pname+"이고, 총비용은 "+
						price*cnt+"입니다!";
		d.addAttribute("msg", msg);
		return RST_PAGE;
	}
/*
과제
	calcu.do로 호출하여 처리되게 하세요.
 계산기
 [   ][+/-/사칙연산자 선택][  ] 
	[계산결과]
 => 
 @@@ X @@ = ## 출력..	
*/	
	// 객체로 요청값 처리..
	// callPerson.do?name=홍길동&age=25&loc=서울신림동
	// useBean을 활용하면..
	//             setName    setAge  setLoc
	///     property로 자동으로 받아지게 된다.
	// Spring에서도 위와 같은 요청값을 특정한 객체에 해당 메서드가 구현되어
	// 있으면, 입력 받게 처리한다.
	// http://localhost:7080/springweb/callPerson.do?name=홍길동&age=25&loc=서울신림동
	// 
	// 1. 요청값을 받을 수 있는 객체 생성..
//	http://localhost:7080/springweb/callPerson.do?name=홍길동&age=25&loc=서울신림동
	@RequestMapping(value="/callPerson.do", method=RequestMethod.GET)
	public String callPersonForm() {
		return "WEB-INF\\views\\a09_callPerson.jsp";
	}
	// 요청값의 key가  객체의 property와 동일할 때, 요청값을 객체로 받을 수 있다.
	//  ?name=홍길동&age=25&loc=서울신림동
	//  1. 할당하는 데이터(매개변수)의 type이 같고,
	//     setName(int name) (X)
	//  2. property명이 요청 key 동일하여야 할당이 된다.
	//     setName(String name) (O)가 선언이 되어 있으면
	//     해당 객체에 데이터 할당된다.
	@RequestMapping(value="/callPerson.do", method=RequestMethod.POST)
	public String callPerson(Person p01, Model d) {
		d.addAttribute("p01", p01);
		return "WEB-INF\\views\\a09_callPerson.jsp";
	}
	/*
	# 쿠키값 설정 처리..
	1. 쿠키 : 서버에서 특정한 데이터를 client위치에 접속관련된 정보를 넘겨주면,
	다음에 서버에 접속할 때, client에서 저장된 정보로 서버에 접속하여 해당 정보에
	대한 인증을 처리할 수 있게 끔 하는 것을 말한다.
	cf) 서버에 접속한 정보를 client 저장..
	# Session 설정 처리.
	1. session : client가 서버에 접속한 정보를 서버에 저장하여, 시간에 다시
	접속시, client를 정보를 확인할 수 있는 데이터를 말한다.
	cf) client가 서버에 접속한 정보를 server에 저장하는 것을 말한다.
	
	 * */
	// http://localhost:7080/springweb/headerCreate.do
	// header정보와 쿠키 정보 생성 페이지
	@RequestMapping("/headerCreate.do")
	public String create(HttpServletResponse response, Model model) {
		// 쿠키 : 서버에서 ==> client
		//      response ? (O)
		//      request ?
		// 1. 임의의 숫자를 만들어 cookie로 client로 넘겨주자.
		//Random random = new Random();
		//String cookValue = Integer.toString(random.nextInt());
		int cookValue= (int)(Math.random()*6+1); // 1~6
		System.out.println("저장할 쿠키값:"+cookValue);
		// 2. 쿠키 생성하여, client에 넘겨주기..
		response.addCookie(new Cookie("ck_num01",""+cookValue));
		return "WEB-INF\\views\\a11_createCookie.jsp";
	}
	// 생성된 header 정보 확인 페이지
	@RequestMapping("/headerInfo.do")
	public String simple(@CookieValue(value="ck_num01", 
							required=false) Integer ck_num01, Model d) {
		System.out.println("클라이언트에서 서버로 온 쿠키:"+ck_num01);
		d.addAttribute("cookie01", ck_num01);
		return "WEB-INF\\views\\a10_simpelValue.jsp";
	}
	// ex) cookie로  물건 갯수, 물건명 을  쿠키 2개에 할당하고,
	//     쿠키 확인할 페이지에서 물건명과 갯수를 출력 처리하세요.
	// http://localhost:7080/springweb/cart.do  쿠키 생성
	// http://localhost:7080/springweb/cartList.do  쿠키 내용
	// #session 처리..
	// 1. request나 HttpSession 매개변수 값으로 session 값을 설정 처리..
	// 2. 화면에서 해당 세션 내용을 확인 처리..
	@RequestMapping("/createSession.do")
	public String createSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("sess01", 
				new Person("himan",25,"서울신림동"));
		return "WEB-INF\\views\\a13_showSession.jsp";
	}
	@RequestMapping("/otherPage.do")
	public String otherPage() {
		return "WEB-INF\\views\\a14_otherSession.jsp";
	}
	// session 종료 처리.
	@RequestMapping("/delSession.do")
	public String delSession(HttpSession session) {
		// 세션 전체를 삭제 처리..
		session.invalidate();
		return "WEB-INF\\views\\a14_otherSession.jsp";
	}	
	// ex) session 설정 처리 연습..
	//    임의의 id, pass입력해서 요청받은 값을 
	//    himan//7777 일때,session 설정 로그인 성공 페이지 이동
	//    그 외에는  다시 로그인 화면에서 로그인 처리할 수 있게..
	//    login.do  get방식
	//    login.do  post방식
	//    success.do  성공페이지
	
}






