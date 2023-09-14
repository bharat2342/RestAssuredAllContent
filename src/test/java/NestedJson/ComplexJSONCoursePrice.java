package NestedJson;

import Files_JSON.JsonFormatMethod;
import io.restassured.path.json.JsonPath;

public class ComplexJSONCoursePrice {

	public static void main(String[] args) 
	{
		
		JsonPath js= new JsonPath(JsonFormatMethod.coursePrice());
		
		int coursesTotalCount=js.getInt("Courses.size()");
		System.out.println("The Price and copies of the API course");
		for(int i=0;i<coursesTotalCount;i++)
		{
			
			String CourseTitles=js.get("Courses["+i+"].title");
			
			if(CourseTitles.equalsIgnoreCase("API"))
			{
				int APIprice=js.get("Courses["+i+"].price");
				System.out.println("Price of API=" + " " +APIprice);
				
				int APICopies=js.get("Courses["+i+"].Copies");
				System.out.println("The number of Copies="+ " "  +APICopies);
				break;
				
				
			}
			
			
			
		}
		
		
	}

}
