<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<link href="${pageContext.request.contextPath}/style.css" rel="stylesheet">
<meta charset="UTF-8">
<title>영화 정보</title>
</head>
<body>
	 <header class="header-container">
        <a href="/movie/movieList" class="btn btn-outline-secondary back-button d-flex justify-content-center align-items-center">
            ←
        </a>
        <div class="header-title">
            영화 정보
        </div>
    </header>

	<!-- 영화 정보 출력하기 -->
	<div class="container my-3 movie-container">
		<div class="movie-info p-3 d-flex justify-content-between">
			<!-- 포스터 영역 -->
			<div class="me-3">
				<img src="/img/${movie.getPoster()}" alt="poster" class="img-fluid" />
			</div>
			<!-- 영화 정보 영역 -->
			<div>
				<h2>${movie.getTitle()}</h2>
				<br />
				<p>
					<strong>간단 줄거리:</strong> ${movie.getSummary()}
				</p>
				<p>
					<strong>장르:</strong> ${movie.getGenre()}
				</p>
				<p>
					<strong>감독:</strong> ${movie.getDirector()}
				</p>
				<p>
					<strong>출연진:</strong> ${movie.getActors()}
				</p>
				<p>
					<strong>개봉일:</strong> ${movie.getRelease_date()}
				</p>
				<!-- 수정/삭제 버튼 영역 -->
				<div class="movie-buttons d-flex justify-content-between">
					<button class="btn btn-outline-warning collapse-button"
						data-bs-toggle="collapse" data-bs-target="#updateMovie"
						aria-expanded="false" aria-controls="updateMovie">
						수정
					</button>
					<a href="/movie/movieList?action=deleteMovie&id=${movie.getId()}">
						<button type="button" class="btn btn-sm btn-outline-danger">삭제</button>
					</a>
				</div>
			</div>
		</div>

	</div>
	

	<div class="collapse form-signin w-100 h-auto" id="updateMovie">
		<form action="/movie/movie?action=updateMovie&id=${movie.getId()}" method="post" enctype="multipart/form-data">
			<div class="form-floating">
				<input type="text" name="title" class="form-control" id="floatingInput" value="${movie.getTitle()}" />
				<label for="floatingInput">영화 제목</label>
			</div>
			<div class="form-floating">
				<textarea class="form-control" name="summary" rows="5" cols="50" id="floatingInput" >
					${movie.getSummary()}
				</textarea>
				<label for="floatingInput">줄거리</label>
			</div>
			<div class="form-floating">
				<input type="text" name="genre" class="form-control" id="floatingInput" value="${movie.getGenre()}" />
				<label for="floatingInput">장르</label>
			</div>
			<div class="form-floating">
				<input type="text" name="director" class="form-control" id="floatingInput" value="${movie.getDirector()}" />
				<label for="floatingInput">감독</label>
			</div>
			<div class="form-floating">
				<input type="text" name="actors" class="form-control" id="floatingInput" value="${movie.getActors()}" />
				<label for="floatingInput">출연진</label>
			</div>
			<div class="form-floating">
				<input type="file" name="poster" class="form-control" id="floatingInput"  />
				<label for="floatingInput">포스터</label>
			</div>
			<div class="form-floating">
				<input type="text" name="release_date" class="form-control" id="floatingInput" value="${movie.getRelease_date()}" />
				<label for="floatingInput">개봉일</label>
			</div>
			<div class="d-flex flex-wrap align-items-center justify-content-center py-3 mb-6 border-bottom fs-4">
				<button class="btn btn-success mt-4">정보 수정하기</button>
			</div>
		</form>
	</div>

</body>
</html>