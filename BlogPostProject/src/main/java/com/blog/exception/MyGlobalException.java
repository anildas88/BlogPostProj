package com.blog.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice()
public class MyGlobalException {
	
	@ExceptionHandler(value= {MyException.class})
	public String arithExc(Model m) {
		m.addAttribute("err", "something `wrong try latter");
		return "error";
	}
	
	@ExceptionHandler(value= {Exception.class})
	public String UnknownExc(Model m) {
		m.addAttribute("err", "internal problem");
		return "error";
	}

}
