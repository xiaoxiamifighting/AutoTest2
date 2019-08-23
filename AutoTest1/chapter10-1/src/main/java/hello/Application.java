package hello;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication   //把这个程序进行托管了
@ComponentScan("com.course.*")  //扫描哪个包下面的类
public class Application {
    //这是springboot 的入口参数
    public static void main(String[] args)
    {
        SpringApplication.run(Application.class,args);
        //固定参数
    }
}
