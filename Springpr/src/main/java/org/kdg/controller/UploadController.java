package org.kdg.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	@GetMapping("upload")
	public void uploadForm() {
		System.out.println("파일 업로드 화면입니다.");
	}
	
	@GetMapping("uploadAjax")
	public void uploadAjaxForm() {
		System.out.println("파일 업로드 두 번째 화면입니다");
	}
	
	//upload.jsp에서 form태그를 이용한 파일 업로드
	@PostMapping("uploadAction")
	// 이미 환경설정을 하며 file-upload 라이브러리가 추가되었기 때문에
	// 따로 DTO를 만들지 않아도 됨!! 
	public void uploadAction(MultipartFile[] uploadFile) {
		
		// 파일 업로드 할 경로 지정 
		String uploadFolder = "D:\\01-STUDY\\upload";
		
		for (MultipartFile multipartFile : uploadFile) {
			// 사용자가 업로드 한 실제 파일 이름
			System.out.println("업로드 파일 이름 = " + multipartFile.getOriginalFilename());
			// 사용자가 업로드 한 실제 파일의 크기
			System.out.println("업로드 파일 크기 = " + multipartFile.getSize());
			// 사용자가 업로드 한 실제 파일의 형식
			System.out.println("업로드 파일 형식 = " + multipartFile.getContentType());
			
			// File : java의 파일 입출력 클래스
			// uploadFolder에 저장되어 있는 경로로 실제 파일명으로 저장
			File saveFile = new File(uploadFolder,multipartFile.getOriginalFilename());
			
			// transferTo : 지정한 폴더에 업로드 시켜줌 (사용하기 위해서는 반드시 예외처리가 필요함)
			try {
				multipartFile.transferTo(saveFile);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // end try
			
		} // for문 end
	}
	
	//uploadAjax.jsp에서 ajax를 이용한 파일 업로드
	@PostMapping("uploadAjaxAction")
	public void uploadAjaxAction(MultipartFile[] uploadFile) {
		
		// 파일 업로드 할 경로 지정 
		String uploadFolder = "D:\\01-STUDY\\upload";
		
		// 이미 환경설정을 하며 file-upload 라이브러리가 추가되었기 때문에
		// 따로 DTO를 만들지 않아도 됨!! 
		for (MultipartFile multipartFile : uploadFile) {
			// 사용자가 업로드 한 실제 파일 이름
			System.out.println("업로드 파일 이름 = " + multipartFile.getOriginalFilename());
			// 사용자가 업로드 한 실제 파일의 크기
			System.out.println("업로드 파일 크기 = " + multipartFile.getSize());
			// 사용자가 업로드 한 실제 파일의 형식
			System.out.println("업로드 파일 형식 = " + multipartFile.getContentType());
			
			// File : java의 파일 입출력 클래스
			// uploadFolder에 저장되어 있는 경로로 실제 파일명으로 저장
			File saveFile = new File(uploadFolder,multipartFile.getOriginalFilename());
			
			// transferTo : 지정한 폴더에 업로드 시켜줌 (사용하기 위해서는 반드시 예외처리가 필요함)
			try {
				multipartFile.transferTo(saveFile);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // end try
			
		} // for문 end
	}
	
	
}














