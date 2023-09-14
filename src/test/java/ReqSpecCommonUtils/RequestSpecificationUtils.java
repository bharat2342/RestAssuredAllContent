package ReqSpecCommonUtils;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import ReqSpecCommonUtils.PojoMainForSerializeTest;

public class RequestSpecificationUtils 
{

	public static void main(String[] args) 
	{
		//Instead of Providing the json in Body we need to use serialization concept
		//Now create the Object after creating the POJO classes
		PojoMainForSerializeTest addPlace=new PojoMainForSerializeTest();
		RestAssured.baseURI="https://rahulshettyacademy.com";

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
		
		
		//these are generic for the every request
		 RequestSpecification req=new  RequestSpecBuilder()
		.setBaseUri("https://rahulshettyacademy.com")
		.addQueryParam("key", "qaclick123")
		.setContentType(ContentType.JSON)
		.build();
		
		 
		 ResponseSpecification resspec= new ResponseSpecBuilder()
		.expectStatusCode(200)
		.expectContentType(ContentType.JSON)
		.build();
		
		RequestSpecification res=given().spec(req)
		
		.body(addPlace);
		
		
		
		
		
		Response response=res.when()
		.post("maps/api/place/add/json")
		.then().log().all()
		.spec(resspec).extract().response();
		
		String responseString= response.toString();
		System.out.println(responseString);
		
		
		  JsonPath js=new JsonPath(responseString); String PlaceID=js.get("place_id");
		  System.out.println(PlaceID);
		 
		
		
		

	}

}
