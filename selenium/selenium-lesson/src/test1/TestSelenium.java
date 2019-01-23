package test1;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class TestSelenium {
	public static void main(String [] args) throws InterruptedException, IOException
	{
		//openIE();
		 //navicat();
		//openChrome();
		//findElenmentTest();
		//findElenmentByXpathTest();
		//findElementByLinkTextTest();
		//testGetPageSource();
		//testGetHandel();
		//testSwitch();
		//testScoll();
		//testRadio();
		//testAlert() ;
		testScreen();
	}
	public static void testScreen() throws InterruptedException, IOException{
		System.setProperty("webdriver.chrome.driver", ".\\Tools\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
	    driver.get("http://www.baidu.com");
	    Thread.sleep(1000);
	    //截图
	    File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(src,new File(".\\file_image\\a.png"));
	    		   
	  
	}
	public static void testAlert() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", ".\\Tools\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
	    driver.get("http://news.cyol.com/node_60799.htm");
	    System.out.println(driver.switchTo().alert().getText());
	    Thread.sleep(200);
	    driver.switchTo().alert().accept();
	    driver.quit();
	  
	}
	public static void testRadio() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", ".\\Tools\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
	    driver.get("http://news.baidu.com");
	    ArrayList<WebElement> lw= (ArrayList<WebElement>)driver.findElements(By.xpath("//*/p[@class='search-radios']/input"));
	   
	    for(WebElement ele:lw)
	    {
	    	ele.click();
	    	Thread.sleep(100);
	    }
	    System.out.println("当前打开页面的标题是："+driver.getTitle());
	    driver.quit();
	}
	
	public static void openIE(){
		System.setProperty("webdriver.ie.driver", ".\\Tools\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
	    driver.get("https://www.baidu.com");
	    System.out.println("当前打开页面的标题是："+driver.getTitle());
	    driver.quit();
	}
	public static void openChrome(){
		System.setProperty("webdriver.chrome.driver", ".\\Tools\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
	    driver.get("https://www.baidu.com");
	    System.out.println("当前打开页面的标题是："+driver.getTitle());
	    driver.quit();
	}
	public static void navicat() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", ".\\Tools\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		driver.get("https://www.baidu.com");
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		driver.navigate().to("http://news.baidu.com/");
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().refresh();
		
	}
	public static void findElenmentTest() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", ".\\Tools\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		driver.get("https://www.baidu.com");
		Thread.sleep(1000);
		driver.findElement(By.id("kw")).sendKeys("java");
		
	}

	public static void findElenmentByXpathTest(){
		System.setProperty("webdriver.chrome.driver", ".\\Tools\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		driver.get("https://www.baidu.com");
		driver.findElement(By.xpath(".//*[@id='kw']")).sendKeys("java");
		driver.findElement(By.xpath(".//*[@id='su']")).click();
		
	}
	public static void findElementByLinkTextTest(){
		System.setProperty("webdriver.chrome.driver", ".\\Tools\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		driver.get("https://www.baidu.com");
		driver.findElement(By.linkText("新闻")).click();
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getCurrentUrl().equals("http://news.baidu.com/"));
		assert driver.getCurrentUrl().equals("http://news.baidu.com/");
		driver.getCurrentUrl();
		driver.quit();
	}
	public static void testGetPageSource(){
		System.setProperty("webdriver.chrome.driver", ".\\Tools\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		driver.get("https://www.baidu.com");
	    String source1 = driver.getPageSource();
	    System.out.println(source1);
	}
	public static void testGetHandel() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", ".\\Tools\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		driver.get("https://www.baidu.com");
	    Thread.sleep(100);
	    WebElement we = driver.findElement(By.partialLinkText("设为主页"));
	    we.click();
	    System.out.println(driver.getWindowHandles());
	}
	public static void testSwitch() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", ".\\Tools\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		driver.get("https://www.jd.com/");
		WebElement we  = driver.findElement(By.partialLinkText("手机"));
		we.click();
		Set<String> ls = driver.getWindowHandles();
		for(String s : ls)
		{
			if(ls.equals(driver.getWindowHandle()))
			{
				driver.close();
				continue;
			}
			driver.switchTo().window(s);
		}
	    Thread.sleep(100);
	  WebElement w=  driver.findElement(By.partialLinkText("小米"));
	  Thread.sleep(100);
	  w.click();
	  Thread.sleep(100);
	 driver.quit();
	    
	    
	}
	public static void testScoll() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", ".\\Tools\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		driver.get("http://blog.csdn.net/u011541946");  
	       
        Thread.sleep(1000);

		 WebElement element = driver.findElement(By.xpath("//*/dd[@class='foot_sub_menu']/a[1]"));
	        //创建一个javascript 执行实例
	      JavascriptExecutor je = (JavascriptExecutor) driver;
	      		
	      	//执行js语句，拖拽浏览器滚动条，直到该元素到底部，马上就不可以见
	      je.executeScript("arguments[0].scrollIntoView(true);",element);

	
	    
	}
}
