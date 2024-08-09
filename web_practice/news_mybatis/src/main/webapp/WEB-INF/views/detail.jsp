<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>뉴스 상세 보기</title>
</head>
<body>
	<div class="container mt-5 mx-auto">
		<h2 class="text-center mb-4">${news.title}</h2>
		<hr />
		<div class="card mx-auto">
			<img src="/img/${news.img}" alt="뉴스 이미지" />
			<div class="card-body">
				<h4 class="card-title">보도일자 : ${news.date}</h4>
				<p class="card-text">내용 : ${news.content}</p>
			</div>
		</div>
		<div class="card-footer">
			<a href="/news/edit?id=${news.id}" class="btn btn-outline-secondary">수정하기</a>
		</div>
		<hr />
		<a href="/news" class="btn btn-primary">👈 뒤로 가기</a>
	</div>	
</body>
</html>