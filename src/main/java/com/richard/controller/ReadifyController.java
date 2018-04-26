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
import org.springframework.web.bind.annotation.RequestParam;
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
 * The controller for readify test
 * 
 * @author Richard
 * @version 1.0
 */
@RestController
@RequestMapping("/api")
public class ReadifyController {

	public static final Logger logger = LoggerFactory.getLogger(ReadifyController.class);

	// ------Create a ToDoItem----------------

	@RequestMapping(value = "/Fibonacci", method = RequestMethod.GET)
	public ResponseEntity<?> GetFibonacciSequence(@RequestParam("n") long n) {
		long result = 0;
		n = Math.abs(n);
		if (n == 0) {
			result = 0;
		} else if (n == 1) {
			result = 1;
		} else {
			long first = 0;
			long second = 1;
			for (long i = 2; i <= n; i++) {
				result = first + second;
				first = second;
				second = result;
			}
		}

		return new ResponseEntity<Long>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/ReverseWords", method = RequestMethod.GET)
	public ResponseEntity<?> GetReverseWords(@RequestParam("sentence") String sentence) {
		char[] in = sentence.toCharArray();
		int begin = 0;
		int end = in.length - 1;
		char temp;
		while (end > begin) {
			temp = in[begin];
			in[begin] = in[end];
			in[end] = temp;
			end--;
			begin++;
		}
		String result = new String(in);

		return new ResponseEntity<String>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/Token", method = RequestMethod.GET)
	public ResponseEntity<?> GetToken() {
		String result = "44971da6-23c5-4d0f-9dca-8d930daaf895";

		return new ResponseEntity<String>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/TriangleType", method = RequestMethod.GET)
	public ResponseEntity<?> GetReverseWords(@RequestParam("a") int a, @RequestParam("b") int b,
			@RequestParam("c") int c) {
		String result = "Scalene";
		if (a == b && a == c) {
			result = "Equilateral";
		} else if (a == b || a == c || b == c) {
			result = "Isosceles";
		} else if (a + b <= c || a + c <= b || b + c <= a) {
			result = "Error";
		}

		return new ResponseEntity<String>(result, HttpStatus.OK);
	}

}
