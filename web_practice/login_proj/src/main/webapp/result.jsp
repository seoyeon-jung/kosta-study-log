<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 결과</title>
</head>
<body>
	<h1>${loginResult ? "로그인 성공" : "로그인 실패"}</h1>
	<c:choose>
		<c:when test="${loginResult }">
			<p>로그인 성공</p>
		</c:when>
		<c:otherwise>
			<p>로그인 실패</p>
			<a href="javascript:history.back()">뒤로 가기</a>
		</c:otherwise>
	</c:choose>
</body>
</html>