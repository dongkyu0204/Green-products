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
	
	
	
	
	
	
	var formObj = $("form[role='form']");
	// 글쓰기 버튼을 클릭하면
	$("input[type='submit']").on("click", function(e) {
//		e.preventDefault();
		var str="";
		// li태그에 있는 data선택자를 이용하여 input태그의 value값으로 세팅
		$("#uploadResult ul li").each(function(i,obj){
			console.log(obj);
			// data 선택자들을 이용하여 input 태그의 value 값으로 세팅
			/*
			 * 
			 * data함수
			 * <span>
			 * $("span").data("age",13) => <span data-age="13"> data함수 괄호 안에 매개변수가 두 개면 setter
			 * <span data-age="13">
			 * $("span").data("age") => 13 data함수 괄호 안에 매개변수가 하나면 getter
			 * 
			 * */
			str+="<input type='hidden' name='attachList["+i+"].fileName' value='"+$(obj).data("filename")+"'>"
	        str+="<input type='hidden' name='attachList["+i+"].uuid' value='"+$(obj).data("uuid")+"'>"
	        str+="<input type='hidden' name='attachList["+i+"].uploadPath' value='"+$(obj).data("path")+"'>"
	        str+="<input type='hidden' name='attachList["+i+"].image' value='"+$(obj).data("type")+"'>"

			
		})
		formObj.append(str).submit();	//aaa.html()과 달리 append는 덮어쓰기가 아니라 추가를 해줌
									//.submit은 'append함과 동시에 submit을 해라'라는 의미
	})
	
	
	
	
	
	
	
	
	
	
	
	
	// 파일의 내용이 변경되면
	$("input[type='file']").on("change", function(e) {
		alert("aaa");
		// 가상의 form태그
		var formData = new FormData();
		var inputFile = $("input[name='uploadFile']");
		var files = inputFile[0].files; // [0]이 있는 이유는 multiply 속성 때문이 아닐까?!
		
//		console.log(files);
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
			url:"/uploadAjaxAction",
			type:"post",
			data:formData,	// 위의 formData에 모든 정보가 저장되어 있음
			processData : false,
			contentType:false,
			success:function(result){	// 사용자가 선택한 파일을 원하는 경로에 성공적으로 업로드 한 후...
//				alert("upload 성공");
//				console.log(result[0].fileName);
//				console.log(result[1].fileName);
//				console.log(result[2].fileName);
				showUploadFile(result);
			}
		}) // $.ajax 끝
		
	})
	
}) // $(document.ready(function()){ 끝

// 사용자가 선택한 파일을 원하는 경로에 성공적으로 업로드 한 후, 이 파일들을 띄우는 것에 대한 함수 선언(showUploadFile)
function showUploadFile(uploadresultArr){
	var str="";
	$(uploadresultArr).each(function(i,obj){ //each : jquery의 향상된 for문(배열에서만 사용 가능)
											// i : index번호, obj : 각 인덱스의 value
		console.log(obj);
		if(!obj.image) {	// 사용자가 업로드 한 파일의 이미지가 아니면 (exl, ppt 등) -> obj안에 image가 boolean 타입으로 나와있음
			// 해당 파일을 download 할 수 있도록 설정할 거임
			var fileCallPath = encodeURIComponent(obj.uploadPath+"/"+obj.uuid+"_"+obj.fileName);
			str+="<li data-path='"+obj.uploadPath+"'";
			str+=" data-uuid='"+obj.uuid+"' data-filename='"+obj.fileName+"' data-type='"+obj.image+"'>";
			str+="<a href='/download?fileName="+fileCallPath+"'>"+obj.fileName+"</a></li>";
		} else {	// 사용자가 업로드 한 파일의 타입이 이미지면 (png, jpg, gif)
			
			// 기존에는 경로 사이가 \로 표시되기에 해당 src로 찾아가지 못함
			// 아래 함수는 원화 표시를 /로 바꿔줌
			// 더불어 아래의 /display?fileName을 encode 안에 넣게되면 / 또한 해석을 하기 때문에 정상적으로 작동하지 않음
			var fileCallPath = encodeURIComponent(obj.uploadPath+"/s_"+obj.uuid+"_"+obj.fileName);
			
			//img 태그를 사용하여 웹브라우저에 출력
			str+="<li data-path='"+obj.uploadPath+"'";
			str+=" data-uuid='"+obj.uuid+"' data-filename='"+obj.fileName+"' data-type='"+obj.image+"'>";
			str+="<img src='/display?fileName="+fileCallPath+"'></li>";
		}
		
		
		
	})	
	$("#uploadResult ul").html(str);
}







