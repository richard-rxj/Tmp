package com.richard.controller;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.richard.model.ToDoItem;
import com.richard.service.ToDoItemServiceImp1;

/**
 * @author Richard
 * @version 1.0
 */
public class ToDoItemServiceImp1Test {
	private ToDoItemServiceImp1 service;
	private List<ToDoItem> itemRepository;

	@Before
	public void prepare() {
		service = new ToDoItemServiceImp1();
		itemRepository = service.findAllItems();
	}

	@Test
	public void saveItemTest() {
		int existingItemsBeforeSave = itemRepository.size();
		ToDoItem item1 = new ToDoItem("test");
		service.saveItem(item1);
		assertEquals(itemRepository.size(), existingItemsBeforeSave + 1);
	}
}
