package org.sample;

import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class SnapDeal {
public static void main(String[] args) throws AWTException, InterruptedException, IOException  {
	System.setProperty("webdriver.chrome.driver","c:/Users\\Gayukuttypapa\\eclipse-project\\Snapdeal\\Driver\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.snapdeal.com/");
	WebElement menwatch = driver.findElement(By.id("inputValEnter"));
	menwatch.sendKeys("iphone X");
	Robot g = new Robot(); 
	g.keyPress(KeyEvent.VK_ENTER);
	g.keyRelease(KeyEvent.VK_ENTER);
	/*List<WebElement> image = driver.findElements(By.tagName("img"));
	image.get(1).click();*/
	WebElement phone = driver.findElement(By.xpath("//p[text()='Apple iPhone 6s ( 32GB , 2 GB ) Space Grey']"));
	phone.click();
		String parent = driver.getWindowHandle();
	Set<String> allwindow = driver.getWindowHandles();
	
	for (String Q: allwindow) {
		if (!(Q.equals(parent))) {
			driver.switchTo().window(Q);
		}
	}
		WebElement addcart = driver.findElement(By.xpath("//span[text()='add to cart']"));
		addcart.click();
		
		
		//WebElement cart = driver.findElement(By.xpath("//span[text()='cart']"));
		//cart.click();
		Thread.sleep(1500);
		TakesScreenshot tk=(TakesScreenshot)driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File des=new File("C:\\Users\\Gayukuttypapa\\eclipse-project\\Snapdeal\\Screenshot\\Payment.png");
		FileUtils.copyFile(src, des);
			
		
		
		}
	}
	

	
	
	

