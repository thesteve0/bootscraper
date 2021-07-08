package com.molw.bootscraper.webservices;


import com.molw.bootscraper.data.PriceCheck;
import com.molw.bootscraper.scapers.DellCameraScraper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PriceCheckWS {

	@GetMapping("/")
	public PriceCheck checkThePrice(){
		double price = DellCameraScraper.scrapeSite();
		PriceCheck pc = new PriceCheck(35.5);
		return pc;
	}

}
