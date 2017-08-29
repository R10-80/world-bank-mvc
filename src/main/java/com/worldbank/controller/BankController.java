package com.worldbank.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriTemplate;

import com.worldbank.exception.WordBankException;
import com.worldbank.model.Countries;
import com.worldbank.model.Details;
import com.worldbank.model.Income;
import com.worldbank.service.WorldBankDataService;

@Controller
public class BankController {

	@Value("${countries.url}")
	private String countryUrl;

	@Value("${incomelevels.url}")
	private String incomeLevelsUrl;

	@Autowired
	private WorldBankDataService worldBankDataService;

	@RequestMapping(value="/bank.html",method=RequestMethod.GET)
	public String bankHome(Model model){

		model.addAttribute("countries", new Countries());

		return "bank";
	}

	@RequestMapping(value="/worldbank.html",method=RequestMethod.POST)
	public ModelAndView worldBank(Model model, Countries countries,HttpServletResponse response) {

		UriTemplate urltemplate = new UriTemplate(countryUrl);
        HashMap<String,String> params = new HashMap<String,String>();
        params.put("isoCode", countries.getIsoCode());

        List<Details> details = worldBankDataService.countryParameters(urltemplate.expand(params));

        model.addAttribute("provider", "World Bank API");

		Cookie cookie = new Cookie("isoCode", countries.getIsoCode());
		response.addCookie(cookie);
		return new ModelAndView("details","detail",details);

	}

	@RequestMapping(value="/incomeLevels.html",method=RequestMethod.GET)
	public String incomeLevels(Model model) {
		List<Income> incomeList = worldBankDataService.incomeLevels(incomeLevelsUrl);
		System.out.println(incomeList);
		model.addAttribute("income", incomeList);
		return "details";
	}

	@ExceptionHandler(WordBankException.class)
	public ModelAndView handleCustomException(WordBankException ex) {

		ModelAndView model = new ModelAndView("exception");

		model.addObject("errCode", ex.getCode());
		model.addObject("errMsg", ex.getMessage());

		return model;

	}


}
