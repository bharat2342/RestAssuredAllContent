package NestedJson;

import Files_JSON.JsonFormatMethod;
import io.restassured.path.json.JsonPath;

public class ComplexJSONDummy {

	public static void main(String[] args)
	{
		JsonPath js= new JsonPath(JsonFormatMethod.coursePrice());
		
		//To print the number of courses returned by API
		int coursesTotalCount=js.getInt("Courses.size()"); 
		System.out.println(coursesTotalCount);
		
		
		//Print the purchase amount
		int totalPrice=js.getInt("Dashboard.purchaseAmount");
		System.out.println(totalPrice);
		
		
		
		
		//To print the title of  1st Course
		String firstCourseName=js.get("Courses[0].title");
		System.out.println(firstCourseName);
		
		String secondCourseName=js.get("Courses[1].title");
		System.out.println(secondCourseName);
		
	}

}
