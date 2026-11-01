package com.demo;

import java.io.IOException;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;

public class HittpClientDemo {

	public static void main(String[] args) throws IOException, ParseException {
		CloseableHttpClient httpClient= HttpClients.createDefault();
	
		HttpGet httpGet = new HttpGet("https://www.google.com");
		httpGet.addHeader("Accept","*/*");
		
		CloseableHttpResponse response = httpClient.execute(httpGet);
		System.out.println(response.getCode());
		
		HttpEntity entity=response.getEntity();
		System.out.println(EntityUtils.toString(entity));
	
	}

}
