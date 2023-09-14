package JiraAPITest;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

public class JiraQueryParamUsage {

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
				
				//Add comment
				String AddCommentResponse=given().pathParam("id", "10101")
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
				.then().assertThat().statusCode(201)
				.extract().response().asString();
				JsonPath js=new JsonPath(AddCommentResponse);
				String CommentID=js.getString("id");
				
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
				
				
				//To validate the ID captured in it with Comment present or not
				JsonPath js1= new JsonPath(IssueDetails);
				int countOfComments=js1.get("fields.comment.comments.size()");
				System.out.println(countOfComments);
				
				for(int i=0;i<countOfComments;i++)
				{
					String CommentIDissue=(js1.get("fields.comment.comments["+i+"].id")).toString();
					if(CommentIDissue.equalsIgnoreCase(CommentID))
					{
						String Message=(js1.get("fields.comment.comments["+i+"].body")).toString();
						System.out.println(Message);
					}
				}
				

	}

}
