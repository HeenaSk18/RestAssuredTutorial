package com.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Demo {

	public static void main(String[] args) throws IOException {
//		We want to make an API Request with the help of Java
//		HTTPURL Connection
		
		URL url = new URL("http://www.google.com");
//		Eatablish the onnection
		
	    HttpURLConnection conn =(HttpURLConnection) url.openConnection();
	    conn.setRequestMethod("GET");
	    conn.setRequestProperty("Accept", "*/*");
	    
	    int statusCode=conn.getResponseCode();
	    System.out.println(statusCode);
	    
//	    Write the Code to read the response Body!! HTML
	    
	    InputStream inputStream= conn.getInputStream();
	    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
	    BufferedReader bufferedReader =new BufferedReader(inputStreamReader);
	    
//	    System.out.println(bufferedReader.readLine());
	    String line;
	    StringBuilder sb = new StringBuilder();
	    while((line =bufferedReader.readLine())!=null) {
	    	sb.append(line);
	    	
	    }
	    System.out.println(sb.toString());
	}

}
