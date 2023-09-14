package EcommerceAPI;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

public class CreateLoginandTokenID 
{

	public static void main(String[] args) 
	{
	RequestSpecification req=new RequestSpecBuilder()
		.setBaseUri("https://rahulshettyacademy.com")
		.setContentType(ContentType.JSON)
		.build();
		
	//Create Object of POJO
	PojoLogin login=new PojoLogin();
	login.setUserEmail("bkbharatkumar007@gmail.com");
	login.setUserPassword("Iambharat93@");
	
	
	RequestSpecification reqLogin=
			given().log().all()
			.spec(req)
	//get access from the Pojo class create object for that and parse into body
	        .body(login);
	
	       LoginResponse requestLogin=
	    		   reqLogin.when().post("/api/ecom/auth/login")
	        .then().log().all()
	        .extract().response()
	        .as(LoginResponse.class);
	      System.out.println(requestLogin.getToken());
	      String token=requestLogin.getToken();
	      System.out.println(requestLogin.getUserId());
	      String UserID=requestLogin.getUserId();
	      
	      
	      //Add Product
	      RequestSpecification addProductBaseReq=new RequestSpecBuilder()
	    			.setBaseUri("https://rahulshettyacademy.com")
	    			.addHeader("Authorization", token )
	    			.build();
	     RequestSpecification reqAddProduct= given().log().all()
	      .spec(addProductBaseReq)
	      .param("productName", "laptopCreate")
	      .param("productAddedBy", UserID)
	      .param("productCategory", "fashion")
	      .param("productSubCategory", "shirts")
	      .param("productPrice", "11500")
	      .param("productDescription", "Addias Originals")
	      .param("productFor", "women")
	      //.param("productImage", "Addias Originals") //Here Image should be sent via rest-assured
	      .multiPart("productImage", new File("D:\\Testing_Practice\\Rest_assured_Tutorials\\RestAssured_Tutorialsby-RahulShetty\\DummyFiles\\Nature.jpg"));
	      
	    
	    String addproductresponse= reqAddProduct.when().post("/api/ecom/product/add-product")
	     .then().log().all()
	     .extract().response()
	     .asString();
	    JsonPath js=new JsonPath(addproductresponse);
	   String createProductID= js.get("productId");
	   System.out.println(createProductID);
	   
	   
	   
	   
	   //create order and check-out
	   
		
		  RequestSpecification createOrderBaseReq=new RequestSpecBuilder()
		  .setBaseUri("https://rahulshettyacademy.com") 
		  .addHeader("Authorization",token ) 
		  .setContentType(ContentType.JSON) .build();
		  
		  PojoOrderDetails orderDetails= new PojoOrderDetails();
		  orderDetails.setCountry("India");
		  orderDetails.setProductOrderedId(createProductID);
		  
		  List<PojoOrderDetails> orderDetailsList= new ArrayList<PojoOrderDetails>();
		  orderDetailsList.add(orderDetails); //We add the orderDetails PojoOrders
		  PojoOrders orders=new PojoOrders(); 
		  orders.setOrders(orderDetailsList);
		  
		  
		  
		  
		  RequestSpecification createOrderReq= given().log().all()
		  .spec(createOrderBaseReq) .body(orders);
		  
		  String responseAddOrderandCheckout= createOrderReq.when().post("/api/ecom/product/add-product")
		  .then().log().all() .extract().response().asString();
		  System.out.println(responseAddOrderandCheckout);
		 
	  
	  
	  // delete the product
	  RequestSpecification deleteProdBaseReq=new RequestSpecBuilder()
	   			.setBaseUri("https://rahulshettyacademy.com")
	   			.addHeader("Authorization", token )
	   			.setContentType(ContentType.JSON)
	   			.build();
	  
	  
	 RequestSpecification deleteProdReq= given().log().all()
	  .spec(deleteProdBaseReq)
	  .pathParam("productId", createProductID);
	  
	  String deleteProductresponse =deleteProdReq.when().delete("/api/ecom/product/delete-product/{productId}")
	  .then().log().all().extract().response().asString();
	  
	   JsonPath js1=new JsonPath(deleteProductresponse);
	   Assert.assertEquals("Product Deleted Successfully", js1.get("message"));
	   //String deleteProductMsg= js1.get("message");
	   //System.out.println(deleteProductMsg);
	  
			   
			 
			   
	  
	  
	  
	  
	}

}
