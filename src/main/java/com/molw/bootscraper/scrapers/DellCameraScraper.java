package com.molw.bootscraper.scrapers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class DellCameraScraper {

	//The title for the camera we want
	private static final String model = "Sony Alpha a7 III Mirrorless Camera with FE 28-70 mm F3.5-5.6 OSS Lens";		
	//Computed this in FF and this gives us all the top level boxes
	private static final String boxCSS = "html.no-js body main div.accessories-result.container section#accessories-result-sub section#middle-content div.accessoriesCategoryResults div.accessories-result-product-stack div.no-div-lines-layout div#ps-wrapper.ps";



	public static double scrapeSite(){
		double result = -9999;
		
		try {
			Document doc = Jsoup.connect("https://www.dell.com/en-us/member/shop/camera-photo-video/ar/4005?appliedRefinements=166,193").get();

			//Get just the results "boxes" on the page
			Elements boxes = doc.select(boxCSS).first().getElementsByTag("article");

			//boxes is the list I actually want to run through a stream
			result = boxes.stream()
					// filter out to just the product we want
					.filter(
							box -> model.equals(box.getElementsByClass("ps-title").text())
					)
					//extract the price string and then make sure it can be cast to a double
					.mapToDouble(cameraBox -> Double.parseDouble(cameraBox.getElementsByClass("ps-dell-price ps-simplified").text().replace(",", "").substring(1)))
					//make sure there are no more than 1 value in the resulting stream
					.reduce((a, b) -> {
						throw new IllegalStateException("Multiple Products match on the page: " + a + ", " + b);
					})
					//get the value out of the single element left
					.getAsDouble();

			System.out.println("here");
		} catch (Exception e) {
			System.out.println(" Threw a "+ e.getClass() + " exception with message: " + e.getMessage());
		} finally {
			return result;
		}

	}
}
