package springweb.a01_start;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springweb.z01_vo.Member;
import springweb.z01_vo.Person;

/*
# spring에서 controller를 통한 화면로딩
1. controller 클래스 생성.
2. annotation 선언.
3. url mapping 주소 추가 메서드로 선언.
 	1) annotation RequestMapping으로 호출 주소 선언.
 	2) 메서드 선언.
 		public String 메서드명(Model d){
 			return "호출할 jsp페이지";
 		}
 4. jsp(View단 호출)
 	1) controller 마지막 return으로 선언된, view단의 
 		jsp파일 해당 위치로 생성.
 	2) jsp 파일, controller 에서 보낸 모델 el태그로 선언.
 5. container(@@.xml)에 controller를 Bean 클래스 등록.
  	springweb.a01_start.A01_StartController
 6. 서버 restart, url로 호출 화면 확인.
 
 */
// 2. annotation 선언(controller 상단에 선언)

@Controller
public class A01_StartController {
	/* 3. url mapping 주소 추가 메서드로 선언.
		http://localhost:7080/springweb/start.do
		1. http://localhost:7080/springweb 기본 서버 페이지 호출
		2. /start.do 를 통해서 특정 controller에 메서드 호출.
	
		1) 주소 선언.
	*/
	@RequestMapping("/start.do")
	public String start(Model d) {
		/*2) 메서드 선언
			- 매개변수(요청값, Model)
		*/
		d.addAttribute("greet","스프링 시작! 반갑습니다");
		/*
			- return WebContent기준 특정 폴더의 jsp 파일 선언(view단 호출)
		 */
		
		//start.do 를 url로 호출하면 a01_start.jsp를 로딩 처리 된다.
		return "WEB-INF\\view\\a01_start.jsp";
	}
	
	// 요청값에 대한 처리.
	// get 방식 기준으로 url 요청 값 전달과 controller의 처리.
	// http://localhost:7080/springweb/start2.do?num01=27&num02=30
	// start2.do?요청key=요청value&요청key2=요청value2
	// 1. 요청값 처리 annotation : @RequestParam
	// 		@RequestParam("요청key") 할당할타입 변수명 
	// 	ex) @RequestParam("num01") int number1
	//  controller단의 매개변수 처리.
	//  : public String 메서드명(요청값1, 요청값2,..., Model d)
	//  url : start2.do?num01=27&num02=30
	// 					요청값1 = 요청데이터 1
	//					@RequestParam("num01") int number1
	//						num01의 27 데이터가 number1에 할당.
	@RequestMapping("/start2.do")
	public String start2(@RequestParam("num01") int number1, @RequestParam("num02") int number2, Model d) {
		System.out.println("받은 요청값 num01 : "+number1);
		System.out.println("받은 요청값 num02 : "+number2);
		System.out.println("합산 : "+(number1+number2));
		d.addAttribute("num01", number1);
		d.addAttribute("num02", number2);
		d.addAttribute("sum", number1+number2);
		return "WEB-INF\\view\\a02_start.jsp";
	}
	
	// 요청값 처리 연습 예제
	// http://localhost:7080/springweb/login100.do?id=himan&pass=7777
	// 화면 : 
	// 로그인한 아이디 : @@@
	// 입력한 패스워드 : @@
	// 인증여부 : himan이고 777일 때 , "성공" 그외에는 실패 출력
	// 입력하는 로그인 화면에서 해당 내용 처리하기.
	// http://localhost:7080/springweb/loginForm.do
	@RequestMapping("/loginForm.do")
	public String loginForm() {
		return "WEB-INF\\view\\a05_loginForm.jsp";
	}
	@RequestMapping("/login100.do")
	public String login1(@RequestParam("id") String loginid, @RequestParam("pass") String pwd, Model d) {
		String rtn;
		if(loginid.equals("himan")&&pwd.equals("7777")) {
			rtn = "성공";
		}else {
			rtn = "실패";
		}
		d.addAttribute("id", loginid);
		d.addAttribute("pass", pwd);
		d.addAttribute("msg", rtn);
		// 삼항 연산자를 활용하여, id는 himan, pass는 7777이면 성공, 그외에는 실패
		d.addAttribute("result", loginid.equals("himan")&&pwd.equals("7777")?"성공":"실패");
		return "WEB-INF\\view\\a04_login.jsp";
	}
	
