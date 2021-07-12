package com.molw.bootscraper.data;

import java.time.ZonedDateTime;
import java.util.HashMap;

public class DigitalCurrencies {

	private HashMap<String, Double> quotes = new HashMap<String, Double>();
	private final ZonedDateTime checkTime = ZonedDateTime.now();

	public DigitalCurrencies(HashMap<String, Double> quotes) {
		this.quotes = quotes;
	}

	public DigitalCurrencies() {}

	public HashMap<String, Double> getQuotes() {
		return quotes;
	}

	public void setQuotes(HashMap<String, Double> quotes) {
		this.quotes = quotes;
	}

	public ZonedDateTime getCheckTime() {
		return checkTime;
	}
}
