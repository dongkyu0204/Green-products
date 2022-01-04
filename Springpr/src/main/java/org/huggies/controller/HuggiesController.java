package org.huggies.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HuggiesController { 
	@RequestMapping(value = "board/board_list_page", method = RequestMethod.GET)
	public void board_list_page() {
		 
	}
}
