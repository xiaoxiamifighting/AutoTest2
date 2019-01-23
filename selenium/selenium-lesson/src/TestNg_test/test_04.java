package TestNg_test;

import java.util.concurrent.TimeUnit;


import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.log4testng.Logger;

public class test_04 {
/*public static void main(String[] args){
		System.out.println("hh");
		
	}
	public static void main1(String[] args){
		
		   
		Logger logger=Logger.getLogger(test_04);
			 
		PropertyConfigurator.configure(".\\Log4j.properties");
			 
			 // 打开浏览器
		System.setProperty("webdriver.chrome.driver", ".\\Tools\\chromedriver.exe");  
		WebDriver driver = new ChromeDriver(); 
		logger.info("启动浏览器");
		     
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logger.info("隐式等待10秒");
		     
		driver.get("https://www.baidu.com");
		logger.info("打开百度首页");
		     
		driver.findElement(By.id("kw")).sendKeys("Selenium");
		logger.info("在搜索输入框输入selenium");
		     
		     
		}*/
		 WebDriver driver;
		  @Test
		  public void f() {
			  driver.get("https://www.baidu.com");
		  }
		  @Test(dependsOnMethods={"f"})
		  public void a(){
			  System.out.println(driver.getCurrentUrl());
			  Reporter.log("你好嗷嗷嗷");
		  }
		  @Test(enabled=false)
		  public void b(){
			  System.out.print("b");
		  }
		  @BeforeClass
		  public void beforeClass() {
			  System.setProperty("WebDriver.chrome.driver", ".\\Tools\\chromedriver.exe");
				 driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);	
		  }

		  @AfterClass
		  public void afterClass() {
			  driver.quit();
		  }
	 



}
