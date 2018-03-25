/**
 * 
 */
package com.richard.model;

/**
 * @author Richard
 * @version 1.0
 */
public class ToDoItemUpdateRequest {

	private String text;
	private Boolean isCompleted;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Boolean getIsCompleted() {
		return isCompleted;
	}

	public void setIsCompleted(Boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	@Override
	public String toString() {
		return "ToDoItemUpdateRequest [text=" + text + ", isCompleted=" + isCompleted + "]";
	}

}
