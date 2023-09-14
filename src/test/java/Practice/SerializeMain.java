package Practice;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SerializeMain {

	public static void main(String[] args) 
	{
		NestedJSONInterviewQuestion jq=new NestedJSONInterviewQuestion();
		ChildJSON cq=new ChildJSON();
		
		cq.setCity("naist street");
		cq.setStreetAddress("Nara");
		jq.setAddress(cq);
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		Response res=given().log().all()
		
		.queryParam("key", "qaclick123")
		.body(jq)
		.when()
		.post("maps/api/place/add/json")
		.then().log().all()
		.assertThat().statusCode(200).extract().response();
		
		
		
		String responseString= res.asString();
		
		System.out.println(responseString);
	
	}

}
