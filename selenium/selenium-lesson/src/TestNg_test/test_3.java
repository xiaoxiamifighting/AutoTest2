package TestNg_test;
import java.util.concurrent.TimeUnit;






import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class test_3 {
/*	public static void main(String[] args)

	{
		System.out.println("hello");
	}*/
/*	WebDriver driver;
	
	@BeforeClass
	public void beforeClass(){
		System.setProperty("WebDriver.chrome.driver", ".\\Tools\\chromedriver.exe");
		 driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);	
	}
	@Test
	public void openBaidu() throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		driver.get("https://www.baidu.com");
		Thread.sleep(200);
		driver.getCurrentUrl();
	}
*/
	
/*	@AfterClass
	public void afterClass(){
		driver.quit();
	}
    */
	@Test
	public void test_01(){
		System.out.println("hello");
	}


}
