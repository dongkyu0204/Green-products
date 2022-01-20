package org.kdg.controller;

import org.kdg.domain.RestSampleDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController = @Controller + @ResponseBody( : view만을 전달하는 게 아니라 해당 data를 전달해줌!)
@RestController
@RequestMapping("sample")
public class NewRestSampleController {
	// 단순 문자열 반환
	@GetMapping(value="getTextN", produces="text/plain; charset=UTF-8")
	public String getText() {
		return "안녕하세요";
	}
	
	// 객체 반환
	@GetMapping(value="getSampleN", produces= {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
	public RestSampleDTO getSampleN() {
//		RestSampleDTO d = new RestSampleDTO();
//		return d;
		
		return new RestSampleDTO(100, "김", "동규");
		//localhost:8082/sample/getSample -> xml형식으로 보여줌
		//localhost:8082/sample/getSample.json -> json형식으로 보여줌
	}
	
	// ResponseEntity 타입 반환
	// 사용 이유 : V가 없기 때문에 data를 좀 더 상세히 전달하고자 할 때 사용
	// ex) HTTP 상태인 404 or 200 or 500 상태일 때 함께 전송하는 data를 다르게 설정
	@GetMapping(value="checkN")
	public ResponseEntity<RestSampleDTO> checkN(int mno, String firstName, String lastName) {
		RestSampleDTO rsdto = new RestSampleDTO(mno, firstName, lastName);
		RestSampleDTO rdto = new RestSampleDTO(0, "ff", "kk");
		
		ResponseEntity<RestSampleDTO> result = null;
		
		if(mno<150) {
			// 첫 번째와 두 번재 방법은 동일한 결과를 도출시킴
//			return new ResponseEntity<>(rsdto,HttpStatus.OK);
			result= ResponseEntity.status(HttpStatus.OK).body(rdto);
		} else {
//			return new ResponseEntity<>(rdto,HttpStatus.INTERNAL_SERVER_ERROR);
			result= ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(rsdto);
		}
		
		return result;
	}
	
	@PostMapping("N")
	public RestSampleDTO N(@RequestBody RestSampleDTO rsdto) {
		return rsdto;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
