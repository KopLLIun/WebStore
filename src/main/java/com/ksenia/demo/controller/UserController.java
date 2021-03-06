package com.ksenia.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ksenia.demo.model.Address;
import com.ksenia.demo.model.User;
import com.ksenia.demo.service.ISecurityService;
import com.ksenia.demo.service.IUserService;
import com.ksenia.validator.UserValidator;

/**
 * Copyright (c) 2020 apollon GmbH+Co. KG All Rights Reserved.
 */

@Controller
public class UserController
{
	@Autowired
	private IUserService userService;

/*	@RequestMapping(value= {"/", "/login"}, method=RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView model = new ModelAndView();

		model.setViewName("user/login");
		return model;
	}*/

	@RequestMapping(value= {"/signup"}, method=RequestMethod.GET)
	public ModelAndView signup() {
		ModelAndView model = new ModelAndView();
		User user = new User();
		model.addObject("user", user);
		model.setViewName("user/signup");

		return model;
	}

	@RequestMapping(value= {"/signup"}, method=RequestMethod.POST)
	public ModelAndView createUser(@Valid User user, BindingResult bindingResult) {
		ModelAndView model = new ModelAndView();
		User userExists = userService.findUserByLogin(user.getLogin());

		if(userExists != null) {
			bindingResult.rejectValue("login", "error.user", "This login already exists!");
		}
		if(bindingResult.hasErrors()) {
			model.setViewName("user/signup");
		} else {
			userService.addUser(user);
			model.addObject("msg", "User has been registered successfully!");
			model.addObject("user", new User());
			model.setViewName("user/signup");
		}

		return model;
	}

/*
	@RequestMapping(value= {"/home/home"}, method=RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView model = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByLogin(auth.getName());

		model.addObject("userName", user.getName() + " " + user.getSurname());
		model.setViewName("home/home");
		return model;
	}

	@RequestMapping(value= {"/access_denied"}, method=RequestMethod.GET)
	public ModelAndView accessDenied() {
		ModelAndView model = new ModelAndView();
		model.setViewName("errors/access_denied");
		return model;
	}
*/







/*	@Autowired
	private IUserService userService;

	@Autowired
	private ISecurityService securityService;

	private final UserValidator userValidator = new UserValidator();

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("userForm", new User());

		return "registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
		userValidator.validate(userForm, bindingResult);

		if (bindingResult.hasErrors()) {
			return "registration";
		}

		userService.addUser(userForm);

		securityService.autoLogin(userForm.getName(), userForm.getConfirmPassword());

		return "redirect:/welcome";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if (error != null) {
			model.addAttribute("error", "Username or password is incorrect.");
		}

		if (logout != null) {
			model.addAttribute("message", "Logged out successfully.");
		}

		return "login";
	}

	@RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
	public String welcome(Model model) {
		return "welcome";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin(Model model) {
		return "admin";
	}*/
}
