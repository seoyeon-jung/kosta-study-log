<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<link href="${pageContext.request.contextPath}/style.css" rel="stylesheet">
<meta charset="UTF-8">
<title>영화 리스트</title>
</head>
<body>
	<header class="header-container">
        <div class="header-title">
            영화 리스트
        </div>
        <button class="btn btn-outline-primary collapse-button" data-bs-toggle="collapse" data-bs-target="#addMovie" aria-expanded="false" aria-controls="addMovie">
			영화 추가하기
		</button>
    </header>
    
    <!-- 영화 작성 버튼 (toggle) -->
	<div class="collapse form-signin w-100 h-auto" id="addMovie">
		<form action="/movie/movieList?action=addMovie" method="post" enctype="multipart/form-data">
			<div class="form-floating">
				<input type="text" name="title" class="form-control" id="floatingInput" placeholder="영화 제목" />
				<label for="floatingInput">영화 제목</label>
			</div>
			<div class="form-floating">
				<textarea class="form-control" name="summary" rows="5" cols="50" id="floatingInput" placeholder="줄거리"></textarea>
				<label for="floatingInput">줄거리</label>
			</div>
			<div class="form-floating">
				<input type="text" name="genre" class="form-control" id="floatingInput" placeholder="장르" />
				<label for="floatingInput">장르</label>
			</div>
			<div class="form-floating">
				<input type="text" name="director" class="form-control" id="floatingInput" placeholder="감독" />
				<label for="floatingInput">감독</label>
			</div>
			<div class="form-floating">
				<input type="text" name="actors" class="form-control" id="floatingInput" placeholder="출연진" />
				<label for="floatingInput">출연진</label>
			</div>
			<div class="form-floating">
				<input type="file" name="poster" class="form-control" id="floatingInput" placeholder="포스터" />
				<label for="floatingInput">포스터</label>
			</div>
			<div class="form-floating">
				<input type="date" name="release_date" class="form-control" id="floatingInput" placeholder="영화 개봉일" />
				<label for="floatingInput">개봉일</label>
			</div>
			<div class="d-flex flex-wrap align-items-center justify-content-center py-3 mb-6 border-bottom fs-4">
				<button class="btn btn-success mt-4">영화 등록하기</button>
			</div>
		</form>
	</div>
	
	<!-- 영화 리스트 -->
	<div class="album py-5 bg-light">
		<div class="container">
			<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
			
				<c:choose>
					<c:when test="${not empty movieList}">
						<c:forEach var="movie" items="${movieList}" varStatus="s">
							<div class="col">
								<div class="card shadow-sm">
									<img src="/img/${movie.getPoster()}" alt="poster" />
									<div class="card-body">
										<h5>${movie.getTitle()}</h5>
										<p class="card-text">${movie.getSummary()}</p>
										<div class="d-flex justify-content-between align-items-center">
											<a href="/movie/movie?id=${movie.getId()}">
												<button type="button"
													class="btn btn-sm btn-outline-secondary">보러가기</button>
											</a> 
											<a href="/movie/movieList?action=deleteMovie&id=${movie.getId()}">
												<button type="button" class="btn btn-sm btn-outline-danger">삭제</button>
											</a>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</c:when>

					<c:otherwise>
						<div class="col-md-6">
							<div class="h-100 p-5 bg-body-tertiary border rounded-3">
								등록된 영화가 없습니다.
							</div>
						</div>
					</c:otherwise>
				</c:choose>
			
				</div>
				
				
			</div>
		</div>
		


</body>
</html>