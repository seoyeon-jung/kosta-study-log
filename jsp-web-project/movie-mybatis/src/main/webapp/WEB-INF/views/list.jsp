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
        <a href="/movie/post">
	        <button class="btn btn-outline-primary collapse-button">
				영화 추가하기
			</button>
		</a>
    </header>
    
	
	
	<!-- 영화 리스트 -->
	<div class="album py-5 bg-light">
		<div class="container">
			<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
			
				<c:choose>
					<c:when test="${not empty movieList}">
						<c:forEach var="movie" items="${movieList}" varStatus="s">
							<div class="col">
								<div class="card shadow-sm">
									<img src="/movieImage/${movie.getPoster()}" alt="poster" />
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