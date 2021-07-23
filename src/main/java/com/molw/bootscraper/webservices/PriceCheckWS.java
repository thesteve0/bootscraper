package com.molw.bootscraper.webservices;


import com.molw.bootscraper.data.DigitalCurrencies;
import com.molw.bootscraper.data.PriceCheck;
import com.molw.bootscraper.sources.DellCameraScraper;
import com.molw.bootscraper.sources.DigiCurrencyFetcher;
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

	@GetMapping("/currency")
	public DigitalCurrencies getDigitaCurrencyQuotes(){
		  DigiCurrencyFetcher dcFetcher = new DigiCurrencyFetcher();
		  return dcFetcher.getQuotes();
		  		
	}


}
