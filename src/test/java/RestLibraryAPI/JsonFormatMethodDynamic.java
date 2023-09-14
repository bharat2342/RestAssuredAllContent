package RestLibraryAPI;

public class JsonFormatMethodDynamic 

{
	
	public static String addBooklibraryAPIDynamic(String aisle, String isbn)
	{
		return "{\r\n"
				+ "    \"name\":\"Learn Appium Automation with Java\",\r\n"
				+ "    \"isbn\":\""+isbn+"\",\r\n"
				+ "    \"aisle\":\""+aisle+"\",\r\n"
				+ "    \"author\":\"Ganta Bharat Kumar(GBK)\"\r\n"
				+ "}";
		
		
	}

}
