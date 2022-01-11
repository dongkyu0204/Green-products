package org.kdg.controller;

import org.kdg.domain.RestSampleDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sample")
public class RestSampleController {
	// 단순 문자열 반환
	@GetMapping(value="getText", produces="text/plain; charset=UTF-8")
	public String getText() {
		
		return "안녕하세요.";	//Controller와 달리 return이 .jsp를 붙이는 용도가 아님
	}
	
	// 객체 반환
	@GetMapping(value="getSample", produces= {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
	public RestSampleDTO getSample() {
		// RestSampleDTO rs = new RestSampleDTO();
		// return rs;
		return new RestSampleDTO(100,"김","동규");
		
		//단순 문자열을 반환하라 했는데 자바 객체이기 때문에 오류 발생
		//MediaType을 활용해 웹에 뿌릴 때 어떤 타입으로 보여줄지 명시
		//localhost:8082/sample/getSample -> xml형식으로 보여줌
		//localhost:8082/sample/getSample.json -> json형식으로 보여줌
	}
}
