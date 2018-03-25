package com.richard.model;

/**
 * @author Richard
 * @version 1.0
 */
public class BalanceTestResult {
	private final String input;
	private final boolean isBalanced;

	public String getInput() {
		return input;
	}

	public boolean getIsBalanced() {
		return isBalanced;
	}

	public BalanceTestResult(String input, boolean isBalanced) {
		this.input = input;
		this.isBalanced = isBalanced;
	}
}