	private static final String BUY_PAGE="WEB-INF\\view\\a06_buy.jsp";
	private static final String RST_PAGE="WEB-INF\\view\\a07_result.jsp";
	// 같은 url 주소와 page를 GET방식과 POST방식을 구분해서 처리할 때,
	// 쓰이는 처리.
	// 1. 초기 화면 : 특정 url을 호출할 때는 get방식으로 호출한다.
	@RequestMapping(value="/buy.do", method=RequestMethod.GET)
	public String buy() {
		return BUY_PAGE;
	}
	// 2. 요청 처리 화면.
	// method방식이 post방식을 요청되는 메서드.
	// form 형식의 method="post" 했을 때, action 속성값에 mapping 된 주소.
	@RequestMapping(value="/buy.do", method=RequestMethod.POST)
	public String buyResult(@RequestParam("pname") String pname, @RequestParam("price") int price,
			@RequestParam("cnt") int cnt, Model d) {
//		d.addAttribute("pname", pname);
//		d.addAttribute("price", price);
//		d.addAttribute("cnt", cnt);
		String msg = "구매한 물건은 "+pname+"이고, 총 비용은"+(price*cnt)+"입니다!";
		d.addAttribute("msg",msg);
		return RST_PAGE;
	}
	
/*
과제
	calcu.do로 호출하여 처리되게 하세요.
	계산기
	[첫번째 값][사칙연산자 선택][두번째 값]
	[계산결과] 버튼 클릭
	=>다음 화면에서
	ex) @@@ * @@ = ## 출력
	
	http://localhost:7080/springweb/calcu.do
 */
	
	private static final String CALC_PAGE = "WEB-INF\\view\\a08_calc.jsp";
	private static final String RTN_PAGE = "WEB-INF\\view\\a09_result.jsp";
	@RequestMapping(value="/calcu.do", method=RequestMethod.GET)
	public String calc() {
		return CALC_PAGE;
	}
	@RequestMapping(value="/calcu.do", method=RequestMethod.POST)
	public String calcResult(@RequestParam("num1") int num1, @RequestParam("cal") String cal, 
			@RequestParam("num2") int num2, Model d) {
		int calcRtn = 0;
		int errorCNT = 0;
		if(cal.equals("+")) {
			calcRtn = num1 + num2;
		}else if(cal.equals("-")) {
			calcRtn = num1 - num2;
		}else if(cal.equals("*")) {
			calcRtn = num1 * num2;
		}else if(cal.equals("/")) {
			calcRtn = num1 / num2;
		}else {
			errorCNT++;
		}
		
		if(errorCNT == 0)
			d.addAttribute("msg",num1 + " "+cal+" "+num2+"="+calcRtn);
		else
			d.addAttribute("msg","잘못된 사칙연산을 입력했습니다.");
		return RTN_PAGE;
	}
	// 객체로 요청값 처리.
	// callPerson.do?name=홍길동&age=25&loc=서울신림동
	// useBean을 활용하면, 
	// 			setName, setAge, setLoc
	//	property로 자동으로 받아지게 된다.
	// spring에서도 위와 같은 요청값을 특정한 객체에 해당 메서드가 구현되어 있으면,
	// 입력받게 처리한다.
	// http://localhost:7080/springweb/callPerson.do?name=홍길동&age=25&loc=서울신림동
	// 1. 요청값을 받을 수 있는 객체 생성.
	
	@RequestMapping(value="/callPerson.do", method=RequestMethod.GET)
	public String callPersonForm(Person p01, Model d) {
		d.addAttribute("p01",p01);
		return "WEB-INF\\view\\a09_callPerson.jsp";
	}
	// 요청값의 key가 객체의 property와 동일할 때, 요청값을 객체로 받을 수 있다.
	// ?name=홍길동&age=25&loc=서울신림동
	// 1. 할당하는 데이터(매개변수)의 type이 같고,
	// 	  setName(int name) (X)
	// 2. property명이 요청 key와 동일하여야 할당이 된다.
	//	  setName(String name) (O) 가 선언되어 있으면 
	// 	   해당 객체의 데이터가 할당된다.
	@RequestMapping(value="/callPerson.do", method=RequestMethod.POST)
	public String callPerson(Person p01, Model d) {
		d.addAttribute("p01",p01);
		return "WEB-INF\\view\\a09_callPerson.jsp";
	}
	
	/* 2020-02-24
	# 쿠키값 설정 처리..
	1. 쿠키 : 서버에서 특정한 데이터를 client 위치체 접속 관련된 정보를 넘겨주면,
		다음에 서버에 접속 할 때, client에서 저장된 정보로 서버에 접속하여 해당 정보에
		대한 인증을 처리할 수 있게끔 하는 것을 말한다.
		cf) 서버에서 접속한 정보를 client에 저장한다.
	# Session 설정 처리.
	1. session : client가 서버에 접속한 정보를 서버에 저장하여, 시간 안에 다시
	 	접속시, client의 정보를 확인 할 수 있는 데이터를 말한다.
	 	cf) client가 서버에 접속한 정보를 server에 저장하는 것을 말한다.
	 	
	 */
	// header정보와 쿠키 정보 생성 페이지
	//http://localhost:7080/springweb/headerCreate.do
	@RequestMapping("/headerCreate.do")
	public String create(HttpServletResponse response, Model model) {
		// 쿠키 : 서버에서 ==> client
		// 		response ? (O) 
		// 		request ?
		// 1. 임의의 숫자를 만들어 cookie에 담아 client로 넘겨주자.
		//Random random = new Random();
		//String cookValue = Integer.toString(random.nextInt());
		int cookValue = (int)(Math.random()*6+1); // 1~6 의 값 임의로 발생
		System.out.println("저장할 쿠키 값 : " + cookValue);
		// 2. 쿠키를 생성하여, client에 넘겨주기.
		response.addCookie(new Cookie("ck_num01", ""+cookValue));
		return "WEB-INF\\view\\a11_createCookie.jsp";
	}
	// 생성된 header 정보 확인 페이지
	// 저장된 client(브라우저) CookieValue 로 가져온다.
	@RequestMapping("/headerInfo.do")
	public String simple(@CookieValue(value="ck_num01",required = false) Integer ck_num01, Model d) {
		System.out.println("클라이언트에서 서버로 온 쿠키 : " + ck_num01);
		d.addAttribute("cookie01",ck_num01);
		return "WEB-INF\\view\\a10_simpleValue.jsp";
	}
	
