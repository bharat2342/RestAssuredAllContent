package InterViewQuestions;

import java.util.List;

//Create the pojo by getters and setters(by type all the variables) and then Shift+Alt+S

public class Pojo 
{
	int page;
	int per_page;
	int total;
	int total_pages;
	List<PojoArray> data;         //As data is in array form so we need to write the separate class create POJOarray
	
	public int getPage() 
	{
		return page;
	}
	public void setPage(int page)
	{
		this.page = page;
	}
	public int getPer_page() 
	{
		return per_page;
	}
	public void setPer_page(int per_page) 
	{
		this.per_page = per_page;
	}
	public int getTotal() 
	{
		return total;
	}
	public void setTotal(int total)
	{
		this.total = total;
	}
	public int getTotal_pages()
	{
		return total_pages;
	}
	public void setTotal_pages(int total_pages) 
	{
		this.total_pages = total_pages;
	}
	public List<PojoArray> getData() 
	{
		return data;
	}
	public void setData(List<PojoArray> data) 
	{
		this.data = data;
	}
	
	
	
	

}
