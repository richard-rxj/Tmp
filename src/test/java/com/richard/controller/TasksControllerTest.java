package com.richard.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.richard.model.BalanceTestResult;
import com.richard.service.TaskService;
import com.richard.service.ValidationService;

/**
 * @author Richard
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = TasksController.class)
public class TasksControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private TaskService taskService;

	@MockBean
	private ValidationService validationService;

	BalanceTestResult mockResult = new BalanceTestResult("()", true);

	@Test
	public void validateBracketsTest() throws Exception {
		Mockito.when(validationService.validateInputString(Mockito.anyString())).thenReturn(null);

		Mockito.when(taskService.validateBrackets(Mockito.anyString())).thenReturn(mockResult);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/test/1.0/tasks/validateBrackets/()")
				.accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(requestBuilder).andExpect(status().isOk()).andExpect(jsonPath("$.input", is("()")))
				.andExpect(jsonPath("$.isBalanced", is(true)));

	}
}
