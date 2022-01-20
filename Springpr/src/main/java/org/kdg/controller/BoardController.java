package org.kdg.controller;

import java.util.ArrayList;

import org.kdg.domain.AttachFileDTO;
import org.kdg.domain.BoardDTO;
import org.kdg.domain.Criteria;
import org.kdg.domain.PageDTO;
import org.kdg.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String writePost(BoardDTO board) {	//AttachFileDTO를 BoardDTO에 추가하여 포함관계로 만들어줌
		System.out.println("write post...." + board);
		
		service.write(board);
		
		return "redirect:/board/list";
	}
	
	// 게시판 목록 리스트...
	@GetMapping("list")
	public void list(Model model, Criteria cri) {
		System.out.println("board/write");
		model.addAttribute("list", service.list(cri));
		int total = service.getTotalCount(cri);
		model.addAttribute("pageMaker", new PageDTO(cri,total));
	}
	
	// 게시판 목록 리스트에서 제목을 클릭하면...
	@GetMapping("detail")
	public void detail(BoardDTO board, Model model) {
		model.addAttribute("detail", service.detail(board));	
	}
	
	
	
	
	
	
	// 게시판 상세 페이지에서 이미지를 출력하기 위해 select된 결과를 javascript로...
	@GetMapping(value="fileList/{bno}", produces= {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<ArrayList<AttachFileDTO>> fileList(@PathVariable int bno) {
		System.out.println("AAA");
		return new ResponseEntity<> (service.fileList(bno),HttpStatus.OK);
	}
	
	
	
	
	
	
	// 글쓰기 수정 화면으로...
	@GetMapping("modify")
	public void modify(BoardDTO board, Model model) {
		model.addAttribute("detail", service.detail(board));
		System.out.println("board/modify");
	}
	
	// 글수정 버튼을 클릭하면...
	@PostMapping("modify")
	public String modifyPost(BoardDTO board, RedirectAttributes rttr) {
		System.out.println(board);
		//update
		service.modify(board);
		rttr.addAttribute("bno", board.getBno());
		return "redirect:/board/detail";
	}
	
	// 글 삭제 버튼을 클릭하면...
	@GetMapping("remove")
	public String remove(BoardDTO board) {
		System.out.println(board);
		service.remove(board);
		return "redirect:/board/list";
	}
}
























