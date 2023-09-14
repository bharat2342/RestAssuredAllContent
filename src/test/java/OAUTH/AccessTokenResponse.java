package OAUTH;

import static io.restassured.RestAssured.given;

import io.restassured.path.json.JsonPath;

public class AccessTokenResponse {

	public static void main(String[] args) 
	{
		//It will still fail because the Code is not correct
		//Again we need to get the Code we use Some Selenium to automate 
		//I created Another Class Called GetCode using Selenium
		  String AccessTokenResponse=given()
		  .queryParams("code","4%2F0AfgeXvsL3UVwORz4P6Avq3OXmCUPhUnFqnB1Ty2IXY2zVlZAwQmZ45F5VJjuN4o37TWpCQ")
		  .queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
          .queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
          .queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
          .queryParams("grant_type", "authorization_code")
          .when().log().all()
          .post("https://www.googleapis.com/oauth2/v4/token").asString();
		  System.out.println(AccessTokenResponse);
          
		  JsonPath js= new JsonPath(AccessTokenResponse);
		  String TokenID=js.getString("access_token");
		  System.out.println(TokenID);
          //.queryParams("state", "verifyfjdss")
          //.queryParams("session_state", "ff4a89d1f7011eb34eef8cf02ce4353316d9744b..7eb8")

       // .queryParam("scope", "email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email")

         

         // .queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")

          
		
		
		String Response=given().queryParam("access_token", "TokenID")
				.when()
				.get("https://rahulshettyacademy.com/getCourse.php").asString();
				System.out.println(Response);


	}

}
