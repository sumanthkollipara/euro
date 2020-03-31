package com.exchangerate.euro.converter.controller;

import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.exchangerate.euro.converter.beans.CurrencyConversionBean;
import com.exchangerate.euro.converter.service.ConverterService;

@Controller
public class CurrencyConverterController {

	@Autowired
	ConverterService converterService;
	@GetMapping("/")
	public String getCurrentValue( Map<String, Object> model, @ModelAttribute CurrencyConversionBean currencyConversionBean)
	{
		 model.put("currencyMap", converterService.getHomePageDetails());
		 
		 return "Home";
		
	}
	
	
	@RequestMapping(path ="/history" , method= RequestMethod.GET  )
	public String getHistoryValue(@ModelAttribute CurrencyConversionBean currencyConversionBean, Map<String, Object> model)
	{
		
		model.put("hisotry", converterService.getHistory(currencyConversionBean.getBase()));
		System.out.println("hi");
		return "history";
		
	}
}
