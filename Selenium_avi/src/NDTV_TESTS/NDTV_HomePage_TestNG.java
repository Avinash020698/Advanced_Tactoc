package NDTV_TESTS;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import NDTV_Homepage.*;

public class NDTV_HomePage_TestNG {

	static WebDriver driver = null;
	
	@BeforeTest
	public void NDTV_initial() {
		
		System.setProperty("webdriver.chrome.driver","E:\\Avinash\\selenium-java-3.141.59\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ndtv.com/");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}

	@Test
	public void NDTV() throws Exception {
		
		HomePage homepage = PageFactory.initElements(driver, HomePage.class);
		
		homepage.SubMenu_Button_click();
		Thread.sleep(2000);
		homepage.Weather_button_click();
		Thread.sleep(4000);
		
		CityInputsFile input = new CityInputsFile();
		String City1= input.Input(1);
				
		String City2=input.Input(2);
		
		WeatherPage weather= PageFactory.initElements(driver, WeatherPage.class);
        weather.Seach_Box(City1);
        Thread.sleep(4000);
        
        int cityTemp1= weather.checkbox(City1);
        
        weather.clearSeachbox();
        weather.Seach_Box(City2);
        
        int cityTemp2= weather.checkbox(City2);
        
        int Tempdiff = weather.Tempcompare(cityTemp1, cityTemp2);
        
        System.out.println("Temperature differences between cities "+City1+","+City2+" is = "+Tempdiff);
	}
	
	
	
	@AfterTest
	public void NDTV_conclusion() {

		 driver.close();
		 driver.quit();
	}

}
