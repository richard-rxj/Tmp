/**
 * 
 */
package com.richard.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.richard.model.ToDoItem;
import com.richard.model.ToDoItemAddRequest;
import com.richard.model.ToDoItemNotFoundError;
import com.richard.model.ToDoItemUpdateRequest;
import com.richard.model.ToDoItemValidationError;
import com.richard.service.ToDoItemService;
import com.richard.service.ValidationService;

/**
 * The controller handles all the requests about ToDoItem operation
 * 
 * @author Richard
 * @version 1.0
 */
@RestController
@RequestMapping("/test/1.0")
public class ToDoController {

	public static final Logger logger = LoggerFactory.getLogger(ToDoController.class);

	@Autowired
	ToDoItemService toDoItemService; // Service which will do all data retrieval and manipulation work

	@Autowired
	ValidationService validationService; // Service which will do all the validation work

	// ------Create a ToDoItem----------------

	@RequestMapping(value = "/todo", method = RequestMethod.POST)
	public ResponseEntity<?> createToDoItem(@RequestBody ToDoItemAddRequest toAdd) {
		logger.info("Creating ToDoItem : {}", toAdd);

		ToDoItemValidationError validationError = validationService.validateToDoItemAddRequest(toAdd);
		if (validationError != null) {
			return new ResponseEntity<ToDoItemValidationError>(validationError, HttpStatus.NOT_ACCEPTABLE);
		}

		ToDoItem toDoItem = new ToDoItem(toAdd.getText());
		toDoItemService.saveItem(toDoItem);

		return new ResponseEntity<ToDoItem>(toDoItem, HttpStatus.OK);
	}

	// ------Update a ToDoItem----------------

	@RequestMapping(value = "/todo/{id}", method = RequestMethod.PATCH)
	public ResponseEntity<?> createToDoItem(@PathVariable("id") int id, @RequestBody ToDoItemUpdateRequest toUpdate) {
		logger.info("Update ToDoItem with id {} : {}", id, toUpdate);

		ToDoItemValidationError validationError = validationService.validateToDoItemUpdateRequest(toUpdate);
		if (validationError != null) {
			return new ResponseEntity<ToDoItemValidationError>(validationError, HttpStatus.NOT_ACCEPTABLE);
		}

		ToDoItem toDoItem = toDoItemService.findItemById(id);
		if (toDoItem == null) {
			String errorMessage = String.format("Item with %s not found", id);
			logger.error(errorMessage);
			ToDoItemNotFoundError notFoundError = new ToDoItemNotFoundError(errorMessage);
			return new ResponseEntity<ToDoItemNotFoundError>(notFoundError, HttpStatus.NOT_FOUND);
		}

		toDoItem.setText(toUpdate.getText());
		toDoItem.setIsCompleted(toUpdate.getIsCompleted());

		return new ResponseEntity<ToDoItem>(toDoItem, HttpStatus.OK);
	}

	// ------Retrieve a ToDoItem---------------

	@RequestMapping(value = "/todo/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getToDoItem(@PathVariable("id") int id) {
		logger.info("Fetching ToDoItem with id {}", id);
		ToDoItem toDoItem = toDoItemService.findItemById(id);
		if (toDoItem == null) {
			String errorMessage = String.format("Item with %s not found", id);
			logger.error(errorMessage);
			ToDoItemNotFoundError notFoundError = new ToDoItemNotFoundError(errorMessage);
			return new ResponseEntity<ToDoItemNotFoundError>(notFoundError, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ToDoItem>(toDoItem, HttpStatus.OK);
	}

	// ------Retrieve All ToDoItems-----------------

	@RequestMapping(value = "/todo/", method = RequestMethod.GET)
	public ResponseEntity<List<ToDoItem>> listAllUsers() {
		logger.info("Fetching all TodoItems");
		List<ToDoItem> items = toDoItemService.findAllItems();
		if (items.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<ToDoItem>>(items, HttpStatus.OK);
	}

}
