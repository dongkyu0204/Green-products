package org.kdg.controller;

import javax.servlet.http.HttpSession;

import org.kdg.domain.MemberDTO;
import org.kdg.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("member")
public class MemberController {
	
	@Autowired
	private MemberService mservice;
	
	// 회원가입 화면으로 이동
	@GetMapping("member")
	public void member() {
		System.out.println("member");
	}
	
	// 회원가입 insert
	@PostMapping("member")
	public void Postmember(MemberDTO mdto) {
		mservice.insert(mdto);
		System.out.println("Postmember");
	}
	
	// 로그인 화면으로 이동
	@GetMapping("login")
	public void login() {
		System.out.println("login");
	}
	
	// 로그인 select
	@PostMapping("login")
	public String Postlogin(MemberDTO mdto, HttpSession session) {
		MemberDTO login = mservice.login(mdto);
		
		// MemberDTO에 있는 MemberDTO [id=1234, password=12, name=김동규]를 세션 영역에 login이라는 변수에 저장
		// sesseion을 사용한다는 것을 컨트롤러에게 알려줌 -> Model을 사용하기 위해 매개변수에 넣어준 것과 같음
		// 세션객체(session)에 login 변수에, login값을 저장(setAttribute)
		session.setAttribute("login", login);
		
		// session.invalidate(); // 세션을 초기화 하겠다는 메소드 -> 로그아웃
		
		
		// session 역역에 login이라는 변수에 값이 있으면 로그인 된 채로
		if (session.getAttribute("login")!=null) { 
			// 메인 페이지로 이동
			return "redirect:/";
		} else { // session 역역에 login이라는 변수에 값이 없으면 (null)
			// 다시 로그인 할 수 있게 로그인 페이지로 이동
			return "redirect:/member/login";
		}
		
		
	}
	
	
	
	
	
}

