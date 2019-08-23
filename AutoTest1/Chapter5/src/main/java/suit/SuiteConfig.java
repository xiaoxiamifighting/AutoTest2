package suit;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class SuiteConfig {
    @BeforeTest
    public void beforeSuite(){
        System.out.println("这是测试套件之前运行的");

    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("这是测试套件之后运行的");

    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("beforeTest");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("afterTest");
    }
}
