package test.tools;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class EnguineBrowser {
	   // private static ResourceBundle bundle= ResourceBundle.getBundle("application", Locale.CHINA);
	    public static String browserName;
	    public static String serverURL;
	    public static WebDriver driver;
	    public static void initConfig(){
	    	System.out.println("hhhhhhhh");
//	        browserName = bundle.getString("BrowserName");
//	        serverURL = bundle.getString("url");
	    	browserName = "Chrome";
	    	serverURL ="https://51.design";
	        
	    }
	    /**
	     * 获取driver
	     *
	     * */
	    public static WebDriver getDriver(){
	        if(browserName.equalsIgnoreCase("firefox"))
	        {
	            System.setProperty("webdriver.gecko.driver",
	                    ".\\Tools\\chromedriver.exe");
	           // driver = createFireFoxDriver();
	            driver = new FirefoxDriver();
	        }else if(browserName.equalsIgnoreCase("Chrome"))
	        {
	            System.setProperty("webdriver.chrome.driver",
	                    "D:\\download\\test_auto\\apache-maven-3.3.9" +
	                            "\\repo\\repo_xiaxia_wei\\org\\seleniumhq" +
	                            "\\selenium\\selenium-chrome-driver" +
	                            "\\3.4.0\\selenium-chrome-driver-3.4.0.jar");
	            driver = new ChromeDriver();
	        }
	        driver.get(serverURL);
	        driver.manage().window().maximize();
	        callWait(100);

	        return  driver;
	    }

	    /**
	     * 隐式等待方法
	     * @param time
	     */
	    public static void callWait(int time){
	        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);

	    }
	    public void tearDown() throws InterruptedException{


	        driver.quit();
	        Thread.sleep(3000);
	    }



	

}
