<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<title>${ empty news ? '뉴스 기사 작성' : '뉴스 기사 수정' }</title>
</head>
<body>
	<div class="container w-75 mt-5 mx-auto">
		<h2 class="text-center mb-4">${ empty news ? '뉴스 기사 작성' : '뉴스 기사 수정' }</h2>
		<hr />
		
		<div>
			<div class="card card-body">
				<form
					action=${ empty news ? '/news/add' : '/news/edit' }
					method="post"
					enctype="multipart/form-data"
				>
					<label for="title" class="form-label">제목</label>
					<input id="title" name="title" class="form-control" value="${news.title}" required />
					
					<label for="img" class="form-label">이미지</label>
					<input id="img" name="img" class="form-contro" type="file"
						<c:if test="${empty news}">required</c:if>
					/>
					<c:if test='${not empty news}'>
						<div>
							<input type="hidden" name="id" value="${news.id }"/>
							<img src="/img/${news.img}" alt="기사 이미지" width=150 />
						</div>
					</c:if> 
					
					<label for="content" class="form-label">기사 내용</label>
					<textarea id="content" name="content" class="form-control" rows="5" cols="50" required>
						${news.content}
					</textarea>
					
					<button class="btn btn-success mt-3">${ empty news ? '저장' : '수정' }</button>
				</form>
			</div>
		</div>
		
		
		<c:if test="${error != null}">
			<div class="alert alert-danger alert-dismissible fade show mt-3" role="alert">
				에러 발생 : ${error}
				<button class="btn-close" data-bs-dismiss="alert"></button>
			</div>
		</c:if>
		
	</div>
</body>
</html>