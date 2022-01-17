<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	
	<body>
		<!-- form 태그에 동봉되는 파일이 단순 문자가 아니란 걸 알려줘야 함 -> enctype -->
		<!-- enctype(인코딩 타입)="multipart/form-data" -->
		<!-- 파일 업로드나 이미지 업로드를 서버로 전송할 때 사용 -->
		<form action="uploadAction" method="post" enctype="multipart/form-data">
			<input type="file" name="uploadFile" multiple>
			<input type="submit" value="전송">
		</form>
	</body>
</html>