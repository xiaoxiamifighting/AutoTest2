package TestNg_test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test_two {
	@Test
	@Parameters("Browser")
	public static void open(String Browser){
	
		 if(Browser.equalsIgnoreCase("InternetExplorerDriver"))
		{
			System.setProperty("WebDriver.InternetExplorer.driver", ".\\Tools\\chromedriver.exe");
			WebDriver driver = new InternetExplorerDriver();
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
			driver.get("www.baidu.com");
			driver.manage().window().maximize();
			
		}
	/*	if(Browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("Webdriver.chrome.driver", ".\\Tools\\chromedriver.exe");
			
			WebDriver driver = new ChromeDriver();
			driver.get("www.baidu.com");
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			
		}*/
		
	}

}
