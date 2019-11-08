package com.flying.controller;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //在上加上RestController 表示修饰该Controller所有的方法返回JSON格式,直接可以编写Restful接口
//@EnableAutoConfiguration
/*
注解:作用在于让 Spring Boot   根据应用所声明的依赖来对 Spring 框架进行自动配置
        这个注解告诉Spring Boot根据添加的jar依赖猜测你想如何配置Spring。
        由于spring-boot-starter-web添加了Tomcat和Spring MVC，所以auto-configuration将假定你正在开发一个web应用并相应地对Spring进行设置。
*/
public class HelloController {
    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }

    /*public static void main(String[] args) {
        //   标识为启动类
        SpringApplication.run(HelloController.class, args);
    }*/

}
