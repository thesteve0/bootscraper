package com.molw.bootscraper.data;

import java.time.ZonedDateTime;

public class PriceCheck {
	private double price;
	private final ZonedDateTime checkTime = ZonedDateTime.now();

	public PriceCheck(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public ZonedDateTime getCheckTime() {
		return checkTime;
	}

	@Override
	public String toString() {
		return "PriceCheck{" +
				"price=" + price + "," +
				"timestamp=" + checkTime +
				'}';
	}
}
