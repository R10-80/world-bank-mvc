package com.worldbank.service;

import java.net.URI;
import java.util.List;

import com.worldbank.model.Details;
import com.worldbank.model.Income;

public interface WorldBankDataService {

     public List<Details> countryParameters(URI uri);

     public List<Income> incomeLevels(String url);

}
