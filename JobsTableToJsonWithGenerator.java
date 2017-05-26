package json;

import javax.json.Json;
import javax.json.stream.JsonGenerator;

import oracle.jdbc.rowset.OracleCachedRowSet;

public class JobsTableToJsonWithGenerator {

	public static void main(String[] args) throws Exception {
	 
		OracleCachedRowSet crs = new OracleCachedRowSet();
		crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		crs.setUsername("hr");
		crs.setPassword("hr");
		crs.setCommand("select * from jobs");
		crs.execute();

		JsonGenerator jobs  = Json.createGenerator(System.out);
		
		jobs.writeStartArray();
		
		while( crs.next()) {
		     jobs.writeStartObject();
			  jobs.write("id",  crs.getString("job_id"));
			  jobs.write("title", crs.getString("job_title"));
			 jobs.writeEnd();  // end of object 
		}
		jobs.writeEnd(); // end of array 
		
		jobs.close();
		
	}

}
