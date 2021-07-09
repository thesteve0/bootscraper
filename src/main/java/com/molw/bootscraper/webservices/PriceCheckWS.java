package com.molw.bootscraper.webservices;


import com.molw.bootscraper.data.PriceCheck;
import com.molw.bootscraper.scrapers.DellCameraScraper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PriceCheckWS {

	@GetMapping("/")
	public PriceCheck checkThePrice(){
		double price = DellCameraScraper.scrapeSite();
		PriceCheck pc = new PriceCheck(price);
		return pc;
	}

}
