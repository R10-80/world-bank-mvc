package com.worldbank.util;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.worldbank.exception.WordBankException;
import com.worldbank.model.Details;
import com.worldbank.model.Income;

public final class JsonParseHelper {

	private JsonParseHelper(){

	}

	public static List<Details> parseResult(String result) throws WordBankException {
		List<Details> detailsForm = new ArrayList<Details>();
		JSONParser parser = new JSONParser();
		try {
			if(parser.parse(result) instanceof JSONArray){
				JSONArray resultJson = (JSONArray) parser.parse(result);
				JSONObject validate = (JSONObject) resultJson.get(0);
				if(validate.containsKey("message")){
					JSONArray details = (JSONArray) validate.get("message");
					JSONObject detail = (JSONObject) details.get(0);
					throw new WordBankException("Country Code", detail.get("key").toString());
				}
				if(validate.containsKey("total")){
					JSONArray details = (JSONArray) resultJson.get(1);
					JSONObject region = (JSONObject) details.get(0);
					JSONObject regVal = (JSONObject) region.get("region");
					JSONObject income = (JSONObject) region.get("incomeLevel");
					String longitude = (String) region.get("longitude");
					String latitude = (String) region.get("latitude");
					String capitalCity = (String) region.get("capitalCity");

					Details detail = new Details();
					detail.setCapitalCity(capitalCity);
					detail.setIncomeLevel(income.get("value").toString());
					detail.setLatitude(latitude);
					detail.setLongitude(longitude);
					detail.setRegion(regVal.get("value").toString());

					detailsForm.add(detail);
				}
     		}else{
     			throw new WordBankException("InvalidData", "Invalid Data Format returned by World Bank API");
     		}

		} catch (ParseException e) {
			e.printStackTrace();
		}

		return detailsForm;
	}

	public static List<Income> parseIncomeLevels(String input) {

		JSONParser parser = new JSONParser();
		List<Income> incomeList = new ArrayList<Income>();
		try {
			if (parser.parse(input) instanceof JSONArray) {
				JSONArray resultJson = (JSONArray) parser.parse(input);
				JSONArray incomeArray = (JSONArray) resultJson.get(1);
				for(int i=0; i < incomeArray.size(); i++){
					JSONObject inc = (JSONObject) incomeArray.get(i);
					Income income = new Income();
					income.setId(inc.get("id").toString());
					income.setDesc(inc.get("value").toString());
					incomeList.add(income);
				}

			} else {
				throw new WordBankException("InvalidData",
						"Invalid Data Format returned by World Bank API");
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return incomeList;

	}

}
