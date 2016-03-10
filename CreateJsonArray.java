// create JSON array with JSON API

package jsonapidemo;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

public class CreateJsonArray {

	public static void main(String[] args) {
 		
		 JsonArrayBuilder jobs = Json.createArrayBuilder();
		 
		 JsonObjectBuilder builder = Json.createObjectBuilder();
		 builder.add("id", "IT_PROG");
		 builder.add("title", "Programmer");
		 jobs.add(builder.build()); // add object to array builder
		 
		 builder = Json.createObjectBuilder();
		 builder.add("id", "SA_MAN");
		 builder.add("title", "Sales Manager");
		 jobs.add(builder.build()); // add object to array builder
		 
		 System.out.println(jobs.build());
   }
}
