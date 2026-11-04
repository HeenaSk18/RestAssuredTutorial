package com.phoenix.requests;

import static io.restassured.RestAssured.*;
import static io.restassured.http.ContentType.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import static org.hamcrest.Matchers.*;

import com.restassured.demo.UserCredentials;


public class LoginAPIRequest {

	public static void main(String[] args) {
		UserCredentials userCreds = new UserCredentials("iamfd", "password"); //POJO clss called model

		given()
			.baseUri("http://64.227.160.186:9000/v1")
		.and()
			.contentType(JSON)
			.accept(ANY)
			.body(userCreds)
		.when()
			.post("login")
		.then()
			.log().all()	
			.statusCode(200)
			.body("message", equalTo("Success"))
			.and()
			.body("data.token", notNullValue())
			.body(matchesJsonSchemaInClasspath("responseSchema/loginAPIResponseSchema.json"))
//		    .body(matchesJsonSchemaInClasspath("responseSchema/userDetailsResponseSchema.json"))
			.time(lessThan(15000L));
		
	}
}