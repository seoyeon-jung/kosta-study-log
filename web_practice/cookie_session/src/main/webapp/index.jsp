<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키, 세션 가져오기</title>
</head>
<body>
	<%
		Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for(Cookie cookie:cookies) {
			out.print("쿠키 이름 : "+cookie.getName()+"<br>");
			out.print("쿠키 값 : "+cookie.getValue()+"<br>");
			out.print("----------------------------------"+"<br>");
		}}
		
		out.print("세션 값 : "+ (String) session.getAttribute("session")+"<br>");
	%>
</body>
</html>