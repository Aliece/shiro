package com.aliece.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String home(){
		return "home";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(String username, String password, RedirectAttributes redirectAttributes){
		try {
			SecurityUtils.getSubject().login(new UsernamePasswordToken(username, password));
		} catch (AuthenticationException e) {
			redirectAttributes.addFlashAttribute("message", "�û�����������");
			return "redirect:/login";
		}
		return "redirect:/user";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(){
		SecurityUtils.getSubject().logout();
		return "redirect:/login";
	}
}
