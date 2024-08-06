<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
</head>
<body>
	<h1>회원 목록</h1>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>이메일</th>
		</tr>
		<c:forEach var="u" items="${userList}" varStatus="s">
			<tr>
				<td>${s.count}</td>
				<td>${u.getName()}</td>
				<td>${u.getEmail()}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="index.jsp"> << HOME</a>
</body>
</html>