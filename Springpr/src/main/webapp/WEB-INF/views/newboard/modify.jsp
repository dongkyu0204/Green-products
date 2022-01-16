<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>수정하기</title>
		
		<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
		<link href="../resources/css/newboard/all.css" rel="stylesheet" type="text/css">
	    <link href="../resources/css/newboard/sb-admin-2.css" rel="stylesheet">
	    <link href="../resources/css/newboard/dataTables.bootstrap4.css" rel="stylesheet">
	</head>
	
	<body>
		<h1>수정하기</h1>
		<form class="user" action="/newboard/modify" method="post">
	        <div class="form-group">
	            <input type="hide" name="bno" class="form-control form-control-user" id="exampleInputEmail" value="${detail.bno}">
	            <input type="text" name="title" class="form-control form-control-user" id="exampleInputEmail" value="${detail.title}">
	            <textarea rows="10" cols="30" name="content" class="form-control form-control-user" id="exampleInputEmail">${detail.content}</textarea>
	            <button>수정하기</button>
	        </div>
	    </form>
	</body>
</html>