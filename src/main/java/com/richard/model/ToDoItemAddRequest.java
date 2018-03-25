/**
 * 
 */
package com.richard.model;

/**
 * @author Richard
 * @version 1.0
 */
public class ToDoItemAddRequest {
	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "ToDoItemAddRequest [text=" + text + "]";
	}
}
