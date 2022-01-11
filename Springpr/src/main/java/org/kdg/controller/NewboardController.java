package org.kdg.controller;

import org.kdg.domain.NewboardDTO;
import org.kdg.service.NewboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	//게시판 글쓰기 화면으로...
	@GetMapping("write")
	public void write() {
	}
	
	//게시판 글쓰기 버튼을 클릭하면...
	@PostMapping("write")
	public String writePost(NewboardDTO board) {
		newboard.newWrite(board);
		return "redirect:/newboard/list";
	}
	
	//게시판 상세 페이지 화면으로(목록 리스트에서 제목을 클릭하면)...
	@GetMapping("detail")
	public void detail(NewboardDTO board, Model model) {
		model.addAttribute("detail", newboard.newDetail(board));
	}
	
}
