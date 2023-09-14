package PojoClasses;

import static io.restassured.RestAssured.given;

import java.util.List;

import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;

public class ToGetCourseNames 
{

	public static void main(String[] args) 
	{
		String CodeUrl="https://rahulshettyacademy.com/getCourse.php?state=iwanttoken&code=4%2F0AfgeXvvA7AgRYqviv6SzKPZf5O9-v-THCB3iRxe7ZrL6V67mzi29RqIr7yPiv73V7QA5Sg&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=none";
		String partialCode=CodeUrl.split("code=")[1];
	      String codeOnly=partialCode.split("&scope")[0];
	      System.out.println(codeOnly);
	      
	      //Google disabled the Operation of Automations
	      //So testing is not possible we need to do it manually only.
	      String AccessTokenResponse=given()
	    		  .urlEncodingEnabled(false)
	    		  .queryParams("code",codeOnly)
	    		  .queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
	              .queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
	              .queryParams("grant_type", "authorization_code")
	              .queryParams("state", "verifyfjdss")
                .queryParams("session_state", "ff4a89d1f7011eb34eef8cf02ce4353316d9744b..7eb8")
	              
	              .queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
	              .when().log().all()
	              .post("https://www.googleapis.com/oauth2/v4/token").asString();
	    		  System.out.println(AccessTokenResponse);
	              
	    		  JsonPath js= new JsonPath(AccessTokenResponse);
	    		  String TokenID=js.getString("access_token");
	    		  System.out.println(TokenID);
	    		  
	    		  
	    		  String Response=given()
	    				  .contentType("application/json")
	    				  .queryParam("access_token", TokenID)
	    				  .expect().defaultParser(Parser.JSON)
	    					.when()
	    					.get("https://rahulshettyacademy.com/getCourse.php").asString();
	    					System.out.println(Response);
	    					
	    					
	    	//Here we perform some operations and Call all the required methods
	  		    		CreationOfPojoClasses pojoClasses=given().
	    		    				queryParam("access_token", TokenID)
	    		    				.expect().defaultParser(Parser.JSON)
	    		    				.when()
	    		    				.get("https://rahulshettyacademy.com/getCourse.php")
	    		    				.as(CreationOfPojoClasses.class);
	  		    		
	  		//Course Title of WebAutomation
	  		    		List<WebAutomation_ChildClass> WebAutomationCoursesList=pojoClasses.getCourses().getWebAutomation();
	  		    		
	  		    		for(int i=0;i<WebAutomationCoursesList.size();i++)
	  		    		{
	  		    			
	  		    			String Course=WebAutomationCoursesList.get(i).getCourseTitle();
	  		    			System.out.println(Course);
	  		    			
	  		    		}
	}

}
