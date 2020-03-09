package springweb.a01_start;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import springweb.z01_vo.MemberReg;

public class MemberRegisterValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return MemberReg.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		// 1. 대상 객체 VO (mapping)
		MemberReg mReg = (MemberReg)target;
		if(mReg.getJobCode() == null || mReg.getJobCode().trim().isEmpty()) {
			errors.rejectValue("jobCode", "required");
		}
		
		// errors.rejectValue를 보다 간편하게 처리하기 위해서 지원되는 util
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required");
		
		if(mReg.getFavoriteOs() == null || mReg.getFavoriteOs().length == 0) {
			errors.rejectValue("favoriteOs", "required");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tool", "required");
		/*
		 * jobcode favoriteOs tool
		 */
		
		// 2. 에러가 발생하는 rejectValue 설정.
		
		// 3. ValidationUtils.rejectIfEmptyWhitespace(error, "해당 속성", "에러 코드")
		
	
	}

}
