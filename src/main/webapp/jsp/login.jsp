<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录/注册</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/statics/css/main.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/statics/css/verify.css">
<style type="text/css">
.main {
	padding-top: 80px;
}

.random-movie a {
	display: block;
}

.random-movie img, .random-movie a {
	height: 666px;
	width: 460px;
}

.login-register {
	border: 1px solid #d8d8d8;
	height: 666px;
	width: 660px;
}

.big {
	margin-top: 60px;
}

.add-none {
	display: none;
}

label.error {
	position: absolute;
	bottom: -32px;
	left: 223px;
	color: red;
}

form {
	position: relative;
}

.form-group {
	position: relative;
	text-align: center;
	margin: 52px 20px 40px;
}

.form-group span, .form-group input {
	display: inline-block;
	height: 38px;
	font-size: 24px;
}

.form-group input {
	font-size: 20px;
	width: 330px;
}

.form-group span {
	width: 122px;
}

form div {
	
}

button {
	width: 140px;
	height: 50px;
	font-size: 22px;
	font-weight: bold;
	/* background: #545652; */
	border: 0;
	outline: 0;
	position: absolute;
	bottom: 86px;
	letter-spacing: 5px;
	cursor: pointer;
	left: 260px;
}

.login, .register {
	display: inline-block;
	text-align: center;
	cursor: pointer;
	margin: 0 40px;
}

.register {
	color: #eee;
}

.choose {
	color: #000;
	font-size: 48px;
	font-weight: bold;
	margin: 60px auto 50px;
	text-align: center;
}

.choose-bar form {
	height: 532px;
}

#mp {
	margin: 50px auto 0;
	width: 400px;
}

#send {
	position: absolute;
	bottom: 208px;
	right: 100px;
	height: 42px;
	width: 88px;
}
</style>
</head>
<body>
	<%@ include file="nav.jsp"%>

	<div class="main">
		<div class="container cf">
			<div class="login-register fr">
				<div class="choose">
					<span class="login">登录</span><span class="register">注册</span>
				</div>
				<div class="choose-bar">
					<div class="login-bar">
						<form action="/showtime/login" method="post" id="login-v"
							onkeydown="if(event.keyCode==13)return false;">
							<div class="form-group">
								<span>邮箱：</span> <input type="text" name="username"
									placeholder="xxx@xxx.com">
							</div>
							<div class="form-group">
								<span>密码：</span> <input type="password" name="password"
									placeholder="数字或字母，至少含有一个字母">
							</div>
							<div id="mp"></div>
							<button type="submit">登 录</button>
						</form>
					</div>
					<div class="register-bar add-none">
						<form action="/showtime/register" method="post" id="register-v"
							onkeydown="if(event.keyCode==13)return false;">
							<div class="form-group">
								<span>邮箱：</span> <input type="text" name="username"
									onchange="doVerify()" placeholder="xxx@xxx.com">
							</div>
							<div class="form-group">
								<span>密码：</span> <input type="password" name="password" id="pw1"
									placeholder="数字或字母，至少含有一个字母">
							</div>
							<div class="form-group">
								<span>确认密码：</span> <input type="password" name="rep"
									placeholder="数字或字母，至少含有一个字母">
							</div>
							<div class="form-group">
								<span>验证码：</span> <input type="text" name="mailVerify"
									onchange="doMailVerify()" placeholder="6位验证码">
							</div>
							<input type="button" onclick="sendMail()" value="发送验证码" id="send">
							<button type="submit">注 册</button>
						</form>
					</div>
				</div>
			</div>
			<div class="random-movie">
				<a href="/showtime/movie/${movie.m_id}"> <img
					src="${movie.m_pic}"> <%-- <div class="one-movie-title">${movie.m_name}</div> --%>
				</a>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/statics/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/statics/js/jquery.validate.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/statics/js/Myvalidate.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/statics/js/verify.min.js"></script>
<script type="text/javascript">
	$('#mp').slideVerify({

		type : 1,
		vOffset : 5,
		explain : '向右滑动完成验证',
		barSize : {
			width : '60%',
			height : '50px',
		},
		ready : function() {
		},
		success : function() {
			setTimeout(function() {
				$(".login-bar form").submit();
			}, 500);
		},
		error : function() {
		}

	});
</script>

</html>