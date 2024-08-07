<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" 
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" 
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>뉴스 보기</title>
</head>
<body>
	<div class="container mt-5 mx-auto">
		<h2 class="text-center mb-4">${news.getTitle()}</h2>
		<hr/>
		
		<div class="card mx-auto">
			<img src="/img/${news.getImg()}" alt="뉴스 이미지" />
			<div class="card-body">
				<h5 class="card-title">보도일자 : ${news.getDate()}</h5>
				<p class="card-text">${news.getContent()}</p>
			</div>
		</div>
		<hr/>
		
		<a href="javascript:history.back()" class="btn btn-primary">뒤로 가기</a>
		
		<!-- 기사 수정하기 -->
		<button
			class="btn btn-outline-success collapse-button"
			data-bs-toggle="collapse" data-bs-target="#modifyForm"
			aria-expanded="false" aria-controls="modifyForm">
			기사 수정	
		</button>
		
		<div class="collapse" id="modifyForm">
			<div class="card card-body">
				<form
					action="/news/newsView?action=modifyNews"
					method="post"
					enctype="multipart/form-data"
				>
					<input type='hidden' name="id" value="${news.getId()}" />
					<label for="title" class="form-label">제목</label>
					<input id="title" name="title" class="form-control" value="${news.getTitle()}" required />
					
					<label for="img" class="form-label">이미지</label>
					<input id="img" name="img" class="form-control" type="file" />
					
					<label for="content" class="form-label">기사 내용</label>
					<textarea id="content" name="content" class="form-control" rows="5" cols="50" required>${news.getContent()}</textarea>
					
					<button class="btn btn-success mt-3">저장</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>