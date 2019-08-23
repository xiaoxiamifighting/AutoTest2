package com.course.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PreDestroy;
//这个就是一个入口参数（不用进行扫描了
@EnableScheduling
@SpringBootApplication
public class Application {
    private static ConfigurableApplicationContext context;
    public static void main(String[] args)
    {
        Application.context = SpringApplication.run(Application.class,args);
    }
    @PreDestroy
    public void close()
    {
        Application.context.close();
    }
}
