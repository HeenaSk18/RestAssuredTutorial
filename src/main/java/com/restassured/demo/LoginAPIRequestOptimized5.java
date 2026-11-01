package com.restassured.demo;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import io.restassured.http.ContentType;

public class LoginAPIRequestOptimized5 {

	public static void main(String[] args) {
		UserCredentials userCredentials = new UserCredentials("iamfd", "password");


			given()
				.baseUri("http://64.227.160.186:9000/v1")
				.and()
				.contentType(ContentType.JSON)
				.and()
				.accept(ContentType.JSON)
				.and()
						.body(userCredentials)//passwing the requestBodyMap to the body()
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
