package com.restassured.demo;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginAPIRequest {

	public static void main(String[] args) {

		RestAssured.baseURI = "http://64.227.160.186:9000/v1";

		RequestSpecification request = RestAssured.given();

//		I want to attach the Header to the request

		RequestSpecification request2 = request.header("Content-Type", "application/json");

//		I want to Attach the Body

		RequestSpecification request3 = request2
				.body("{\r\n" + "    \"username\": \"iamfd\",\r\n" + "    \"password\": \"password\"\r\n" + "}");

//		I want to httpverb
		Response response= request3.post("login");
		System.out.println(response.asPrettyString());
		System.out.println("STATUS CODE "+ response.statusCode());
		System.out.println("RESPONSE TIME "+ response.time());
	}

}
