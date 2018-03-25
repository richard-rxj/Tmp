/**
 * 
 */
package com.richard.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.richard.model.ToDoItem;

/**
 * @author Richard
 * @version 1.0
 */
@Service("toDoItemService")
public class ToDoItemServiceImp1 implements ToDoItemService {

	private static final AtomicLong counter = new AtomicLong();

	private static List<ToDoItem> toDoItems = new ArrayList<ToDoItem>();

	@Override
	public ToDoItem findItemById(int id) {
		for (ToDoItem item : toDoItems) {
			if (item.getId() == id) {
				return item;
			}
		}
		return null;
	}

	@Override
	public void saveItem(ToDoItem item) {
		toDoItems.add(item);
	}

	@Override
	public boolean isItemExist(ToDoItem item) {
		return findItemById(item.getId()) != null;
	}

	@Override
	public List<ToDoItem> findAllItems() {
		return toDoItems;
	}

}
