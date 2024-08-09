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
<title>뉴스 목록</title>
</head>
<body>
	<div class="container w-75 mt-5 mx-auto">
		<h2 class="text-center mb-4">뉴스 목록</h2>
		<hr />
		<c:choose>
			<c:when test="${not empty newsList}">
				<ul class="list-group mb-4">
					<c:forEach var="news" items="${newsList}" varStatus="s">
						<li class="
							list-group-item list-group-item-action
							d-flex justify-content-between
							align-items-center">
							<a href="/news/newsView?id=${news.getId()}">[${s.count}] ${news.getTitle()}</a>
							<div>
								<span>${news.getDate()}</span>
								<a href="/news/newsList?action=deleteNews&id=${news.getId()}">
									<span class="badge bg-secondary"> &times; </span>
								</a>
							</div>
						</li>
					</c:forEach>
				</ul>
			</c:when>
			<c:otherwise>
				<div class="no-news-msg">뉴스 기사가 없습니다.</div>
			</c:otherwise>
		</c:choose>
		
		<c:if test="${error != null}">
			<div class="alert alert-danger alert-dismissible fade show mt-3" role="alert">
				에러 발생 : ${error}
				<button class="btn-close" data-bs-dismiss="alert"></button>
			</div>
		</c:if>
	</div>
</body>
</html>