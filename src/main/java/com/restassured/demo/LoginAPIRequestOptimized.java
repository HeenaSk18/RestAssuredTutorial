package com.restassured.demo;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

public class LoginAPIRequestOptimized {

	public static void main(String[] args) {

		baseURI = "http://64.227.160.186:9000/v1";

		Response response = given().header("Content-Type", "application/json")
				.body("{\r\n" + "    \"username\": \"iamfd\",\r\n" + "    \"password\": \"password\"\r\n" + "}")
				.post("login");
		System.out.println(response.asPrettyString());
		System.out.println("STATUS CODE " + response.statusCode());
		System.out.println("RESPONSE TIME " + response.time());
	}

}
