package com.flying.mapper;

import java.util.List;

import com.flying.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM USERS WHERE NAME = #{name}")
    User findByName(@Param("name") String name);

    @Insert("INSERT INTO USERS(NAME, AGE) VALUES(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);

    @Select("SELECT * FROM USERS ")
    List<User> findUserList();


}
