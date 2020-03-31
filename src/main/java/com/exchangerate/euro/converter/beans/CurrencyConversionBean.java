package com.exchangerate.euro.converter.beans;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.Map;

public class CurrencyConversionBean {
private String base;
private String symbols;
private LocalDate date;
private Map<String,BigDecimal> rates;
private BigDecimal quantity;
private BigDecimal totalCalculatedAmount;


public String getBase() {
	return base;
}
public void setBase(String base) {
	this.base = base;
}
public String getSymbols() {
	return symbols;
}
public void setSymbols(String symbols) {
	this.symbols = symbols;
}

public LocalDate getDate() {
	return date;
}
public void setDate(LocalDate date) {
	this.date = date;
}
public Map<String, BigDecimal> getRates() {
	return rates;
}
public void setRates(Map<String, BigDecimal> rates) {
	this.rates = rates;
}
public BigDecimal getQuantity() {
	return quantity;
}
public void setQuantity(BigDecimal quantity) {
	this.quantity = quantity;
}
public BigDecimal getTotalCalculatedAmount() {
	return totalCalculatedAmount;
}
public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
	this.totalCalculatedAmount = totalCalculatedAmount;
}

}


