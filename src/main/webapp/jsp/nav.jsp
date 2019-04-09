<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/statics/css/main.css">
<style type="text/css">
.nav-bar {
	height: 60px;
	line-height: 60px;
	font-size: 20px;
	background: #545652;
	color: #d5d5d5;
}

.nav-bar a {
	color: #d5d5d5;
	margin-right: 25px;
}
</style>
</head>
<body>
	<div class="nav-bar">
		<div class="container">
			<a href="/showtime">看个片儿</a><a href="/showtime/movieIndex/index">电影分类</a><span
				class="fr"><c:choose>
					<c:when test="${not empty username}">
						<span>欢迎回来：</span>
						<a href="space.jsp">${username}</a>
						<a href="/showtime/outLogin" style="margin-right: 0">退出</a>
					</c:when>
					<c:otherwise>
						<a href="/showtime/randomMovie">登录/注册</a>
					</c:otherwise>
				</c:choose></span>
		</div>
	</div>
</body>
</html>