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
	
	// ResponeEntity타입 반환 (produces는 생략 가능, mno를 받아 RestSampleDTO에 저장할 거임)
	@GetMapping(value="check")
	public ResponseEntity<RestSampleDTO> check(int mno, String firstName, String lastName){
		// 사용자로부터 매니저 번호(mno)를 받아,
		RestSampleDTO rsdto = new RestSampleDTO(mno, firstName, lastName);
		ResponseEntity<RestSampleDTO> result=null;
		// 매니저 번호가 150 미만이면
		if (mno<150) {
			// 비정상으로 처리(ResponseEntity) - status가 502 : Bad_GATEWAY
			result=ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(rsdto);
			//rsdto를 바디에 넣어서 ~한 상태를 responsentity 타입으로 반환하라(?)
		} else {// 그렇지 않으면
			// 정상으로 처리(ResponseEntity) - status가 200 : OK
			result=ResponseEntity.status(HttpStatus.OK).body(rsdto);
		}
		return result;	
	}
	// 메소드의 매개변수
	
	// 객체 타입을 매개변수로 지정해야 하는 경우에는 @RequestBody를 사용해야 함! - 일반적인 controller는 상관 없었음
	// post방식으로 처리하기에는 restcontroller는 화면이 없음
	// 이를 위한 도구들이 마련되어 있음 -> 크롬웹스토어에서 rest client를 검색하여 다운 받아야 함
	
	// JS로 작성된 데이터를 Java로 보내주는 것 -> 타입이 안 맞음
	// JS 타입을 Java로 변환해주는 녀석이 @RequestBody
	@PostMapping("mno")
	public RestSampleDTO mno(@RequestBody RestSampleDTO rsdto) {
		return rsdto;
	}
	
	
	
	
	
	
}
































