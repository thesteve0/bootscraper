package com.molw.bootscraper.sources;

/*

Using this API
https://p.nomics.com/cryptocurrency-bitcoin-api

I think we will fetch - bitcoin, etherium and dogecoin

 */

import com.molw.bootscraper.data.DigitalCurrencies;
import com.molw.bootscraper.data.Quote;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DigiCurrencyFetcher {

	private static final HashMap<String, String> currencies = (HashMap) Stream.of(new String[][]
			{
					{"BTC", "Bitcoin"},
					{"ETC", "Ethereum"},
					{"DOGE", "Dogecoin"},
					{"XCH", "Chia"}
			}
		).collect(Collectors.toMap(data -> data[0], data -> data[1]));
	private final String api_key = System.getenv("nomics_api_key");
	private final String url = "https://api.nomics.com/v1/currencies/ticker?ids=BTC,ETC,DOGE,XCH&interval=1d&key=" + api_key;
	private WebClient webClient = WebClient.builder()
			.baseUrl(url)
			.build();

	public DigitalCurrencies getQuotes(){
		DigitalCurrencies currentPrices = new DigitalCurrencies();
		Mono<List<Quote>> response = webClient.get().accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToMono(new ParameterizedTypeReference<List<Quote>>() {});

		currentPrices.setQuotes( (ArrayList<Quote>) response.block());


		return currentPrices;
		
	}

   	 
}
