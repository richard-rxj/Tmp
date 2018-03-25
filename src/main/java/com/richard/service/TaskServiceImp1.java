package com.richard.service;

import java.util.Stack;

import org.springframework.stereotype.Service;

import com.richard.model.BalanceTestResult;

/**
 * @author Richard
 * @version 1.0
 */
@Service("taskService")
public class TaskServiceImp1 implements TaskService {

	@Override
	public BalanceTestResult validateBrackets(String input) {
		boolean isBalanced = this.validateBracketsBalance(input);
		return new BalanceTestResult(input, isBalanced);
	}

	/**
	 * This method checks if brackets in a string are balanced
	 * 
	 * @param input
	 * @return
	 */
	private boolean validateBracketsBalance(String input) {
		if (input == null || input.isEmpty()) {
			return true;
		}
		char[] chars = input.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		for (char curCharacter : chars) {
			switch (curCharacter) {
			case '(':
			case '[':
			case '{': {
				stack.push(curCharacter);
				break;
			}

			case ')':
			case ']':
			case '}': {
				if (stack.isEmpty()) {
					return false; // no matched left bracket
				}
				char toMatch = stack.pop();
				if (!isMatch(curCharacter, toMatch)) {
					return false; // no matched left bracket
				}
				break;
			}
			default:
				break;

			}
		}
		if (stack.isEmpty()) {
			return true;
		}
		return false; // no matched right bracket
	}

	/**
	 * The method checks whether two brackets are matched
	 * 
	 * @param right
	 * @param left
	 * @return
	 */
	private boolean isMatch(char right, char left) {
		if (right == ')' && left == '(') {
			return true;
		}

		if (right == ']' && left == '[') {
			return true;
		}

		if (right == '}' && left == '{') {
			return true;
		}
		return false;
	}

}
