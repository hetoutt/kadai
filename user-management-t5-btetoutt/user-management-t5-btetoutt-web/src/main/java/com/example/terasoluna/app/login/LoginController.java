package com.example.terasoluna.app.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    private static final Logger logger = LoggerFactory
            .getLogger(LoginController.class);
      
	@RequestMapping(value = "loginForm")
	public String viewLoginForm() {
		
		logger.info("Login!!");
		
		return "login/loginForm";
	}

}