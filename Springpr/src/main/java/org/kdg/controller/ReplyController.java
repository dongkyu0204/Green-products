package org.kdg.controller;

import org.kdg.domain.ReplyDTO;
import org.kdg.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("replies")
public class ReplyController {
	@Autowired
	private ReplyService rservice;
	// 댓글 쓰기를 하기 위한  RequestMapping
	// consumes : 들어오는 데이터 타입 정의(생략 가능)
	// produces : 반환하는 데이터 타입 정의(생략 가능)
	// * 생략을 하게 되면, 웹브라우저가 자체적으로 타입을 판단 *
	// * 생략 하지 않는 이유 : Mapping을 할 때 우리가 원하는 데이터 타입을 강제 설정함으로써 오류를 방지하기 위해 *	
	
	@PostMapping(value="new", consumes="application/json", produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> create(@RequestBody ReplyDTO rdto){ //requestBody : js의 reply를 받을 수 있도록 도와줌
		System.out.println("rdto"+rdto);
		rservice.write(rdto);
		return null;
	}
}
