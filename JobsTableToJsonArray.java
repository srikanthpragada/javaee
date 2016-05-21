package jsonapidemo;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;

import oracle.jdbc.rowset.OracleCachedRowSet;

public class JobsTableToJsonArray {

	public static void main(String[] args)  throws Exception {
		OracleCachedRowSet crs = new OracleCachedRowSet();
		crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		crs.setUsername("hr");
		crs.setPassword("hr");
		crs.setCommand("select * from jobs");
		crs.execute();

		JsonArrayBuilder jobsBuilder = Json.createArrayBuilder();
		
		while( crs.next()) {
			 JsonObjectBuilder builder = Json.createObjectBuilder();
			 builder.add("id",  crs.getString("job_id"));
			 builder.add("title", crs.getString("job_title"));
			 
			 jobsBuilder.add( builder.build());  // add to array builder
		}
		
		System.out.println( jobsBuilder.build());
	}

}
