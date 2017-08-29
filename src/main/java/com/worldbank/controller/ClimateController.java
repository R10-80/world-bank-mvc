package com.worldbank.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

@Controller
public class ClimateController {

	@Value("${climate.url}")
	private String climateUrl;

	@RequestMapping(value="/climate.html", method=RequestMethod.GET)
	public String climateDetails(@CookieValue(value = "isoCode")String isoCode, Model model){

		System.out.println("Climate Url " + climateUrl);

		System.out.println("From cookie " + isoCode);

		UriTemplate urltemplate = new UriTemplate(climateUrl);
        HashMap<String,String> params = new HashMap<String,String>();

		params.put("type", "mavg");
		params.put("var", "tas");
		params.put("start", "1960");
		params.put("end", "1979");
		params.put("iso", isoCode);
		urltemplate.expand(params);

		System.out.println("Trasform " + urltemplate.expand(params));

		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.getForObject(urltemplate.expand(params), String.class);
		System.out.println(response);

		return "";
	}



}
