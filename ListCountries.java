package json;

import java.net.URL;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class ListCountries {

	public static void main(String[] args) throws Exception {

		URL resturl = new URL("https://restcountries.eu/rest/v2/all");
		JsonReader reader = Json.createReader(resturl.openStream());

		JsonArray countries = reader.readArray();

		for (int i = 0; i < countries.size(); i++) {
			JsonObject country = countries.get(i).asJsonObject();
			System.out.printf("%-40s - %s\n", country.getString("name"), country.getString("capital"));

		}

	}

}
