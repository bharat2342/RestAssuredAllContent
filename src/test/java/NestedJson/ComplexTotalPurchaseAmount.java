package NestedJson;

import org.testng.Assert;

import Files_JSON.JsonFormatMethod;
import io.restassured.path.json.JsonPath;

public class ComplexTotalPurchaseAmount {

	public static void main(String[] args)
	{
		int sum=0;
		JsonPath js= new JsonPath(JsonFormatMethod.coursePrice());
		int coursesTotalCount=js.getInt("Courses.size()");
		
		
		for(int i=0;i<coursesTotalCount;i++)
		{
			int price=js.get("Courses["+i+"].price");
			//System.out.println(price);
			int APICopies=js.get("Courses["+i+"].Copies");
			int purchaseTotal= price*APICopies;
			System.out.println(purchaseTotal);
			sum=sum+purchaseTotal;
		}
		System.out.println(sum);
		
		int totalPrice=js.getInt("Dashboard.purchaseAmount");
		System.out.println(totalPrice);
		Assert.assertEquals(sum, totalPrice);
		
		
		//without testNG method
		/*
		if(totalPrice==sum)
		{
			System.out.println("Yes the purchased amount is matching the sum");
		}
		else
		{
			System.out.println("the purchased amount is not matching total");
		}
		*/

	}

}
