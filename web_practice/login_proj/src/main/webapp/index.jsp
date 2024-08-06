<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
</head>
<body>
	<h1>로그인 폼</h1>

	<c:choose>
		<c:when test="${sessionScope.loginedUser != null}">
			<!-- 로그인 상태 -->
			<p>${sessionScope.loginedUser}님 어서오세요!</p>
			<form action="login" method="post">
				<input type="hidden" name="action" value="logout" /> 
				<input type="submit" value="로그아웃" />
			</form>
		</c:when>
		<c:otherwise>
			<!-- 로그인 안한 상태 -->
			<form action="login" method="post">
				아이디 : <input type="text" name="userId" /> <br /> 
				비밀번호 : <input type="password" name="userPW" /> <br />
				<input type="submit" value="로그인" />
			</form>
		</c:otherwise>
	</c:choose>
	
	<p style="color:red">${error}</p>

</body>
</html>