package com.flying.service.impl;

import java.util.List;

import com.flying.entity.User;
import com.flying.mapper.UserMapper;
import com.flying.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserMapper userMapper;

    @Override
    public void createUser(String name, Integer age) {

        jdbcTemplate.update("insert into users values(null,?,?);", name, age);

    }

    @Override
    public PageInfo<User> findUserList(int page, int size) {
        // 开启分页插件,放在查询语句上面
        PageHelper.startPage(page, size);
        List<User> listUser = userMapper.findUserList();
        // 封装分页之后的数据
        PageInfo<User> pageInfoUser = new PageInfo<User>(listUser);
        return pageInfoUser;
    }
}
