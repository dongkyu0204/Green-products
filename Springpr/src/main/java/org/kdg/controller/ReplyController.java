package org.kdg.controller;

import java.util.ArrayList;

import org.kdg.domain.ReplyDTO;
import org.kdg.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		// insert 성공 시 ReplyService.java로 부터 1,
		// insert 실패 시 ReplyService.java로 부터 0
		// 값을 리턴 받는다.
		int result = rservice.write(rdto);

		
		return result==1?new ResponseEntity<>("success",HttpStatus.OK) // insert가 정상적으로 처리되었을 때, success -> js의 result로!!
						:new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // insert가 비정상적으로 처리되었을 때
	}
	
	@GetMapping(value="list/{bno}",produces= {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<ArrayList<ReplyDTO>> getList(@PathVariable int bno){ // @PathVariable : REST 방식에서 주로 사용. URL 경로의 일부를 파라미터로 사용하고자 할 때 사용
		System.out.println(bno);												// ? 뒤의 쿼리 대신 /bno가 온다고 함
		return new ResponseEntity<>(rservice.list(bno),HttpStatus.OK);
	}
	
	// 댓글 수정을 하기 위해 댓글 내용 가져오기
	@GetMapping(value="{rno}", produces={MediaType.APPLICATION_JSON_UTF8_VALUE}) 
	public ResponseEntity<ReplyDTO> getDetail(@PathVariable int rno){ // @PathVariable : REST 방식에서 주로 사용. URL 경로의 일부를 파라미터로 사용하고자 할 때 사용
		System.out.println(rno);												// ? 뒤의 쿼리 대신 /bno가 온다고 함
		return new ResponseEntity<>(rservice.detail(rno),HttpStatus.OK);
	}

	
	
}















