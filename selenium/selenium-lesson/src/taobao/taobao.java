package taobao;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class taobao {
	public static void main(String [] args) throws InterruptedException
	{
		
		openChrome();
		
	}
	public static void openChrome() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", ".\\Tools\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
	    driver.get("https://daogou.sc.weibo.com/user/home");
	    driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div/div[1]/div/div/div/div/div/a")).click();
	    System.out.println("当前打开页面的标题是："+driver.getTitle());
	    WebElement login = driver.findElement(By.id("loginname"));
	    login.sendKeys("15940256502");
	    Thread.sleep(100);
	    WebElement pasword = driver.findElement(By.xpath("//*[@id='pl_login_form']/div/div[3]/div[2]/div/input"));
	    
	    pasword.sendKeys("12w19901227x");
	    Thread.sleep(100);
	    WebElement cli = driver.findElement(By.xpath("//*[@id='pl_login_form']/div/div[3]/div[6]/a"));
	    cli.click();//登录到微博内容导购的平台
	    Thread.sleep(100);  
	    /**
	     * 由于推广的按钮只有li不一样，所以可以用拼接的方式
	     * 
	     */
	    int i=1,j=1;
	   
	    for(i=1;i<5;i++){
	    	if(i%5==0){
	    		Thread.sleep(5000);
	    		j=1;}
	    	
	    
	    String xpath_li1 ="//*[@id='root']/div/div[2]/div[2]/div/div/div[3]/div[1]/div/ul/li[";
	    int  xpath_li2=j;
	    String xpath_li3 ="]/div[4]/a[1]/span";
	    //拼接之后的xpath
	    String   xpath_total=xpath_li1+xpath_li2+xpath_li3;
	    System.out.println("xpath_total:"+xpath_total);
	    driver.findElement(By.xpath(xpath_total)).click();//第一次点击推广的链接
	    Thread.sleep(1000);
	    //下面的这个功能是点击复选框，可以在微博评论中有这一个优惠券的链接
        driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div/div/div[5]/div/div/div/div[2]/div/div[1]/div[1]/div[2]/p/input")).click();
	    Thread.sleep(100);
	    //立即进行推广
	    driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div/div/div[5]/div/div/div/div[2]/div/div[1]/div[2]/div[2]/span")).click();
	    //弹出一个推广成功的弹窗，点击确定，弹窗消失，留在当前页面
	    driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div/div/div[5]/div/div/div/div[2]/span")).click();
	    Thread.sleep(1000*60*5);//每次推广成功都进行休息一分钟
	    j++;
	    }
	    }
	
	 
	   
	    
	    
	

}
