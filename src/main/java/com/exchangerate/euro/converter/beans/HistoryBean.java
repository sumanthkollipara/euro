package com.exchangerate.euro.converter.beans;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

public class HistoryBean {

	private String base;
	private LocalDate date;
	private BigDecimal rates;
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public BigDecimal getRates() {
		return rates;
	}
	public void setRates(BigDecimal rates) {
		this.rates = rates;
	}
	
	


	
}
