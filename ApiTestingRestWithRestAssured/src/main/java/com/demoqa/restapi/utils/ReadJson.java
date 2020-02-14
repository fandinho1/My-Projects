package com.demoqa.restapi.utils;

import com.demoqa.restapi.models.City;
import com.demoqa.restapi.models.Consumer;
import com.demoqa.restapi.models.Employe;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ReadJson {
	
	private ReadJson() {}

	public static City getCityModel(String responseBody) {
		Gson gson = new Gson();
		return gson.fromJson(responseBody, City.class);
	}
	
	public static String getJsonObjectForConsumer(Consumer consumer) {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("FirstName", consumer.getName());
		jsonObject.addProperty("LastName", consumer.getLastName());
		jsonObject.addProperty("UserName", consumer.getUserName());
		jsonObject.addProperty("Password", consumer.getPassword());
		jsonObject.addProperty("Email", consumer.getEmail());
		return jsonObject.toString();		
	}
	
	public static String getJsonObjectForEmploye(Employe employe) {
		Gson gson = new Gson();
		return gson.toJson(employe);
	}

}
