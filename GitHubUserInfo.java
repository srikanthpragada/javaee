package jsonapidemo;

import java.net.URL;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class GitHubUserInfo {

	public static void main(String[] args) throws Exception {

		URL url = new URL("https://api.github.com/users/srikanthpragada");
		
		JsonReader reader = Json.createReader( url.openStream());
		
		JsonObject user = reader.readObject();
		
		System.out.println("Name     : " +  user.getString("name"));
		System.out.println("Location : " +  user.getString("location"));

	}

}
