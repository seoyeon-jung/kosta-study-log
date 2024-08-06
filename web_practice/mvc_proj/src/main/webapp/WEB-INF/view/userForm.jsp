<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 추가</title>
</head>
<body>
	<h1>회원 추가</h1>
	<form action="user" method="post">
		<label for="username">이름 : </label> 
		<input type="text" id="username" name="name" /> <br/>
		<label for="useremail">이메일 : </label> 
		<input type="text" id="useremail" name="email" /> <br/>
		<input type="submit" value="추가" />
	</form>
</body>
</html>