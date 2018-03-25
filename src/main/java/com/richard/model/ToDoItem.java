/**
 * 
 */
package com.richard.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Richard
 * @version 1.0
 */
public class ToDoItem {
	private static final AtomicInteger count = new AtomicInteger(0);
	private static final DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
	static {
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
	}

	private final int id;

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

	public int getId() {
		return id;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	private String text;
	private Boolean isCompleted;
	private final String createdAt;

	public ToDoItem(String text) {
		this.id = count.incrementAndGet();
		this.text = text;
		this.isCompleted = false;
		this.createdAt = sdf.format(new Date());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + id;
		result = prime * result + ((isCompleted == null) ? 0 : isCompleted.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ToDoItem other = (ToDoItem) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", text=" + text + ", isCompleted=" + isCompleted + ", createdAt=" + createdAt + "]";
	}

}
