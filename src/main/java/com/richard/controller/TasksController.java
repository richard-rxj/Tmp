package com.richard.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.richard.model.BalanceTestResult;
import com.richard.model.ToDoItem;
import com.richard.model.ToDoItemAddRequest;
import com.richard.model.ToDoItemValidationError;
import com.richard.service.TaskService;
import com.richard.service.ToDoItemService;
import com.richard.service.ValidationService;

/**
 * The controller handles all the requests about tasks
 * 
 * @author Richard
 * @version 1.0
 */
@RestController
@RequestMapping("/test/1.0")
public class TasksController {

	public static final Logger logger = LoggerFactory.getLogger(TasksController.class);

	@Autowired
	TaskService taskService; // Service which will do all task work

	@Autowired
	ValidationService validationService; // Service which will do all the request validation work

	// ------Create a ToDoItem----------------

	@RequestMapping(value = "/tasks/validateBrackets/{input}", method = RequestMethod.GET)
	public ResponseEntity<?> validateBrackets(@PathVariable("input") String input) {
		logger.info("Validate Brackets : {}", input);

		ToDoItemValidationError validationError = validationService.validateInputString(input);
		if (validationError != null) {
			return new ResponseEntity<ToDoItemValidationError>(validationError, HttpStatus.NOT_ACCEPTABLE);
		}

		BalanceTestResult balanceTestResult = taskService.validateBrackets(input);

		return new ResponseEntity<BalanceTestResult>(balanceTestResult, HttpStatus.OK);
	}

}
