package com.flying.controller;

import com.flying.entity.User;
import com.flying.service.UserService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Value("${http_url}")
    private String httpUrl;

    @Autowired
    private UserService userService;

    @GetMapping("/findUserList")
    public PageInfo<User> findUserList(int page, int size) {
        return userService.findUserList(page, size);
    }

    @RequestMapping("/insertUser")
    public String insertUser(String name, int age){
        try {
            userService.createUser(name, age);
            logger.info("success and url: " + httpUrl);
            return "success and url: " + httpUrl;
        }catch (Exception e){
            logger.info("fail and url: " + httpUrl);
            e.printStackTrace();
        }
        return httpUrl;
    }

}
