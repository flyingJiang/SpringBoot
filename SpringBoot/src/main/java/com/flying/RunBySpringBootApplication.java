package com.flying;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
@SpringBootApplication 被 @Configuration、@EnableAutoConfiguration、@ComponentScan 注解所修饰，
换言之 Springboot 提供了统一的注解来替代以上三个注解
扫包范围：在启动类上加上@SpringBootApplication注解,当前包下或者子包下所有的类都可以扫到。
*/

@SpringBootApplication
public class RunBySpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(RunBySpringBootApplication.class, args);
    }
}
