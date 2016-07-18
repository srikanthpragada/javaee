package jsonapidemo;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

public class CreateJsonObject {

	public static void main(String[] args) {
 
		 JsonObjectBuilder builder = Json.createObjectBuilder();
		 builder.add("name", "Scott");
		 builder.add("email", "scott@gmail.com");
		 builder.add("mobile", "3939393933");
		 
		 JsonObject object = builder.build();
		 
		 System.out.println(object);

	}

}
