<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>영화 리스트</title>
</head>
<body>
	<header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom fs-4">영화 리스트</header>
	
	
	<div class="album py-5 bg-light">
		<div class="container">
			<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
			
				<div class="col">
					<div class="card shadow-sm">
						<img alt="poster" />
						<div class="card-body">
							<p class="card-text">파일럿</p>
							<div class="d-flex justify-content-betwen align-items-center">
								<button type="button" class="btn btn-sm btn-outline-secondary">보러가기</button>
								<button type="button" class="btn btn-sm btn-outline-secondary">삭제</button>
							</div>
						</div>
					</div>
				</div>
				
				<div class="col">
					<div class="card shadow-sm">
						<img alt="poster" />
						<div class="card-body">
							<p class="card-text">파일럿</p>
							<div class="d-flex justify-content-betwen align-items-center">
								<button type="button" class="btn btn-sm btn-outline-secondary">보러가기</button>
								<button type="button" class="btn btn-sm btn-outline-secondary">삭제</button>
							</div>
						</div>
					</div>
				</div>
				
				<div class="col">
					<div class="card shadow-sm">
						<img alt="poster" />
						<div class="card-body">
							<p class="card-text">파일럿</p>
							<div class="d-flex justify-content-betwen align-items-center">
								<button type="button" class="btn btn-sm btn-outline-secondary">보러가기</button>
								<button type="button" class="btn btn-sm btn-outline-secondary">삭제</button>
							</div>
						</div>
					</div>
				</div>
				
				
			</div>
		</div>
	</div>
</body>
</html>