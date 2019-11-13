package com.flying.service;

import com.flying.entity.User;
import com.github.pagehelper.PageInfo;

public interface UserService {

    public void createUser(String name, Integer age);

    public PageInfo<User> findUserList(int page, int size);

}
