package com.restassured.demo;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import io.restassured.http.ContentType;

public class LoginAPIRequestOptimized7 {

	public static void main(String[] args) {

		File loginRequestPayload = new File("src/main/resources/requestPayload/loginRequest.json");

			given()
				.baseUri("http://64.227.160.186:9000/v1")
				.and()
				.contentType(ContentType.JSON)
				.and()
				.accept(ContentType.JSON)
				.and()
						.body(loginRequestPayload)//passwing the requestBodyMap to the body()
						.log().uri()//logs only the URI of the Request
						.log().method()//logs the request http method
						.log().body()//logs the request body
						.log().headers()//logs the request Headers
					.when()//setup
						.post("login")// action
				  .then()//assertion/valdiation
//				    .log().status()//logs the response status code
//				  	.log().body()//logs the response body
				  .log().ifValidationFails()//Conditional Logs
				   .statusCode(200)
				   .and()
				   .body("message", Matchers.equalTo("Ok"))
				   .and()
				   .extract().response();//return validated response
			
//		System.out.println(response.asPrettyString());
//		System.out.println("STATUS CODE " + response.statusCode());
//		System.out.println("RESPONSE TIME " + response.time());
		
	}

}
