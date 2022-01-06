package org.kdg.controller;

import org.kdg.domain.BoardDTO;
import org.kdg.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("board")
public class BoardController {
	
	@Autowired 
	// Autowired가 아래와 같이 인스턴스화를 시켜 포함관계를 만들어줌
	// private BoardService service = new BoardService();
	private BoardService service;
	
	// 글쓰기 화면으로...
	@GetMapping("write")
	public void write() {
		System.out.println("board/write");
	}
	
	// 글쓰기 버튼을 클릭하면...
	@PostMapping("write")
	public String writePost(BoardDTO board) {
		service.write(board);
		System.out.println("write post...." + board);
		return "redirect:/board/list";
	}
	
	// 게시판 목록 리스트...
	@GetMapping("list")
	public void list(Model model) {
		service.list();
		System.out.println("board/write");
		model.addAttribute("list", service.list());
	}
	
	// 게시판 목록 리스트에서 제목을 클릭하면...
	@GetMapping("detail")
	public void detail(BoardDTO board, Model model) {
		model.addAttribute("detail", service.detail(board));
		
	}
	
}
