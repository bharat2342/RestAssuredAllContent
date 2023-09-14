package JiraAPITest;
import static io.restassured.RestAssured.*;

import java.io.File;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;

public class JiraAddCommentForExistingIssue {

	public static void main(String[] args)
	{
		//To add comment for existing Issue/Bug in JIRA
		RestAssured.baseURI="http://localhost:8080";
		
		SessionFilter session= new SessionFilter(); //We get the session Instead of doing google-map type approach
		
		String Response=given()
		.header("Content-type","application/json")
		.body("{\r\n"
				+ "    \"username\":\"gantabharatkumar@gmail.com\",\r\n"
				+ "    \"password\":\"PwdForJira\",\r\n"
			
				+ "    }\r\n"
				+ "")
		
		.log().all()
		.filter(session)
		.when()
		.post("/rest/auth/1/session")
		.then().extract().response().asString();
		
		
		given().pathParam("id", "10101")
		.body("{\r\n"
				+ "    \"fields\": {\r\n"
				+ "       \"project\":\r\n"
				+ "       {\r\n"
				+ "          \"key\": \"TEST\"\r\n"
				+ "       },\r\n"
				+ "       \"summary\": \"REST ye merry gentlemen.\",\r\n"
				+ "       \"description\": \"This is my 1st Issue\",\r\n"
				+ "       \"issuetype\": {\r\n"
				+ "          \"name\": \"Bug\"\r\n"
				+ "       }\r\n"
				+ "   }\r\n"
				+ "}")
		.filter(session)
		.log().all()
		.when()
		.post("/rest/api/2/issue/{id}/comment")
		.then().assertThat().statusCode(201);
		
		
		//Add Attachment in JIRA
		given()
		.header("X-Atlassian-Token", "no-check").filter(session)
		.pathParam("key","10101")
		.header("Content-Type","multi-part/form-data")
		.multiPart("File",new File("jira.txt")) //Java Knows that it is a Text File
		.when()
		.post("rest/api/2/issue/10101/attachments")
		.then()
		.log().all()
		.assertThat().statusCode(200);
		
		
		//Get The Issue from the JIRA both we use Path & Query Parameters
		String IssueDetails=given()
		.filter(session)
		.pathParam("key","10101")
		.queryParam("fields", "comment")
		.when()
		.get("/rest/api/2/issue/{key}")
		.then().log().all()
		.extract().response().asString();
		System.out.println(IssueDetails);
		
		
		
		
		
		
		

	}

}
