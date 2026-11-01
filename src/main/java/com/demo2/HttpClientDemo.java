package com.demo2;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class HttpClientDemo {

	public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
		HttpClient client = HttpClient.newHttpClient();//Responsible for Execute Request

		HttpRequest request = HttpRequest.newBuilder().uri(new URI("https://www.google.com")).GET()
				.header("Accept", "*/*").build();//Request

		HttpResponse<String> repsonse = client.send(request, BodyHandlers.ofString());
		System.out.println(repsonse.statusCode());
		System.out.println(repsonse.body());
	}

}
