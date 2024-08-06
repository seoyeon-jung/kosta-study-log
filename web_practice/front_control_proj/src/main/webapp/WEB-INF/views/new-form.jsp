<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 추가</title>
</head>
<body>
	<h1>NEW-FROM</h1>
	<form action="/front/member/save" method="get">
		<input type="text" name="name" /> <br /> 
		<input type="number" name="age" />
		<button>입력</button>
	</form>
</body>
</html>