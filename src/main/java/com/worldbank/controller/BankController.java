package com.worldbank;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.worldbank.model.Countries;

@Controller
public class BankController {

	@RequestMapping(value="/bank.html",method=RequestMethod.GET)
	public String bankHome(Model model){
		
		model.addAttribute("countries", new Countries());
		
		return "bank";
	}
	
	@RequestMapping(value="/worldbank.html",method=RequestMethod.POST)
	public void worldBank(Model model, Countries countries){
		
		String url = "http://api.worldbank.org/countries/ind?format=json";
		
		System.out.println("Countr  " + countries.getCountry());
		
		System.out.println("iso  " + countries.getIsoCode());
		
		RestTemplate restTemplate = new RestTemplate();
		
		String result = restTemplate.getForObject(url, String.class);
		
		System.out.println("Result " + result);
		
		
	}
	
	
}
