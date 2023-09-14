package RestAPIBasics;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;

import Files_JSON.JsonFormatMethod;
import Files_JSON.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class UpdatethePlace {

	public static void main(String[] args) 
	{
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		//To give the input parameters
		String response=given()
		.queryParam("key", "qaclick123")
		.header("content-Type","application/json")
		.body(JsonFormatMethod.addPlaceByJSON())   //we create a static method to call the payload form the files package in-order to avoid the long text
		
		// we give the resource and the http method
		.when().post("maps/api/place/add/json")
		
		//To validate the response
		.then() 
		.statusCode(200)
		.body("scope", equalTo("APP"))
		.header("Server", "Apache/2.4.41 (Ubuntu)")
		.extract().asString();					//We need to extract the string and then we parse it
		System.out.println(response);
		
		//We got the place-ID now we need to hold the body
		JsonPath js= new JsonPath(response);
		String placeID=js.getString("place_id");
		System.out.println(placeID);
		
		String newAddress="Siva Ram Nagar Colony,Bondilipuram-SKLM";
		
		
		//We validate all without using TestNG methods as Rest-Assured provided some of them
		//update the place
		given()
		.log().all()
		.queryParam("key", "qaclick123")
		.header("content-Type","application/json")
		.body("{\r\n"
				+ "    \"place_id\":\""+placeID+"\",\r\n"
				+ "    \"address\":\""+newAddress+"\",\r\n"
				+ "    \"key\":\"qaclick123\"\r\n"
				+ "    }\r\n"
				+ "")
		.when().put("maps/api/place/update/json")
		
		.then().assertThat()
		.log().all()
		.statusCode(200)
		.body("msg",equalTo("Address successfully updated"));
		
		
		//Get the updated details
		String getPlaceresponse= 
				given().log().all()
				.queryParam("key", "qaclick123")
				.queryParam("place_id", placeID)
				.when().get("maps/api/place/get/json")
				.then().log().all() 
				.assertThat()
				.statusCode(200).extract().response().asString();
		
		//JsonPath js1=ReusableMethods.rawToJSON(getPlaceresponse);
		JsonPath js1= new JsonPath(getPlaceresponse);
		String actualAddress=js1.getString("address");
		System.out.println(actualAddress);
		
		//Simple TestNG Assert-command
		Assert.assertEquals(actualAddress, newAddress);
		
				
		
		
		
		
	}

}
