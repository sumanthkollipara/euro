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

@Service
public class ConverterService {
	
	public Map<String,BigDecimal> getHomePageDetails()
	{
		Map< String , BigDecimal> values = new HashMap<String, BigDecimal>();
		
		values.put("USD",getTodayValue("USD")  );
		values.put("GBP",getTodayValue("GBP")  );
		//values.putAll(getTodayValue("HKD")  );
		
		return values;
	}
	
	public BigDecimal getTodayValue(String fromValue )
	{
		 ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity(
			        "http://api.ratesapi.io/api/latest?base="+fromValue+"&symbols=EUR", CurrencyConversionBean.class);
		 
		 CurrencyConversionBean response = responseEntity.getBody();
		  return response.getRates().get("EUR"); 
	}

	public Map<LocalDate,BigDecimal> getHistory(String id) {
		// TODO Auto-generated method stub
		LocalDate date = LocalDate.now();
		List<ResponseEntity<CurrencyConversionBean>> responseEntity = new ArrayList<>();
		
		for(int i=1; i<=6; i++)
		{
		responseEntity.add(new RestTemplate().getForEntity(
		        "https://api.ratesapi.io/api/"+date.minusMonths(i)+"?base="+id+"&symbols=EUR", CurrencyConversionBean.class));
		}
		
		Map<LocalDate,BigDecimal> historyValues = new HashMap<>();
		for( ResponseEntity<CurrencyConversionBean> res : responseEntity)
		{
			historyValues.put(res.getBody().getDate(), res.getBody().getRates().get("EUR"));
			
		}
		
		for(Map.Entry<LocalDate, BigDecimal> set : historyValues.entrySet())
		{
			System.out.println(set.getKey()+"   " + set.getValue());
			
		}
		
		
		return historyValues;
	}

}
