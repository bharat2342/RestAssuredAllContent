package InterViewQuestions;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


//To print the Last name using the ObjectMapper
public class UseofJackson
{

	public static void main(String[] args) throws IOException
	{
		File jsonFile = new File("JSONInput.json");
        ObjectMapper objectMapper = new ObjectMapper();
        
        
        JsonNode rootNode = objectMapper.readTree(jsonFile);

        String lastName = rootNode.get("data").get(1).get("last_name").asText();
        System.out.println("Last Name at data[1]: " + lastName);

        
        
        
        
        
        //Other method
        //without index and mapping
       /* 
        File jsonFile = new File("JSONInput.json");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(jsonFile);
        JsonNode dataArray = rootNode.get("data");

        if (dataArray.isArray()) 
        {
            for (JsonNode dataNode : dataArray)
            {
                JsonNode lastNameNode = dataNode.get("last_name");
                if (lastNameNode != null)
                {
                    String lastName = lastNameNode.asText();
                    System.out.println("Last Name: " + lastName);
                }
            }
        }
        */
        
	}

}
