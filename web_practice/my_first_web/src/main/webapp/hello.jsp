<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDateTime" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>첫 웹 프로젝트</title>
</head>
<body>
	<h1>Hello World!!</h1>
	<hr>
	<p>
		현재 날짜와 시간은 <%=LocalDateTime.now() %> 입니다!
	</p>
</body>
</html>