	// 쿠키 확인 예제 (2020.02.24)
	// A02_FirstController.java 에서 실행
	
	// #session 처리.
	// 1. request나 HttpSession 매개변수 값으로 session 값을 설정 처리.
	// 2. 화면단에서 해당 세션 내용을 확인 처리.
	// http://localhost:7080/springweb/createSession.do
	@RequestMapping("/createSession.do")
	public String createSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("sess01", new Person("himan",25,"서울신림동"));
		
		return "WEB-INF\\view\\a13_showSession.jsp";
	}
	@RequestMapping("/otherPage.do")
	public String otherPage() {
		return "WEB-INF\\view\\a14_otherSession.jsp";
	}
	//session 종료 처리
	@RequestMapping("/delSession.do")
	public String delSession(HttpSession session) {
		// 세션 전체를 삭제 처리
		session.invalidate();
		return "WEB-INF\\\\view\\\\a14_otherSession.jsp";
	}
	
	
	// 세션 확인 예제 (2020.02.24)
	// ex) session 설정 처리 연습.
	// 		임의의 id, password 입력 후 요청 받은 값을 
	//		himan / 7777 일때, 로그인 성공 페이지로 이동하면 session 설정
	// 		그 외에는 다시 로그인 화면에서 로그인 처리할 수 있도록.
	// login.do get방식, login.do post방식
	// success.do 성공 페이지
	// http://localhost:7080/springweb/login.do
	@RequestMapping(value="/login.do", method =RequestMethod.GET)
	public String loginSession() {
		return "WEB-INF\\view\\a15_loginSession.jsp";
	}
	@RequestMapping(value="/login.do", method = RequestMethod.POST)
	public String loginRtn(Member member, HttpServletRequest request) {
		// name="id" setName name="pass" setPass() 로 데이터 입력 처리.
		if (member.getId().equals("himan") && member.getPass().equals("7777")) {
			HttpSession session = request.getSession();
			session.setAttribute("member", member);
			return "WEB-INF\\view\\a16_loginSuccessSession.jsp";
		} else {
			return "redirect:/login.do";
		}
	}
	
	@RequestMapping("/logout.do")
	public String delLoginSession(HttpSession session) {
		session.invalidate();
		return "redirect:/login.do";
	}
	
	/*
	# 요청값 처리.
	1. request 객체를 통해서 가져오는 값. (주소?key=value)
		1) @RequestParam("key") String value;
		2) 객체를 통해서 가져오는 내용
			setKey(String value) : 해당 property 메서드가 있으면 요청 값을 저장하여 
				public String form(Object reqObj, Model d)
		3) 쿠키값 가져오기.
			response.addCookie로 쿠키값 저장.
			@CookieValue("쿠키의 키") 쿠키 값으로 요청과 함께 가져올 수 있다.
		4) url 주소로 요청값 처리하는 방식.
			@RequestMapping("/members/{요청값처리}")
			@PathVariable("요청값") String 변수;
	2. session 설정.
		서버의 controller에서 HttpSession을 통해 session 값 설정한다.
	 */
	// 주소에 의한 요청값 처리.
	// http://localhost:7080/springweb/members.do
	@RequestMapping("/members.do")
	public String members(Model m) {
		List<Member> mlist = new ArrayList<Member>();
		mlist.add(new Member("himan","7777"));
		mlist.add(new Member("higirl","8888"));
		mlist.add(new Member("goodMan","9999"));
		m.addAttribute("mlist",mlist);
		
		return "WEB-INF\\view\\a20_memberList.jsp";
	}
	//  /members/"+id+".do" 형식을 받은 데이터를 받기.
	@RequestMapping("/{memberId}.do")
	public String memberId(@PathVariable("memberId") String memberId, Model d) {
		System.out.println("받은 id: "+memberId);
		Member m = new Member(memberId,"7777");
		m.setName("홍길동");
		m.setPoint(10000);
		d.addAttribute("memDetail",m);
		return "WEB-INF\\view\\a21_memberDetail.jsp";
	}
	
}




