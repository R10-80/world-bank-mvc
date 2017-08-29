package com.worldbank.service.impl;

import java.net.URI;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.worldbank.model.Details;
import com.worldbank.model.Income;
import com.worldbank.service.WorldBankDataService;
import com.worldbank.util.JsonParseHelper;
import com.worldbank.util.WorldBankUtil;

@Service
public class WorldBankDataServiceImpl implements WorldBankDataService {

	@Override
	public List<Details> countryParameters(URI uri) {
		WorldBankUtil.setProxyConnection();
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		return JsonParseHelper.parseResult(result);
	}

	@Override
	public List<Income> incomeLevels(String url) {
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(url, String.class);
		return JsonParseHelper.parseIncomeLevels(result);
	}

}
