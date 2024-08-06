<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 실습</title>
</head>
<body>
	<!-- JSTL을 사용하기 위해서는 taglib 지시어(JSTL이 어디에 있는지, 접두어가 무엇인지)를 추가해야 한다. -->
	<c:set var="title" value="<h1>JSP</h1>" />
	${title}

	<c:set var="greeting" value="안녕하세요!" />
	${greeting}

	<!--<c:set var="numArr" value="${[1,2,3,4,5]}" />
	${numArr[2]}-->

	<c:set var="loginUser" value="${sessionScope.loginUser }" />

	<c:if test='${loginUser != null}'>
		<p>${greeting }${loginUser }님</p>

		<!-- 로그아웃 form -->
		<form action="/jstl_web/logout" method="post">
			<button>로그아웃</button>
		</form>
	</c:if>
	<c:if test="${loginUser == null}">
		<p>로그인부터 해주세요.</p>

		<!-- 로그인 화면 만들기 -->
		<form action="/jstl_web/login" method="post">
			<input type="text" name="name" />
			<button>로그인</button>
		</form>
	</c:if>


	<c:choose>
		<c:when test="${loginUser == null}">
			<p>로그인부터 해주세요.</p>

			<!-- 로그인 화면 만들기 -->
			<form action="/jstl_web/login" method="post">
				<input type="text" name="name" />
				<button>로그인</button>
			</form>
		</c:when>
		<c:when test="${loginUser.equals(\"최인규\")}">
			<p>드디어 최인규님이 오셨네요.</p>
			<form action="/jstl_web/logout" method="post">
				<button>로그아웃</button>
			</form>
		</c:when>
		<c:otherwise>
			<p>${greeting }${loginUser }님</p>

			<!-- 로그아웃 form -->
			<form action="/jstl_web/logout" method="post">
				<button>로그아웃</button>
			</form>
		</c:otherwise>
	</c:choose>

	<c:forEach var="u" items="${userList}">
		<p>${u.getName()}</p>
	</c:forEach>

</body>
</html>