package PojoClasses;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;

public class ToGetCodeUsingSeleniumandOperationsOFNESTEDJSON 
{

	public static void main(String[] args)
	{
		/*
		 * System.setProperty("webdriver.gecko.driver",
		 * "D:\\Testing_Practice\\geckodriver.exe"); WebDriver driver=new
		 * FirefoxDriver(); driver.get(
		 * "https://accounts.google.com/o/oauth2/v2/auth/identifier?scope=https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&auth_url=https%3A%2F%2Faccounts.google.com%2Fo%2Foauth2%2Fv2%2Fauth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&redirect_uri=https%3A%2F%2Frahulshettyacademy.com%2FgetCourse.php&response_type=code&state=iwanttoken&service=lso&o2v=2&flowName=GeneralOAuthFlow"
		 * ); //Enter the Login and Pwd Details
		 * driver.findElement(By.id("identifierId")).sendKeys("bkbharatkumar007");
		 * driver.findElement(By.id("identifierNext")).click(); //Pwd
		 * 
		 * driver.findElement(By.id("identifierPwd")).sendKeys("hero");
		 * driver.findElement(By.id("identifierNext")).click(); String
		 * CodeUrl=driver.getCurrentUrl(); System.out.println(CodeUrl);
		 */
	      // Now we got entire URL
	      //But we need only ?Code only how do we get
	      //Parse the URL
		  String CodeUrl="https://rahulshettyacademy.com/getCourse.php?state=iwanttoken&code=4%2F0AfgeXvurgfCmqzDCKo6QkTt9XyTRvhJeAzdKsM8dQxIwOVu7DW1mKQXXuytG5ftp6bhVDw&scope=email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&authuser=0&prompt=none";
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
	    					
	    					
	    // So here we got the response and then we call the classes using POJO
	    //Now we manipulate with some operations
	    //Always we need to update the CodeURL mentioned at start of the code
	    					
	    		//Here we perform some operations and Call all the required methods
	    		CreationOfPojoClasses pojoClasses=given().
	    				queryParam("access_token", TokenID)
	    				.expect().defaultParser(Parser.JSON)
	    				.when()
	    				.get("https://rahulshettyacademy.com/getCourse.php")
	    				.as(CreationOfPojoClasses.class);
	    		
	    		
	    		System.out.println(pojoClasses.getLinkedIn());
	    		System.out.println(pojoClasses.getInstructor());
	    		
	    		String APICourseTitle=pojoClasses.getCourses().getApi().get(1).getCourseTitle();
	    		System.out.println(APICourseTitle);
	    		
	    //As every time we cant give index so we need to obtain dynamically
	    		
	    		List<Api_ChildClass> APICoursesList=pojoClasses.getCourses().getApi();
	    		
	    		for(int i=0;i<APICoursesList.size();i++)
	    		{
	    			if(APICoursesList.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing"));
	    			{
	    				String APIPrice=APICoursesList.get(i).getPrice();
	    				System.out.println(APIPrice);
	    			}
	    		}
	}

}
