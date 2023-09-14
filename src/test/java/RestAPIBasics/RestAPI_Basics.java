package RestAPIBasics;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*; // To given() package
import static org.hamcrest.Matchers.*;      // To check Equals Method

import Files_JSON.JsonFormatMethod;
public class RestAPI_Basics {

	public static void main(String[] args) 
	{
		//Given-Input parameters //when-submit API- resource http method// then-validate the response
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		//To give the input parameters
		given().log().all()
		.queryParam("key", "qaclick123")
		.header("content-Type","application/json")
		.body(JsonFormatMethod.addPlaceByJSON())   //we create a static method to call the payload form the files package in-order to avoid the long text
		
		// we give the resource and the http method
		.when().post("maps/api/place/add/json")
		
		//To validate the response
		.then().log().all() 
		.statusCode(200)
		.body("scope", equalTo("APP"))
		.header("Server", "Apache/2.4.41 (Ubuntu)");
		
		
		//Add-Place and update the place with that generated ID
		
		

	}

}
