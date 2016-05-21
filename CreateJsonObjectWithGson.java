package jsonapidemo;

import java.util.ArrayList;

import com.google.gson.Gson;

public class CreateJsonObjectWithGson {

	public static void main(String[] args) {
		 Person p = new Person("Srikanth","srikanthpragada@gmail.com","9059057000");
		 Gson gson = new Gson();
         String json =  gson.toJson(p);
         System.out.println(json);
         
         ArrayList<Person> persons = new ArrayList<>();
         persons.add( new Person("Mr. Abc","abc@gmail.com","4949494333"));
         persons.add( new Person("Mr. Xyz","xyz@gmail.com","3433434349"));
         
         json = gson.toJson(persons);
         System.out.println(json);
	}

}
