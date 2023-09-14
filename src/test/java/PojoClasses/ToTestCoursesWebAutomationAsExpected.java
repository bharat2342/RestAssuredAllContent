package PojoClasses;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;

import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;

public class ToTestCoursesWebAutomationAsExpected {

	public static void main(String[] args)
	{
		String []Courses= {"Selenium Webdriver Java","Cypress","Protractor"};
		String CodeUrl="https://rahulshettyacademy.com/getCourse.php?state=iwanttoken&code=4%2F0AfgeXvuNORNDv7voIQOXzcjy5baBUeRTvn2JRUz4lSOG5YFqvYqQQOvBbaoLSrZXI3jBpw&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=none"; 
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
	  		//This Code to get Only CoursesList but Not Comparing
	  		    		/*List<WebAutomation_ChildClass> WebAutomationCoursesList=pojoClasses.getCourses().getWebAutomation();
	  		    		
	  		    		for(int i=0;i<WebAutomationCoursesList.size();i++)
	  		    		{
	  		    			
	  		    			String Course=WebAutomationCoursesList.get(i).getCourseTitle();
	  		    			System.out.println(Course);
	  		    			
	  		    		}*/
		//Now we need to Compare with the expected String
	    //DynamicList adding using ArrayList
	    ArrayList<String> Actual= new ArrayList<String>();
	    
	    List<WebAutomation_ChildClass> WebAutomationCoursesList=pojoClasses.getCourses().getWebAutomation();
  		for(int i=0;i<WebAutomationCoursesList.size();i++)
  		{
  			Actual.add(WebAutomationCoursesList.get(i).getCourseTitle());
  			
  		}
  		//Here we cant compare with both Array and ArrayList
  		//So here we convert all into ArrayList Only using the below method
  		//Arrays.aslist()
  		List<String> ExpectedList=Arrays.asList(Courses);
  		Assert.assertEquals(Actual, ExpectedList);
  		//Assert.assertTrue(Actual.equals(ExpectedList)) ;
  		
  		
		
	}

}
