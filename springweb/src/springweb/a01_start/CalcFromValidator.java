package springweb.a01_start;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import springweb.z01_vo.Answer;

public class CalcFromValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return Answer.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Answer answ = (Answer)target;
		if(answ.getAnswer1() == null || answ.getAnswer1().trim().isEmpty()) {
			errors.rejectValue("answer1", "required");
		}else if(!answ.getAnswer1().equals(answ.getTrueAnswer1())){
			errors.rejectValue("answer1","falseAnswer");
		}
		
		if(answ.getAnswer2() == null || answ.getAnswer2().trim().isEmpty()) {
			errors.rejectValue("answer2", "required");
		}else if(!answ.getAnswer2().equals(answ.getTrueAnswer2())){
			errors.rejectValue("answer2","falseAnswer");
		}
				
		
	}

}
