<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/statics/css/main.css">
<style>
.title-box {
	font-size: 28px;
	font-weight: bold;
	margin-bottom: 8px;
}

.one-movie {
	background: #545652;
}

.one-movie a {
	display: inline-block;
}

.one-movie img {
	width: 225px;
	height: 375px;
}

.one-movie-title {
	color: #d5d5d5;
	text-align: center;
}

.top-movie {
	width: 200px;
	background: #545652;
	height: 600px;
	margin-top: 43px;
}

.movie-box {
	width: 912px;
}

.perfect-title {
	text-align: center;
	color: #d5d5d5;
	margin: 20px 0;
	font-size: 25px;
	font-weight: bold;
}

.perfect-box li {
	padding: 10px;
	text-align: center;
	border-bottom: 1px dashed #ccc;
}

.perfect-box li, .perfect-box li a {
	color: #d5d5d5;
}

.perfect-box li a {
	font-size: 24px;
}

.perfect-box li span {
	margin-left: 10px;
	display: inline-block;
}
</style>
<title>看个片儿</title>
<body>
	<%@ include file="jsp/nav.jsp"%>

	<div class="main">
		<div class="container cf">
			<div class="top-movie fr">
				<div class="perfect-title">评分TOP 10</div>
				<div class="perfect-box">
					<ul>
						<c:forEach items="${ten}" var="ten">
							<li><a href="/showtime/movie/${ten.m_id}">${ten.movie.getM_name()}</a><span>${ten.m_grade}</span></li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<div class="new-movie">
				<div class="title-box">最新电影</div>
				<div class="movie-box cf">
					<c:forEach items="${movies}" var="m" begin="0" end="7">
						<div class="one-movie fl">
							<a href="/showtime/movie/${m.m_id}"> <img src="${m.m_pic}">
								<div class="one-movie-title">${m.m_name}</div>
							</a>
						</div>
					</c:forEach>
				</div>
			</div>
			<!-- 		<div class="all-movie">
				<div class="title-box">瀑布流，本站电影</div>
				<div class="movie-box"></div>
			</div> -->
		</div>
	</div>
</body>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/statics/js/jquery-3.3.1.min.js"></script>
</html>
