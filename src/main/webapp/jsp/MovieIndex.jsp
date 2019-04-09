<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>电影分类</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/statics/css/main.css">

<style type="text/css">
.search {
	height: 90px;
	font-size: 20px;
	line-height: 30px;
	border: 1px solid #000;
	margin-top: 15px;
	margin-bottom: 15px;
	background: #545652;
	padding: 15px;
	border: 1px solid #000;
	color: #d5d5d5;
}

.search a {
	color: #eee;
	display: inline-block;
	padding-left: 10px;
}

.one-movie-result img {
	height: 300px;
	width: 210px;
}

.one-movie-result {
	margin-right: 22px;
	background: #545652;
	margin-bottom: 20px;
}

.one-movie-result a {
	display: block;
}

.one-movie-result:nth-child(5n) {
	margin-right: 0;
}

.movie-result {
	height: 715px;
}

.one-movie-title {
	height: 32px;
	color: #eee;
	line-height: 28px;
	text-align: center;
}

.movie-page {
	text-align: center;
}

.movie-page a {
	color: #545652;
	padding: 0 5px;
}
</style>
</head>
<body>
	<%@ include file="nav.jsp"%>

	<div class="main">
		<div class="container">
			<div class="search">
				<div>
					<span>国家：</span><a href="/showtime/movieIndex/m_country/china">中国</a><a
						href="/showtime/movieIndex/m_country/usa">美国</a><a
						href="/showtime/movieIndex/m_country/japan">日本</a><a
						href="/showtime/movieIndex/m_country/korea">韩国</a><a
						href="/showtime/movieIndex/m_country/other">其他</a>
				</div>

				<div>
					<span>类型：</span><a href="/showtime/movieIndex/m_type/story">剧情</a><a
						href="/showtime/movieIndex/m_type/act">动作</a><a
						href="/showtime/movieIndex/m_type/comedy">喜剧</a><a href="/showtime/movieIndex/m_type/sf">科幻</a><a
						href="/showtime/movieIndex/m_type/biopic">传记</a><a
						href="/showtime/movieIndex/m_type/animate">动画</a><a
						href="/showtime/movieIndex/m_type/horror">恐怖</a><a
						href="/showtime/movieIndex/m_type/suspense">悬疑</a><a
						href="/showtime/movieIndex/m_type/war">战争</a><a href="/showtime/movieIndex/m_type/other">其他</a>
				</div>
				<div>
					<span>年代：</span><a href="/showtime/movieIndex/m_date/2019">2019</a><a
						href="/showtime/movieIndex/m_date/2018">2018</a><a
						href="/showtime/movieIndex/m_date/2017">2017</a><a
						href="/showtime/movieIndex/m_date/2016">2016</a><a
						href="/showtime/movieIndex/m_date/2015">2015</a><a
						href="/showtime/movieIndex/m_date/2014">2014</a><a
						href="/showtime/movieIndex/m_date/2013">2013</a><a
						href="/showtime/movieIndex/m_date/2012">2012</a><a
						href="/showtime/movieIndex/m_date/2011">2011</a><a
						href="/showtime/movieIndex/m_date/2010">2010</a><a
						href="/showtime/movieIndex/m_date/other">其他</a>
				</div>
			</div>

			<div class="movie-result cf">
				<c:forEach items="${movies}" var="m" begin="0" end="9">
					<div class="one-movie-result fl">
						<div>
							<a href="/showtime/movie/${m.m_id}"> <img src="${m.m_pic}">
								<div class="one-movie-title">${m.m_name}</div>
							</a>
						</div>
					</div>
				</c:forEach>
			</div>
			<div class="movie-page">
				<a href="?start=0">首 页</a>
				<c:if test="${page.start-page.count>=0}">
					<a href="?start=${page.start-page.count}">上一页</a>
				</c:if>
				<c:if test="${page.start-page.count<0}">
					<a href="javascript:void(0)">上一页</a>
				</c:if>
				<c:choose>
					<c:when test="${page.pageSize<1}">
						<a href="?start=0">1</a>
					</c:when>
					<c:otherwise>
						<c:forEach var="i" begin="0" end="${page.pageSize-1}">
							<a href="?start=${i*10}">${i+1}</a>
						</c:forEach>
					</c:otherwise>
				</c:choose>
				<c:if test="${page.start+page.count<=page.last}">
					<a href="?start=${page.start+page.count}">下一页</a>
				</c:if>
				<c:if test="${page.start+page.count>page.last}">
					<a href="javascript:void(0)">下一页</a>
				</c:if>
				<a href="?start=${page.last}">末 页</a>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/statics/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		
	})
</script>
</html>