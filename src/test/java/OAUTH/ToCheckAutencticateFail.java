package OAUTH;
import static io.restassured.RestAssured.*;

public class ToCheckAutencticateFail {

	public static void main(String[] args)
	{
		//It gives failed Authentication and Invalid Access-Token
		//So we need the Code Block I have kept in separate class
		String Response=given().queryParam("access_token", "")
		.when()
		.get("https://rahulshettyacademy.com/getCourse.php").asString();
		System.out.println(Response);

	}

}
