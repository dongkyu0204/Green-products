<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp" %>
	<p>index.jsp입니다</p>
	<a href="/sample/member?id=abcd&pw=1234&name=정자바">회원가입</a>
	<form action="/sample/memberDTO" method="post">
	<!-- form 태그의 변수명은 name 속성과 같음 -->
	<!-- 즉 자바의 String id, String pw, String name과 같음!!! -->
	
	<!-- 자바의 id="abcd", pw="1234", name="정자바"는 어떻게 하느냐?! -> value를 활용!!! -->
		<div>id : <input type="text" name="id"></div>
		<div>pw : <input type="password" name="pw"></div>
		<div>name:<input type="text" name="name"></div>
		<input type="submit" value="회원가입">
	</form>
	${yyyy}
</body> 
</html>