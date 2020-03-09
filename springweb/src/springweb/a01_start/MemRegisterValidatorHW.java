package springweb.a01_start;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import springweb.z01_vo.MemberReg_hw;

public class MemRegisterValidatorHW implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return MemberReg_hw.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		MemberReg_hw mreg = (MemberReg_hw)target;
		if(mreg.getId() == null || mreg.getId().trim().isEmpty()) {
			errors.rejectValue("id", "memberRequired");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "memberRequired");
	}

}
