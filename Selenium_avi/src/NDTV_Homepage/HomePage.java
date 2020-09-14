package NDTV_Homepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {
	
	WebDriver driver=null ;
	
    public HomePage(WebDriver driver) {
		
		this.driver=driver;
	}
	
	@FindBy(how=How.ID,using="h_sub_menu")
	WebElement SubMenu_Button;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"subnav\"]/div/div/div/div/div/a[8]")
	WebElement Weather_button;
	
	public void SubMenu_Button_click() {
		
		SubMenu_Button.click();
	}
	
	public void Weather_button_click() {
		
		Weather_button.click();
	}
}
