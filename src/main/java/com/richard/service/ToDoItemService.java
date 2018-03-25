/**
 * 
 */
package com.richard.service;

import java.util.List;

import com.richard.model.ToDoItem;

/**
 * This interface handles the ToDoItem data manipulation
 * 
 * @author Richard
 * @version 1.0
 */
public interface ToDoItemService {
	ToDoItem findItemById(int id);

	void saveItem(ToDoItem item);

	boolean isItemExist(ToDoItem item);

	List<ToDoItem> findAllItems();
}
