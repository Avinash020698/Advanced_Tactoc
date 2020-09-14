package com.selenium.avi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.sql.*;


public class AdvancedCourse{

	public static void main(String[] args) throws InterruptedException,Exception {
		System.setProperty("webdriver.chrome.driver","E:\\Avinash\\selenium-java-3.141.59\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://10.0.1.86/tatoc");
		Thread.sleep(2000);
		
		driver.findElement(By.linkText("Advanced Course")).click();
		Thread.sleep(4000);
		
		Actions act=new Actions(driver);
		
		WebElement menuelement = driver.findElement(By.xpath("//span[contains(text(),'Menu 2')]"));
		act.moveToElement(menuelement).perform();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//span[contains(text(),'Go Next')]")).click();
		Thread.sleep(2000);
		
			WebElement symbol =driver.findElement(By.xpath("//div[@id='symboldisplay']"));
			String s1= symbol.getText();
			System.out.println(s1);
			String uname = null;
			String pass= null;
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://10.0.1.86/tatoc","tatocuser","tatoc01");
			Statement st= con.createStatement();
			String sql= "SELECT * FROM credentials INNER JOIN identity ON credentials.id=identity.id WHERE identity.symbol ='"+s1+"' ";
			ResultSet rs = st.executeQuery(sql);
			
			
			while(rs.next())
			{
				uname= rs.getString(2);
				pass= rs.getString(3);
				System.out.println(uname+pass);
			}
			
			driver.findElement(By.xpath("//input[@id='name']")).sendKeys(uname);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='passkey']")).sendKeys(pass);
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//input[@id='submit']")).click();
			Thread.sleep(3000);
			
		con.close();	
	
		
			driver.close();

	}

}
