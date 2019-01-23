package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/**
 * 很多页面，我们有些方法是相同的，例如，判断一个元素是否在页面显
 * 示，还有元素点击和输入操作，还有判断页面标题和页面地址等
 * 等，甚至，有些软件web不同页面有公共的元素。这些因素，决定了
 * 我们需要写一个页面父类，来定义一些公共的方法或者公共的元素。
 */
 

public class BasePage {
	private WebDriver driver;
	private String pageTitle;//页面标题
	private String pageUrl;
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
	}
	/*
	 * * 在文本框内输入字符
	 * */
	
	public void type(WebElement element,String text)
	{
		if(element.isEnabled())
		{
			element.clear();
		}
		element.sendKeys(text);
	}
	/*
	 * 
	 * 点击元素，这里指点击鼠标左键
*/
	public void click(WebElement element)
	{
		if(element.isEnabled())
		{
			element.click();
		}
	}
	/**
	 * 文本输入框执行清除操作
	 * */
	
	public void clear(WebElement element)
	{
		if(element.isEnabled())
		{
			element.click();
		}
	}
	/*
	 * 获取页面的标题
	 * *
	 */
	public String GetCurrentPageTitle()
	{
	
			pageTitle = driver.getTitle();
		
		return pageTitle;
	}
	
/*
 * * 获取页面的url

 * 
 * */
	
	public String getCurrentPageUrl()
	{
		pageUrl = driver.getCurrentUrl();
		return pageUrl;
		
	}
}
