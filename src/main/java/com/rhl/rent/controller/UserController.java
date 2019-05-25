package com.rhl.rent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.rhl.rent.DTO.UserDTO;
import com.rhl.rent.config.security.SecurityService;
import com.rhl.rent.config.validator.UserValidator;
import com.rhl.rent.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private UserValidator userValidator;

	@GetMapping("/registration")
	public String registration(Model model) {
		model.addAttribute("userForm", new UserDTO());
		return "registration";
	}

	@PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") UserDTO userDTO, BindingResult bindingResult) {
        userValidator.validate(userDTO, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.createUser(userDTO);
        securityService.autoLogin(userDTO.getUserName(), userDTO.getPasswordConfirm());
        return "redirect:/welcome";
    }

	@GetMapping("/login")
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");

		return "login";
	}

	@GetMapping({ "/", "/welcome" })
	public String welcome(Model model) {
		return "welcome";
	}
}
