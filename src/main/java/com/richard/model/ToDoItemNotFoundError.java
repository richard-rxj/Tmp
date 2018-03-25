package com.richard.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Richard
 * @version 1.0
 */
public class ToDoItemNotFoundError {
	private final String name;

	public String getName() {
		return name;
	}

	public List<Map<String, String>> getDetails() {
		return details;
	}

	private final List<Map<String, String>> details;

	public ToDoItemNotFoundError(String msg) {
		this.name = "NotFoundError";
		details = new ArrayList<Map<String, String>>();
		Map<String, String> detail = new HashMap<String, String>();
		detail.put("message", msg);
		this.details.add(detail);
	}
}
