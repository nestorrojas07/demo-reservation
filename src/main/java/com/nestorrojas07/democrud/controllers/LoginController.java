/**
 * 
 */
package com.nestorrojas07.democrud.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controlador para controlar el acceso a la app
 * @author nrojas
 *
 */
@Controller
@RequestMapping("app")
public class LoginController {
	
	@GetMapping(value = {"/", "/login"})
	public ModelAndView  doLogin() {
		ModelAndView mav = new ModelAndView();
		
		String errorMsg = "User not Authorized";
		mav.addObject("errorMsg", errorMsg);
		mav.setViewName("login");
		
		return mav;
	}
	
	@GetMapping("/home")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("home");		
		return mav;
	}
}
