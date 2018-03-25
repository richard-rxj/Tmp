/**
 * 
 */
package com.richard.service;

import com.richard.model.ToDoItemAddRequest;
import com.richard.model.ToDoItemUpdateRequest;
import com.richard.model.ToDoItemValidationError;

/**
 * This interface handles the request validation
 * 
 * @author Richard
 * @version 1.0
 */
public interface ValidationService {
	ToDoItemValidationError validateToDoItemAddRequest(ToDoItemAddRequest toDoItemAddRequest);

	ToDoItemValidationError validateToDoItemUpdateRequest(ToDoItemUpdateRequest toDoItemUpdateRequest);

	ToDoItemValidationError validateInputString(String input);
}
