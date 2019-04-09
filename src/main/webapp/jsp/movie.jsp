<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../statics/css/main.css">
<title>${movie.m_name}</title>
<style type="text/css">
.movie-name {
	font-size: 40px;
	font-weight: bolder;
	margin-bottom: 20px;
}

.movie-info {
	height: 300px;
	font-size: 20px;
}

.movie-pic, .movie-pic img {
	width: 200px;
	height: 300px;
}

.info-box {
	margin-left: 220px;
	line-height: 35px;
	width: 570px;
}

.info-box div {
	overflow: hidden;
	text-overflow: ellipsis;
}

.movie-summary {
	text-indent: 2em;
	margin-top: 24px;
	height: 150px;
	line-height: 28px;
	font-size: 18px;
}

.one-movie-grade {
	height: 300px;
	width: 300px;
}

.our-grade {
	font-size: 24px;
}

.movie-grade {
	height: 80px;
	width: 80px;
	border-radius: 50%;
	background: #545652;
	text-align: center;
	line-height: 80px;
	margin-left: 111px;
	color: #fff;
}

.mb {
	margin-bottom: 20px;
}
</style>
</head>
<body>
	<%@ include file="nav.jsp"%>

	<div class="main">
		<div class="container">
			<div class="movie-name">${movie.m_name}</div>
			<div class="movie-info cf">
				<div class="movie-pic fl">
					<img src="${movie.m_pic}" alt="">
				</div>
				<div class="one-movie-grade fr">
					<div class="mb">
						<div class="our-grade">本站评分</div>
						<c:choose>
							<c:when test="${empty grade}">
								<div class="movie-grade">无</div>
							</c:when>
							<c:otherwise>
								<div class="movie-grade">${grade}</div>
							</c:otherwise>
						</c:choose>
					</div>
					<div>
						<div class="our-grade">我的评分</div>
						<c:choose>
							<c:when test="${not empty username}">
								<c:choose>
									<c:when test="${not empty myGrade}">
										<div class="movie-grade">${myGrade}</div>
										<span>评分</span>
										<select id="up-grade"
											onchange="update_movie_grade(${movie.m_id})">
											<option value="2.0">槽糕</option>
											<option value="4.0">还行</option>
											<option value="6.0">一般</option>
											<option value="8.0">佳作</option>
											<option value="10.0">神作</option>
										</select>
									</c:when>
									<c:otherwise>
										<div class="add-grade movie-grade">无</div>
										<span>评分</span>
										<select onchange="add_movie_grade(${movie.m_id})">
											<option value="2.0">槽糕</option>
											<option value="4.0">还行</option>
											<option value="6.0">一般</option>
											<option value="8.0">佳作</option>
											<option value="10.0">神作</option>
										</select>
									</c:otherwise>
								</c:choose>
							</c:when>
							<c:otherwise>
								<div class="please-login movie-grade">请登录</div>
							</c:otherwise>
						</c:choose>
					</div>

				</div>
				<div class="info-box">
					<div>
						<span>导演：</span>${movie.m_director}</div>
					<div>
						<span>主演：</span>${movie.m_actor}</div>
					<div>
						<span>类型：</span>${movie.m_type}</div>
					<div>
						<span>国家：</span>${movie.m_country}</div>
					<div>
						<span>时长：</span>${movie.m_length} 分钟
					</div>
					<div>
						<span>上映日期：</span>
						<fmt:formatDate value="${movie.m_date}" pattern="yyyy-MM-dd" />
					</div>
				</div>
			</div>
			<div class="movie-summary">${movie.m_summary}</div>
		</div>

	</div>
</body>
<script type="text/javascript" src="../statics/js/jquery-3.3.1.min.js"></script>

<script type="text/javascript">
	function add_movie_grade(mid) {
		var grade = $("select").val();
		$.ajax({
			url : "/showtime/addGrade",
			data : {
				"m_id" : mid,
				"m_grade" : grade,
			},
			type : "post",
			datatype : "text",
			success : function(msg) {
					alert("评分成功");
					setTimeout(function() {
						$("#my-grade").html(grade);
						$(".movie-grade").html(msg);
					}, 500);
			}
		});
	} 

	function update_movie_grade(mid) {
		var grade = $("select").val();
		$.ajax({
			url : "/showtime/updateGrade",
			data : {
				"m_id" : mid,
				"m_grade" : grade,
			},
			type : "post",
			datatype : "text",
			success : function(msg) {
					alert("评分成功");
					setTimeout(function() {
						$("#my-grade").html(grade);
						$(".movie-grade").html(msg);
					}, 500);
			}
		});
	}
	 /* $(document) .ready( function() { $ .ajax({ url : "/showtime/{m_id}",
		 type : "get", datatype : "json", success : function(msg) { var msg = '
		 <div class="alert alert-info" role="alert">删除成功!</div>
		 '; $('.main').html(msg); } }); })  */
</script>
</html>