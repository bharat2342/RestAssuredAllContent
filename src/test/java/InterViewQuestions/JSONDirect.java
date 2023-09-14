package InterViewQuestions;

import java.io.File;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;

import io.restassured.path.json.JsonPath;

public class JSONDirect
{

	public static void main(String[] args) throws IOException 
	{
		String json = "{\n" +
                "    \"page\": 2,\n" +
                "    \"per_page\": 6,\n" +
                "    \"total\": 12,\n" +
                "    \"total_pages\": 2,\n" +
                "    \"data\": [\n" +
                "        {\n" +
                "            \"id\": 7,\n" +
                "            \"email\": \"michael.lawson@reqres.in\",\n" +
                "            \"first_name\": \"Sai\",\n" +
                "            \"last_name\": \"Goutham\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 8,\n" +
                "            \"email\": \"lindsay.ferguson@reqres.in\",\n" +
                "            \"first_name\": \"Ram\",\n" +
                "            \"last_name\": \"Krishna\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
		
		
		
		JSONObject jsonObject = new JSONObject(json);
        JSONArray dataArray = jsonObject.getJSONArray("data");

        if (dataArray.length() > 1) 
        {
            JSONObject secondObject = dataArray.getJSONObject(1);
            String lastName = secondObject.getString("last_name");
            System.out.println("Last Name: " + lastName);
        }
	       

	}

}
