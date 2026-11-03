package com.phoenix.requests;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.ANY;
import static io.restassured.http.ContentType.JSON;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import com.restassured.demo.UserCredentials;

public class LoginAPIRequest {

	public static void main(String[] args) {
		UserCredentials userCreds = new UserCredentials("iamfd", "password");

		given()
			.baseUri("http://64.227.160.186:9000/v1")
		.and()
			.contentType(JSON)
			.accept(ANY)
			.body(userCreds)
		.when()
			.post("login")
		.then()
			.statusCode(200)
			.body("message", equalTo("Success"))
			.and()
			.body("data.token", notNullValue())
			.body(matchesJsonSchemaInClasspath("responseSchema/loginAPIResponseSchema.json"));
	}
}