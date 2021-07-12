package com.molw.bootscraper.sources;

/*

Using this API
https://p.nomics.com/cryptocurrency-bitcoin-api

I think we will fetch - bitcoin, etherium and dogecoin

 */

import com.molw.bootscraper.data.DigitalCurrencies;

import java.util.HashMap;
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

	public static DigitalCurrencies getQuotes(){
		DigitalCurrencies currentPrices = new DigitalCurrencies();
		// TODO  - here is where we put the API calls to get the quotes
		return currentPrices;
		
	}
}
