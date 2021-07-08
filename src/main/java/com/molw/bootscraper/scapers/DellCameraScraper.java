package com.molw.bootscraper.scapers;

import com.molw.bootscraper.data.PriceCheck;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class DellCameraScraper {

	private static final StringBuffer model = new StringBuffer("Sony Alpha a7 III Mirrorless Camera with FE 28-70 mm F3.5-5.6 OSS Lens");
	//Computed this in FF and this gives us all the top level boxes
	private static final String boxCSS = "html.no-js body main div.accessories-result.container sectin#accessories-result-sub section#middle-content div.accessoriesCategoryResults div.accessories-result-product-stack div.no-div-lines-layout div#ps-wrapper.ps";
	//private static final String boxCSS = "html.no-js body main div.accessories-result.container section#accessories-result-sub section#middle-content div.accessoriesCategoryResults div.accessories-result-product-stack div.no-div-lines-layout div#ps-wrapper.ps article#aa114449.stack-accessories.ps-stack section.ps-top";


	public static double scrapeSite(){
		double result = -999;
		
		try {
			Document doc = Jsoup.connect("https://www.dell.com/en-us/member/shop/camera-photo-video/ar/4005?appliedRefinements=166,193").get();
			Elements boxes = doc.select(boxCSS).first().getElementsByTag("article");
			//boxes is the list I actually want to run through a stream
			//code below is trying to figure out the filter for the stream
			Element firstBox = boxes.first(); // this is where we would actually start to filter
			boolean ourNode = firstBox.getElementsByClass("ps-title").text().contentEquals(model);
			System.out.println("here");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			return result;
		}

	}
}
