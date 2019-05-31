package com.blog.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.blog.constants.ApplicationConstant;
import com.blog.exception.MyException;
import com.blog.user.model.Login;
import com.blog.user.model.UserFormModel;
import com.blog.user.service.UserService;

@Controller
public class UserController {
	
	@Autowired(required=true)
	private UserService service;
	
	/**
	 * This method is used to Display Applicant reg form
	 * 
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "/showForm")
	public String appRegForm(Model model) {

		// add cwModel object to Model scope
		model.addAttribute("appModel", new UserFormModel());

		return "userReg";
	}

	/**
	 * This method is used to register applicant with given values
	 * 
	 * @param appAccModel
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/appReg", method = RequestMethod.POST)
	public String appReg(@ModelAttribute("userModel") UserFormModel userModel,RedirectAttributes attribute) {
		String message=null;
	try {
		//call service method
		 message=service.registerUser(userModel);
	} catch (Exception e) {
		//throw user defined excep[tion]
		throw new MyException(e.getMessage());
	}
		
		//set data into redirect attribute
	//redirect form to empty form page with message
		
		attribute.addFlashAttribute(ApplicationConstant.MESSAGE, message);
		return "redirect:/showForm";//return view name
	}//method
	
	/*
	 * to show login page
	 */
	
	@RequestMapping("/showLogin")
	public String login(Model model) {
		
		model.addAttribute("login",new Login());
		return "login";
		
	}
	
	
	/*
	 * 
	 * to authenticate username and pwd
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String dologin(@ModelAttribute("login") Login login,RedirectAttributes attribute) {
		
		String message=null;
	try {
		//call service method
		message=service.login(login);
		
	} catch (Exception e) {
		throw new MyException(e.getMessage());
	}
	
	attribute.addFlashAttribute(ApplicationConstant.MESSAGE, message);
	return "redirect:/showLogin";
		
	}

}
