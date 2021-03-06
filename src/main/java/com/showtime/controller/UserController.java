package com.showtime.controller;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.showtime.pojo.User;
import com.showtime.service.UserService;
import com.showtime.util.SendMail;

@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("login")
	public ModelAndView login(String username, String password, HttpSession session) {
		// 从数据库中查找传进来的用户名和密码
		User user = userService.selectOneUser(username, password);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/randomMovie");

		// 比较用户名和密码
		if (user != null && username.equals(user.getUsername()) && password.equals(user.getPassword())) {
			// 添加session
			session.setAttribute("username", username);
			session.setAttribute("u_id", user.getU_id());
			mv.setViewName("redirect:/");
		}
		return mv;
	}

	@PostMapping("register")
	public String register(String username, String password, HttpSession session) {
		userService.insertOneUser(username, password);
		int u_id = userService.selectOneUser(username, password).getU_id();
		session.setAttribute("username", username);
		session.setAttribute("u_id", u_id);
		return "/";
	}

	@PostMapping("verifyAccout")
	public String verifyAccout(@RequestBody String username) {
		String name = userService.selectUsername(username);
		if (username.equals(name)) {
			return "false";
		}
		return "true";
	}

	// 注销
	@GetMapping("outLogin")
	public ModelAndView outLogin(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		session.invalidate();
		mv.setViewName("redirect:/");
		return mv;
	}

	@PostMapping("send")
	public String sendMail(@RequestBody String username, HttpSession session) {
		String ran = (int) ((Math.random() * 9 + 1) * 100000) + "";
		session.setAttribute("ran", ran);
		try {
			SendMail.send(username, ran);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return "true";
	}

	@PostMapping("doMailVerify")
	public String doMailVerify(@RequestBody String code, HttpSession session) {
		String ran = (String) session.getAttribute("ran");
		session.invalidate();
		if (code.equals(ran)) {
			return "true";
		}
		return "false";
	}
}
