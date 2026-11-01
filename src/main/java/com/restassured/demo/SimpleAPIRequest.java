package com.restassured.demo;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SimpleAPIRequest {

	public static void main(String[] args) {
		
//		I want to make a simple GET Request to get google.com
		
//		Base URL https://www.google.com
//		ENDPOINT NA
//		HTTPVERD GET
//		HEADER Accept
//		BODY XX
		
		RestAssured.baseURI = "https://www.google.com";
		
//		Request Specification?? Interface --- allows us to pass to configure various important information for the
//		request
//		endpoint, base url, httpverb, headers, payload(body)
		
		RequestSpecification request= RestAssured.given();
		RequestSpecification request2= request.header("Accept","*/*");
		Response response= request2.get();
		
		System.out.println(response.asPrettyString());
		System.out.println("STATUS CODE "+ response.statusCode());
		System.out.println("RESPONSE TIME "+ response.time());
		
		
	}

}
	