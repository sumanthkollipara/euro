package com.exchangerate.euro.converter.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
import com.exchangerate.euro.converter.exception.ConverterException;
import com.exchangerate.euro.converter.service.ConverterService;


/**
 * @author sumanth
 *Controller used to fetch conversion rate of euro to other currencies 
 */
@Controller
public class CurrencyConverterController {
	
	Logger logger = LoggerFactory.getLogger(CurrencyConverterController.class);

	@Autowired
	ConverterService converterService;
	/**
	 * @param model
	 * @param currencyConversionBean
	 * @return
	 * Method is used to fetch current euro value against USD, GBP, HKD
	 */
	@GetMapping("/")
	public String getCurrentValue( Map<String, Object> model, @ModelAttribute CurrencyConversionBean currencyConversionBean)
	{
		logger.debug("fethching details from server");
		Map<String,BigDecimal>exchangeRate = converterService.getHomePageDetails();
		if(exchangeRate !=null && exchangeRate.size()!=0 )
		 model.put("currencyMap", exchangeRate);
		else
		{
			logger.error("error while fetching data from service provider");
			throw new ConverterException();
		}
			
		 return "Home";
		
	}
	
	
	/**
	 * @param base
	 * @param model
	 * @return
	 * This method is used to fetch EURO rate from last 6 months of a particular currency passed as an input
	 */
	@RequestMapping(path ="{base}/history" , method= RequestMethod.GET  )
	public String getHistoryValue(@PathVariable("base") String base, Map<String, Object> model)
	{
		if(base !=null & !base.isEmpty())
		{
			logger.debug("Fetching data of provided base");
		
		model.put("hisotry", converterService.getHistory(base));
		}
		else
		{
			logger.error("error while reading data from UI. param bas value is null");
			throw new RuntimeException();
		}
		
		return "history";
		
	}
	
	/**
	 * @param model
	 * @return
	 * Method is used to fetch history of EURO rate from last six months on current date 
	 */
	@RequestMapping(path ="/history" , method= RequestMethod.GET  )
	public String getHistoryValue(Map<String, Object> model)
	{
		Map<String, List<BigDecimal>> allRec = converterService.getHistory();
		if(allRec !=null && allRec.size()>0)
		{
			logger.debug("Fetching data");
		model.put("allhisotry",allRec );
		}
		else
		{
			logger.error("error while fetching data from service provider");
			throw new ConverterException();
		}
		return "allHistory";
		
	}
	
	
}
