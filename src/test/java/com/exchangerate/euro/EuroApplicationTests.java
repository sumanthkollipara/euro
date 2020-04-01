package com.exchangerate.euro;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.exchangerate.euro.converter.service.ConverterService;

@RunWith(SpringRunner.class)
@SpringBootTest
class EuroApplicationTests {
	
	ConverterService converterService;

	@Test
	void contextLoads() {
	}
	
	
	@Test
	public void testHomePageData()
	{
		ConverterService converterService = new ConverterService();

		Map<String,BigDecimal>exchangeRate = converterService.getHomePageDetails();
		assertNotNull(exchangeRate);
	}
	@Test
	public void testHistoryPageData()
	{
		ConverterService converterService = new ConverterService();

		Map<LocalDate,BigDecimal>exchangeRate = converterService.getHistory("USD");
		assertNotNull(exchangeRate);
	}
	@Test
	public void testAllHistoryData()
	{
		ConverterService converterService = new ConverterService();

		Map<String,List<BigDecimal>>exchangeRate = converterService.getHistory();
		assertNotNull(exchangeRate);
	}

}
