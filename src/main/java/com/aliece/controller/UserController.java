package com.aliece.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aliece.entity.User;
import com.aliece.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Inject
	private UserService userService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String list(Model model){
		List<User> userList = userService.findAll();
		model.addAttribute("userList", userList);
		return "user/list";
		
	}
	
	@RequestMapping(value="/edit/{id:\\d+}", method=RequestMethod.GET)
	public String edit(@PathVariable int id, Model model){
		User user = userService.findById(id);
		model.addAttribute("user", user);
		System.out.println(user);
		return "user/edit";
		
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(User user){
		userService.update(user);
		return "redirect:/user";
	}
	
	@RequestMapping(value="/delete/{id:\\d+}", method=RequestMethod.GET)
	public String delete(@PathVariable int id){
		userService.delete(id);
		return "redirect:/user";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String add(){
		return "user/add";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(User user){
		System.out.println(user.getPassword());
		userService.add(user);
		return "redirect:/user";
	}
	
}
