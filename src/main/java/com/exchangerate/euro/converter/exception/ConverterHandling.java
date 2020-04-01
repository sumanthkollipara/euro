package com.exchangerate.euro.converter.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ConverterHandling   {
 
	
	@ExceptionHandler(value=ConverterException.class)
	public String exceptionHandler()
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("messsage", "Something went wrong. please try again later");
		return "ExceptionPage";
	}
	
	@ExceptionHandler(value=RuntimeException.class)
	public String runTimeExc()
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("messsage", "Something went wrong. please try again later");
		
		return "ExceptionPage";
	}
	
	
	
}
