/**
 * 
 */
package com.selenium.avi;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.Cookie;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.awt.color.*;


/**
 * @author Avinash
 *
 */
public class firstclass {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","E:\\Avinash\\selenium-java-3.141.59\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://10.0.1.86/tatoc");
		Thread.sleep(2000);
		/* Main Page */
		
		driver.findElement(By.partialLinkText("Basic")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.className("greenbox")).click();
		Thread.sleep(4000);
				
		/* Frames */
	
		 
		driver.switchTo().frame("main");
		WebElement Box1=driver.findElement(By.xpath("//div[contains(text(),'Box 1')]"));
		String Box1rgb = Box1.getCssValue("background-color");
		String box1hexColor= Color.fromString(Box1rgb).asHex();

		WebElement Box2;
		String Box2rgb;
		String box2hexColor;
		
		driver.switchTo().frame("child");
 		Box2 =driver.findElement(By.xpath("//div[contains(text(),'Box 2')]"));
		Box2rgb = Box2.getCssValue("background-color");
		box2hexColor= Color.fromString(Box2rgb).asHex();
        driver.switchTo().parentFrame();
        
		
		while(!box1hexColor.equals(box2hexColor)) {   	
    	    driver.findElement(By.partialLinkText("Repaint Box")).click();
        	driver.switchTo().frame("child");
     		Box2 =driver.findElement(By.xpath("//div[contains(text(),'Box 2')]"));
    		Box2rgb = Box2.getCssValue("background-color");
    		box2hexColor= Color.fromString(Box2rgb).asHex();
    		driver.switchTo().parentFrame();	
       }
		driver.findElement(By.linkText("Proceed")).click();
		Thread.sleep(4000);
		driver.switchTo().defaultContent();
		
		/* DRAG And Drop*/
		
		Actions act=new Actions(driver);
		
		WebElement from= driver.findElement(By.id("dragbox"));
		WebElement to= driver.findElement(By.id("dropbox"));
		 
		act.dragAndDrop(from, to).perform();
		Thread.sleep(2000);
		
		driver.findElement(By.linkText("Proceed")).click();
		Thread.sleep(4000);
		
		/* Launch Popup Window */
		
		String currentWindow= driver.getWindowHandle();
		driver.findElement(By.linkText("Launch Popup Window")).click();
		Thread.sleep(4000);
		
		driver.switchTo().window("popup");
		
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Avinash");
		Thread.sleep(1000);
		
		driver.findElement(By.id("submit")).click();
		Thread.sleep(1000);
		driver.switchTo().window(currentWindow);
		
		driver.findElement(By.linkText("Proceed")).click();
		Thread.sleep(4000);
		
		/* Cookies */
		
		driver.findElement(By.xpath("//a[contains(text(),'Generate Token')]")).click();
		Thread.sleep(3000);
		
		WebElement cookiE= driver.findElement(By.xpath("//span[@id='token']"));
		String c= cookiE.getText();
		String[] split=c.split(": ");
		String value = split[1];
		driver.manage().addCookie(new Cookie("Token",value));
		driver.findElement(By.linkText("Proceed")).click();
		Thread.sleep(5000);
		
		/* Last Page */
		
		driver.findElement(By.linkText("Advanced Course")).click();
		Thread.sleep(4000);
		
		WebElement menuelement = driver.findElement(By.xpath("//span[contains(text(),'Menu 2')]"));
		act.moveToElement(menuelement).perform();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//span[contains(text(),'Go Next')]")).click();
		Thread.sleep(2000);
		
		
			driver.close();
	}
	
}
