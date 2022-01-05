package org.kdg.controller;

import org.kdg.domain.SampleMemberDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("sample")
public class SampleController {
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	//@RequestMapping(value = "", method = RequestMethod.GET)
	@GetMapping("")
	public void basic(Model model) {
		logger.info("sample 실행됨.");
		// aaaa 문자열을 abcd변수에 저장하여 sample.jsp에 보내기
		model.addAttribute("abcd", "aaaa");
	}
	
	//@RequestMapping(value = "ex01", method = RequestMethod.GET)
	@GetMapping("ex01")
	public String basic1(Model model) {
		logger.info("sample 실행됨.");
		// bbbb 문자열을 zzzz변수에 저장하여 ex01.jsp에 보내기
		
		model.addAttribute("zzzz", "bbbb");
		return "ex01";
	}
	
	//@RequestMapping(value = "index", method = RequestMethod.GET)
	@GetMapping("index")
	public String index(Model model) {
		// cccc 문자열을 yyyy변수에 저장하여 index.jsp에 보내기
		model.addAttribute("yyyy", "cccc");
		return "index";		
	}
	
	//@RequestMapping(value = "sample/member", method=RequestMethod.GET)
	@GetMapping("member")
	public String member(String id, String pw, String name, Model model) {
		System.out.println("id="+id);
		System.out.println("pw="+pw);
		System.out.println("name="+name);
		
		// id값을 id 변수에 저장하여 member.jsp에 보내기
		// pw를 pw변수에 저장하여 member.jsp에 보내기
		// name값을 name변수에 저장하여 member.jsp에 보내기
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		model.addAttribute("name", name);
		
		return "member";
	}
	
	//@RequestMapping(value = "memberDTO", method=RequestMethod.GET)
	@PostMapping("memberDTO")
	public String memberdto(SampleMemberDTO smd, Model model) {
		System.out.println("id="+smd.getId());
		System.out.println("pw="+smd.getPw());
		System.out.println("name="+smd.getName());
	
		// SampleMemberDto값을 id 변수에 저장하여 index.jsp에 보내기(난이도 상)
		model.addAttribute("name", smd.getName());
		
		//return "memberDTO";
		//return "redirect:/";
		return "redirect:/sample/member";
	}
}





