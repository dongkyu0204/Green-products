$(document).ready(function(){
	
	// 파일의 크기와 확장자를 검사하는 함수 선언
	
	// 서버에서 설정한 파일 크기
	var maxSize=5242880; //5MB
	// 서버에서 설정한 파일 확장자(정규식-정해놓은 규칙을 식으로 만든 것)와 비교
	// 정규식 : id는 몇자 이상, pw는 특수문자가 포함되어야 한다 등 규칙
	var regex= new RegExp("(.*?)\.(exe|sh|zip|alz)$");
	// . 뒤에 있는 애들 중 하나가 들어 있으면 true 없으면 false
	
	function checkExtension(fileSize, fileName) {
		// 사용자가 선택한 파일의 크기가 서버에서 설정한 파일보다 크거나 같으면
		if(fileSize >= maxSize) {
			alert("파일 사이즈 초과");
			return false;
		}
		// 사용자가 선택한 파일의 확장자가 서버에서 설정한 파일과 일치하면
		if(regex.test(fileName)){	//regex에서 fileName을 테스트 하는 것
			alert("해당 종류의 파일은 업로드 할 수 없습니다.");
			return false;
		}
		return true;
	}
	
	
	
	
	
	
	
	$("input[type='submit']").on("click", function() {
		alert("aaa");
		// 가상의 form태그
		var formData = new FormData();
		var inputFile = $("input[name='uploadFile']");
		var files = inputFile[0].files; // [0]이 있는 이유는 multiply 속성 때문이 아닐까?!
		
		console.log(files);
		// append : 뒤족에 추가
		for(var i=0; i<files.length; i++) {
			// 파일의 크기가 설정 크기의 이상이면
			if(!checkExtension(files[i].size, files[i].name)){
				// 아래 코드 실행하지 마라
				return false;
			}
			formData.append("uploadFile",files[i]);
			// "uploadFile"과 위의 input name 값(uploadFile)은 같아야 함
		}
		
		// ajax를 이용해서 C와 연결
		// formData 자체를 데이터로 전송하고, 
		// formData를 데이터로 전송할 때는
		// processData와 contentType은 반드시 false여야 함
		$.ajax({
			url:"uploadAjaxAction",
			type:"post",
			data:formData,	// 위의 formData에 모든 정보가 저장되어 있음
			processData : false,
			contentType:false,
			success:function(result){
				alert("upload 성공")
			}
		})
		
	})
})