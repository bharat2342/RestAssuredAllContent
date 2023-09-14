package NestedJson;

import Files_JSON.JsonFormatMethod;
import io.restassured.path.json.JsonPath;

public class ComplexUsingForLoop {

	public static void main(String[] args) 
	{
		
		//As the response changes dynamically for courses purchased in real-time 
		//we need to use for-loop
		JsonPath js= new JsonPath(JsonFormatMethod.coursePrice());
		
		int coursesTotalCount=js.getInt("Courses.size()");
		for(int i=0;i<coursesTotalCount;i++)
		{
			String CourseTitles=js.get("Courses["+i+"].title");
			System.out.println(CourseTitles);
			System.out.println(js.get("Courses["+i+"].price"));
			
			
			
			
		}

	}

}
