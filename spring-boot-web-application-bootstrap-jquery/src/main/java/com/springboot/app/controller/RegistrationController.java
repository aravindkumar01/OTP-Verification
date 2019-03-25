package com.springboot.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.app.entity.Registration;
import com.springboot.app.logic.RandomNumber;
import com.springboot.app.service.RegisterService;

@Controller
@RequestMapping(value="/customer")
public class RegistrationController {
	
	@Autowired
	RandomNumber rand;
	@Autowired
	RegisterService service;
	@Autowired
	HttpSession session;
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String customer(@ModelAttribute("Registration") Registration regs)
	{
		try {
			String res;
			res=service.register(regs);
			return "verify";
			
		} catch (Exception e) {
			return e.toString();
			// TODO: handle exception
		}
	}
	
	@RequestMapping(value = "/verify/{number}", method = RequestMethod.POST)
	public @ResponseBody String customer(@PathVariable("number") int number)
	{
		try {
			String result;
			result=service.verify(number);
			return result;
			
		} catch (Exception e) {
			return e.toString();
			// TODO: handle exception
		}
	}
	@RequestMapping(value = "/resent")
	public  String customer()
	{
		try {
		String email= (String) session.getAttribute("email");
			rand.random(email);
			return "verify";
		} catch (Exception e) {
			return e.toString();
			// TODO: handle exception
		}
	}

}
