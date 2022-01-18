package org.kdg.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import org.kdg.domain.AttachFileDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import net.coobird.thumbnailator.Thumbnailator;

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
	
	
	
	
	
	
	
	
	
	// 년/월/일 이름의 폴더를 생성하기 위한 메소드 선언
	private String getFolder() { 	// 자바는 날짜 형식이 없기에 String타입
		// 현재 날짜를 추출 (Tue Jan 18 09:34:09 KST 2022)
		Date date = new Date();
		// Tue Jan 18 09:34:09 KST 2022 -> 2022-01-18(yyyy-mm-dd 형식으로 변경)
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // M : Month, m : minute
		// 2022-01-18 -> 2022\01\18 로 바꿔줘야 함(폴더 경로 확인!- 원화)
		String str = sdf.format(date);
		
		
		// 			2022-01-18 -> 2022\01\18
		return str.replace("-", File.separator); //File.separator : 원화표시
	}
	
	// 썸네일 이미지 생성을 할 건 지 안 할 것인지 판단하는 메소드 선언 (사용자가 업로드 한 파일이 이미지면 생성, 그렇지 않으면 생성X)
	private boolean checkImage(File file) {
		try {
			// 파일의 타입을 알아내는 probeContentType 메소드를 호출해서 사용
			String contentType = Files.probeContentType(file.toPath());
			// 그 파일의 타입이 image이면 true, 그렇지 않으면 false
			return contentType.startsWith("image");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return false;
	}
	
	
	
	
	
	
	
	
	//uploadAjax.jsp에서 ajax를 이용한 파일 업로드
	@PostMapping(value = "uploadAjaxAction", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ArrayList<AttachFileDTO>> uploadAjaxAction(MultipartFile[] uploadFile) {
		//AttachFileDTO에 저장되는 값이 여러 파일에 대한 값이면 배열로 처리가 되어야 하므로 ArrayList타입이 되어야 함 
		ArrayList<AttachFileDTO> list = new ArrayList<>();
		
		
		
		// 파일 업로드 할 경로 지정 
		String uploadFolder = "D:\\01-STUDY\\upload";
		
		
		// 폴더 생성				  (기존 폴더의 경로에 현재 폴더의 경로를 합쳐줌)
		File uploadPath = new File(uploadFolder,getFolder());
		
		// DTO의 uploadPath에 경로를 저장하기 위한 변수 선언
		String uploadFolderPath = getFolder();
		
		
		System.out.println("uploadPath = " + uploadPath);
		
		// 만드려는 폴더가 없으면
		if (uploadPath.exists()==false) {
			// 폴더 생성
			uploadPath.mkdirs(); 	// mkdirs(make directory) : 폴더를 생성하라는 메소드
		}
		
		
		
		
		// 이미 환경설정을 하며 file-upload 라이브러리가 추가되었기 때문에
		// 따로 DTO를 만들지 않아도 됨!! 
		for (MultipartFile multipartFile : uploadFile) {
			// UploadController에 있는 uploadAjaxAction메소드에서 AttachFileDTO를 사용하여 값을 저장해야 하는데,
			// 이러한 경우 C에 AttachFileDTO 모델이 없으면 사용할 수가 없음
			// 따라서 new를 이용하여 포함관계를 만들어 줌
			AttachFileDTO attachdto = new AttachFileDTO();
			
			// 사용자가 업로드 한 실제 파일 이름
			System.out.println("업로드 파일 이름 = " + multipartFile.getOriginalFilename());
			// 사용자가 업로드 한 실제 파일의 크기
			System.out.println("업로드 파일 크기 = " + multipartFile.getSize());
			// 사용자가 업로드 한 실제 파일의 형식
			System.out.println("업로드 파일 형식 = " + multipartFile.getContentType());
			
			// 실제 파일명 저장
			String uploadFileName = multipartFile.getOriginalFilename();
			
			
			// DTO의 filename에 실제 파일명(uploadFileName)을 저장
			attachdto.setFileName(uploadFileName);
			
			
			
			// 중복이 발생하지 않는 임의의 문자열 생성
			UUID uuid = UUID.randomUUID();	// 이 친구는 new 없이 호출 했으므로 인스턴스 메소드가 아닌 class 메소드임!
			// UUID + "_" + getOriginalFilename() 의 조합으로 파일명을 생성하여 uploadFileName에 저장
			uploadFileName=uuid.toString()+"_"+uploadFileName;	// 기존 uploadFileName에 덮어쓰기
			
			// File : java의 파일 입출력 클래스 -> 특정 경로의 파일에 접근하고 싶을때 사용
			// uploadFolder(uploadpath)에 저장되어 있는 경로로 실제 파일명으로 저장
			File saveFile = new File(uploadPath, uploadFileName);
			
			try {
				// transferTo : 지정한 폴더에 업로드 시켜줌 (사용하기 위해서는 반드시 예외처리가 필요함)
				// saveFile 변수에 저장되어 있는 폴더명으로 파일을 보냄
				multipartFile.transferTo(saveFile);
				
				// DTO의 uploadPath에 경로를 저장 (upload를 사용하지 않고 getFolder()를 사용하는 이유 : 날짜는 시간이 지남에 따라 바뀌지만 앞선 경로는 고정임!)
				attachdto.setUploadPath(uploadFolderPath);
				// DTO의 uuid에 값를 저장 (toString을 활용해 string 타입으로 변환)
				attachdto.setUuid(uuid.toString());
				
				
				// 이미지 파일이면
				if (checkImage(saveFile) == true) {
					// FileType값(image)을 DTO의 image에 저장
					attachdto.setImage(true);
					
					// 썸네일을 이미지를 만들기 전, 썸네일 파일을 생성
					FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath,"s_"+uploadFileName));
					// 썸네일 이미지 생성
					Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail, 100, 100);
				    // inputStream : 데이터가 들어오는 통로 (byte 단위로 들어옴)
					// outputStream : 데이터가 나가는 통로
					
					
					// 썸네일 종료(메모리 공간 환수)
					thumbnail.close();
				}
				list.add(attachdto);	// new attachdto가 for 바깥에 있었을 때는 
										// 하나의 주소에 덮어쓰기 됐으므로 아래의 list를 return 하고 console을 찍었을 떄
										// 5만 표시된 것 
										// 즉 서로 다른 값의 데이터를 list에 추가시켜도 기존의 추가시켰던 데이터와
										// 주소가 같으므로 값이 동일하게 바뀌어야 함
				System.out.println(attachdto);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // end try
			
			
			
		} // for문 end
		
		// 통신상태가 정상적(HttpStatus.OK)이면 ArrayList(list)에 저장되어 있는 값을 웹브라우저(uploadAjax.js의 ajax로)에 넘겨라
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	
}














