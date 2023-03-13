package com.jack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jack.model.User;
import com.jack.repository.UserRepository;

@Controller
public class UserController {
 
	@Autowired
	private UserRepository repo;
	
	//By using "/" we can Call home.html page
	//here we using ModelAndView class to transfer data to {/save} method
	@GetMapping("/")
	public ModelAndView homePage() {
		List<User> list = repo.findAll();
		return new ModelAndView("home","any",list);
	}
	// Adding user in addnewuser.html form with this method
	@PostMapping("/save")
	//@ModelAttribute using this annotation for mapping between java code and html code
	public String saveUser(@ModelAttribute User user) {
		repo.save(user);
		// using redirect for call home page
		return "redirect:/";
	} 
	@GetMapping("/add")
	public String addNewUser() {
		return "addnewuser";
	}
	
	@RequestMapping("/update/{id}")
	public String updateUserById(@PathVariable int id, Model model) {
		User returnedUser = repo.findById(id).get();
		model.addAttribute("any", returnedUser);
		return "update";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteUserById(@PathVariable int id) {
		repo.delete(repo.findById(id).get());
		return "redirect:/";
	}
}








