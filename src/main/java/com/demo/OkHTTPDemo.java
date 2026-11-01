package com.demo;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHTTPDemo {

	public static void main(String[] args) throws IOException {
		OkHttpClient client = new OkHttpClient();
		
//		Request Body!!!
		String jsonBody = "{\r\n"
				+ "    \"username\": \"iamfd\",\r\n"
				+ "    \"password\": \"password\"\r\n"
				+ "}";
		
		RequestBody requestBody =RequestBody.create(MediaType.parse("application/json"), jsonBody);
		
		Request request = new Request.Builder().url("http://64.227.160.186:9000/v1/login")
				.post(requestBody).header("Accept", "*/*").build();
		
//		Request ---> GET
		
//		Request request=new Request.Builder().url("https://www.google.com")
//		.get().header("Accept", "*/*").build();
		
		Response response= client.newCall(request).execute();
		System.out.println(response.code());
		System.out.println(response.body().string());

		
		
	}

}
