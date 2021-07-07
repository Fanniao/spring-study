package com.sun.controller;

import com.sun.entity.User;
import com.sun.mapper.UserMapper;
import com.sun.service.LoginService;
import com.sun.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class LoginHandler {

	@Autowired
	private UserMapper userMapper;

	@GetMapping("/")
	public String index() {
		return "login";
	}

	@GetMapping("/login")
	public String login(){
		return "login";
	}

	@PostMapping("/login")
	public ModelAndView login(User user) {
		ModelAndView view = new ModelAndView();
		System.out.println(user);
		LoginService loginService = new LoginService(userMapper);
		if (loginService.login(user)) {
			view.setViewName("redirect:/mapper/findAll");
		} else {
			view.setViewName("login");
			view.addObject("username", user.getUsername());
			view.addObject("msg", "用户名或密码错误!");
		}
		return view;
	}

	@GetMapping("/register")
	public String register() {
		return "register";
	}

	@PostMapping("/register")
	public ModelAndView register(User user){
		ModelAndView view = new ModelAndView();
		System.out.println(user);
		RegisterService registerService = new RegisterService(userMapper);
		if (registerService.register(user)) {
			view.addObject("username", user.getUsername());
			view.setViewName("/login");
		} else {
			view.addObject("msg", "用户名重复,注册失败!");
			view.setViewName("/register");
		}
		return view;
	}
}
