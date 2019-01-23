package test.suiteTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import test.tools.EnguineBrowser;

public class TestLauheBrowser {
	WebDriver driver;
	String url;
	@Test
	public void test(){
		System.out.println(11111111);
		System.out.println(11111);
		EnguineBrowser.initConfig();
		url= EnguineBrowser.serverURL;
		driver =EnguineBrowser.getDriver();
		driver.get(url);
	}

}
