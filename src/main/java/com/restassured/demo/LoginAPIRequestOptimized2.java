package com.restassured.demo;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

public class LoginAPIRequestOptimized2 {

	public static void main(String[] args) {


		Response response =

			given()
				.baseUri("http://64.227.160.186:9000/v1")
				.and()
				.header("Content-Type", "application/json")
				.and()
						.body("{\r\n" + "    \"username\": \"iamfd\",\r\n" + "    \"password\": \"password\"\r\n" + "}")
						.log().all()
					.when()//setup
						.post("login")// action
				  .then()//assertion/valdiation
				   .log().all()
				   .statusCode(200)
				   .and()
				   .extract().response();//return validated response
//		System.out.println(response.asPrettyString());
//		System.out.println("STATUS CODE " + response.statusCode());
//		System.out.println("RESPONSE TIME " + response.time());
		
	}

}
