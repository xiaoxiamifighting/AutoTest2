package TestNg_test;
import java.util.concurrent.TimeUnit;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNg_one {
	
	@Test
	public void hello(){
		System.out.println("hello");
	}

		//WebDriver driver;
	
/*	@Test
	public void openBaidu(){
		driver.get("https://www.baidu.com");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}
	@BeforeClass
	public void beforeClass(){
		System.setProperty("Webdriver.chrome.driver", ".\\Tools\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
	}
	@AfterClass
	public void afterClass(){
		driver.quit();
		
	}*/
	

}
