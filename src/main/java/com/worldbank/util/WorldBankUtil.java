package com.worldbank.util;

public final class WorldBankUtil {

	private WorldBankUtil(){

	}

	public static void setProxyConnection(){
		System.getProperties().put("http.proxyHost", "proxy.cognizant.com");
		System.getProperties().put("http.proxyPort", "6050");
	}


}
