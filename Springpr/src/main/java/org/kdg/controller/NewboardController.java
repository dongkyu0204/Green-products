package org.kdg.controller;

import org.kdg.service.NewboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("newboard")
public class NewboardController {
	@Autowired
	private NewboardService newboard;
	
	//게시판 목록 리스트...
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void create(Model model) {
		model.addAttribute("list", newboard.newlist());
	}
	
	//게시판 글쓰기...
	@GetMapping("write")
	public void write() {
		
	}
}
