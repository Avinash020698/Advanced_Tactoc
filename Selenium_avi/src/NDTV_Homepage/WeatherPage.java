package NDTV_Homepage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class WeatherPage {
	
	WebDriver driver =null;
	
	public WeatherPage(WebDriver driver) {
		
		this.driver = driver;
	}

	@FindBy(how=How.XPATH,using="//input[@id='searchBox']") WebElement Search;
	
	public void Seach_Box(String cityName) {
		
		Search.sendKeys(cityName);
	}
	
	
	public int checkbox(String cityname) {
		
         List<WebElement> checkbox = driver.findElements(By.xpath("//input[@type='checkbox']"));
         int cityTemp = 0;
        
        for(int i=0;i<checkbox.size();i++)
        {
        	WebElement check = checkbox.get(i);
        	
        	String city = check.getAttribute("id");
        	if(city.equalsIgnoreCase(cityname)) 
        	{
        	    if(!check.isSelected())
        	    {
        	    	check.click();
        	    }
       
           	    WebElement city1= driver.findElement(By.xpath("//div[@title='"+city+"']/div[@class='temperatureContainer']/span[@class='tempRedText']"));
        	    cityTemp = Integer.parseInt(city1.getText().substring(0,2));   	    
        	}
        }
        
        return cityTemp;
	}
	
	public void clearSeachbox() {
		
		Search.clear();
	}
	
	public int Tempcompare(int temp1,int temp2) {
		
		if(temp1>temp2)
		{
		  return (temp1-temp2);
	    }
		else
		{
	      return (temp2-temp1);
		}
	}
}