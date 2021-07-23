package com.molw.bootscraper.data;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class DigitalCurrencies {

	private ArrayList<Quote> quotes = new ArrayList<Quote>();
	private final ZonedDateTime checkTime = ZonedDateTime.now();

	public DigitalCurrencies(ArrayList<Quote> quotes) {
		this.quotes = quotes;
	}

	public DigitalCurrencies() {}

	public ArrayList<Quote> getQuotes() {
		return quotes;
	}

	public void setQuotes(ArrayList<Quote> quotes) {
		this.quotes = quotes;
	}

	public ZonedDateTime getCheckTime() {
		return checkTime;
	}
}
