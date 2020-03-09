package springweb.a01_start;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class H02_HWController {
	
	private static final String INIT_PAGE = "WEB-INF\\view\\h02_mathInit.jsp";
	private static final String RST_PAGE = "WEB-INF\\view\\h02_mathResult.jsp";
	private String calcArrRst[] = new String[10];
	//http://localhost:7080/springweb/math.do
	@RequestMapping(value="/math.do", method=RequestMethod.GET)
	public String mathInit(Model d){
	
		
		ArrayList<Gugu> glist = new ArrayList<Gugu>();
		for(int i=1; i<11; i++){
			int ranIdx =(int)(Math.random()*3); //0~3

			String state[] = {"+","-","*","/"};
			
			
			int input1 = (int)(Math.random()*10+1);
			String input2 = state[(int)(Math.random()*3)];
			
			int input3 = (int)(Math.random()*10+1);
			int result = new int[] {input2+input3,input2-input3,
									input2*input3, input2/input3};
			//state[ranIdx] // 선택된 연산자.
			//result[ranIdx] // 선택된 정답..		
			glist.add(new Gugu(input1, state[ranIdx],input3,result[ranIdx]));
			int calcRst=0;
			if(input2.equals("+")){
				calcRst = input1+input3;
			}else if(input2.equals("-")){
				calcRst = input1-input3;
			}else if(input2.equals("*")){
				calcRst = input1*input3;
			}else if(input2.equals("/")){
				calcRst = input1/input3;
			}
			
			calcArrRst[i-1] = Integer.toString(calcRst);
			
			d.addAttribute("q"+i, input1+input2+input3);
			
			
		}
		return INIT_PAGE;
	}
	
	@RequestMapping(value="/math.do", method=RequestMethod.POST)
	public String mathResult(@RequestParam("val") String inputVal, Model d){
		System.out.println(inputVal);
		String[] inputArrayRst = inputVal.split(",");
		//inputVal = new String[10];
		
		int score=0;
		
		for(int i=0; i<10; i++){
			System.out.println(calcArrRst[i] +", "+inputArrayRst[i]);
			System.out.println(calcArrRst[i] == inputArrayRst[i]);
			if(calcArrRst[i].equals(inputArrayRst[i])){
				score++;
			}
		}
		
		//계산 값 결과
		d.addAttribute("msg","정답 : "+score+", 점수 : "+(score*10));
		
		return RST_PAGE;
	}
}
class Gugu{
	private int num01;
	private String cal;
	private int num02;
	private int corReply;
	//생성자
	// set/get메서드 생성..
	
}
		
		
		
