package RestAPIBasics;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import Files_JSON.JsonFormatMethod;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class RestAssured_Chaining_IntoString {

	public static void main(String[] args) 
	{
		//Given-Input parameters //when-submit API- resource http method// then-validate the response
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
				// This simple JSON-and we need to parse the data
				
	}

}
