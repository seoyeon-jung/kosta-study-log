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
<link href="${pageContext.request.contextPath}/style.css"
	rel="stylesheet">
<meta charset="UTF-8">
<title>영화 추가하기</title>
</head>
<body>

	
	<div class="section section-signup h-full" style="background-image: url('https://img.freepik.com/free-vector/elegant-retro-film-strip-design-black-background_1017-42670.jpg?t=st=1723096874~exp=1723100474~hmac=bb55c117342c292169d5e5c6d98571c3ea1e0cf2a49268d767508dcd18bbe7f3&w=1380')">
		<header class="header-container">
			<a href="/movie/movieList"
				class="btn btn-outline-secondary back-button d-flex justify-content-center align-items-center">
				← </a>
			<div class="header-title text-white">영화 추가하기</div>
		</header>

		<div class="container">
			<div class="row">
				<div class="card card-signup mb-4" style="background-color: #f2f2f2;">
					<form class="form" action="/movie/movieList?action=addMovie" method="post" enctype="multipart/form-data">
						<div class="form-floating">
							<input type="text" name="title" class="form-control mt-4 mb-4"
								id="floatingInput" placeholder="영화 제목" /> <label
								for="floatingInput">영화 제목</label>
						</div>
						<div class="form-floating">
							<textarea class="form-control mb-4" name="summary" rows="5" cols="50"
								id="floatingInput" placeholder="줄거리"></textarea>
							<label for="floatingInput">줄거리</label>
						</div>
						<div class="form-floating">
							<input type="text" name="genre" class="form-control mb-4"
								id="floatingInput" placeholder="장르" /> <label
								for="floatingInput">장르</label>
						</div>
						<div class="form-floating">
							<input type="text" name="director" class="form-control mb-4"
								id="floatingInput" placeholder="감독" /> <label
								for="floatingInput">감독</label>
						</div>
						<div class="form-floating">
							<input type="text" name="actors" class="form-control mb-4 p-2"
								id="floatingInput" placeholder="출연진" /> <label
								for="floatingInput">출연진</label>
						</div>
						<div class="form-floating">
							<input type="file" name="poster" class="form-control mb-4"
								id="floatingInput" /> <label
								for="floatingInput">포스터</label>
						</div>
						<div class="form-floating">
							<input type="date" name="release_date" class="form-control mb-4"
								id="floatingInput" placeholder="영화 개봉일" /> <label
								for="floatingInput">개봉일</label>
						</div>
						<div
							class="d-flex flex-wrap align-items-center justify-content-center py-3 mb-6 border-bottom fs-4">
							<button class="btn btn-outline-secondary mt-4 mb-4">영화 등록하기</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	
</body>
</html>