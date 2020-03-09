package board.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import board.vo.Board;

public class BoardInsertValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return Board.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Board board = (Board)target;
		if(board.getSubject() == null || board.getSubject().trim().isEmpty()){
			errors.rejectValue("subject", "required");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "writer", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pass", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "content", "required");
	}

}
