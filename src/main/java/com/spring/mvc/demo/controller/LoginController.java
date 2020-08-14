package com.spring.mvc.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@Autowired
	private Environment env;
	
	@RequestMapping(value = "/login", method= RequestMethod.GET )
	public String getLoginPage() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method= RequestMethod.POST )
	public String authenticateUserCredentials(@RequestParam String userName, @RequestParam String password, ModelMap modelMap) {
		if(password.equals("swarnali")) {
			modelMap.put("userNameInWelcomeView", userName);
			return "welcome";
		}else {
			modelMap.put("errorInLoginPage", "Invalid Credentials");
			return "login";
		}
		
	}

}
