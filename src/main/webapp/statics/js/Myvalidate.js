$().ready(function() {
	$(".login").click(function() {
		$(".login-bar").removeClass("add-none");
		$(".register-bar").addClass("add-none");
		$(this).css("color", "#000");
		$(".register").css("color", "#eee");
	})

	$(".register").click(function() {
		$(".login-bar").addClass("add-none");
		$(".register-bar").removeClass("add-none");
		$(this).css("color", "#000");
		$(".login").css("color", "#eee");
	})

	$("#login-v").validate({
		rules : {
			username : {
				required : true,
				email : true,
			},
			password : {
				required : true,
				chrnum : true,
				rangelength : [ 6, 16 ]
			},
		},
		messages : {
			username : {
				required : "请输入邮箱",
				email : "请输入正确的邮箱",
			},
			password : {
				required : "请输入密码",
				rangelength : "密码长度在6到16位之间"
			},
		}
	});

	$("#register-v").validate({
		rules : {
			username : {
				required : true,
				email : true,
			},
			password : {
				required : true,
				chrnum : true,
				rangelength : [ 6, 16 ]
			},
			rep : {
				required : true,
				equalTo : "#pw1"
			},
			mailVerify : {
				required : true
			}
		},
		messages : {
			username : {
				required : "请输入邮箱",
				email : "请输入正确的邮箱"
			},
			password : {
				required : "请输入密码",
				rangelength : "密码长度在6到16位之间"
			},
			rep : {
				required : "请确认密码",
				equalTo : "密码不一致"
			},
			mailVerify : {
				required : "请输入验证码",
			}
		}
	});

})

function doVerify() {
	var account = $(".register-bar input[name='username']").val();
	if (account != "") {
		$.ajax({
			url : "/showtime/verifyAccout",
			data : {
				"username" : account
			},
			type : "post",
			datatype : "text",
			success : function(msg) {
				if ("true" != msg) {
					alert("该账号已经存在");
					setTimeout(function() {
						$(".register-bar input[name='username']").val("");
					}, 500);
				}
			}
		});
	}
}

function sendMail() {
	var account = $(".register-bar input[name='username']").val();
	if (account != "") {
		$("#send").val("发送中");
		$.ajax({
			url : "/showtime/send",
			data : {
				"username" : account
			},
			type : "post",
			datatype : "text",
			success : function(msg) {
				$("#send").val("发送成功");
			}
		});
	} else {
		alert("账号为空");
	}
}

function doMailVerify() {
	var code = $(".register-bar input[name='mailVerify']").val();
	if (code != "") {
		$.ajax({
			url : "/showtime/doMailVerify",
			data : {
				"code" : code
			},
			type : "post",
			datatype : "text",
			success : function(msg) {
				if ("true" != msg) {
					alert("验证码错误");
					$(".register-bar input[name='mailVerify']").val("");
				}
			}
		});
	}
}

// 字母和数字的验证
jQuery.validator.addMethod("chrnum", function(value, element) {
	var chrnum = /^([A-Za-z]){1,}([A-Z0-9a-z]){5,15}$/;
	return this.optional(element) || (chrnum.test(value));
}, "格式错误");