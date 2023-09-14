package RestLibraryAPI;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Files_JSON.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class DynamicDataProvider 
{
	
	
	@Test(dataProvider="Books Data")
	public void addBookDynamically(String aisle,String isbn)
	{
		
		RestAssured.baseURI="http://216.10.245.166";
		String response=given().log().all()
		.header("Content-Type","application/json")
		.body(JsonFormatMethodDynamic.addBooklibraryAPIDynamic(aisle, isbn))
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
		
		
		//Now how do we add Multiple books and retrieve data from a array
		//So we use Data-Provider annotation
		//delete book also in this code only
	}
		@DataProvider(name="Books Data")
		public Object[][] getBookData()
		{
			//we create Multi-dimensional array lets create a data of 3 books
			return new Object[][] {{"abc","1"},{"def","2"},{"ghi","3"}};
					
		}
	}

