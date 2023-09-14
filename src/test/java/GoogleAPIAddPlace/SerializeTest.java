package GoogleAPIAddPlace;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class SerializeTest 
{

	public static void main(String[] args) 
	{
		//Instead of Providing the json in Body we need to use serialization concept
		//Now create the Object after creating the POJO classes
		PojoMainForSerializeTest addPlace=new PojoMainForSerializeTest();
		addPlace.setAccuracy(50);
		addPlace.setAddress("Siva Ram Nagar Colony");
		addPlace.setLanguage("Telugu");
		addPlace.setPhone_number("+91-8897583291");
		addPlace.setWebsite("https://booka.com");
		addPlace.setName("Bharat Kumar");
		List<String> myList=new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");
		addPlace.setTypes(myList);
		NestedJSON_ForLocation location= new NestedJSON_ForLocation();
		location.setLatitude(-38.383494);
		location.setLongitude(33.427362);
		addPlace.setLocation(location);
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		Response res=given().log().all()
		
		.queryParam("key", "qaclick123")
		.body(addPlace)
		.when()
		.post("maps/api/place/add/json")
		.then().log().all()
		.assertThat().statusCode(200).extract().response();
		
		String responseString= res.asString();
		System.out.println(responseString);
		System.out.println("aba");
		
		

	}

}
