package PojoClasses;

import java.util.List;

public class CoursesNestedJSON_Child 
{
	//Since we are expecting the array so we give List of elements in it
	private List<WebAutomation_ChildClass> webAutomation;
	private List<Api_ChildClass> api;
	private List<Mobile_ChildClass> mobile;
	
	public List<WebAutomation_ChildClass> getWebAutomation() 
	{
		return webAutomation;
	}
	public void setWebAutomation(List<WebAutomation_ChildClass> webAutomation) 
	{
		this.webAutomation = webAutomation;
	}
	
	
	public List<Api_ChildClass> getApi() 
	{
		return api;
	}
	public void setApi(List<Api_ChildClass> api) 
	{
		this.api = api;
	}
	
	
	public List<Mobile_ChildClass> getMobile() 
	{
		return mobile;
	}
	public void setMobile(List<Mobile_ChildClass> mobile) 
	{
		this.mobile = mobile;
	}

	

}
