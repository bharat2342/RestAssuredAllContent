package Files_JSON;

import io.restassured.path.json.JsonPath;

public class ReusableMethods 
{
	public static JsonPath rawToJSON(String response)
	{
		JsonPath js1= new JsonPath(response);
		return js1;
		
		
		
	}
	

}
