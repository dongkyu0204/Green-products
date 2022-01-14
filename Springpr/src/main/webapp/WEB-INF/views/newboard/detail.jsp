<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>게시판 상세 페이지</title>
		
		<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
		<link href="../resources/css/newboard/all.css" rel="stylesheet" type="text/css">
	    <link href="../resources/css/newboard/sb-admin-2.css" rel="stylesheet">
	    <link href="../resources/css/newboard/dataTables.bootstrap4.css" rel="stylesheet">
	</head>
	
	<body>
		<div>${detail.title}</div>
		<div>${detail.content}</div>
		
		<a href="/newboard/modify?bno=${detail.bno}">수정</a>
		<a href="/newboard/remove?bno=${detail.bno}">삭제</a>
	</body>
</html>