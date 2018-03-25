/**
 * 
 */
package com.richard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * This controller shows the introduction info to the end user
 * 
 * @author Richard
 * @version 1.0
 */
@Controller
public class WelcomeController {

	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "To give some introduction info";
	}
}
