package com.flying;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages = "com.flying.controller")
@EnableAutoConfiguration
public class MainRun {
    public static void main(String[] args) {
        SpringApplication.run(MainRun.class, args);
    }
}
