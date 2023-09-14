package RestLibraryAPI;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import Files_JSON.JsonFormatMethod;
import Files_JSON.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class StaticJson 
{

	@Test
	public void addBook()
	{
		RestAssured.baseURI="http://216.10.245.166";
		String response=given().log().all()
		.header("Content-Type","application/json")
		.body(JsonFormatMethod.addBooklibraryAPI())
		.when()
		.post("/Library/Addbook.php")
		.then().log().all()
		.assertThat().statusCode(200)
		.extract().response().asString();
		
		
		//we call reusable method which we created JSON-Object
		JsonPath js=ReusableMethods.rawToJSON(response);
		//JsonPath js=new JsonPath(response);
		String ID=js.getString("ID");
		System.out.println(ID);
		
	}
	
}
