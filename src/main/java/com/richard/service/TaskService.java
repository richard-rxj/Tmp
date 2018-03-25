package com.richard.service;

import com.richard.model.BalanceTestResult;

/**
 * This interface handles the tasks
 * 
 * @author Richard
 * @version 1.0
 */
public interface TaskService {

	/**
	 * This method checks if brackets in a string are balanced
	 * 
	 * @param input
	 * @return
	 */
	BalanceTestResult validateBrackets(String input);
}
