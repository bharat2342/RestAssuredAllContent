package Files_JSON;

public class JsonFormatMethod 
{

	public static String addPlaceByJSON()
	{
		return "{\r\n"
				+ "    \"location\":{\r\n"
				+ "            \"lat\": -38.383494,\r\n"
				+ "            \"lng\": 33.427362\r\n"
				+ "            },\r\n"
				+ "            \"accuracy\": 50,\r\n"
				+ "            \"name\": \"Bharat Kumar Ganta Academy1\",\r\n"
				+ "            \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "            \"address\": \"29, side layout, cohen 09\",\r\n"
				+ "            \"types\": [ \"shoe park\",\r\n"
				+ "                        \"shop\" ],\r\n"
				+ "            \"website\": \"http://google.com\",\r\n"
				+ "            \"language\": \"French-IN\"\r\n"
				+ "				}";
	}
	
	public static String coursePrice()
	{
		
		return "{\r\n"
				+ "  \"Dashboard\":{\r\n"
				+ "    \"purchaseAmount\":910,\r\n"
				+ "    \"website\": \"rahulsettyacademy.com\"\r\n"
				+ "  },\r\n"
				+ "  \"Courses\":[\r\n"
				+ "    {\r\n"
				+ "      \"title\":\"Selenum python\",\r\n"
				+ "    \"price\" : 50,\r\n"
				+ "    \"Copies\":8\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"title\":\"Cypress\",\r\n"
				+ "    \"price\" : 40,\r\n"
				+ "    \"Copies\":3\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"title\":\"API\",\r\n"
				+ "    \"price\" : 45,\r\n"
				+ "    \"Copies\":10\r\n"
				+ "  },\r\n"
				+ "    \r\n"
				+ "  {\r\n"
				+ "    \"title\":\"APPIUM\",\r\n"
				+ "    \"price\" : 70,\r\n"
				+ "    \"Copies\":20\r\n"
				+ "  }\r\n"
				+ "  ] \r\n"
				+ "}";
		
		
		
	}
	
	public static String addBooklibraryAPI()
	{
		return "{\r\n"
				+ "    \"name\":\"Learn Appium Automation with Java\",\r\n"
				+ "    \"isbn\":\"MAINBOOK\",\r\n"
				+ "    \"aisle\":\"16265005\",\r\n"
				+ "    \"author\":\"Ganta Bharat Kumar(GBK)\"\r\n"
				+ "}";
		
		
	}
}
