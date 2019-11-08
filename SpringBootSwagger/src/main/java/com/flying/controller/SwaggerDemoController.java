package com.flying.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
@Api("part 1: api")
public class SwaggerDemoController {
    private static final Logger logger = LoggerFactory.getLogger(SwaggerDemoController.class);

    @ApiOperation(value = "根据id查询学生信息", notes = "查询数据库中某个的学生信息")
    @ApiImplicitParam(name = "id", value = "学生ID", paramType = "path", required = true, dataType = "int")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    //@GetMapping("/getStudentByID")
    public String getStudent(@PathVariable int id) {
        logger.info("开始查询某个学生信息");
        return "success";
    }
    @ApiOperation(value = "查询年龄", notes = "请输入年龄")
    @ApiImplicitParam(name = "age", value = "年龄", required = true, dataType = "int")
    @GetMapping("/getAge")
    public int getAge(int age){
        logger.info("age:" + age);
        return age;
    }

    @ApiOperation("查询姓名")
    @ApiImplicitParam(name = "name", value = "姓名", required = true, dataType = "String")
    @PostMapping("/getName")
    public String getName (String name){
        logger.info("name: " + name);
        return name;
    }
}
