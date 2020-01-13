package org.yenbo.awssdkdemo.iot;

import java.time.ZonedDateTime;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ShadowJsonFactory {

	private static Gson gson = new Gson();
	
	public static String getShadowJson(HashMap<String, Object> properties) {
				
		JsonObject state = new JsonObject();
		state.add("desired", gson.toJsonTree(properties));
		
		JsonObject payload = new JsonObject();
		payload.add("state", state);
		
		return gson.toJson(payload);
	}
	
	public static String getShadowJson() {
		
		HashMap<String, Object> properties = new HashMap<>();
		properties.put("time", ZonedDateTime.now().toString());
		properties.put("millis", ZonedDateTime.now().toEpochSecond());
		
		return getShadowJson(properties);
	}
}
