package com.richard.service;

import org.springframework.stereotype.Service;

import com.richard.model.ToDoItemAddRequest;
import com.richard.model.ToDoItemUpdateRequest;
import com.richard.model.ToDoItemValidationError;

/**
 * @author Richard
 * @version 1.0
 */
@Service("validationService")
public class ValidationServiceImp1 implements ValidationService {

	@Override
	public ToDoItemValidationError validateToDoItemAddRequest(ToDoItemAddRequest toDoItemAddRequest) {
		return this.validateInputString(toDoItemAddRequest.getText());
	}

	@Override
	public ToDoItemValidationError validateToDoItemUpdateRequest(ToDoItemUpdateRequest toDoItemUpdateRequest) {
		return this.validateInputString(toDoItemUpdateRequest.getText());
	}

	@Override
	public ToDoItemValidationError validateInputString(String input) {
		if (input == null || input.length() < 1 || input.length() > 50) {
			return new ToDoItemValidationError("text", "Must be between 1 and 50 chars long");
		}
		return null;
	}

}
