package com.exchangerate.euro.converter.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.exchangerate.euro.converter.beans.CurrencyConversionBean;
import com.exchangerate.euro.converter.beans.HistoryBean;


/**
 * @author sumanth
 *
 */
@Service
public class ConverterService {
	
	
	/**
	 * @return
	 * Method to fetch home page details
	 */
	public Map<String,BigDecimal> getHomePageDetails()
	{
		Map< String , BigDecimal> values = new HashMap<String, BigDecimal>();
		
		values.put("USD",getTodayValue("USD")  );
		values.put("GBP",getTodayValue("GBP")  );
		//values.put("HKD",getTodayValue("HKD")  );
		
		return values;
	}
	
	/**
	 * @param fromValue
	 * @return
	 * Method creates a rest call and fetches each currency conversion rate against  euro 
	 */
	public BigDecimal getTodayValue(String fromValue )
	{
		ResponseEntity<CurrencyConversionBean> responseEntity = null;
		 CurrencyConversionBean response = null;
		try {
		  responseEntity = new RestTemplate().getForEntity(
			        "http://api.ratesapi.io/api/latest?base="+fromValue+"&symbols=EUR", CurrencyConversionBean.class);
		 
		 response = responseEntity.getBody();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		if(response != null)
		  return response.getRates().get("EUR"); 
		else
			return null;
	}

	/**
	 * @param id
	 * @return
	 * Method makes a rest call to fetch Euro conversion rate against given currency for current date of last six months
	 */
	public Map<LocalDate,BigDecimal> getHistory(String id) {
		// TODO Auto-generated method stub
		LocalDate date = LocalDate.now();
		List<ResponseEntity<CurrencyConversionBean>> responseEntity = new ArrayList<>();
		Map<LocalDate,BigDecimal> historyValues = null;
		
		try {
		for(int i=1; i<=6; i++)
		{
		responseEntity.add(new RestTemplate().getForEntity(
		        "https://api.ratesapi.io/api/"+date.minusMonths(i)+"?base="+id+"&symbols=EUR", CurrencyConversionBean.class));
		}
		
		 historyValues = new HashMap<>();
		for( ResponseEntity<CurrencyConversionBean> res : responseEntity)
		{
			historyValues.put(res.getBody().getDate(), res.getBody().getRates().get("EUR"));
			
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
		
		return historyValues;
	}

	/**
	 * @return
	 * Method makes rest call to fetch all the currency rates against EURo for current date of last sixt months
	 */
	public Map<String,List<BigDecimal>> getHistory() {
		// TODO Auto-generated method stub
		LocalDate date = LocalDate.now();
		List<ResponseEntity<CurrencyConversionBean>> responseEntity  =null;
		List<String > baseList = new ArrayList<>();
		baseList.add("USD");
		baseList.add("GBP");
		baseList.add("HKD");
		Map<String,List<BigDecimal> > values = new HashMap<>();
		List<BigDecimal> hsList = null;
		try {
		for(String base : baseList)
		{
			responseEntity = new ArrayList<>();
		for(int i=1; i<=6; i++)
		{
			hsList= new ArrayList<>();
			
		responseEntity.add(new RestTemplate().getForEntity(
		        "https://api.ratesapi.io/api/"+date.minusMonths(i)+"?base="+base+"&symbols=EUR", CurrencyConversionBean.class));
		}
		
		for( ResponseEntity<CurrencyConversionBean> res : responseEntity)
		{
			hsList.add(res.getBody().getRates().get("EUR"));
		}
		values.put(base, hsList);
		
		
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
		return null;
	}
		
		return values;
	
	}

}
